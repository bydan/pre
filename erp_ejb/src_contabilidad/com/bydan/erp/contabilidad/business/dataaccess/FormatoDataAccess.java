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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//FormatoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class FormatoDataAccess extends  FormatoDataAccessAdditional{ //FormatoDataAccessAdditional,DataAccessHelper<Formato>
	//static Logger logger = Logger.getLogger(FormatoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formato";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,nombre,id_tipo_movimiento,id_tipo_formato,ubicacion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,nombre=?,id_tipo_movimiento=?,id_tipo_formato=?,ubicacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formato from "+FormatoConstantesFunciones.SPERSISTENCENAME+" formato";
	public static String QUERYSELECTNATIVE="select "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".version_row,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_empresa,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_modulo,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".nombre,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id_tipo_formato,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".ubicacion from "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME;//+" as "+FormatoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".id,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".version_row,"+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+".nombre from "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME;//+" as "+FormatoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormatoConstantesFunciones.SCHEMA+"."+FormatoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,nombre=?,id_tipo_movimiento=?,id_tipo_formato=?,ubicacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMATO_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMATO_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMATO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMATO_SELECT(?,?)";
	
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
	
	
	protected FormatoDataAccessAdditional formatoDataAccessAdditional=null;
	
	public FormatoDataAccessAdditional getFormatoDataAccessAdditional() {
		return this.formatoDataAccessAdditional;
	}
	
	public void setFormatoDataAccessAdditional(FormatoDataAccessAdditional formatoDataAccessAdditional) {
		try {
			this.formatoDataAccessAdditional=formatoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormatoDataAccess() {
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
		FormatoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormatoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormatoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormatoOriginal(Formato formato)throws Exception  {
		formato.setFormatoOriginal((Formato)formato.clone());		
	}
	
	public void setFormatosOriginal(List<Formato> formatos)throws Exception  {
		
		for(Formato formato:formatos){
			formato.setFormatoOriginal((Formato)formato.clone());
		}
	}
	
	public static void setFormatoOriginalStatic(Formato formato)throws Exception  {
		formato.setFormatoOriginal((Formato)formato.clone());		
	}
	
	public static void setFormatosOriginalStatic(List<Formato> formatos)throws Exception  {
		
		for(Formato formato:formatos){
			formato.setFormatoOriginal((Formato)formato.clone());
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
	
	public  Formato getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Formato entity = new Formato();		
		
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
	
	public  Formato getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Formato entity = new Formato();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.Formato.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormatoOriginal(new Formato());
      	    	entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormato("",entity,resultSet); 
				
				//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormato(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Formato getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Formato entity = new Formato();
				
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
	
	public  Formato getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Formato entity = new Formato();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Formato.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormatoOriginal(new Formato());
      	    	entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormato("",entity,resultSet);    
				
				//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormato(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Formato
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Formato entity = new Formato();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Formato.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormato(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Formato> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		
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
	
	public  List<Formato> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Formato();
      	    	entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormato("",entity,resultSet);
      	    	
				//entity.setFormatoOriginal( new Formato());
      	    	//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormato(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Formato> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
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
	
	public  List<Formato> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Formato();
				
				if(conMapGenerico) {
					entity.inicializarMapFormato();
					//entity.setMapFormato(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormatoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormato().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
					entity=FormatoDataAccess.getEntityFormato("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoOriginal( new Formato());
					////entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Formato getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Formato entity = new Formato();		  
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
	
	public  Formato getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Formato entity = new Formato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Formato();
				
				if(conMapGenerico) {
					entity.inicializarMapFormato();
					//entity.setMapFormato(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormatoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormato().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
					entity=FormatoDataAccess.getEntityFormato("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormatoOriginal( new Formato());
					////entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
					////entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormato(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Formato getEntityFormato(String strPrefijo,Formato entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Formato.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Formato.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormatoDataAccess.setFieldReflectionFormato(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormato=FormatoConstantesFunciones.getTodosTiposColumnasFormato();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormato) {
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
							field = Formato.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Formato.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormatoDataAccess.setFieldReflectionFormato(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormato(Field field,String strPrefijo,String sColumn,Formato entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormatoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormatoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormatoConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoConstantesFunciones.IDTIPOFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormatoConstantesFunciones.UBICACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Formato>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Formato();
					entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormato("",entity,resultSet);
					
					//entity.setFormatoOriginal( new Formato());
					//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
					//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormatos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormato(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Formato>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormatoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormatoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Formato> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
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
	
	public  List<Formato> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Formato();
      	    	entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormato("",entity,resultSet);
      	    	
				//entity.setFormatoOriginal( new Formato());
      	    	//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormatos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormato(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Formato> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
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
	
	public  List<Formato> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Formato> entities = new  ArrayList<Formato>();
		Formato entity = new Formato();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Formato();
      	    	entity=super.getEntity("",entity,resultSet,FormatoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormato("",entity,resultSet);
      	    	
				//entity.setFormatoOriginal( new Formato());
      	    	//entity.setFormatoOriginal(super.getEntity("",entity.getFormatoOriginal(),resultSet,FormatoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormatoOriginal(this.getEntityFormato("",entity.getFormatoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormatos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Formato getEntityFormato(String strPrefijo,Formato entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormatoConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+FormatoConstantesFunciones.IDMODULO));
				entity.setnombre(resultSet.getString(strPrefijo+FormatoConstantesFunciones.NOMBRE));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+FormatoConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_tipo_formato(resultSet.getLong(strPrefijo+FormatoConstantesFunciones.IDTIPOFORMATO));
				entity.setubicacion(resultSet.getString(strPrefijo+FormatoConstantesFunciones.UBICACION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+FormatoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormato(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Formato entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormatoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormatoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormatoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormatoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormatoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormatoDataAccess.TABLENAME,FormatoDataAccess.ISWITHSTOREPROCEDURES);
			
			FormatoDataAccess.setFormatoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Formato relformato)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformato.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,Formato relformato)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relformato.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,Formato relformato)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relformato.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoFormato getTipoFormato(Connexion connexion,Formato relformato)throws SQLException,Exception {

		TipoFormato tipoformato= new TipoFormato();

		try {
			TipoFormatoDataAccess tipoformatoDataAccess=new TipoFormatoDataAccess();

			tipoformatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoformatoDataAccess.setConnexionType(this.connexionType);
			tipoformatoDataAccess.setParameterDbType(this.parameterDbType);

			tipoformato=tipoformatoDataAccess.getEntity(connexion,relformato.getid_tipo_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoformato;

	}


		
		public List<TipoGastoEmpresa> getTipoGastoEmpresas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<TipoGastoEmpresa> tipogastoempresas= new ArrayList<TipoGastoEmpresa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+TipoGastoEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_empresa.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN tipogastoempresa.Formato WHERE tipogastoempresa.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoGastoEmpresaDataAccess tipogastoempresaDataAccess=new TipoGastoEmpresaDataAccess();

			tipogastoempresaDataAccess.setConnexionType(this.connexionType);
			tipogastoempresaDataAccess.setParameterDbType(this.parameterDbType);
			tipogastoempresas=tipogastoempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogastoempresas;

	}

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Formato WHERE notacreditosoli.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.Formato WHERE notacreditopuntoventa.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventas;

	}

	public List<ParametroCompra> getParametroCompraPedidos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroCompra> parametrocomprapedidos= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.FormatoPedido WHERE parametrocompra.FormatoPedido.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocomprapedidos=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocomprapedidos;

	}

	public List<Requisicion> getRequisicions(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Requisicion> requisicions= new ArrayList<Requisicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+RequisicionConstantesFunciones.SCHEMA+".requisicion.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN requisicion.Formato WHERE requisicion.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RequisicionDataAccess requisicionDataAccess=new RequisicionDataAccess();

			requisicionDataAccess.setConnexionType(this.connexionType);
			requisicionDataAccess.setParameterDbType(this.parameterDbType);
			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicions;

	}

	public List<CuentaBanco> getCuentaBancoRetencionIvas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<CuentaBanco> cuentabancoretencionivas= new ArrayList<CuentaBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN cuentabanco.FormatoRetencionIva WHERE cuentabanco.FormatoRetencionIva.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancoretencionivas=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancoretencionivas;

	}

	public List<ConfiguracionPunVen> getConfiguracionPunVenNotaCreditos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ConfiguracionPunVen> configuracionpunvennotacreditos= new ArrayList<ConfiguracionPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ConfiguracionPunVenConstantesFunciones.SCHEMA+".configuracion_pun_ven.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN configuracionpunven.FormatoNotaCredito WHERE configuracionpunven.FormatoNotaCredito.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConfiguracionPunVenDataAccess configuracionpunvenDataAccess=new ConfiguracionPunVenDataAccess();

			configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			configuracionpunvennotacreditos=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return configuracionpunvennotacreditos;

	}

	public List<ParametroFactu> getParametroFactuInventarios(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroFactu> parametrofactuinventarios= new ArrayList<ParametroFactu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroFactuConstantesFunciones.SCHEMA+".parametro_factu.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametrofactu.FormatoInventario WHERE parametrofactu.FormatoInventario.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuDataAccess parametrofactuDataAccess=new ParametroFactuDataAccess();

			parametrofactuDataAccess.setConnexionType(this.connexionType);
			parametrofactuDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuinventarios=parametrofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuinventarios;

	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<FacturaPuntoVenta> facturapuntoventas= new ArrayList<FacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN facturapuntoventa.Formato WHERE facturapuntoventa.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventas;

	}

	public List<FormatoActivoFijo> getFormatoActivoFijos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<FormatoActivoFijo> formatoactivofijos= new ArrayList<FormatoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+FormatoActivoFijoConstantesFunciones.SCHEMA+".formato_activo_fijo.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN formatoactivofijo.Formato WHERE formatoactivofijo.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormatoActivoFijoDataAccess formatoactivofijoDataAccess=new FormatoActivoFijoDataAccess();

			formatoactivofijoDataAccess.setConnexionType(this.connexionType);
			formatoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			formatoactivofijos=formatoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatoactivofijos;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.Formato WHERE guiaremision.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN notacredito.Formato WHERE notacredito.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}

	public List<Pedido> getPedidos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN pedido.Formato WHERE pedido.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.Formato WHERE pedidocompraimpor.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.Formato WHERE ordencompra.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<OrdenProdu> getOrdenProdus(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<OrdenProdu> ordenprodus= new ArrayList<OrdenProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN ordenprodu.Formato WHERE ordenprodu.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenProduDataAccess ordenproduDataAccess=new OrdenProduDataAccess();

			ordenproduDataAccess.setConnexionType(this.connexionType);
			ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordenprodus;

	}

	public List<PedidoCompra> getPedidoCompras(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<PedidoCompra> pedidocompras= new ArrayList<PedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN pedidocompra.Formato WHERE pedidocompra.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompras;

	}

	public List<Banco> getBanco2s(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Banco> banco2s= new ArrayList<Banco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+BancoConstantesFunciones.SCHEMA+".banco.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN banco.Formato2 WHERE banco.Formato2.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);
			banco2s=bancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco2s;

	}

	public List<Definicion> getDefinicions(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN definicion.Formato WHERE definicion.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}

	public List<ParametroFactuSecuencial> getParametroFactuSecuencials(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroFactuSecuencial> parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+".parametro_factu_secuencial.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametrofactusecuencial.Formato WHERE parametrofactusecuencial.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuSecuencialDataAccess parametrofactusecuencialDataAccess=new ParametroFactuSecuencialDataAccess();

			parametrofactusecuencialDataAccess.setConnexionType(this.connexionType);
			parametrofactusecuencialDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactusecuencials=parametrofactusecuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactusecuencials;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.Formato WHERE pedidoexpor.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<PedidoProdu> getPedidoProdus(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<PedidoProdu> pedidoprodus= new ArrayList<PedidoProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN pedidoprodu.Formato WHERE pedidoprodu.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoProduDataAccess pedidoproduDataAccess=new PedidoProduDataAccess();

			pedidoproduDataAccess.setConnexionType(this.connexionType);
			pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoprodus;

	}

	public List<Factura> getFacturas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN factura.Formato WHERE factura.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<ParametroImpor> getParametroImporIngresos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroImpor> parametroimporingresos= new ArrayList<ParametroImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroImporConstantesFunciones.SCHEMA+".parametro_impor.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametroimpor.FormatoIngreso WHERE parametroimpor.FormatoIngreso.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroImporDataAccess parametroimporDataAccess=new ParametroImporDataAccess();

			parametroimporDataAccess.setConnexionType(this.connexionType);
			parametroimporDataAccess.setParameterDbType(this.parameterDbType);
			parametroimporingresos=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroimporingresos;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.Formato WHERE asientocontable.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}

	public List<PlaneacionCompra> getPlaneacionCompras(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<PlaneacionCompra> planeacioncompras= new ArrayList<PlaneacionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+PlaneacionCompraConstantesFunciones.SCHEMA+".planeacion_compra.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN planeacioncompra.Formato WHERE planeacioncompra.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PlaneacionCompraDataAccess planeacioncompraDataAccess=new PlaneacionCompraDataAccess();

			planeacioncompraDataAccess.setConnexionType(this.connexionType);
			planeacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return planeacioncompras;

	}

	public List<ParametroGenerico> getParametroGenericos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroGenerico> parametrogenericos= new ArrayList<ParametroGenerico>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroGenericoConstantesFunciones.SCHEMA+".parametro_generico.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametrogenerico.Formato WHERE parametrogenerico.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroGenericoDataAccess parametrogenericoDataAccess=new ParametroGenericoDataAccess();

			parametrogenericoDataAccess.setConnexionType(this.connexionType);
			parametrogenericoDataAccess.setParameterDbType(this.parameterDbType);
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrogenericos;

	}

	public List<ParametroProducto> getParametroProductos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroProducto> parametroproductos= new ArrayList<ParametroProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroProductoConstantesFunciones.SCHEMA+".parametro_producto.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametroproducto.Formato WHERE parametroproducto.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroProductoDataAccess parametroproductoDataAccess=new ParametroProductoDataAccess();

			parametroproductoDataAccess.setConnexionType(this.connexionType);
			parametroproductoDataAccess.setParameterDbType(this.parameterDbType);
			parametroproductos=parametroproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroproductos;

	}

	public List<DefiProvisionEmpleado> getDefiProvisionEmpleados(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<DefiProvisionEmpleado> defiprovisionempleados= new ArrayList<DefiProvisionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN defiprovisionempleado.Formato WHERE defiprovisionempleado.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess=new DefiProvisionEmpleadoDataAccess();

			defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return defiprovisionempleados;

	}

	public List<ParametroFactuPrincipal> getParametroFactuPrincipals(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<ParametroFactuPrincipal> parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+".parametro_factu_principal.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuprincipal.Formato WHERE parametrofactuprincipal.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuPrincipalDataAccess parametrofactuprincipalDataAccess=new ParametroFactuPrincipalDataAccess();

			parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuprincipals;

	}

	public List<SolicitudVacacion> getSolicitudVacacions(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<SolicitudVacacion> solicitudvacacions= new ArrayList<SolicitudVacacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+SolicitudVacacionConstantesFunciones.SCHEMA+".solicitud_vacacion.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN solicitudvacacion.Formato WHERE solicitudvacacion.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudVacacionDataAccess solicitudvacacionDataAccess=new SolicitudVacacionDataAccess();

			solicitudvacacionDataAccess.setConnexionType(this.connexionType);
			solicitudvacacionDataAccess.setParameterDbType(this.parameterDbType);
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudvacacions;

	}

	public List<Proforma> getProformas(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN proforma.Formato WHERE proforma.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.Formato WHERE movimientoinventario.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN consignacion.Formato WHERE consignacion.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<TipoContrato> getTipoContratos(Connexion connexion,Formato formato)throws SQLException,Exception {

		List<TipoContrato> tipocontratos= new ArrayList<TipoContrato>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormatoConstantesFunciones.SCHEMA+".formato ON "+TipoContratoConstantesFunciones.SCHEMA+".tipo_contrato.id_formato="+FormatoConstantesFunciones.SCHEMA+".formato.id WHERE "+FormatoConstantesFunciones.SCHEMA+".formato.id="+String.valueOf(formato.getId());
			} else {
				sQuery=" INNER JOIN tipocontrato.Formato WHERE tipocontrato.Formato.id="+String.valueOf(formato.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoContratoDataAccess tipocontratoDataAccess=new TipoContratoDataAccess();

			tipocontratoDataAccess.setConnexionType(this.connexionType);
			tipocontratoDataAccess.setParameterDbType(this.parameterDbType);
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocontratos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Formato formato) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formato.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formato.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(formato.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(formato.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(formato.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_formato.setValue(formato.getid_tipo_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueubicacion=new ParameterValue<String>();
					parameterMaintenanceValueubicacion.setValue(formato.getubicacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueubicacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!formato.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formato.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formato.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formato.getId());
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
	
	public void setIsNewIsChangedFalseFormato(Formato formato)throws Exception  {		
		formato.setIsNew(false);
		formato.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormatos(List<Formato> formatos)throws Exception  {				
		for(Formato formato:formatos) {
			formato.setIsNew(false);
			formato.setIsChanged(false);
		}
	}
	
	public void generarExportarFormato(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
