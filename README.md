# GeneticScheduling

A Scheduler which uses genetic algorithm to book machines and required machining operations on part-lots.

## Overview

Java app Project developed in 2015. It used real part CAPP resulting files. Basically, you have a shop floor with some machines with different cappabilities, costs and time to process. On the other hand, your company have orders with different parts to be processed, each part demands a group of operations, potentially done in multiple machines (milling, drilling, turning, etc). Which is the best combination, sequence of operations that can minimize cost or time? The software is meant to answer this question by using genetic algorithm. Each child created represents a possible solution for scheduling teh required processes. The algorithm iterates in some user defined generations, with a certain population (other settings are also available).
The challenges of transportation time, sequencing of operations, machine exclusivity and capability constraint (a turning machine cannot be used for milling), etc, are all programmed.

## Installation

This project was implemented using JRE1.7, this version is recommended inn order to run the code. 
Data used must be compliient with Step-NC standard. 
In order to plot results, you must include the J-free-chart to the project too. https://www.jfree.org/jfreechart/index.html

