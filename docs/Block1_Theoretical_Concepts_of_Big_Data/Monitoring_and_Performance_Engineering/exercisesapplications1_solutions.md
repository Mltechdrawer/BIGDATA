# Case Studies - Solutions

## Case 1: Emergency Response System with Autonomous Drones

A team has developed an autonomous drone system to assist in natural disaster situations. The drones collect environmental data (wind, temperature, humidity), and their main function is to deliver essential supplies. The data is stored in a relational database, which is shared with other emergency systems in real time.

During a mission in a mountainous area, one of the drones lost control and crashed into a temporary facility where refugees were sheltered. After investigation, it was discovered that the drone's navigation system did not properly assess rapid changes in wind in mountainous regions.

**Aspects to Consider:** Relentless Suspicion

Storage: The environmental data collected by the drones is stored in a centralized relational database that allows for quick queries.

Optimization: Relentless Suspicion should have been applied, questioning the necessity of each instruction in the navigation algorithm and verifying if the wind data was sufficient to ensure a safe flight.

Questions for Students:

Is it ethical to deploy an autonomous system without considering all possible critical navigation scenarios?
Should more extensive testing have been conducted on the stored data to cover situations with extreme winds? How could the databases be improved to store more useful information?
What type of data structure or format could be used to improve the real-time processing of this environmental data?

Answers for Case 1:

Is it ethical to deploy an autonomous system without considering all possible critical navigation scenarios?
**Answer:** No, it is not ethical. Launching an autonomous system that interacts with people must include a thorough risk analysis. Considering all possible critical scenarios, especially those that could endanger human lives, is essential. To minimize these risks, ethical engineering should be applied, along with methods such as risk modeling and simulated environment testing to ensure coverage of the most critical cases.

Should more extensive testing have been conducted on the stored data to cover situations with extreme winds? How could the databases be improved to store more useful information?
**Answer:** Yes, more exhaustive testing should have been conducted, particularly regarding wind data and extreme conditions in the region. To improve the database, tags and metadata related to extreme weather conditions could be added. Additionally, a hierarchical data structure could be used to prioritize access to critical information during emergencies.

What type of data structure or format could be used to improve the real-time processing of this environmental data?
Answer: A time series database would be ideal for storing environmental data, as it allows for efficient querying of time-related information. Moreover, this data could be complemented with spatial indexing techniques to facilitate quick access to critical data in specific locations, improving the system's ability to react in real time.

---

## Case 2: Real-Time Medical Evaluation Platform

A clinic has implemented a platform for the real-time monitoring of vital signs of elderly patients. Data is continuously generated from wearable sensors and stored in a real-time database (a streaming data system). The platform should alert relatives or medical staff when values outside normal parameters are detected.

Recently, one of the devices failed, and the system did not issue the necessary alert in time. The reason was that the system constantly recalculated each value, and due to the large amount of data, delays occurred.

**Aspects to Consider:** Early Binding

Storage: The data is stored in a real-time database, where it is processed as it is received.

Optimization: Applying Early Binding would have allowed pre-computation of certain critical indicators, storing them for reuse, which would have reduced processing times and ensured a better response during emergencies.

Questions for Students:

How can the data flow be optimized so that the system responds more efficiently during an emergency?
What are the advantages and disadvantages of applying Early Binding in a real-time monitoring context?
How could pre-computed values be stored to facilitate access and retrieval in critical situations?

Answers for Case 2:

How can the data flow be optimized so that the system responds more efficiently during an emergency?
**Answer:** Data flow can be optimized by applying pre-processing of critical data (Early Binding), storing key values such as average heart rate or alert thresholds in advance. Additionally, utilizing a streaming system that applies real-time filtering to ensure only relevant data reaches emergency services would further improve response efficiency.

What are the advantages and disadvantages of applying Early Binding in a real-time monitoring context?
**Answer:** The main advantage is the reduction in response time since critical calculations are already pre-computed. This is crucial for timely responses in medical emergencies. The main disadvantage is that more memory is required to store these pre-computed values, and problems could arise if the health status changes rapidly, making pre-computed values obsolete.

How could pre-computed values be stored to facilitate access and retrieval in critical situations?
Answer: Pre-computed values could be stored in an in-memory database such as Redis, which allows ultra-fast access to information. A cache could also be used for the most frequently queried values, reducing latency in emergency situations.

---

## Case 3: University Exam Evaluation System

The university has developed an automated system to evaluate student exams. These exams consist of multiple-choice and open-ended questions. Student responses are stored in a matrix data structure for mass evaluations.

In a recent incident, the system assigned incorrect grades due to the way responses were evaluated: all questions were evaluated in a fixed order without considering their type or complexity, which led to errors.

**Aspects to Consider:** Ordering Tests

Storage: The students' responses are stored in a matrix, where each row represents a student and each column represents a specific response.

Optimization: Applying Ordering Tests would have allowed the evaluations to be ordered by probability of being correct or by type, optimizing the evaluation sequence and reducing errors.

