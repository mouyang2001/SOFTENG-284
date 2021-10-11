def longest_common_prefix(strs):
    prefix = ""

    word = strs[0]
    strs.pop(0)

    for i in range(len(word)):
        for other_word in strs:
            if (i < len(other_word)):
                if (word[i] != other_word[i]):
                    return prefix  
            else:
                return prefix

        prefix += word[i]

    return prefix


strs = ["flower", "flow", "flight"]
print(longest_common_prefix(strs))

