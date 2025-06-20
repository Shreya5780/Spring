package org.example.quizeapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class QuestionList {

    List<Question> questions;

    @Bean
    public List<Question> genquestionsList() {
            return Arrays.asList(
                    new Question("What is the capital of France?",
                            "A", "London", "Berlin", "Rome", "Paris"),
                    new Question("Which planet is known as the Red Planet?",
                            "D", "Mars", "Jupiter", "Venus", "Mars"),
                    new Question("Who wrote 'Hamlet'?",
                            "D", "Dickens", "Hemingway", "Tolkien", "Shakespeare"),
                    new Question("What is the boiling point of water?",
                            "C", "100°C", "110°C", "120°C", "100°C"),
                    new Question("Which language runs in a web browser?",
                            "D", "C", "Python", "Java", "JavaScript")
            );
        }

    @Bean
    public List<Question> mlquestionsList() {
        return Arrays.asList(
                // Machine Learning
                new Question("What is the main goal of supervised learning?",
                        "D", "Predict outcomes based on labeled data", "Reduce dimensionality", "Cluster data into groups", "Predict outcomes based on labeled data"),
                new Question("Which algorithm is commonly used for classification tasks?",
                        "A", "Linear Regression", "Decision Tree", "PCA", "Decision Tree"),
                new Question("What does overfitting mean in machine learning?",
                        "C", "Model performs poorly on both training and test data", "Model has too few parameters", "Model uses unsupervised learning", "Model performs well on training data but poorly on new data"),
                new Question("Which metric is best for evaluating a classification model?",
                        "A", "Accuracy", "R-squared", "Euclidean Distance", "Accuracy"),
                new Question("What is the purpose of cross-validation?",
                        "B", "To reduce model complexity", "To evaluate model performance on unseen data", "To normalize features", "To evaluate model performance on unseen data")
                );
    }


    @Bean
    public List<Question> aiquestionsList() {

        return Arrays.asList(
        // Artificial Intelligence
        new Question("Which branch of AI deals with mimicking human reasoning?",
                "A", "Expert Systems", "Robotics", "Natural Language Processing", "Expert Systems"),
                new Question("What is the Turing Test used for?",
                        "B", "Testing AI's ability to exhibit human-like intelligence", "Evaluating neural networks", "Checking data quality", "Testing AI's ability to exhibit human-like intelligence"),
                new Question("Which AI technique is used in self-driving cars for decision-making?",
                        "C", "Rule-Based Systems", "Reinforcement Learning", "Clustering", "Reinforcement Learning"),
                new Question("What is the role of a knowledge base in an expert system?",
                        "D", "Store rules and facts", "Perform image recognition", "Generate random outputs", "Store rules and facts"),
                new Question("Which AI field focuses on understanding and generating human language?",
                        "C", "NLP", "Robotics", "Deep Learning", "NLP")
                );
    }

    @Bean
    public List<Question> dsaquestionsList() {
        return Arrays.asList(

                // Data Structures & Algorithms
                new Question("Which data structure uses LIFO (Last In First Out)?",
                        "C", "Stack", "Array", "Linked List", "Stack"),
                new Question("What is the time complexity of binary search in a sorted array?",
                        "C", "O(log n)", "O(n log n)", "O(1)", "O(log n)"),
                new Question("Which sorting algorithm is considered the fastest in average case?",
                        "B", "Merge Sort", "Quick Sort", "Selection Sort", "Quick Sort"),
                new Question("What is a hash table used for?",
                        "A", "Searching data efficiently", "Storing hierarchical data", "Traversing graphs", "Searching data efficiently"),
                new Question("Which graph traversal algorithm uses a queue?",
                        "D", "Breadth-First Search", "Dijkstra’s Algorithm", "Kruskal’s Algorithm", "Breadth-First Search")
        );
    }





}
