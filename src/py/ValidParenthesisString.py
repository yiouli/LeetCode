"""
Given a string containing only three types of characters: '(', ')' and '*',
write a function to check whether this string is valid. We define the validity of a string by these rules:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
- An empty string is also valid.
"""
class Solution:
    def checkValidString(self, s: str) -> bool:
        lp = []
        stars = []
        idx = 0
        for c in s:
            if c == ')':
                cand = lp or stars
                if cand:
                    cand.pop()
                else:
                    return False
            if c == '(':
                lp.append(idx)
            elif c == '*':
                stars.append(idx)
            idx += 1
        lp.reverse()
        stars.reverse()
        sidx = 0
        for lidx in lp:
            if sidx >= len(stars) or stars[sidx] < lidx:
                return False
            sidx += 1
        return True