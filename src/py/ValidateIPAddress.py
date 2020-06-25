"""
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
"""

class Solution:
    def validIPv4(self, IP: str) -> bool:
        arr = IP.split('.')
        if len(arr) != 4:
            return False
        for tok in arr:
            try:
                val = int(tok)
                if val > 255 or val <0:
                    return False
                if val > 0 and tok.startswith('0'):
                    return False
                if val == 0 and len(tok) > 1:
                    return False
            except ValueError:
                return False
        return True
        
        
    def validIPv6(self, IP: str) -> bool:
        arr = IP.split(':')
        if len(arr) != 8:
            return False
        for tok in arr:
            if len(tok) < 1 or len(tok) > 4:
                return False
            for c in tok:
                if not (
                    (c >= 'a' and c <= 'f') or
                    (c >= 'A' and c <= 'F') or
                    (c >= '0' and c <= '9')
                ):
                    return False
        return True
            
    
    def validIPAddress(self, IP: str) -> str:
        if self.validIPv4(IP):
            return "IPv4"
        elif self.validIPv6(IP):
            return "IPv6"
        return "Neither"
        