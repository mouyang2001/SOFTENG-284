def romanToInt(s):
  romanDictionary = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
    "IV": 4,
    "IX": 9,
    "XL": 40,
    "XC": 90,
    "CD": 400,
    "CM": 900
  }

  value = 0
  i=0
  while i < len(s):
    if (i+1<len(s) and s[i]+s[i+1] in romanDictionary):
      value = value + romanDictionary.get(s[i]+s[i+1])
      i = i + 2
    else:
      value = value + romanDictionary.get(s[i])
      i = i + 1
  return value


print(romanToInt("IX"))
