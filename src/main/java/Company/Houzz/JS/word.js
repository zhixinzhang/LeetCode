/**
 * Created by zhang on 2018/1/22.
 */
// button onclick
// <button onclick="myFunction('Harry Potter','Wizard')">点击这里</button>
function myFunction(name,job)
{
    var a = 'Hi, my name\'s Han Meimei, a SOFTWARE engineer';
    alert(a);
}
/**word upper*/
var a = 'Hi, my name\'s Han Meimei, a SOFTWARE engineer';

//for循环
function titleCase(s) {
    var i, ss = s.toLowerCase().split(/\s+/);
    for (i = 0; i < ss.length; i++) {
        ss[i] = ss[i].slice(0, 1).toUpperCase() + ss[i].slice(1);
    }
    return ss.join(' ');
}
console.log(titleCase(a));

function wordUp(name,job)
{
    var sentence = "i like houzz THe houzz is best"
    var str = sentence.toLowerCase().split(' ');
    for (var i in str) {
        str[i] = str[i].replace(str[i].charAt(0), str[i].charAt(0).toUpperCase());
    };
    str.join(" ")
    alert(str);
}