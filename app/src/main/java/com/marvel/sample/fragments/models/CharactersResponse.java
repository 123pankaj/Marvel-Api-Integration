package com.marvel.sample.fragments.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pankaj on 4/17/2017.
 */

public class CharactersResponse {

    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("attributionText")
    @Expose
    public String attributionText;
    @SerializedName("attributionHTML")
    @Expose
    public String attributionHTML;
    @SerializedName("etag")
    @Expose
    public String etag;
    @SerializedName("data")
    @Expose
    public Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("offset")
        @Expose
        public Integer offset;
        @SerializedName("limit")
        @Expose
        public Integer limit;
        @SerializedName("total")
        @Expose
        public Integer total;
        @SerializedName("count")
        @Expose
        public Integer count;
        @SerializedName("results")
        @Expose
        public List<Result> results = null;

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public class Result {

            @SerializedName("id")
            @Expose
            public Integer id;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("description")
            @Expose
            public String description;
            @SerializedName("modified")
            @Expose
            public String modified;
            @SerializedName("thumbnail")
            @Expose
            public Thumbnail thumbnail;
            @SerializedName("resourceURI")
            @Expose
            public String resourceURI;
            @SerializedName("comics")
            @Expose
            public Comics comics;
            @SerializedName("series")
            @Expose
            public Series series;
            @SerializedName("stories")
            @Expose
            public Stories stories;
            @SerializedName("events")
            @Expose
            public Events events;
            @SerializedName("urls")
            @Expose
            public List<Url> urls = null;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getModified() {
                return modified;
            }

            public void setModified(String modified) {
                this.modified = modified;
            }

            public Thumbnail getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(Thumbnail thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getResourceURI() {
                return resourceURI;
            }

            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            public Comics getComics() {
                return comics;
            }

            public void setComics(Comics comics) {
                this.comics = comics;
            }

            public Series getSeries() {
                return series;
            }

            public void setSeries(Series series) {
                this.series = series;
            }

            public Stories getStories() {
                return stories;
            }

            public void setStories(Stories stories) {
                this.stories = stories;
            }

            public Events getEvents() {
                return events;
            }

            public void setEvents(Events events) {
                this.events = events;
            }

            public List<Url> getUrls() {
                return urls;
            }

            public void setUrls(List<Url> urls) {
                this.urls = urls;
            }

            public class Thumbnail {

                @SerializedName("path")
                @Expose
                public String path;
                @SerializedName("extension")
                @Expose
                public String extension;

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }
            }

            public class Comics {

                @SerializedName("available")
                @Expose
                public Integer available;
                @SerializedName("collectionURI")
                @Expose
                public String collectionURI;
                @SerializedName("items")
                @Expose
                public List<Item> items = null;
                @SerializedName("returned")
                @Expose
                public Integer returned;

                public Integer getAvailable() {
                    return available;
                }

                public void setAvailable(Integer available) {
                    this.available = available;
                }

                public String getCollectionURI() {
                    return collectionURI;
                }

                public void setCollectionURI(String collectionURI) {
                    this.collectionURI = collectionURI;
                }

                public List<Item> getItems() {
                    return items;
                }

                public void setItems(List<Item> items) {
                    this.items = items;
                }

                public Integer getReturned() {
                    return returned;
                }

                public void setReturned(Integer returned) {
                    this.returned = returned;
                }

                public class Item {

                    @SerializedName("resourceURI")
                    @Expose
                    public String resourceURI;
                    @SerializedName("name")
                    @Expose
                    public String name;

                    public String getResourceURI() {
                        return resourceURI;
                    }

                    public void setResourceURI(String resourceURI) {
                        this.resourceURI = resourceURI;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

            }

            public class Series {

                @SerializedName("available")
                @Expose
                public Integer available;
                @SerializedName("collectionURI")
                @Expose
                public String collectionURI;
                @SerializedName("items")
                @Expose
                public List<Item_> items = null;
                @SerializedName("returned")
                @Expose
                public Integer returned;

                public Integer getAvailable() {
                    return available;
                }

                public void setAvailable(Integer available) {
                    this.available = available;
                }

                public String getCollectionURI() {
                    return collectionURI;
                }

                public void setCollectionURI(String collectionURI) {
                    this.collectionURI = collectionURI;
                }

                public List<Item_> getItems() {
                    return items;
                }

                public void setItems(List<Item_> items) {
                    this.items = items;
                }

                public Integer getReturned() {
                    return returned;
                }

                public void setReturned(Integer returned) {
                    this.returned = returned;
                }

                public class Item_ {

                    @SerializedName("resourceURI")
                    @Expose
                    public String resourceURI;
                    @SerializedName("name")
                    @Expose
                    public String name;

                    public String getResourceURI() {
                        return resourceURI;
                    }

                    public void setResourceURI(String resourceURI) {
                        this.resourceURI = resourceURI;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

            }

            public class Stories {

                @SerializedName("available")
                @Expose
                public Integer available;
                @SerializedName("collectionURI")
                @Expose
                public String collectionURI;
                @SerializedName("items")
                @Expose
                public List<Item__> items = null;
                @SerializedName("returned")
                @Expose
                public Integer returned;

                public Integer getAvailable() {
                    return available;
                }

                public void setAvailable(Integer available) {
                    this.available = available;
                }

                public String getCollectionURI() {
                    return collectionURI;
                }

                public void setCollectionURI(String collectionURI) {
                    this.collectionURI = collectionURI;
                }

                public List<Item__> getItems() {
                    return items;
                }

                public void setItems(List<Item__> items) {
                    this.items = items;
                }

                public Integer getReturned() {
                    return returned;
                }

                public void setReturned(Integer returned) {
                    this.returned = returned;
                }

                public class Item__ {

                    @SerializedName("resourceURI")
                    @Expose
                    public String resourceURI;
                    @SerializedName("name")
                    @Expose
                    public String name;
                    @SerializedName("type")
                    @Expose
                    public String type;

                    public String getResourceURI() {
                        return resourceURI;
                    }

                    public void setResourceURI(String resourceURI) {
                        this.resourceURI = resourceURI;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }

            }

            public class Events {

                @SerializedName("available")
                @Expose
                public Integer available;
                @SerializedName("collectionURI")
                @Expose
                public String collectionURI;
                @SerializedName("items")
                @Expose
                public List<Item___> items = null;
                @SerializedName("returned")
                @Expose
                public Integer returned;

                public Integer getAvailable() {
                    return available;
                }

                public void setAvailable(Integer available) {
                    this.available = available;
                }

                public String getCollectionURI() {
                    return collectionURI;
                }

                public void setCollectionURI(String collectionURI) {
                    this.collectionURI = collectionURI;
                }

                public List<Item___> getItems() {
                    return items;
                }

                public void setItems(List<Item___> items) {
                    this.items = items;
                }

                public Integer getReturned() {
                    return returned;
                }

                public void setReturned(Integer returned) {
                    this.returned = returned;
                }

                public class Item___ {

                    @SerializedName("resourceURI")
                    @Expose
                    public String resourceURI;
                    @SerializedName("name")
                    @Expose
                    public String name;

                    public String getResourceURI() {
                        return resourceURI;
                    }

                    public void setResourceURI(String resourceURI) {
                        this.resourceURI = resourceURI;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

            }


            public class Url {

                @SerializedName("type")
                @Expose
                public String type;
                @SerializedName("url")
                @Expose
                public String url;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

        }
    }
}
