import { useState } from "react";
import { movies } from "./data.js"

function Movies() {

    const [movieList, setMovies] = useState(movies);
    // console.log(movieList);

    function onBtnClick(gener){
        if(gener!="All"){
            setMovies(movies.filter(item =>item.category == gener));
        }
        else{
            setMovies(movies.filter(item =>item.category != gener));
        }

    }

    return (
        <>
            <div className="mt-5 flex gap-3">
                <button className="btn btn-outline btn-warning" onClick={()=>{onBtnClick("All")}}>All</button>
                <button className="btn btn-outline btn-warning" onClick={()=>{onBtnClick("Action")}}>Action</button>
                <button className="btn btn-outline btn-primary" onClick={()=>{onBtnClick("Thriller")}}>Thriller</button>
                <button className="btn btn-outline btn-secondary" onClick={()=>{onBtnClick("Animation")}}>Animation</button>
                <button className="btn btn-outline btn-error" onClick={()=>{onBtnClick("Horror")}}>Horror</button>
                <button className="btn btn-outline btn-info" onClick={()=>{onBtnClick("Drama")}}>Drama</button>
                <button className="btn btn-outline btn-success" onClick={()=>{onBtnClick("Sci-Fi")}}>Sci-Fi</button>
            </div>


            <div className="w-[90%] flex flex-wrap gap-10 justify-center">
                {movieList.map((item, index) => (
                    <div key={index} style={{ width: "250px" }} className="flex flex-col gap-2 items-center p-5 bg-gray-700 rounded-2xl">
                        <div className="overflow-hidden border-1 border-yellow-200 mb-4">
                            <img className="transform transition-transform duration-300 hover:scale-110" style={{ width: "100%", padding: "1px" }} src={item.poster_path} />
                        </div>
                        <h2 className="text-lg">{item.title}</h2>
                        <p className="text-md">{item.release_date}</p>
                    </div>
                ))}
            </div>
        </>
    )
}

export default Movies;