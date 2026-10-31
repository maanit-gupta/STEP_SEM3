# STEP Semester 3 Solutions

> **Student Name:** Maanit Gupta  
> **Registration Number:** RA2511003012384  
> **Course:** STEP (Student Talent Enhancement Program) — Semester 3  

This repository contains the complete solutions for all **STEP Semester 3** Java programming problems, covering both in-class live coding problems and homework/assignment problems across each weekly session.

---

## 📌 Sessions Overview

| Session | Focus / Topic | Branch | Date of Completion | Status |
| :---: | :--- | :--- | :---: | :---: |
| **Session 1** | Java Basics, Control Flow, Methods & Strings | `feature/session_1` | 29-08-2026 | Completed |
| **Session 2 & 3** | String Processing, Regex & CSV Parsing | `feature/session_2`, `feature/session_3` | 05-09-2026 | Completed |
| **Session 4** | Arrays, Two Pointers & Sliding Window (Category C) | `feature/session_4` | 05-09-2026 | Completed |
| **Session 5** | 2D Arrays, Matrix Operations & Grid Simulation | `feature/session_5` | 05-09-2026 | Completed |
| **Session 6** | OOP: Classes, Objects, Constructors & State | `feature/session_6` | 12-09-2026 | Completed |
| **Session 7** | OOP: Encapsulation, Access Modifiers & Invariants | `feature/session_7` | 19-09-2026 | Completed |
| **Session 8** | OOP: Polymorphism, Method Overriding & Dispatch | `feature/session_8` | 26-09-2026 | Completed |
| **Session 9** | OOP: Abstraction & Interface Implementations | `feature/session_9` | 03-10-2026 | Completed |
| **Session 10** | Category C DS & Problem Solving Practice | `feature/session_10` | 11-10-2026 | Completed |
| **Session 11** | Category C: Search, Hashing, Sorting Algorithms | `feature/session_11` | 31-10-2026 | Completed |

---

## 🗂️ Repository Structure

```
STEP_SEM3/
├── README.md
├── .gitignore
└── src/
    └── main/
        └── java/
            ├── week1/
            │   ├── class_problems/        # In-class live coding solutions
            │   │   └── *.java
            │   └── assignment_problems/   # Homework / assignment solutions
            │       └── *.java
            ├── week2/
            │   ├── class_problems/
            │   └── assignment_problems/
            ├── ...
            ├── week10/
            │   ├── classwork/
            │   └── homework/
            └── week11/
                ├── classwork/             # 10 Category C Part A problems
                │   ├── LibraryCatalogLookup.java
                │   ├── WarehouseBinGridScan.java
                │   ├── TransactionDuplicateCheck.java
                │   ├── EmployeeIdLookup.java
                │   ├── PairWithTargetSum.java
                │   ├── BestSingleTradeProfit.java
                │   ├── InsertPositionInSortedList.java
                │   ├── SpiralOrderTraversal.java
                │   ├── PairSumSortedArray.java
                │   └── RemoveDuplicatesSortedArray.java
                └── homework/              # 5 Sorting Algorithm assignments
                    ├── HeightLineUp.java
                    ├── PrizeTable.java
                    ├── LibraryBookShelf.java
                    ├── QueueOrderCheck.java
                    └── DiceThrowTally.java
```

### Conventions

| Item | Convention | Example |
|------|-----------|---------|
| **Branch** | `feature/session_<N>` | `feature/session_11` |
| **Source root** | `src/main/java/` | — |
| **Week folder** | `week<N>/` | `week11/` |
| **Classwork folder** | `classwork/` or `class_problems/` | `week11/classwork/` |
| **Homework folder** | `homework/` or `assignment_problems/` | `week11/homework/` |
| **Package declaration** | `package week<N>.classwork;` or `package week<N>.homework;` | `package week11.classwork;` |
| **File naming** | PascalCase, descriptive `.java` file | `LibraryCatalogLookup.java` |
| **Tracked files** | Only `.java` source files (no `.class`, no IDE configs) | — |

