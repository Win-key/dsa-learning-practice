    let data= [{
            'patient_id': 1,
            'body_site': [{
                    'primary': true,
                    'tumor_location': 'Loc3',
                    'tumor_type': 'Typ1',
                    'stages': [{
                            'type': 'Y',
                            'tmn_values': 'T1 M2 N3',
                            'stage': 'S'
                        }
                    ],
                    'biomarkers': [
                        'ZER 3', 'NE 4', 'J5'
                    ],
					'numbers' : [7,3,5,9]
                }, {
                    'primary': false,
                    'tumor_location': 'Loc2',
                    'tumor_type': 'Typ12',
                    'stages': [{
                            'type': 'C',
                            'tmn_values': 'T3 M2 N3',
                            'stage': 'S1'
                        }
                    ],
                    'biomarkers': [
                        'AER 4', 'A 4', '95'
                    ],
					'numbers' : [7,5,7,4]
                },
				{
                    'primary': false,
                    'tumor_location': 'Loc5',
                    'tumor_type': 'Typ15',
                    'stages': [{
                            'type': 'C',
                            'tmn_values': 'T0 M0 N0',
                            'stage': 'S1'
                        }
                    ],
                    'biomarkers': [
                        'KER 4', 'A 4', '75'
                    ],
					'numbers' : [17,3,5,11]
                }
            ]
        }, {
            'patient_id': 2,
            'body_site': [{
                    'primary': true,
                    'tumor_location': 'Loc4',
                    'tumor_type': 'Typ1',
                    'stages': [{
                            'type': 'Z',
                            'tmn_values': 'T1 M2 N3',
                            'stage': 'S'
                        }
                    ],
                    'biomarkers': [
                        'HER 3', 'NE 4', 'J5'
                    ],
					'numbers' : [1,3,5,9]
                }, {
                    'primary': false,
                    'tumor_location': 'Loc1',
                    'tumor_type': 'Typ12',
                    'stages': [{
                            'type': 'C',
                            'tmn_values': 'T6 M6 N6',
                            'stage': 'S1'
                        }
                    ],
                    'biomarkers': [
                        'HER 4', 'A 4', '85'
                    ],
					'numbers' : [5,8,89,9]
                },
				{
                    'primary': false,
                    'tumor_location': 'Loc0',
                    'tumor_type': 'Typ10',
                    'stages': [{
                            'type': 'C',
                            'tmn_values': 'T4 M4 N4',
                            'stage': 'S1'
                        }
                    ],
                    'biomarkers': [
                        'HER 4', 'A 4', '95'
                    ],
					'numbers' : [0,4,12,3]
                }
            ]
        },
		{
            'patient_id': 3,
            'body_site': [{
                    'primary': true,
                    'tumor_location': 'Loc10',
                    'tumor_type': 'Typ10',
                    'stages': [{
                            'type': 'A',
                            'tmn_values': 'T10 M2 N3',
                            'stage': 'S'
                        }
                    ],
                    'biomarkers': [
                        'ZER 3', 'AE 4', 'JF 5'
                    ],
					'numbers' : [99,3,15,9]
                }, {
                    'primary': false,
                    'tumor_location': 'Loc1',
                    'tumor_type': 'Typ123',
                    'stages': [{
                            'type': 'A',
                            'tmn_values': 'T9 M6 N6',
                            'stage': 'S1'
                        }
                    ],
                    'biomarkers': [
                        'TER 4', 'As 4', 'HGW 85'
                    ],
					'numbers' : [57,8,89,123]
                },
				{
                    'primary': false,
                    'tumor_location': 'Loc12',
                    'tumor_type': 'Typ8',
                    'stages': [{
                            'type': 'C',
                            'tmn_values': 'T9 M4 N4',
                            'stage': 'S89'
                        }
                    ],
                    'biomarkers': [
                        'QER 4', 'AD 4', 'WA 95'
                    ],
					'numbers' : [0,41,12,3]
                }
            ]
        }
    ];
/*function fn(data) {

	data.forEach(e => {
		e.body_site.sort((a, b) => a.tumor_location > b.tumor_location ? 1 : -1);
	});

	data.forEach(e => {
		e['sortedText'] = e.body_site.reduce((acc,cur)=>acc.concat(cur.tumor_location), '');
	});

	data.sort((a, b) => a.sortedText > b.sortedText ? 1 : -1);
}*/

//"body_site.tumor_location"

// Accepts data, Path array (? index by default to 0)
// Array of primitives needs to be handled with '*' additional element to recognise them as primitives
function multiLevelSort(data, path, index = 0) {
	// n-1 recursion stacks
	if(index  < path.length - 1 ) {
		data.forEach(e => multiLevelSort(e[path[index]],path, index + 1));
		data.forEach(e => {
			let reduceApndText = index  == path.length - 2 ? '' : 'SortedText';
			e[path[index] + 'SortedText'] = e[path[index]].reduce((acc,cur)=>{
				// when path is array of primitives
				if(path[index+1] === '*')
					return acc.concat(cur)
				else
					return acc.concat(cur[path[index+1] + reduceApndText])
			}, '');
		});
	}
	let appendText = index  == path.length - 1 ? '' : 'SortedText';
	// debugger
	// when path is array of primitives
	if(path[index] === '*')
		data.sort((a, b) => a > b ? 1 : -1);
	else
		data.sort((a, b) => a[path[index]+ appendText] > b[path[index]+ appendText] ? 1 : -1);
}

multiLevelSort(data, ['body_site', 'tumor_type'])
console.table(data)
multiLevelSort(data, ['body_site', 'stages', 'type'])
console.table(data)
multiLevelSort(data, ['body_site', 'tumor_location'])
console.table(data)
multiLevelSort(data, ['body_site', 'biomarkers', '*'])
console.table(data)
multiLevelSort(data, ['body_site', 'numbers', '*'])
console.table(data)
multiLevelSort(data, ['patient_id'])
console.table(data)


//body_site.biomarkers.*