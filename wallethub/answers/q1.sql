select @curRank := @curRank + 1 AS rank, votes, name
from votes, (SELECT @curRank := 0) r
order by votes desc, name;
