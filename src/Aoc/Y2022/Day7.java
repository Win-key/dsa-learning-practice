package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class Day7 extends BaseClass {
    public static long dirWithAtMost10K = 0L;
    public static long totalSpace = 70000000L;
    public static long requiredSpace = 30000000L;
    public static long availableSpace = 0L;
    public static long targetSpace = Long.MAX_VALUE;

    public static void main(String[] args) {
        new Day7().execute();
    }
    @Override
    public void execute() {
        Resource resource = Resource.build(input);
        long usedSpace = resource.getSize();
        availableSpace = totalSpace - usedSpace;
        print(Day7.dirWithAtMost10K);
        resource.getSize();
        print(targetSpace);
    }


    /**
     * Represents any resources - File, Dir
     */
    interface Resource {
        long getSize();
        String getName();
        boolean isDir();

        static Resource build(List<String> instructions) {
            return build(
                    new Dir("root"),
                    instructions
                            .stream()
                            .map(Command::new)
                            .collect(Collectors.toCollection(ArrayDeque::new)));
        }

        private static Resource build(Resource resource, Queue<Command> instructions) {
            while (!instructions.isEmpty()) {
                Command cmd = instructions.poll();
                if (Objects.isNull(cmd)) {
                    throw new RuntimeException("Can not be a resource");
                }
                switch (cmd.type) {
                    case LS:
                        var dir = (Dir) resource;
                        cmd = instructions.peek();
                        while (Objects.nonNull(cmd)
                                && cmd.type != CommandType.CD) {
                            dir.addResource(Resource.build(dir, instructions));
                            cmd = instructions.peek();
                        }
                        break;
                    case DIR:
                        return new Dir(cmd.value);
                    case CD:
                        if (cmd.value.equals("..")) {
                            return resource;
                        }
                        dir = (Dir) resource;
                        Resource.build(dir.find(cmd.value), instructions);
                        break;
                    case FILE:
                        String[] value = cmd.value.split(" ");
                        return new File(Long.parseLong(value[0]), value[1]);
                }
            }
            return resource;
        }
    }

    static class File implements Resource {

        private long size;
        private String name;

        public File(long size, String name) {
            this.size = size;
            this.name = name;
        }

        @Override
        public long getSize() {
            return this.size;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public boolean isDir() {
            return false;
        }

        @Override
        public String toString() {
            return "File "+ name + "(" + size + ")";
        }
    }

    static class Dir implements Resource {

        private List<Resource> resources;
        private String name;

        public Dir(String name) {
            this.name = name;
            this.resources = new ArrayList<>();
        }

        @Override
        public long getSize() {
            long size = 0L;
            for (Resource resource : resources) {
                long rSize = resource.getSize();
                if(resource.isDir()) {
                    if(rSize <= 100000L)
                        dirWithAtMost10K += rSize;
                    if(availableSpace + rSize >= requiredSpace)
                        targetSpace = Math.min(targetSpace, rSize);
                }
                size += rSize;
            }
            return size;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean isDir() {
            return true;
        }

        public void addResource(Resource resource) {
            this.resources.add(resource);
        }
        public Resource find(String name) {
            return resources
                    .stream()
                    .filter(e -> e.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Resource doesn't exist"));
        }

        @Override
        public String toString() {
            return "Dir "+ name;
        }
    }

    static class Command {
        CommandType type;
        String value;

        @Override
        public String toString() {
            return "CMD " + type +"=" + value ;
        }

        public Command(String instruction) {
            if (Character.isDigit(instruction.charAt(0))) {
                this.value= instruction;
                this.type = CommandType.FILE;
            } else {
                String[] cmdValue = instruction.split(" ");
                this.type = CommandType.lookUp(cmdValue[0]);
                if (cmdValue.length > 1)
                    this.value = cmdValue[1];
            }
        }
    }

    static enum CommandType {
        CD("cd"),LS("ls"),DIR("dir"),FILE("");
        String value;

        CommandType(String value) {
            this.value = value;
        }

        public static CommandType lookUp(String value) {
            for (CommandType cmd : CommandType.values()) {
                if(cmd.value.equals(value)) {
                    return cmd;
                }
            }
            return CommandType.FILE;
        }
    }

}