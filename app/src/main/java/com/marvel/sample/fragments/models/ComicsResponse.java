package com.marvel.sample.fragments.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pankaj on 4/16/2017.
 */

public class ComicsResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("attributionText")
    @Expose
    private String attributionText;
    @SerializedName("attributionHTML")
    @Expose
    private String attributionHTML;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("data")
    @Expose
    private Data data;

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
        private Integer offset;
        @SerializedName("limit")
        @Expose
        private Integer limit;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("results")
        @Expose
        private List<Result> results = null;

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
            private Integer id;
            @SerializedName("digitalId")
            @Expose
            private Integer digitalId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("issueNumber")
            @Expose
            private Integer issueNumber;
            @SerializedName("variantDescription")
            @Expose
            private String variantDescription;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("modified")
            @Expose
            private String modified;
            @SerializedName("isbn")
            @Expose
            private String isbn;
            @SerializedName("upc")
            @Expose
            private String upc;
            @SerializedName("diamondCode")
            @Expose
            private String diamondCode;
            @SerializedName("ean")
            @Expose
            private String ean;
            @SerializedName("issn")
            @Expose
            private String issn;
            @SerializedName("format")
            @Expose
            private String format;
            @SerializedName("pageCount")
            @Expose
            private Integer pageCount;
            @SerializedName("textObjects")
            @Expose
            private List<TextObject> textObjects = null;
            @SerializedName("resourceURI")
            @Expose
            private String resourceURI;
            @SerializedName("urls")
            @Expose
            private List<Url> urls = null;
            @SerializedName("series")
            @Expose
            private Series series;
            @SerializedName("variants")
            @Expose
            private List<Object> variants = null;
            @SerializedName("collections")
            @Expose
            private List<Object> collections = null;
            @SerializedName("collectedIssues")
            @Expose
            private List<Object> collectedIssues = null;
            @SerializedName("dates")
            @Expose
            private List<Date> dates = null;
            @SerializedName("prices")
            @Expose
            private List<Price> prices = null;
            @SerializedName("thumbnail")
            @Expose
            private Thumbnail thumbnail;
            @SerializedName("images")
            @Expose
            private List<Object> images = null;
            @SerializedName("creators")
            @Expose
            private Creators creators;
            @SerializedName("characters")
            @Expose
            private Characters characters;
            @SerializedName("stories")
            @Expose
            private Stories stories;
            @SerializedName("events")
            @Expose
            private Events events;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getDigitalId() {
                return digitalId;
            }

            public void setDigitalId(Integer digitalId) {
                this.digitalId = digitalId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getIssueNumber() {
                return issueNumber;
            }

            public void setIssueNumber(Integer issueNumber) {
                this.issueNumber = issueNumber;
            }

            public String getVariantDescription() {
                return variantDescription;
            }

            public void setVariantDescription(String variantDescription) {
                this.variantDescription = variantDescription;
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

            public String getIsbn() {
                return isbn;
            }

            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }

            public String getUpc() {
                return upc;
            }

            public void setUpc(String upc) {
                this.upc = upc;
            }

            public String getDiamondCode() {
                return diamondCode;
            }

            public void setDiamondCode(String diamondCode) {
                this.diamondCode = diamondCode;
            }

            public String getEan() {
                return ean;
            }

            public void setEan(String ean) {
                this.ean = ean;
            }

            public String getIssn() {
                return issn;
            }

            public void setIssn(String issn) {
                this.issn = issn;
            }

            public String getFormat() {
                return format;
            }

            public void setFormat(String format) {
                this.format = format;
            }

            public Integer getPageCount() {
                return pageCount;
            }

            public void setPageCount(Integer pageCount) {
                this.pageCount = pageCount;
            }

            public List<TextObject> getTextObjects() {
                return textObjects;
            }

            public void setTextObjects(List<TextObject> textObjects) {
                this.textObjects = textObjects;
            }

            public String getResourceURI() {
                return resourceURI;
            }

            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            public List<Url> getUrls() {
                return urls;
            }

            public void setUrls(List<Url> urls) {
                this.urls = urls;
            }

            public Series getSeries() {
                return series;
            }

            public void setSeries(Series series) {
                this.series = series;
            }

            public List<Object> getVariants() {
                return variants;
            }

            public void setVariants(List<Object> variants) {
                this.variants = variants;
            }

            public List<Object> getCollections() {
                return collections;
            }

            public void setCollections(List<Object> collections) {
                this.collections = collections;
            }

            public List<Object> getCollectedIssues() {
                return collectedIssues;
            }

            public void setCollectedIssues(List<Object> collectedIssues) {
                this.collectedIssues = collectedIssues;
            }

            public List<Date> getDates() {
                return dates;
            }

            public void setDates(List<Date> dates) {
                this.dates = dates;
            }

            public List<Price> getPrices() {
                return prices;
            }

            public void setPrices(List<Price> prices) {
                this.prices = prices;
            }

            public Thumbnail getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(Thumbnail thumbnail) {
                this.thumbnail = thumbnail;
            }

            public List<Object> getImages() {
                return images;
            }

            public void setImages(List<Object> images) {
                this.images = images;
            }

            public Creators getCreators() {
                return creators;
            }

            public void setCreators(Creators creators) {
                this.creators = creators;
            }

            public Characters getCharacters() {
                return characters;
            }

            public void setCharacters(Characters characters) {
                this.characters = characters;
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

            public class TextObject {

                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("language")
                @Expose
                private String language;
                @SerializedName("text")
                @Expose
                private String text;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            } /*TextObject End*/

            public class Url {

                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("url")
                @Expose
                private String url;

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
            }  /*URL END*/

            public class Series {

                @SerializedName("resourceURI")
                @Expose
                private String resourceURI;
                @SerializedName("name")
                @Expose
                private String name;

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
            } /*SERIES*/


            public class Date {

                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("date")
                @Expose
                private String date;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }
            }  /*DATE END*/

            public class Price {

                @SerializedName("type")
                @Expose
                private String type;
                @SerializedName("price")
                @Expose
                private Float price;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Float getPrice() {
                    return price;
                }

                public void setPrice(Float price) {
                    this.price = price;
                }
            } /*PRICE*/

            public class Thumbnail {

                @SerializedName("path")
                @Expose
                private String path;
                @SerializedName("extension")
                @Expose
                private String extension;

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
            } /*Thumbnail*/

            public class Creators {

                @SerializedName("available")
                @Expose
                private Integer available;
                @SerializedName("collectionURI")
                @Expose
                private String collectionURI;
                @SerializedName("items")
                @Expose
                private List<Item> items = null;
                @SerializedName("returned")
                @Expose
                private Integer returned;

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
                    private String resourceURI;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("role")
                    @Expose
                    private String role;

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

                    public String getRole() {
                        return role;
                    }

                    public void setRole(String role) {
                        this.role = role;
                    }
                } /*Item End*/
            } /*Creators End*/

            public class Characters {

                @SerializedName("available")
                @Expose
                private Integer available;
                @SerializedName("collectionURI")
                @Expose
                private String collectionURI;
                @SerializedName("items")
                @Expose
                private List<Item_> items = null;
                @SerializedName("returned")
                @Expose
                private Integer returned;

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
                    private String resourceURI;
                    @SerializedName("name")
                    @Expose
                    private String name;

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
                } /*Item_ end*/

            } /*Characters end*/
            public class Stories {

                @SerializedName("available")
                @Expose
                private Integer available;
                @SerializedName("collectionURI")
                @Expose
                private String collectionURI;
                @SerializedName("items")
                @Expose
                private List<Item__> items = null;
                @SerializedName("returned")
                @Expose
                private Integer returned;

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
                    private String resourceURI;
                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("type")
                    @Expose
                    private String type;

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
                } /*Item__ end*/


            } /*Stories End*/

            public class Events {

                @SerializedName("available")
                @Expose
                private Integer available;
                @SerializedName("collectionURI")
                @Expose
                private String collectionURI;
                @SerializedName("items")
                @Expose
                private List<Object> items = null;
                @SerializedName("returned")
                @Expose
                private Integer returned;

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

                public List<Object> getItems() {
                    return items;
                }

                public void setItems(List<Object> items) {
                    this.items = items;
                }

                public Integer getReturned() {
                    return returned;
                }

                public void setReturned(Integer returned) {
                    this.returned = returned;
                }

            }
        }
    }
}
