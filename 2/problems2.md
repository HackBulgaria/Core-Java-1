###Implement a String join method### 
Java does not have a String join method. Apache StringUtils does have, but, well, that's not an excuse.

Make a method that joins strings, with a 'glue' given from the caller of your method.

Can you think of a way for it to work with every object, not just string? Even primitives?

`stichMeUp(" ", "Днес", "видях", 5, "ходещи", "медузи") => "Днес видях 5 ходещи медузи"` 