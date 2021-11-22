# Sift Language

## Examples

```
scan(mlb)
|> select(age > 40)
|> project(name, position, substr(team, 2) -> id)
|> limit(25)
```

```
scan(mlb)
|> select(age > 40)
|> group(
     avg(age),
     max(age) -> oldest
   ) by (v1, v2, ...)
|> sort(fields, ...)
```
