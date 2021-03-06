package com.eventyay.organizer.core.attendee.list.listeners;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.mikepenz.fastadapter.utils.EventHookUtil;

import com.eventyay.organizer.data.attendee.Attendee;
import com.eventyay.organizer.core.attendee.list.AttendeesView;
import com.eventyay.organizer.core.attendee.list.viewholders.AttendeeViewHolder;

import java.util.List;

public class AttendeeItemCheckInEvent extends ClickEventHook<Attendee> {

    private final AttendeesView attendeesView;

    @Nullable
    @Override
    public List<View> onBindMany(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof AttendeeViewHolder) {
            return EventHookUtil.toList(((AttendeeViewHolder) viewHolder).getRoot());
        }
        return super.onBindMany(viewHolder);
    }

    public AttendeeItemCheckInEvent(AttendeesView attendeesView) {
        this.attendeesView = attendeesView;
    }

    @Override
    public void onClick(View view, int position, FastAdapter<Attendee> fastAdapter, Attendee attendee) {
        attendeesView.showToggleDialog(attendee.getId());
    }
}