Questions for Students:

How could the evaluation system be optimized so that the most probable answers are evaluated first?
What improvements could be made to the matrix data structure to enhance the efficiency of the evaluation system?
Should more extensive testing with different response patterns have been conducted to ensure system accuracy?

Answers for Case 3:

How could the evaluation system be optimized so that the most probable answers are evaluated first?
**Answer:** The Ordering Tests technique could be applied, analyzing historical patterns to determine which responses are most frequently correct and processing these first. A machine learning system could also be used to learn these patterns and continuously optimize the evaluation order based on previous responses.

What improvements could be made to the matrix data structure to enhance the efficiency of the evaluation system?
**Answer:** The matrix could be re-ordered to place the most common questions first, facilitating faster access. Additionally, a sparse matrix could be used to store only non-null responses, reducing the amount of data to process and improving efficiency.

Should more extensive testing with different response patterns have been conducted to ensure system accuracy?
**Answer:** Yes, more exhaustive testing with various response patterns is essential to ensure system robustness. This includes simulating correct and incorrect responses and using random testing techniques to verify how the system behaves in different situations, ensuring no biases in evaluation.

---

## Case 4: Autonomous Delivery Robot in a City

A logistics company has developed an autonomous robot to deliver packages in the city. The robot uses massive data collected by sensors and cameras to avoid obstacles and optimize its routes. This data is stored in a graph that models the city's street network.

Recently, the robot hit a pedestrian while trying to avoid a parked car. After an investigation, it was discovered that the robot was overloaded with unnecessary data, which affected its ability to react quickly.

**Aspects to Consider:** Code Simplification

Storage: The data is stored in a graph, where nodes represent intersections and edges represent streets.

Optimization: Applying Code Simplification would have simplified the navigation code and eliminated unnecessary complexity, optimizing the robot's response to unexpected situations.

Questions for Students:

How could navigation algorithms be optimized to improve the robot's real-time reaction?
Which parts of the graph could be simplified to avoid data overload and improve efficiency?
How could storing data in a graph influence the robot's efficiency, and what adjustments could be made to optimize it?

Answers for Case 4:

How could navigation algorithms be optimized to improve the robot's real-time reaction?
**Answer:** Navigation algorithms could be optimized by applying Code Simplification, eliminating redundant or unnecessary calculations, and focusing on critical decision-making functions. Implementing a Kalman filter would also help smooth sensor measurements, allowing the robot to make quicker and more accurate decisions.

Which parts of the graph could be simplified to avoid data overload and improve efficiency?
**Answer:** Irrelevant nodes (such as dead-end streets or restricted-access routes) could be removed from the graph to reduce route complexity. Additionally, grouping similar streets into supernodes could help simplify the network and reduce the computational cost associated with route searching.

How could storing data in a graph influence the robot's efficiency, and what adjustments could be made to optimize it?
**Answer:** Storing data in a graph allows for structured navigation but can be inefficient if there are too many unnecessary nodes and edges. Using a hierarchical graph representation, where major routes are evaluated first, could improve the robot's efficiency. Implementing an A* search algorithm would also be a significant improvement for quickly finding optimal routes.

---

## Case 5: Energy Demand Prediction System

An electric company has developed a system to predict energy demand using historical consumption data. The data is stored in a distributed database due to the large volume of information from millions of households. Recently, however, the system issued incorrect predictions during a heatwave, leading to unexpected blackouts.

Upon investigation, it was found that the system's algorithms were based on complex models that tried to capture too many variables, including some that were not relevant to the prediction.

**Aspects to Consider:** Problem Simplification

Storage: The historical data is stored in a distributed database, which allows for massive analysis and querying of consumption patterns.

Optimization: Applying Problem Simplification would have reduced the model's complexity by focusing only on the most relevant variables for prediction, thus increasing accuracy and reducing computational overload.

Questions for Students:

What variables could have been eliminated from the model to reduce complexity without sacrificing accuracy?
How could the distributed database be improved to store only truly useful and relevant data?
What strategies could be implemented to simplify the demand prediction problem and optimize the system's responsiveness?

Answers for Case 5:

What variables could have been eliminated from the model to reduce complexity without sacrificing accuracy?
**Answer:** Variables that do not have a significant correlation with energy demand, such as irrelevant weather factors, could be eliminated. Dimensionality reduction techniques like Principal Component Analysis (PCA) can help identify less relevant variables and remove them from the model.

How could the distributed database be improved to store only truly useful and relevant data?
**Answer:** Implementing data cleaning algorithms that filter and discard obsolete or redundant data would help maintain only relevant information. Using advanced indexing would also enable more efficient storage of key data, improving query and analysis capabilities.

What strategies could be implemented to simplify the demand prediction problem and optimize the system's responsiveness?
**Answer:** Applying Problem Simplification involves reducing the number of factors to only those strictly necessary for prediction. Additionally, a reinforcement learning-based model could be applied to optimize predictions by adapting to changing demand patterns, which would reduce complexity and increase efficiency.
