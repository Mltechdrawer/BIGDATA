# Case Studies

## Case 1: Emergency Response System with Autonomous Drones

A team has developed an autonomous drone system to assist in natural disaster situations. The drones collect environmental data (wind, temperature, humidity), and their main function is to deliver essential supplies. The data is stored in a relational database, which is shared with other emergency systems in real time.

During a mission in a mountainous area, one of the drones lost control and crashed into a temporary facility where refugees were sheltered. After investigation, it was discovered that the drone's navigation system did not properly assess rapid changes in wind in mountainous regions.

### Aspects to Consider

**Storage:** The environmental data collected by the drones is stored in a centralized relational database that allows for quick queries.

**Optimization:** Should have been applied, questioning the necessity of each instruction in the navigation algorithm and verifying if the wind data was sufficient to ensure a safe flight.

### Questions for Students

- Is it ethical to deploy an autonomous system without considering all possible critical navigation scenarios?
- Should more extensive testing have been conducted on the stored data to cover situations with extreme winds? How could the databases be improved to store more useful information?
- What type of data structure or format could be used to improve the real-time processing of this environmental data?

---

## Case 2: Real-Time Medical Evaluation Platform

A clinic has implemented a platform for the real-time monitoring of vital signs of elderly patients. Data is continuously generated from wearable sensors and stored in a real-time database (a streaming data system). The platform should alert relatives or medical staff when values outside normal parameters are detected.

Recently, one of the devices failed, and the system did not issue the necessary alert in time. The reason was that the system constantly recalculated each value, and due to the large amount of data, delays occurred.

### Aspects to Consider

**Storage:** The data is stored in a real-time database, where it is processed as it is received.

**Optimization:** To allow pre-computation of certain critical indicators, storing them for reuse, which would have reduced processing times and ensured a better response during emergencies.

### Questions for Students

- How can the data flow be optimized so that the system responds more efficiently during an emergency?
- What are the advantages and disadvantages of applying Early Binding in a real-time monitoring context?
- How could pre-computed values be stored to facilitate access and retrieval in critical situations?

---

## Case 3: University Exam Evaluation System

The university has developed an automated system to evaluate student exams. These exams consist of multiple-choice and open-ended questions. Student responses are stored in a matrix data structure for mass evaluations.

In a recent incident, the system assigned incorrect grades due to the way responses were evaluated: all questions were evaluated in a fixed order without considering their type or complexity, which led to errors.

### Aspects to Consider

**Storage:** The students' responses are stored in a matrix, where each row represents a student, and each column represents a specific response.

**Optimization:** To order the evaluations by probability of being correct or by type, optimizing the evaluation sequence and reducing errors.

### Questions for Students

- How could the evaluation system be optimized so that the most probable answers are evaluated first?
- What improvements could be made to the matrix data structure to enhance the efficiency of the evaluation system?
- Should more extensive testing with different response patterns have been conducted to ensure system accuracy?

---

## Case 4: Autonomous Delivery Robot in a City

A logistics company has developed an autonomous robot to deliver packages in the city. The robot uses massive data collected by sensors and cameras to avoid obstacles and optimize its routes. This data is stored in a graph that models the city's street network.

Recently, the robot hit a pedestrian while trying to avoid a parked car. After an investigation, it was discovered that the robot was overloaded with unnecessary data, which affected its ability to react quickly.

### Aspects to Consider

**Storage:** The data is stored in a graph, where nodes represent intersections and edges represent streets.

**Optimization:** Simplify the navigation code and eliminate unnecessary complexity, optimizing the robot's response to unexpected situations.

### Questions for Students

- How could navigation algorithms be optimized to improve the robot's real-time reaction?
- Which parts of the graph could be simplified to avoid data overload and improve efficiency?
- How could storing data in a graph influence the robot's efficiency, and what adjustments could be made to optimize it?

---

## Case 5: Energy Demand Prediction System

An electric company has developed a system to predict energy demand using historical consumption data. The data is stored in a distributed database due to the large volume of information from millions of households. Recently, however, the system issued incorrect predictions during a heatwave, leading to unexpected blackouts.

Upon investigation, it was found that the system's algorithms were based on complex models that tried to capture too many variables, including some that were not relevant to the prediction.

### Aspects to Consider

**Storage:** The historical data is stored in a distributed database, which allows for massive analysis and querying of consumption patterns.

**Optimization:** Reduce the model's complexity by focusing only on the most relevant variables for prediction, thus increasing accuracy and reducing computational overload.

### Questions for Students

- What variables could have been eliminated from the model to reduce complexity without sacrificing accuracy?
- How could the distributed database be improved to store only truly useful and relevant data?
- What strategies could be implemented to simplify the demand prediction problem and optimize the system's responsiveness?
