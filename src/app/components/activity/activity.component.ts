import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { SharedModule } from '../../shared/shared.module';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-activity',
  standalone: true,
  imports: [
    SharedModule // Import SharedModule
  ],
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.scss']
})
export class ActivityComponent implements OnInit {
  gridStyle = {
    width: '100%',
    textAlign: 'center'
  };
  
  activityForm!: FormGroup;
  activities: any;

  constructor(
    private fb: FormBuilder, 
    private message: NzMessageService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.activityForm = this.fb.group({
      caloriesBurnt: [null, [Validators.required]],
      distance: [null, [Validators.required]],
      steps: [null, [Validators.required]],
      date: [null, [Validators.required]]
    });

    this.getAllActivities();
  }

  submitForm(): void {
    if (this.activityForm.valid) {
      this.userService.postActivity(this.activityForm.value).subscribe(
        res => {
          this.message.success('Activity posted successfully', { nzDuration: 3000 });
          this.activityForm.reset();

          this.getAllActivities();
        },
        error => {
          this.message.error('Error while posting Activity', { nzDuration: 3000 });
        }
      );
    } else {
      this.message.error('Please fill out the form correctly', { nzDuration: 3000 });
    }
  }

  getAllActivities(): void{
    this.userService.getActivities().subscribe(res=>{
      this.activities = res;
      console.log(this.activities);
    });
  }
}