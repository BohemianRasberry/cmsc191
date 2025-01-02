import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';
import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-goal',
  imports: [SharedModule],
  templateUrl: './goal.component.html',
  styleUrl: './goal.component.scss'
})
export class GoalComponent {
gridStyle = {
    width: '100%',
    textAlign: 'center'
  };
  
  goalForm!: FormGroup;
  goals: any;
  twotone: 'outline' | 'fill' | 'twotone' = 'twotone'; // Explicitly define the allowed string values
  constructor(
    private fb: FormBuilder, 
    private message: NzMessageService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.goalForm = this.fb.group({
      description: [null, [Validators.required]],
      startDate: [null, [Validators.required]],
      endDate: [null, [Validators.required]],
    });

    this.getAllGoals();
  }

  submitForm(): void {
    if (this.goalForm.valid) {
      this.userService.postGoal(this.goalForm.value).subscribe(
        res => {
          this.message.success('Goal posted successfully', { nzDuration: 3000 });
          this.goalForm.reset();

          this.getAllGoals();
        },
        error => {
          this.message.error('Error while posting Goal', { nzDuration: 3000 });
        }
      );
    } else {
      this.message.error('Please fill out the form correctly', { nzDuration: 3000 });
    }
  }

  getAllGoals(): void{
    this.userService.getGoals().subscribe(res=>{
      this.goals = res;
      console.log(this.goals);
    });
  }

  updateGoalStatus(id: number): void {
    console.log("Goal ID: ", id);
    this.userService.updateGoalsStatus(id).subscribe(
      res => {
        this.message.success('Goal status updated successfully', { nzDuration: 3000 });
        this.getAllGoals();
      },
      error => {
        this.message.error('Error while updating Goal status', { nzDuration: 3000 });
      }
    );
  }
}