> **Note:** Sessions 1–5 use `class_problems/` and `assignment_problems/` as subfolder names; Sessions 6+ use `classwork/` and `homework/`. Both are valid — stay consistent within a session.

---

## 📚 Detailed Session Breakdown

### Session 1 — Java Fundamentals & Control Flow
- **Completion Date:** 29-08-2026
- **Branch:** `feature/session_1`
- **Class Problems:**
  1. `BMICalculator.java` — Body Mass Index calculator and health classification
  2. `FirstNonRepeatingCharacter.java` — Find the first non-repeating character in a string
  3. `PalindromeChecker.java` — Check if a string is a palindrome
  4. `ReverseCustomerName.java` — Customer name string reversal
  5. `RockPaperScissorsGame.java` — Interactive rock-paper-scissors game simulator
- **Assignment Problems:**
  1. `ExamHallSeatDuplicationChecker.java` — Duplicate seat assignment detector
  2. `MovieReviewWordLengthProfiler.java` — Word length profiling for reviews
  3. `TrafficSignalStreakAnalyzer.java` — Traffic signal state streak analyzer
  4. `TypingSpeedTestAccuracyChecker.java` — Typing accuracy checker
  5. `WarehouseInventoryBalancer.java` — Stock and inventory rebalance calculator

---

### Session 2 & 3 — String Manipulation, Validation & CSV Parsing
- **Completion Date:** 05-09-2026
- **Branch:** `feature/session_2` / `feature/session_3`
- **Class Problems:**
  1. `BankTransactionReferenceValidator.java` — Bank transaction reference format validator
  2. `CSVStudentRecordParser.java` — CSV student record parser and serializer
  3. `FileExtensionValidator.java` — Allowed file extension checker
  4. `MaskedPhoneNumberFormatter.java` — Phone number masking utility
  5. `VowelConsonantCounter.java` — Count vowels and consonants in text
- **Assignment Problems:**
  1. `ATMPinLengthValidator.java` — ATM PIN length and numeric validator
  2. `LibraryISBNValidator.java` — ISBN-10 / ISBN-13 normalizer and validator
  3. `ProductInventoryCSVParser.java` — Inventory CSV parser with validation
  4. `StopWordFrequencyReport.java` — Stop-word filtered word frequency generator
  5. `WordReversalEncoder.java` — Word-by-word sentence encoder

---

### Session 4 — Arrays, Two Pointers & Algorithmic Optimization
- **Completion Date:** 05-09-2026
- **Branch:** `feature/session_4`
- **Class Problems:**
  1. `TwoSum.java` — Find two numbers that sum up to a target
  2. `BestTimeToBuyAndSellStock.java` — Maximize profit from stock trading
  3. `ContainsDuplicate.java` — Identify duplicate values in an array
  4. `MergeTwoSortedArrays.java` — In-place merge of two sorted arrays
  5. `RotateArray.java` — Rotate array elements by k steps
