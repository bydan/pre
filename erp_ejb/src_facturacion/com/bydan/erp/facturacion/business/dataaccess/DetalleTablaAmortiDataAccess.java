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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//DetalleTablaAmortiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleTablaAmortiDataAccess extends  DetalleTablaAmortiDataAccessAdditional{ //DetalleTablaAmortiDataAccessAdditional,DataAccessHelper<DetalleTablaAmorti>
	//static Logger logger = Logger.getLogger(DetalleTablaAmortiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_tabla_amorti";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_tabla_amorti,valor,interes,capital,fecha_inicio,fecha_fin,descripcion,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_tabla_amorti=?,valor=?,interes=?,capital=?,fecha_inicio=?,fecha_fin=?,descripcion=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalletablaamorti from "+DetalleTablaAmortiConstantesFunciones.SPERSISTENCENAME+" detalletablaamorti";
	public static String QUERYSELECTNATIVE="select "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".version_row,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_periodo,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_tabla_amorti,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".valor,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".interes,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".capital,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".fecha_inicio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".fecha_fin,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".descripcion,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_anio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_mes from "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME;//+" as "+DetalleTablaAmortiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".version_row from "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME;//+" as "+DetalleTablaAmortiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_tabla_amorti=?,valor=?,interes=?,capital=?,fecha_inicio=?,fecha_fin=?,descripcion=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLETABLAAMORTI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLETABLAAMORTI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLETABLAAMORTI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLETABLAAMORTI_SELECT(?,?)";
	
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
	
	
	protected DetalleTablaAmortiDataAccessAdditional detalletablaamortiDataAccessAdditional=null;
	
	public DetalleTablaAmortiDataAccessAdditional getDetalleTablaAmortiDataAccessAdditional() {
		return this.detalletablaamortiDataAccessAdditional;
	}
	
	public void setDetalleTablaAmortiDataAccessAdditional(DetalleTablaAmortiDataAccessAdditional detalletablaamortiDataAccessAdditional) {
		try {
			this.detalletablaamortiDataAccessAdditional=detalletablaamortiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleTablaAmortiDataAccess() {
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
		DetalleTablaAmortiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleTablaAmortiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleTablaAmortiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleTablaAmortiOriginal(DetalleTablaAmorti detalletablaamorti)throws Exception  {
		detalletablaamorti.setDetalleTablaAmortiOriginal((DetalleTablaAmorti)detalletablaamorti.clone());		
	}
	
	public void setDetalleTablaAmortisOriginal(List<DetalleTablaAmorti> detalletablaamortis)throws Exception  {
		
		for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis){
			detalletablaamorti.setDetalleTablaAmortiOriginal((DetalleTablaAmorti)detalletablaamorti.clone());
		}
	}
	
	public static void setDetalleTablaAmortiOriginalStatic(DetalleTablaAmorti detalletablaamorti)throws Exception  {
		detalletablaamorti.setDetalleTablaAmortiOriginal((DetalleTablaAmorti)detalletablaamorti.clone());		
	}
	
	public static void setDetalleTablaAmortisOriginalStatic(List<DetalleTablaAmorti> detalletablaamortis)throws Exception  {
		
		for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis){
			detalletablaamorti.setDetalleTablaAmortiOriginal((DetalleTablaAmorti)detalletablaamorti.clone());
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
	
	public  DetalleTablaAmorti getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		
		
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
	
	public  DetalleTablaAmorti getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetalleTablaAmorti.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleTablaAmortiOriginal(new DetalleTablaAmorti());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTablaAmorti("",entity,resultSet); 
				
				//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTablaAmorti(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleTablaAmorti getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();
				
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
	
	public  DetalleTablaAmorti getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTablaAmortiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleTablaAmorti.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleTablaAmortiOriginal(new DetalleTablaAmorti());
      	    	entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleTablaAmorti("",entity,resultSet);    
				
				//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleTablaAmorti(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleTablaAmorti
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleTablaAmorti entity = new DetalleTablaAmorti();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTablaAmortiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleTablaAmorti.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleTablaAmorti(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleTablaAmorti> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		
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
	
	public  List<DetalleTablaAmorti> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTablaAmortiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTablaAmorti();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTablaAmorti("",entity,resultSet);
      	    	
				//entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
      	    	//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTablaAmortis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTablaAmorti(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTablaAmorti> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
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
	
	public  List<DetalleTablaAmorti> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTablaAmorti();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTablaAmorti();
					//entity.setMapDetalleTablaAmorti(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleTablaAmortiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTablaAmorti().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTablaAmortiDataAccess.getEntityDetalleTablaAmorti("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
					////entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTablaAmortis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTablaAmorti(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleTablaAmorti getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
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
	
	public  DetalleTablaAmorti getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTablaAmorti();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleTablaAmorti();
					//entity.setMapDetalleTablaAmorti(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleTablaAmortiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleTablaAmorti().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
					entity=DetalleTablaAmortiDataAccess.getEntityDetalleTablaAmorti("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
					////entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleTablaAmorti(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTablaAmorti(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleTablaAmorti getEntityDetalleTablaAmorti(String strPrefijo,DetalleTablaAmorti entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleTablaAmorti.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleTablaAmorti.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleTablaAmortiDataAccess.setFieldReflectionDetalleTablaAmorti(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleTablaAmorti=DetalleTablaAmortiConstantesFunciones.getTodosTiposColumnasDetalleTablaAmorti();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleTablaAmorti) {
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
							field = DetalleTablaAmorti.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleTablaAmorti.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleTablaAmortiDataAccess.setFieldReflectionDetalleTablaAmorti(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleTablaAmorti(Field field,String strPrefijo,String sColumn,DetalleTablaAmorti entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleTablaAmortiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.INTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.CAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleTablaAmortiConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTablaAmorti>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTablaAmortiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleTablaAmorti();
					entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleTablaAmorti("",entity,resultSet);
					
					//entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
					//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleTablaAmortis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTablaAmorti(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleTablaAmorti>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleTablaAmortiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleTablaAmortiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleTablaAmorti> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
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
	
	public  List<DetalleTablaAmorti> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTablaAmorti();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTablaAmorti("",entity,resultSet);
      	    	
				//entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
      	    	//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleTablaAmortis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleTablaAmorti(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleTablaAmorti> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
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
	
	public  List<DetalleTablaAmorti> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleTablaAmorti> entities = new  ArrayList<DetalleTablaAmorti>();
		DetalleTablaAmorti entity = new DetalleTablaAmorti();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleTablaAmorti();
      	    	entity=super.getEntity("",entity,resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleTablaAmorti("",entity,resultSet);
      	    	
				//entity.setDetalleTablaAmortiOriginal( new DetalleTablaAmorti());
      	    	//entity.setDetalleTablaAmortiOriginal(super.getEntity("",entity.getDetalleTablaAmortiOriginal(),resultSet,DetalleTablaAmortiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleTablaAmortiOriginal(this.getEntityDetalleTablaAmorti("",entity.getDetalleTablaAmortiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleTablaAmortis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleTablaAmorti getEntityDetalleTablaAmorti(String strPrefijo,DetalleTablaAmorti entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDPERIODO));
				entity.setid_tabla_amorti(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleTablaAmortiConstantesFunciones.VALOR));
				entity.setinteres(resultSet.getDouble(strPrefijo+DetalleTablaAmortiConstantesFunciones.INTERES));
				entity.setcapital(resultSet.getDouble(strPrefijo+DetalleTablaAmortiConstantesFunciones.CAPITAL));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+DetalleTablaAmortiConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+DetalleTablaAmortiConstantesFunciones.FECHAFIN).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleTablaAmortiConstantesFunciones.DESCRIPCION));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleTablaAmortiConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleTablaAmorti(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleTablaAmorti entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleTablaAmortiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleTablaAmortiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleTablaAmortiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleTablaAmortiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleTablaAmortiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleTablaAmortiDataAccess.TABLENAME,DetalleTablaAmortiDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleTablaAmortiDataAccess.setDetalleTablaAmortiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalletablaamorti.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalletablaamorti.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalletablaamorti.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalletablaamorti.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public TablaAmorti getTablaAmorti(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		TablaAmorti tablaamorti= new TablaAmorti();

		try {
			TablaAmortiDataAccess tablaamortiDataAccess=new TablaAmortiDataAccess();

			tablaamortiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tablaamortiDataAccess.setConnexionType(this.connexionType);
			tablaamortiDataAccess.setParameterDbType(this.parameterDbType);

			tablaamorti=tablaamortiDataAccess.getEntity(connexion,reldetalletablaamorti.getid_tabla_amorti());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tablaamorti;

	}

	public Anio getAnio(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalletablaamorti.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleTablaAmorti reldetalletablaamorti)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalletablaamorti.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleTablaAmorti detalletablaamorti) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalletablaamorti.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalletablaamorti.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalletablaamorti.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalletablaamorti.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalletablaamorti.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tabla_amorti=new ParameterValue<Long>();
					parameterMaintenanceValueid_tabla_amorti.setValue(detalletablaamorti.getid_tabla_amorti());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tabla_amorti);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detalletablaamorti.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres=new ParameterValue<Double>();
					parameterMaintenanceValueinteres.setValue(detalletablaamorti.getinteres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecapital=new ParameterValue<Double>();
					parameterMaintenanceValuecapital.setValue(detalletablaamorti.getcapital());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecapital);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(detalletablaamorti.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(detalletablaamorti.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalletablaamorti.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalletablaamorti.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalletablaamorti.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalletablaamorti.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalletablaamorti.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalletablaamorti.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalletablaamorti.getId());
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
	
	public void setIsNewIsChangedFalseDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti)throws Exception  {		
		detalletablaamorti.setIsNew(false);
		detalletablaamorti.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleTablaAmortis(List<DetalleTablaAmorti> detalletablaamortis)throws Exception  {				
		for(DetalleTablaAmorti detalletablaamorti:detalletablaamortis) {
			detalletablaamorti.setIsNew(false);
			detalletablaamorti.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleTablaAmorti(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
