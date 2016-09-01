/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TipoAfiliacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoAfiliacionDataAccess extends  TipoAfiliacionDataAccessAdditional{ //TipoAfiliacionDataAccessAdditional,DataAccessHelper<TipoAfiliacion>
	//static Logger logger = Logger.getLogger(TipoAfiliacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_afiliacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cate_tipo_afiliacion,codigo,nombre,porcen_emplea,porcen_patro,porcen_gene_emplea,porcen_gene_patro,porcen_secu,porcen_iece,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cate_tipo_afiliacion=?,codigo=?,nombre=?,porcen_emplea=?,porcen_patro=?,porcen_gene_emplea=?,porcen_gene_patro=?,porcen_secu=?,porcen_iece=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoafiliacion from "+TipoAfiliacionConstantesFunciones.SPERSISTENCENAME+" tipoafiliacion";
	public static String QUERYSELECTNATIVE="select "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id_empresa,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id_cate_tipo_afiliacion,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".codigo,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".nombre,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_emplea,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_patro,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_gene_emplea,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_gene_patro,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_secu,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".porcen_iece,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".descripcion from "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+TipoAfiliacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".id,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".version_row,"+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+".nombre from "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME;//+" as "+TipoAfiliacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoAfiliacionConstantesFunciones.SCHEMA+"."+TipoAfiliacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cate_tipo_afiliacion=?,codigo=?,nombre=?,porcen_emplea=?,porcen_patro=?,porcen_gene_emplea=?,porcen_gene_patro=?,porcen_secu=?,porcen_iece=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOAFILIACION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOAFILIACION_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOAFILIACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOAFILIACION_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected TipoAfiliacionDataAccessAdditional tipoafiliacionDataAccessAdditional=null;
	
	public TipoAfiliacionDataAccessAdditional getTipoAfiliacionDataAccessAdditional() {
		return this.tipoafiliacionDataAccessAdditional;
	}
	
	public void setTipoAfiliacionDataAccessAdditional(TipoAfiliacionDataAccessAdditional tipoafiliacionDataAccessAdditional) {
		try {
			this.tipoafiliacionDataAccessAdditional=tipoafiliacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoAfiliacionDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		TipoAfiliacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoAfiliacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoAfiliacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setTipoAfiliacionOriginal(TipoAfiliacion tipoafiliacion)throws Exception  {
		tipoafiliacion.setTipoAfiliacionOriginal((TipoAfiliacion)tipoafiliacion.clone());		
	}
	
	public void setTipoAfiliacionsOriginal(List<TipoAfiliacion> tipoafiliacions)throws Exception  {
		
		for(TipoAfiliacion tipoafiliacion:tipoafiliacions){
			tipoafiliacion.setTipoAfiliacionOriginal((TipoAfiliacion)tipoafiliacion.clone());
		}
	}
	
	public static void setTipoAfiliacionOriginalStatic(TipoAfiliacion tipoafiliacion)throws Exception  {
		tipoafiliacion.setTipoAfiliacionOriginal((TipoAfiliacion)tipoafiliacion.clone());		
	}
	
	public static void setTipoAfiliacionsOriginalStatic(List<TipoAfiliacion> tipoafiliacions)throws Exception  {
		
		for(TipoAfiliacion tipoafiliacion:tipoafiliacions){
			tipoafiliacion.setTipoAfiliacionOriginal((TipoAfiliacion)tipoafiliacion.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  TipoAfiliacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  TipoAfiliacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoAfiliacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoAfiliacionOriginal(new TipoAfiliacion());
      	    	entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoAfiliacion("",entity,resultSet); 
				
				//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoAfiliacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoAfiliacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoAfiliacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoAfiliacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoAfiliacionOriginal(new TipoAfiliacion());
      	    	entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoAfiliacion("",entity,resultSet);    
				
				//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoAfiliacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoAfiliacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoAfiliacion entity = new TipoAfiliacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoAfiliacion.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseTipoAfiliacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoAfiliacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoAfiliacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
      	    	//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAfiliacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoAfiliacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoAfiliacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAfiliacion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoAfiliacion();
					//entity.setMapTipoAfiliacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoAfiliacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoAfiliacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=TipoAfiliacionDataAccess.getEntityTipoAfiliacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
					////entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAfiliacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoAfiliacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoAfiliacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAfiliacion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoAfiliacion();
					//entity.setMapTipoAfiliacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoAfiliacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoAfiliacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=TipoAfiliacionDataAccess.getEntityTipoAfiliacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
					////entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoAfiliacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoAfiliacion getEntityTipoAfiliacion(String strPrefijo,TipoAfiliacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoAfiliacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoAfiliacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoAfiliacionDataAccess.setFieldReflectionTipoAfiliacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoAfiliacion=TipoAfiliacionConstantesFunciones.getTodosTiposColumnasTipoAfiliacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoAfiliacion) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = TipoAfiliacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoAfiliacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoAfiliacionDataAccess.setFieldReflectionTipoAfiliacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoAfiliacion(Field field,String strPrefijo,String sColumn,TipoAfiliacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoAfiliacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENEMPLEA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENPATRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENGENEPATRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENSECU:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.PORCENIECE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TipoAfiliacionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoAfiliacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new TipoAfiliacion();
					entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoAfiliacion("",entity,resultSet);
					
					//entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
					//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoAfiliacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoAfiliacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoAfiliacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoAfiliacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<TipoAfiliacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoAfiliacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
      	    	//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoAfiliacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoAfiliacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoAfiliacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoAfiliacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoAfiliacion> entities = new  ArrayList<TipoAfiliacion>();
		TipoAfiliacion entity = new TipoAfiliacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoAfiliacion();
      	    	entity=super.getEntity("",entity,resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoAfiliacion("",entity,resultSet);
      	    	
				//entity.setTipoAfiliacionOriginal( new TipoAfiliacion());
      	    	//entity.setTipoAfiliacionOriginal(super.getEntity("",entity.getTipoAfiliacionOriginal(),resultSet,TipoAfiliacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoAfiliacionOriginal(this.getEntityTipoAfiliacion("",entity.getTipoAfiliacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoAfiliacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoAfiliacion getEntityTipoAfiliacion(String strPrefijo,TipoAfiliacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoAfiliacionConstantesFunciones.IDEMPRESA));
				entity.setid_cate_tipo_afiliacion(resultSet.getLong(strPrefijo+TipoAfiliacionConstantesFunciones.IDCATETIPOAFILIACION));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoAfiliacionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoAfiliacionConstantesFunciones.NOMBRE));
				entity.setporcen_emplea(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENEMPLEA));
				entity.setporcen_patro(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENPATRO));
				entity.setporcen_gene_emplea(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENGENEEMPLEA));
				entity.setporcen_gene_patro(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENGENEPATRO));
				entity.setporcen_secu(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENSECU));
				entity.setporcen_iece(resultSet.getDouble(strPrefijo+TipoAfiliacionConstantesFunciones.PORCENIECE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoAfiliacionConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoAfiliacionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoAfiliacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoAfiliacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoAfiliacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoAfiliacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoAfiliacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoAfiliacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoAfiliacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoAfiliacionDataAccess.TABLENAME,TipoAfiliacionDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoAfiliacionDataAccess.setTipoAfiliacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoAfiliacion reltipoafiliacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoafiliacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CateTipoAfiliacion getCateTipoAfiliacion(Connexion connexion,TipoAfiliacion reltipoafiliacion)throws SQLException,Exception {

		CateTipoAfiliacion catetipoafiliacion= new CateTipoAfiliacion();

		try {
			CateTipoAfiliacionDataAccess catetipoafiliacionDataAccess=new CateTipoAfiliacionDataAccess();

			catetipoafiliacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			catetipoafiliacionDataAccess.setConnexionType(this.connexionType);
			catetipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);

			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion,reltipoafiliacion.getid_cate_tipo_afiliacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return catetipoafiliacion;

	}


		
		public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,TipoAfiliacion tipoafiliacion)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoAfiliacionConstantesFunciones.SCHEMA+".tipo_afiliacion ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_tipo_afiliacion="+TipoAfiliacionConstantesFunciones.SCHEMA+".tipo_afiliacion.id WHERE "+TipoAfiliacionConstantesFunciones.SCHEMA+".tipo_afiliacion.id="+String.valueOf(tipoafiliacion.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.TipoAfiliacion WHERE datogeneralempleado.TipoAfiliacion.id="+String.valueOf(tipoafiliacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoAfiliacion tipoafiliacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoafiliacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoafiliacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cate_tipo_afiliacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cate_tipo_afiliacion.setValue(tipoafiliacion.getid_cate_tipo_afiliacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cate_tipo_afiliacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoafiliacion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoafiliacion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_emplea=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_emplea.setValue(tipoafiliacion.getporcen_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_patro=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_patro.setValue(tipoafiliacion.getporcen_patro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_patro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_gene_emplea=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_gene_emplea.setValue(tipoafiliacion.getporcen_gene_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_gene_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_gene_patro=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_gene_patro.setValue(tipoafiliacion.getporcen_gene_patro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_gene_patro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_secu=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_secu.setValue(tipoafiliacion.getporcen_secu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_secu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcen_iece=new ParameterValue<Double>();
					parameterMaintenanceValueporcen_iece.setValue(tipoafiliacion.getporcen_iece());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcen_iece);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoafiliacion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoafiliacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoafiliacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoafiliacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoafiliacion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseTipoAfiliacion(TipoAfiliacion tipoafiliacion)throws Exception  {		
		tipoafiliacion.setIsNew(false);
		tipoafiliacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoAfiliacions(List<TipoAfiliacion> tipoafiliacions)throws Exception  {				
		for(TipoAfiliacion tipoafiliacion:tipoafiliacions) {
			tipoafiliacion.setIsNew(false);
			tipoafiliacion.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoAfiliacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
