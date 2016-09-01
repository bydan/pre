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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//DetalleAutoriConsepConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleAutoriConsepDataAccess extends  DetalleAutoriConsepDataAccessAdditional{ //DetalleAutoriConsepDataAccessAdditional,DataAccessHelper<DetalleAutoriConsep>
	//static Logger logger = Logger.getLogger(DetalleAutoriConsepDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_autori_consep";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+"(version_row,id_autori_consep,id_empresa,id_producto,id_unidad,cantidad_anio,cantidad_saldo,id_estado_detalle_autori_consep,nombre)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_autori_consep=?,id_empresa=?,id_producto=?,id_unidad=?,cantidad_anio=?,cantidad_saldo=?,id_estado_detalle_autori_consep=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleautoriconsep from "+DetalleAutoriConsepConstantesFunciones.SPERSISTENCENAME+" detalleautoriconsep";
	public static String QUERYSELECTNATIVE="select "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_autori_consep,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_producto,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_unidad,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".cantidad_anio,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".cantidad_saldo,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_estado_detalle_autori_consep,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+DetalleAutoriConsepConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+DetalleAutoriConsepConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_autori_consep=?,id_empresa=?,id_producto=?,id_unidad=?,cantidad_anio=?,cantidad_saldo=?,id_estado_detalle_autori_consep=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEAUTORICONSEP_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEAUTORICONSEP_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEAUTORICONSEP_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEAUTORICONSEP_SELECT(?,?)";
	
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
	
	
	protected DetalleAutoriConsepDataAccessAdditional detalleautoriconsepDataAccessAdditional=null;
	
	public DetalleAutoriConsepDataAccessAdditional getDetalleAutoriConsepDataAccessAdditional() {
		return this.detalleautoriconsepDataAccessAdditional;
	}
	
	public void setDetalleAutoriConsepDataAccessAdditional(DetalleAutoriConsepDataAccessAdditional detalleautoriconsepDataAccessAdditional) {
		try {
			this.detalleautoriconsepDataAccessAdditional=detalleautoriconsepDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleAutoriConsepDataAccess() {
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
		DetalleAutoriConsepDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleAutoriConsepDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleAutoriConsepDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleAutoriConsepOriginal(DetalleAutoriConsep detalleautoriconsep)throws Exception  {
		detalleautoriconsep.setDetalleAutoriConsepOriginal((DetalleAutoriConsep)detalleautoriconsep.clone());		
	}
	
	public void setDetalleAutoriConsepsOriginal(List<DetalleAutoriConsep> detalleautoriconseps)throws Exception  {
		
		for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps){
			detalleautoriconsep.setDetalleAutoriConsepOriginal((DetalleAutoriConsep)detalleautoriconsep.clone());
		}
	}
	
	public static void setDetalleAutoriConsepOriginalStatic(DetalleAutoriConsep detalleautoriconsep)throws Exception  {
		detalleautoriconsep.setDetalleAutoriConsepOriginal((DetalleAutoriConsep)detalleautoriconsep.clone());		
	}
	
	public static void setDetalleAutoriConsepsOriginalStatic(List<DetalleAutoriConsep> detalleautoriconseps)throws Exception  {
		
		for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps){
			detalleautoriconsep.setDetalleAutoriConsepOriginal((DetalleAutoriConsep)detalleautoriconsep.clone());
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
	
	public  DetalleAutoriConsep getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		
		
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
	
	public  DetalleAutoriConsep getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleAutoriConsep.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleAutoriConsepOriginal(new DetalleAutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAutoriConsep("",entity,resultSet); 
				
				//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAutoriConsep(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleAutoriConsep getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();
				
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
	
	public  DetalleAutoriConsep getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleAutoriConsep.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleAutoriConsepOriginal(new DetalleAutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAutoriConsep("",entity,resultSet);    
				
				//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleAutoriConsep
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleAutoriConsep entity = new DetalleAutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleAutoriConsep.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleAutoriConsep> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		
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
	
	public  List<DetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAutoriConsep("",entity,resultSet);
      	    	
				//entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
      	    	//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAutoriConseps(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
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
	
	public  List<DetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAutoriConsep();
					//entity.setMapDetalleAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAutoriConsepDataAccess.getEntityDetalleAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
					////entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAutoriConseps(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleAutoriConsep getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
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
	
	public  DetalleAutoriConsep getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAutoriConsep();
					//entity.setMapDetalleAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAutoriConsepDataAccess.getEntityDetalleAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
					////entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleAutoriConsep(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleAutoriConsep getEntityDetalleAutoriConsep(String strPrefijo,DetalleAutoriConsep entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleAutoriConsep.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleAutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleAutoriConsepDataAccess.setFieldReflectionDetalleAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleAutoriConsep=DetalleAutoriConsepConstantesFunciones.getTodosTiposColumnasDetalleAutoriConsep();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleAutoriConsep) {
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
							field = DetalleAutoriConsep.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleAutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleAutoriConsepDataAccess.setFieldReflectionDetalleAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleAutoriConsep(Field field,String strPrefijo,String sColumn,DetalleAutoriConsep entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleAutoriConsepConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.CANTIDADANIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAutoriConsepConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAutoriConsep>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleAutoriConsep();
					entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleAutoriConsep("",entity,resultSet);
					
					//entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
					//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleAutoriConseps(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAutoriConsep>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleAutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
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
	
	public  List<DetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAutoriConsep("",entity,resultSet);
      	    	
				//entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
      	    	//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleAutoriConseps(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAutoriConsep> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
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
	
	public  List<DetalleAutoriConsep> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAutoriConsep> entities = new  ArrayList<DetalleAutoriConsep>();
		DetalleAutoriConsep entity = new DetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAutoriConsep("",entity,resultSet);
      	    	
				//entity.setDetalleAutoriConsepOriginal( new DetalleAutoriConsep());
      	    	//entity.setDetalleAutoriConsepOriginal(super.getEntity("",entity.getDetalleAutoriConsepOriginal(),resultSet,DetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAutoriConsepOriginal(this.getEntityDetalleAutoriConsep("",entity.getDetalleAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAutoriConseps(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleAutoriConsep getEntityDetalleAutoriConsep(String strPrefijo,DetalleAutoriConsep entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_autori_consep(resultSet.getLong(strPrefijo+DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleAutoriConsepConstantesFunciones.IDEMPRESA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleAutoriConsepConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleAutoriConsepConstantesFunciones.IDUNIDAD));
				entity.setcantidad_anio(resultSet.getDouble(strPrefijo+DetalleAutoriConsepConstantesFunciones.CANTIDADANIO));
				entity.setcantidad_saldo(resultSet.getDouble(strPrefijo+DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO));
				entity.setid_estado_detalle_autori_consep(resultSet.getLong(strPrefijo+DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP));
				entity.setnombre(resultSet.getString(strPrefijo+DetalleAutoriConsepConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+DetalleAutoriConsepConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleAutoriConsep(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleAutoriConsep entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleAutoriConsepDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleAutoriConsepDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleAutoriConsepDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleAutoriConsepDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleAutoriConsepConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleAutoriConsepDataAccess.TABLENAME,DetalleAutoriConsepDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleAutoriConsepDataAccess.setDetalleAutoriConsepOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public AutoriConsep getAutoriConsep(Connexion connexion,DetalleAutoriConsep reldetalleautoriconsep)throws SQLException,Exception {

		AutoriConsep autoriconsep= new AutoriConsep();

		try {
			AutoriConsepDataAccess autoriconsepDataAccess=new AutoriConsepDataAccess();

			autoriconsepDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			autoriconsepDataAccess.setConnexionType(this.connexionType);
			autoriconsepDataAccess.setParameterDbType(this.parameterDbType);

			autoriconsep=autoriconsepDataAccess.getEntity(connexion,reldetalleautoriconsep.getid_autori_consep());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoriconsep;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleAutoriConsep reldetalleautoriconsep)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleautoriconsep.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Producto getProducto(Connexion connexion,DetalleAutoriConsep reldetalleautoriconsep)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleautoriconsep.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleAutoriConsep reldetalleautoriconsep)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleautoriconsep.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public EstadoDetalleAutoriConsep getEstadoDetalleAutoriConsep(Connexion connexion,DetalleAutoriConsep reldetalleautoriconsep)throws SQLException,Exception {

		EstadoDetalleAutoriConsep estadodetalleautoriconsep= new EstadoDetalleAutoriConsep();

		try {
			EstadoDetalleAutoriConsepDataAccess estadodetalleautoriconsepDataAccess=new EstadoDetalleAutoriConsepDataAccess();

			estadodetalleautoriconsepDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			estadodetalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);

			estadodetalleautoriconsep=estadodetalleautoriconsepDataAccess.getEntity(connexion,reldetalleautoriconsep.getid_estado_detalle_autori_consep());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetalleautoriconsep;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleAutoriConsep detalleautoriconsep) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleautoriconsep.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_autori_consep=new ParameterValue<Long>();
					parameterMaintenanceValueid_autori_consep.setValue(detalleautoriconsep.getid_autori_consep());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_autori_consep);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleautoriconsep.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleautoriconsep.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleautoriconsep.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_anio=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_anio.setValue(detalleautoriconsep.getcantidad_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_saldo=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_saldo.setValue(detalleautoriconsep.getcantidad_saldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_saldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_autori_consep=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_autori_consep.setValue(detalleautoriconsep.getid_estado_detalle_autori_consep());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_autori_consep);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(detalleautoriconsep.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleautoriconsep.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleautoriconsep.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleautoriconsep.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleautoriconsep.getId());
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
	
	public void setIsNewIsChangedFalseDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep)throws Exception  {		
		detalleautoriconsep.setIsNew(false);
		detalleautoriconsep.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleAutoriConseps(List<DetalleAutoriConsep> detalleautoriconseps)throws Exception  {				
		for(DetalleAutoriConsep detalleautoriconsep:detalleautoriconseps) {
			detalleautoriconsep.setIsNew(false);
			detalleautoriconsep.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleAutoriConsep(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
