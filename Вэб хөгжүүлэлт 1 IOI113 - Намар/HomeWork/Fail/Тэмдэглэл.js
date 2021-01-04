// ***********PROMPT***********//
var n = prompt('n-д утга оруулна уу')

var helnuud = ['JavaScript', 'php', 'C#', 'Python'];
// massive d ugsun utgaa duudahdaa ehnii element iig 0 ees ehelj duudna

helnuud[1] = 'Lisp'
// Ene argaar 1r elemented baigaa utagiig uurchilj bolno

console.log(helnuud.length + ' Shirheg hel baina ')
// length ni massive hden elementteig helj ugdug

helnuud[4] = 'C++'
// Daraachiin elementiin toog oruulj ugsunuur shine element oruulj ugnu

helnuud[helnuud.length] = 'assembler'
// Ene argiig ashiglan bas Element nemj bolno

helnuud.unshift['Perl']
// urdaas ni element nemj oruulahad ashiglagdana
helnuud.shift()
// Urd baiga elementiig ustgana

helnuud.push['C']
// Tugsguluus ni element nemj oruulahad ashiglagdana

console.log(helnuud.pop());
// pop ni hamgiin tugsguliin elementiig gargaj ugdug

console.log(helnuud.indexOf('python'))
// IndexOf ni massive dotorh ugugdul hed deh element gedegiin helj ugnu

helnuud.splice(2 - 3)
// SPLICE ni x elementees hoish y ni hden element ustgaj uguhiig helj ugnu, massive dotroos tasalj avna

var x = helnuud.slice(1, 3)
// massive aas todorhoi hesgiin avah, huulj avah
console.log(x)
// avsan elementee end gargaj ugnu 

// **SORT**
console.log(helnuud)
// Ehelj gargaj irsen sort maani sortlogdoogui garj ireh boln
helnuud.sort()
//helnuud dotorh massive ni string utgatai tul A aas ni ehlen eremleh bol
console.log(helnuud)
// Harin odoo gargaj ireh helnuud maani (A,B,C,D) gej usgiin daraallaar eremblegdsen baih bolno

var Random = Math.random()
console.log(Random)
// Random Math Function ni Duriin too avna