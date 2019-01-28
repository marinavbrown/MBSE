## EMSE 6817: Model-Based Systems Engineering (Spring 2019)

### Instructors:

**Spencer Breiner**, sjbreiner[at]gmail.com

**Eswaran (Sub) Subrahmanian**, sub[at]cmu.edu

---
### Basic Course Information

##### Time & Location:

Monroe Hall, Room 351

Monday, 3:30 PM - 6:00 PM


##### Prerequisites:
 EMSE 6801: Systems Engineering I

##### Course Materials:
 Course materials will be distributed electronically through the course [Github site](https://github.com/sjbreiner/MBSE).
 
 Readings will be posted [here](https://github.com/sjbreiner/MBSE/blob/master/Course%20Documents/Reading/reading.md).
 
 Homeworks will be posted [here](https://github.com/sjbreiner/MBSE/blob/master/Course%20Documents/Homework)
 
 Other course documents (like this syllabus) can be found [here](https://github.com/sjbreiner/MBSE/blob/master/Course%20Documents/)

---

### Course Description

This course will introduce students to a set of general techniques for building formal models based in mathematics and computation. We will develop a compositional approach to model-building, based on a small number of modeling primitives which can assembled in many different ways to address many different questions. 

The first half of the course will cover process representations, using them to explore the mantra: *A model is a mapping*. In particular, any model involves three parts which together define some sort of calculation:
- An abstract process representations expressed in terms of information and resource flows. This provides the plan for a calculation.
- A mathematical formalism such as probability or differential equations. This tells us how to perform the steps of the calculation.
- An assignment of abstract process elements (e.g., subprocesses) to mathematical entities (e.g., probabilities or differential equations). This tells us the actual values to use when evaluating the calculation.

The second half of the class will cover class-based and ontological approaches to system description. These use logical and graph-based representations to package, organize and validate system data. More importantly, we will discuss methods for integrating overlapping models, which allows us to build complex system-level models by putting together simpler pieces.

The course will be project-driven. Each student will select a project or domain of interest and, throughout the course, develop a portfolio of formal models relevant to that area. In the first half of the course you will work independently to develop models for your chosen domain. In the second half you will be teamed with other students in the class and expected to integrate your models to address more complex systems-level questions.

The approach that we follow in this course is based on a branch of mathematics called category theory, an abstract approach to the study of compositional systems. For completeness we will also cover several other formal and semi-formal modeling techniques including industry-standard UML/SysML, formal ontology language OWL and database language SQL.

---

### Course Schedule*

| Week | Date | Topic | Milestone(s) |
|---|---|---|---|
| 1 | 1/28 | Models in Systems Engineering | **HW0 assigned.** **Due 2/4**. |
| 2 | 2/4 | Process Modeling I: Process Models | **HW0 Due**. HW1 assigned. **Due 2/18.**|
| 3 | 2/11 | Process Modeling II: Refinement & Abstraction | |
| 4 | 2/18 | Analyzing Behavior I: Computation | **HW1 Due.** HW2 assigned. **Due 3/4.** |
| * | 2/25 | No class. President's Day | |
| 5 | 3/4 | Analyzing Behavior II: Probability | |
| * | 3/11 | No class. Spring break. |  |
| 6 | 3/18 | Analyzing Behavior III: Dynamics | **HW2 Due.** |
| 7 | 3/25 | Domain models | **Solo Presentation** |.
| 8 | 4/1 | Semantic Modeling I: Schemas | HW3 assigned. **Due 4/22.** |
| 9 | 4/8 | Semantic Modeling II: Data | |
| 10 | 4/15 | Semantic Modeling III: Queries & Data Transformation | |
| 11 | 4/22 | Semantic Bridges I: Aggregating Models | **HW3 Due.** |
| 12 | 4/29 | Semantic Bridges II: Compositional Systems | |
| 13 | 5/2 or 5/3 | System models| **Group Presentation.**|
| * | 5/6 | No exam. Final Report Due  | **Group Report Due.** |

\*Subject to change

---
### Grading

Your grade will be computed as a weighted average with the following weights:

| **Assignment** | **Value** |**Assignment** | **Value** |
|---|---|---|---|
| HW0 | 4% | Solo Presentation | 8% |
| HW1 | 12% | Group Presentation | 12% |
| HW2 | 12% | Group Report | 25% |
| HW3 | 12% | Participation | 5% |
| Quizzes | 10% | | |

The translation between numeric and letter grades is:

| | | | | | |
|---|---|---|---|---|---|
| **A** | 93-100- |  **B-** | 87-89.9 | **C-** | 74-76.9 |
| **A-** | 90-92.9 | **B** | 80-86.9 | **C** | 64-73.9 |
| **F** | < 60 | **B-** | 77-79.9 | **C-** | 60-63.9 |


#### Attendance

Although attendance is not strictly required, there will be a quiz at the beginning of most class meetings.

In the case of emergencies or *pre-approved* absences (e.g., [religious holiday](https://registrar.gwu.edu/university-policies#holidays)) the quiz will be substituted by a written assignment. A request for approved absence must be submitted to the instructors by email at least one week prior. **No absences will be approved for the presentation dates 3/18 and 4/29**.

#### Late Work

Assignments are due **before** 3:30 PM (class time) on the date listed in the course schedule above. All assignments should be submitted to both instructors via email (addresses listed above).

Late submissions will be penalized as follows:

- 0-24 hours late (including during class): 90% credit
- 24-72 hours: 70% credit
- Any assignment more than three days late will be dealt with on an individual basis and **may not be accepted**.

#### Reading

We will assign readings for each week of class, which will be posted [here](https://github.com/sjbreiner/MBSE/blob/master/Course%20Documents/Reading/reading.md), organized by week. New readings will be posted no later than classtime, one week before they are due.

You are responsible for studying all assigned readings by the beginning of the following class. Basic material from the reading will often appear in the weekly quizzes, and you may be asked to summarize elements of the reading in class.

#### Participation

Many activities in class will involve sharing, explaining and critiquing simple models that we develop in class. All students will be expected to actively participate in these discussions, and your contribution to the class will be reflected in a small portion (5%) of your overall grade.

---

### Course Objectives

#### Learning Outcomes

On completion of the course, students will be able to: 

- Model a system processes at 2-3 levels of abstraction, and formally document the relationships between these models.
- Convert a process representation into a behavioral model in a formal domain such as  probability, dynamical systems or computer science.
- Build a domain-specific language (semantic model) to represent background knowledge and requirements for some aspect of a system process. 
- Build formal mappings (bridges) between multiple models, and use these to analyze a systems-level question which depends on multiple domains or sub-systems.

#### Instructor’s Mission Statement
- To provide students with tools and methods for developing formal models of system organization and behavior, and to illustrate these through diverse examples.
- To engage each student in a concrete application of these methods based on their own expertise and interest.
- To enhance and evaluate a student’s academic independence and critical thinking.
- To regularly solicit feedback to improve the quality of lectures and course materials.

---

### Other information

#### Special Needs

If you have any special needs which may impact your ability to succeed in the course, please let the instructors know within the first two weeks of class (before the end of January) to develop an alternative work plan.

You may also want to contact one of GWU's student support services:

- [Disability Support Services (DSS)](https://disabilitysupport.gwu.edu/), 202-994-8250, Rome Hall, Suite 102
- [Mental Health Services](https://counselingcenter.gwu.edu/), 202-994-5300 



#### Academic Integrity:

You will be expected to behave according to basic standards of academic integrity. For the full code of conduct see the [GWU Code of Academic Integrity](https://studentconduct.gwu.edu/code-academic-integrity).

Always:

- Acknowledge all sources and collaborators for homework, projects and other assignments.
- Work independently on quizzes and other assignments specified as individual work.
- Acknowledge any assistance that you provide to other students.

Never:

- Cheat.
- Misrepresent your work as someone else's.
- Take credit for the work of others.
- Fabricate information.
- Plagiarize.

With regards to plagiarism, it is not okay to copy or to paraphrase other people’s words and ideas without giving proper attribution (e.g., quotation marks for direct quotes, reference and citation, etc.). When paraphrasing, actually use your own words. Do not, e.g., substitute synonyms into the original author's sentence.

You are expected to know how to correctly quote and cite material. If you need assistance with this, please contacct the [GWU Writing Center](https://writingcenter.gwu.edu/).

#### Security and Safety

Current information on any safety & security issues around campus (e.g., weather closures) can be found [campus advisory page](http://www.campusadvisories.gwu.edu/). You may also want to enrol in mobile alerts by signing into the [GWeb Information](https://banweb.gwu.edu/PRODCartridge/twbkwbis.P_WWW) site and updating your contact information to include mobile devices.

In the event of a life-threatening emergency on campus, please call 202-994-6111.










