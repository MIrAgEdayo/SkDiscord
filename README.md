```
Effects:
	EffGenerateLinkCode:
		ID: EffGenerateLinkCode
		Patterns:
			generate [[discord] link] code of %player% with length %integer%
	EffLink:
		ID: EffLink
		Patterns:
			[discord[ ]]link %user% with [the] code %string%
Expressions:
	ExprLastLinkDiscordAccount:
		ID: ExprLastLinkDiscordAccount
		Return type: user
		Changers:
			none
		Patterns:
			[the] last link[ed] discord account
	ExprLastLinkError:
		ID: ExprLastLinkError
		Return type: Text
		Changers:
			none
		Patterns:
			[the] last link[ed] error
	ExprLastLinkMCAccount:
		ID: ExprLastLinkMCAccount
		Return type: Player
		Changers:
            none
		Patterns:
			[the] last link[ed] (mc|minecraft) account
	ExprLinkCode:
		ID: ExprLinkCode
		Return type: Text
		Changers:
			set
			delete
			reset
		Patterns:
			[the] discord link code[s] of %player%
			%player%'[s] discord link code[s]
```