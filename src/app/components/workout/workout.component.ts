import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-workout',
  imports: [SharedModule],
  templateUrl: './workout.component.html',
  styleUrl: './workout.component.scss'
})
export class WorkoutComponent {
  gridStyle = {
    width: '100%',
    textAlign: 'center'
  }

  workoutForm!: FormGroup;
  workouts: any[] = [];

  listOfType: any[] = [
    "Cardio",
    "Stregth",
    "Flexibility",
    "HIIT",
    "Pilates",
    "Crossfit",
    "Dance",
    "Swimming",
    "Cycling",
    "Running",
    "Walking",
    "Boxing",
    "Rowing",
    "Stretching",
    "Martial Arts",
    "Gymnastics",
    "Climbing",
    "Plyometrics"
  ];

  constructor(
      private fb: FormBuilder, 
      private message: NzMessageService,
      private userService: UserService
    ) {}

    ngOnInit(): void {
        this.workoutForm = this.fb.group({
          type: [null, [Validators.required]],
          duration: [null, [Validators.required]],
          caloriesBurnt: [null, [Validators.required]],
          date: [null, [Validators.required]]
        });

        this.getAllWorkouts();
    }

    getAllWorkouts(): void{
      this.userService.getWorkouts().subscribe(res=>{
        this.workouts = res;
        console.log(this.workouts);
      });
    }

    submitForm(): void {
      if (this.workoutForm.valid) {
        this.userService.postWorkout(this.workoutForm.value).subscribe(
          res => {
            this.message.success('Workout posted successfully', { nzDuration: 3000 });
            this.workoutForm.reset();
            this.getAllWorkouts();
          },
          error => {
            this.message.error('Error while posting Workout', { nzDuration: 3000 });
          }
        );
      } else {
        this.message.error('Please fill out the form correctly', { nzDuration: 3000 });
      }
    }
}
