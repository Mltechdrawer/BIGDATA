# Comparison of Storage Systems

Key differences between **Warehouse**, **Lake**, and **Lakehouse** Storage Systems.  

The comparison focuses on features such as Data types, Schema strategy, Use case focus, Storage cost/scalability and Performance/governance.  

---

## Conceptual Overview  

| Feature                     | Data Warehouse                                                                 | Data Lake                                                                                  | Data Lakehouse                                                                                       |
|----------------------------|----------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| **Data types**             | Primarily structured data.                                                       | Structured, semi-structured, unstructured.                                                  | All types: structured, semi-, unstructured.                                                            |
| **Schema strategy**        | Schema-on-write (strict, predefined).                                           | Schema-on-read (flexible).                                                                  | Supports both; more flexibility with governance.                                                       |
| **Use case focus**         | BI, dashboards, reporting, decision support.                                    | Data science, ML, exploratory analytics, raw data retention.                                | Unified analytics: BI + ML + real-time + batch.                                                        |
| **Storage cost / scalability** | Higher cost per unit; optimized for structured.                                 | Lower cost storage (object stores), highly scalable.                                        | Uses low-cost storage + performance enhancements; scales well.                                        |
| **Performance / governance** | High performance for structured queries, mature governance.                      | Less optimized for query performance; governance often weaker.                              | Performance comparable to warehouse, with strong governance and unified metadata.                      |
