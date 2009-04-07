Welcome to the Donkey

The Donkey is an Open Source integration framework. 

The motivation behind this project was born of the fact 
that we were dissatisfied with the way existing (open or 
commercial) EAI solutions treat their users for the 
following reasons: 

* Quite often solutions were not written for easy 
testability. Integration end points need to be easy to 
"mock" as often times the only end-to-end solution is the 
production environment. 

* Existing solutions always treated inbound end points the 
same as outbound endpoints, making the configuration 
parameters confusing and often contradictory.

* No existing solution was test driven, or was even 
exercised with a fast CI loop (as far as we could tell from 
the code and their web sites).

* The source code was often a mess. Huge classes (> 100 
NCSS is big for us), badly defined interfaces. Often coding 
standards were not automatically enforced. 

* A lot of cool functionality was locked away behind 
"Enterprise" editions. 

* The documentation and examples was often wrong and 
contradictory. 

* Endpoint configuration was primarily in XML. Not cool. In 
our view, XML makes things harder to test and also 
maintain.

* Even the simplest examples of file based end points were 
buggy.

We wanted a robust solution that addressed all of these 
concerns and we have largely achieved this. Of course, we 
have things we would like to fix already, but our code is 
maintainable enough for us to still move through changes 
quickly. 

Feel free to help us create the best integration solution 
on the planet.
