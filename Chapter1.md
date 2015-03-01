Chapter 1: Review
===

###Risks of threads

* Safety hazards
    Race conditions
    Non-sequentiality, unexpected change of data

* Liveness hazards
	Liveness concerns the complementary goal that "sth  good eventually happens".
	A liveness failure occurs when an activity gets into a state such that it is permanently unable to make forward progress, for example: deadlocks

* Performance hazards
	While liveness means that sth good eventually happens, eventually may not be good enough - we often want good things to happen quickly.