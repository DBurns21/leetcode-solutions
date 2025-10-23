/**
 * @param {string} s
 * @return {boolean}
 */
var hasSameDigits = function(s) {
    
    while (s.length > 2) {
        let newString = "";
        for (let i = 0; i < s.length-1; ++i) {
            newString += ((Number(s.charAt(i)) + Number(s.charAt(i+1))) % 10).toString();
        }
        s = newString;
        console.log(newString);
    }

    return s.charAt(0) === s.charAt(1);
};