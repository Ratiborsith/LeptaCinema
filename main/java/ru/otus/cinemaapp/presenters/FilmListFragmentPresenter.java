package ru.otus.cinemaapp.presenters;

import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.util.List;

import androidx.lifecycle.Observer;
import ru.otus.cinemaapp.model.Movie;
import ru.otus.cinemaapp.repo.FilmRepositoryInt;

public class FilmListFragmentPresenter {

    private FilmRepositoryInt repository;

    public FilmListFragmentPresenter(FilmRepositoryInt repository) {
        this.repository = repository;
    }





    public List<Integer> getRemarkableFilmsIdsList() {
        return repository.getRemarkableFilmsIdsList();
    }


    private void checkIsFirstStartToday() {
        if (isFirstStartToday()) {
            repository.updateAllMovies();
            repository.setFirstStartDate(LocalDate.now());
        }
    }

    private boolean isFirstStartToday() {
        LocalDate localDateNow = LocalDate.now();
        LocalDate firstStartDate = repository.getFirstStartDate();
        return !firstStartDate.isEqual(localDateNow);
    }

    public void onFilmItemLongClicked(int position) {
        Movie movie = repository.getMovies().get(position);
        List<Integer> remarkableFilmsIdsList = repository.getRemarkableFilmsIdsList();
        boolean isRemarkable = false;
        if (remarkableFilmsIdsList.contains(movie.id)) {
            remarkableFilmsIdsList.remove(movie.id);
        } else {
            remarkableFilmsIdsList.add(movie.id);
            isRemarkable = true;
        }
        repository.setRemarkableFilmsIds(remarkableFilmsIdsList);

    }
}