- **Assignment Problems:**
  1. `ProductOfArrayExceptSelf.java` — Product of array elements except self
  2. `MaximumSubarray.java` — Largest sum contiguous subarray (Kadane's Algorithm)
  3. `ThreeSum.java` — Triplets summing to zero
  4. `SubarraySumEqualsK.java` — Total contiguous subarrays whose sum equals k
  5. `FindMinimumInRotatedSortedArray.java` — Binary search in rotated sorted array

---

### Session 5 — 2D Arrays, Matrix Operations & Grid Simulations
- **Completion Date:** 05-09-2026
- **Branch:** `feature/session_5`
- **Class Problems:**
  1. `Top3PodiumFinder.java` — Identify top 3 scoring teams/participants
  2. `PlacementDriveShortlistingRankingEngine.java` — Candidate shortlisting & ranking engine
  3. `HackathonScoreCurveBooster.java` — Matrix score normalization & boosting
  4. `HackathonSeatingGridOptimizer.java` — Seating layout grid optimization
  5. `DuplicateTeamNameFinder.java` — Duplicate team detection across batches
- **Assignment Problems:**
  1. `FantasyLeagueAutoDraftRankingEngine.java` — Fantasy draft ranking engine
  2. `FantasyTeamScoreMultiplier.java` — Score multiplier calculator based on performance
  3. `MatchDayGridAnalyzer.java` — Match day grid analysis
  4. `TopPerformerTracker.java` — Top performer tracking across rounds
  5. `DuplicatePlayerPickChecker.java` — Disallow duplicate player selections

---

### Session 6 — OOP: Classes, Objects & Constructors
- **Completion Date:** 12-09-2026
- **Branch:** `feature/session_6`
- **Classwork:**
  1. `Student.java` — Student class model with roll number, name, and GPA
  2. `IdCard.java` — Student identity card model
  3. `Course.java` — Course registration and credit calculation
  4. `MessWallet.java` — Digital mess wallet transactions & balance
  5. `PlacementRecord.java` — Placement eligibility & recruitment record
- **Assignment:**
  1. `Employee.java` — Employee profile and designation management
  2. `EmployeeCompany.java` — Association between employees and company records
  3. `BookInventory.java` — Library book inventory management
  4. `HallTicket.java` — Examination hall ticket generator and validator
  5. `PayrollAccount.java` — Employee salary calculation and payroll account

---

### Session 7 — OOP: Encapsulation & Data Invariants
- **Completion Date:** 19-09-2026
- **Branch:** `feature/session_7`
- **Classwork:**
  1. `AttendanceSheet.java` — Attendance percentage tracker with eligibility checks
  2. `Locker.java` — Secure digital locker with PIN management
  3. `NameTag.java` — Standardized name tag generator
  4. `PiggyBank.java` — Encapsulated savings balance with deposit/withdrawal invariants
  5. `Scorecard.java` — Academic scorecard with grade computation
- **Assignment:**
  1. `Cart.java` — E-commerce shopping cart with item addition and discount constraints
  2. `Character.java` — RPG character attributes (health, mana, defense)
  3. `PasswordChecker.java` — Password policy and strength validator
  4. `Playlist.java` — Music playlist management with bounded track capacity
  5. `TrafficLight.java` — Automated traffic light state transitions

---

### Session 8 — OOP: Polymorphism & Dynamic Dispatch
- **Completion Date:** 26-09-2026
- **Branch:** `feature/session_8`
- **Classwork:**
  1. `DeliveryFeeCalculator.java` — Tiered and distance-based delivery fee calculations
  2. `ExamQuestionGrader.java` — Multi-type question grading system
  3. `LibraryDueDateCalculator.java` — Membership tier-based loan duration calculator
  4. `PaymentSystem.java` — Multi-channel payment processor (Card, UPI, NetBanking)
  5. `TransportFareCalculator.java` — Public transit fare calculator across vehicle types
- **Assignment:**
  1. `CanteenBillingCounter.java` — Canteen item billing with tiered discounts
  2. `FestivalBonusCalculator.java` — Role-based festival bonus calculator
  3. `HostelElectricityBill.java` — Slab-based electricity tariff computation
  4. `ParkingChargeCalculator.java` — Vehicle-type specific parking fare calculator
  5. `StreamingPlanRenewal.java` — Subscription renewal calculator with promotions

---

### Session 9 — OOP: Abstraction & Interfaces
- **Completion Date:** 03-10-2026
- **Branch:** `feature/session_9`
- **Classwork:**
  1. `ElectricityConnectionBilling.java` — Abstract base for residential & commercial utility billing
  2. `GardenPlotAreaReport.java` — Geometric shape abstraction for area calculation
  3. `LibraryLateFineCounter.java` — Asset fine counter with abstract calculation rules
  4. `TravelBookingWithCommonFee.java` — Travel booking system with common interface fee
  5. `WeeklyStaffPay.java` — Abstract staff payroll system (hourly vs salaried)
- **Homework:**
  1. `CityCabFareMeter.java` — Cab fare meter implementing fare calculation interfaces
  2. `CollegeFeeCounter.java` — Tuition fee counter with scholarship deductions
  3. `HomeApplianceEnergyReport.java` — Appliance power rating and energy calculation
  4. `MovieTicketCounter.java` — Cinema ticketing engine with dynamic showtime rates
  5. `ParcelShippingDesk.java` — Weight-based shipping counter (Standard vs Express)

---

### Session 10 — Category C Data Structures & Coding Practice
- **Completion Date:** 11-10-2026
- **Branch:** `feature/session_10`
- **Classwork:**
  1. `VowelConsonantCounter.java` — Vowel and consonant counter (case-insensitive)
  2. `PalindromeChecker.java` — Word reverser and palindrome checker using `StringBuilder`
  3. `EvenAndOddNumbersInList.java` — Even and odd integer counts in a list
  4. `InPlaceArrayReversal.java` — In-place two-pointer array element reversal
  5. `DigitSumAndNumberReversal.java` — Integer digit sum and reversal
  6. `PrimeNumberChecker.java` — Square root optimized prime number validator
  7. `FactorialCalculation.java` — Non-negative integer factorial calculation
  8. `StudentGradeAssignment.java` — Criteria-based student score to letter grade mapping
  9. `LeapYearDetector.java` — Gregorian calendar leap year detector
  10. `StudentResultCardGenerator.java` — Student result card generator with average and grade calculation
- **Homework:**
  1. `BusiestBusRow.java` — Finds the busiest row in a college bus seating grid (O(r * c) time, O(1) space)
  2. `AttendanceSummary.java` — Single-pass student attendance summary & longest streak (O(n) time, O(1) space)
  3. `RotateRoster.java` — Duty roster rotation by k places using k % n (O(n) time, O(n) space)
  4. `CountInBand.java` — Logarithmic band range count using lower & upper bound binary search (O(log n) time, O(1) space)
  5. `SecondHighestScore.java` — Second-highest distinct score without sorting (O(n) time, O(1) space)

---

### Session 11 — Category C: Search, Hashing & Sorting Algorithms
- **Completion Date:** 31-10-2026
- **Branch:** `feature/session_11`
- **Classwork (Part A — Coding Problems):**
  1. `LibraryCatalogLookup.java` — Binary search on sorted ISBN catalog (O(log n) time, O(1) space)
  2. `WarehouseBinGridScan.java` — Grid scan for total item count & max-bin coordinates (O(m·n) time, O(1) space)
  3. `TransactionDuplicateCheck.java` — HashSet-based duplicate detection (O(n) time, O(n) space)
  4. `EmployeeIdLookup.java` — HashMap build & O(1) department lookup
  5. `PairWithTargetSum.java` — HashSet complement check for two-sum (O(n) time, O(n) space)
  6. `BestSingleTradeProfit.java` — Single-pass min-price tracking for max profit (O(n) time, O(1) space)
  7. `InsertPositionInSortedList.java` — Binary search insert position (O(log n) time, O(1) space)
  8. `SpiralOrderTraversal.java` — Four-boundary clockwise spiral traversal (O(m·n) time)
  9. `PairSumSortedArray.java` — Two-pointer pair sum on sorted array (O(n) time, O(1) space)
  10. `RemoveDuplicatesSortedArray.java` — In-place two-pointer deduplication (O(n) time, O(1) space)
- **Homework (Sorting Algorithms):**
  1. `HeightLineUp.java` — Bubble Sort with pass-by-pass printing & early termination
  2. `PrizeTable.java` — Selection Sort (descending) with actual swap counting
  3. `LibraryBookShelf.java` — Insertion Sort with shelf state after each placement
  4. `QueueOrderCheck.java` — Single-pass sorted-order validation (returns first break index)
  5. `DiceThrowTally.java` — Counting Sort for dice rolls (1–6), no element comparisons