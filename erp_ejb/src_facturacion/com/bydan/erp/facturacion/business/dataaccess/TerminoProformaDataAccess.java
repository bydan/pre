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
import com.bydan.erp.facturacion.util.*;//TerminoProformaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TerminoProformaDataAccess extends  TerminoProformaDataAccessAdditional{ //TerminoProformaDataAccessAdditional,DataAccessHelper<TerminoProforma>
	//static Logger logger = Logger.getLogger(TerminoProformaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="termino_proforma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_moneda,id_proforma,atencion,registro_sanitario,referencia,descripcion,descripcion2,marca,origen,garantia_tecnica,fecha_pago,fecha_entrega,adjunto,responsable,cargo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_moneda=?,id_proforma=?,atencion=?,registro_sanitario=?,referencia=?,descripcion=?,descripcion2=?,marca=?,origen=?,garantia_tecnica=?,fecha_pago=?,fecha_entrega=?,adjunto=?,responsable=?,cargo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select terminoproforma from "+TerminoProformaConstantesFunciones.SPERSISTENCENAME+" terminoproforma";
	public static String QUERYSELECTNATIVE="select "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".version_row,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_empresa,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_sucursal,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_moneda,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_proforma,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".atencion,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".registro_sanitario,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".referencia,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".descripcion,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".descripcion2,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".marca,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".origen,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".garantia_tecnica,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".fecha_pago,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".fecha_entrega,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".adjunto,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".responsable,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".cargo from "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME;//+" as "+TerminoProformaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".version_row from "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME;//+" as "+TerminoProformaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_moneda=?,id_proforma=?,atencion=?,registro_sanitario=?,referencia=?,descripcion=?,descripcion2=?,marca=?,origen=?,garantia_tecnica=?,fecha_pago=?,fecha_entrega=?,adjunto=?,responsable=?,cargo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TERMINOPROFORMA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TERMINOPROFORMA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TERMINOPROFORMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TERMINOPROFORMA_SELECT(?,?)";
	
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
	
	
	protected TerminoProformaDataAccessAdditional terminoproformaDataAccessAdditional=null;
	
	public TerminoProformaDataAccessAdditional getTerminoProformaDataAccessAdditional() {
		return this.terminoproformaDataAccessAdditional;
	}
	
	public void setTerminoProformaDataAccessAdditional(TerminoProformaDataAccessAdditional terminoproformaDataAccessAdditional) {
		try {
			this.terminoproformaDataAccessAdditional=terminoproformaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TerminoProformaDataAccess() {
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
		TerminoProformaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TerminoProformaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TerminoProformaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTerminoProformaOriginal(TerminoProforma terminoproforma)throws Exception  {
		terminoproforma.setTerminoProformaOriginal((TerminoProforma)terminoproforma.clone());		
	}
	
	public void setTerminoProformasOriginal(List<TerminoProforma> terminoproformas)throws Exception  {
		
		for(TerminoProforma terminoproforma:terminoproformas){
			terminoproforma.setTerminoProformaOriginal((TerminoProforma)terminoproforma.clone());
		}
	}
	
	public static void setTerminoProformaOriginalStatic(TerminoProforma terminoproforma)throws Exception  {
		terminoproforma.setTerminoProformaOriginal((TerminoProforma)terminoproforma.clone());		
	}
	
	public static void setTerminoProformasOriginalStatic(List<TerminoProforma> terminoproformas)throws Exception  {
		
		for(TerminoProforma terminoproforma:terminoproformas){
			terminoproforma.setTerminoProformaOriginal((TerminoProforma)terminoproforma.clone());
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
	
	public  TerminoProforma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();		
		
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
	
	public  TerminoProforma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TerminoProforma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTerminoProformaOriginal(new TerminoProforma());
      	    	entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTerminoProforma("",entity,resultSet); 
				
				//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTerminoProforma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TerminoProforma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();
				
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
	
	public  TerminoProforma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TerminoProforma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTerminoProformaOriginal(new TerminoProforma());
      	    	entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTerminoProforma("",entity,resultSet);    
				
				//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTerminoProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TerminoProforma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TerminoProforma entity = new TerminoProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TerminoProforma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTerminoProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TerminoProforma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		
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
	
	public  List<TerminoProforma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTerminoProforma("",entity,resultSet);
      	    	
				//entity.setTerminoProformaOriginal( new TerminoProforma());
      	    	//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTerminoProformas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TerminoProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
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
	
	public  List<TerminoProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TerminoProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapTerminoProforma();
					//entity.setMapTerminoProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTerminoProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTerminoProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=TerminoProformaDataAccess.getEntityTerminoProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTerminoProformaOriginal( new TerminoProforma());
					////entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTerminoProformas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TerminoProforma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();		  
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
	
	public  TerminoProforma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TerminoProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapTerminoProforma();
					//entity.setMapTerminoProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTerminoProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTerminoProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=TerminoProformaDataAccess.getEntityTerminoProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTerminoProformaOriginal( new TerminoProforma());
					////entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTerminoProforma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TerminoProforma getEntityTerminoProforma(String strPrefijo,TerminoProforma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TerminoProforma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TerminoProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TerminoProformaDataAccess.setFieldReflectionTerminoProforma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTerminoProforma=TerminoProformaConstantesFunciones.getTodosTiposColumnasTerminoProforma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTerminoProforma) {
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
							field = TerminoProforma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TerminoProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TerminoProformaDataAccess.setFieldReflectionTerminoProforma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTerminoProforma(Field field,String strPrefijo,String sColumn,TerminoProforma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TerminoProformaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.IDPROFORMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.ATENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.REGISTROSANITARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.DESCRIPCION2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.ORIGEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.GARANTIATECNICA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.FECHAPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.FECHAENTREGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.ADJUNTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TerminoProformaConstantesFunciones.CARGO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TerminoProforma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TerminoProforma();
					entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTerminoProforma("",entity,resultSet);
					
					//entity.setTerminoProformaOriginal( new TerminoProforma());
					//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
					//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTerminoProformas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TerminoProforma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TerminoProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TerminoProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TerminoProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
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
	
	public  List<TerminoProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTerminoProforma("",entity,resultSet);
      	    	
				//entity.setTerminoProformaOriginal( new TerminoProforma());
      	    	//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTerminoProformas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTerminoProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TerminoProforma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
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
	
	public  List<TerminoProforma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TerminoProforma> entities = new  ArrayList<TerminoProforma>();
		TerminoProforma entity = new TerminoProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TerminoProforma();
      	    	entity=super.getEntity("",entity,resultSet,TerminoProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTerminoProforma("",entity,resultSet);
      	    	
				//entity.setTerminoProformaOriginal( new TerminoProforma());
      	    	//entity.setTerminoProformaOriginal(super.getEntity("",entity.getTerminoProformaOriginal(),resultSet,TerminoProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTerminoProformaOriginal(this.getEntityTerminoProforma("",entity.getTerminoProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTerminoProformas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TerminoProforma getEntityTerminoProforma(String strPrefijo,TerminoProforma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TerminoProformaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TerminoProformaConstantesFunciones.IDSUCURSAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+TerminoProformaConstantesFunciones.IDMONEDA));
				entity.setid_proforma(resultSet.getLong(strPrefijo+TerminoProformaConstantesFunciones.IDPROFORMA));
				entity.setatencion(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.ATENCION));
				entity.setregistro_sanitario(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.REGISTROSANITARIO));
				entity.setreferencia(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.REFERENCIA));
				entity.setdescripcion(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.DESCRIPCION));
				entity.setdescripcion2(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.DESCRIPCION2));
				entity.setmarca(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.MARCA));
				entity.setorigen(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.ORIGEN));
				entity.setgarantia_tecnica(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.GARANTIATECNICA));
				entity.setfecha_pago(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.FECHAPAGO));
				entity.setfecha_entrega(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.FECHAENTREGA));
				entity.setadjunto(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.ADJUNTO));
				entity.setresponsable(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.RESPONSABLE));
				entity.setcargo(resultSet.getString(strPrefijo+TerminoProformaConstantesFunciones.CARGO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTerminoProforma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TerminoProforma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TerminoProformaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TerminoProformaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TerminoProformaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TerminoProformaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TerminoProformaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TerminoProformaDataAccess.TABLENAME,TerminoProformaDataAccess.ISWITHSTOREPROCEDURES);
			
			TerminoProformaDataAccess.setTerminoProformaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TerminoProforma relterminoproforma)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relterminoproforma.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TerminoProforma relterminoproforma)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relterminoproforma.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Moneda getMoneda(Connexion connexion,TerminoProforma relterminoproforma)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relterminoproforma.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Proforma getProforma(Connexion connexion,TerminoProforma relterminoproforma)throws SQLException,Exception {

		Proforma proforma= new Proforma();

		try {
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);

			proforma=proformaDataAccess.getEntity(connexion,relterminoproforma.getid_proforma());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proforma;

	}


		
		public List<DetalleTerminoProforma> getDetalleTerminoProformas(Connexion connexion,TerminoProforma terminoproforma)throws SQLException,Exception {

		List<DetalleTerminoProforma> detalleterminoproformas= new ArrayList<DetalleTerminoProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TerminoProformaConstantesFunciones.SCHEMA+".termino_proforma ON "+DetalleTerminoProformaConstantesFunciones.SCHEMA+".detalle_termino_proforma.id_termino_proforma="+TerminoProformaConstantesFunciones.SCHEMA+".termino_proforma.id WHERE "+TerminoProformaConstantesFunciones.SCHEMA+".termino_proforma.id="+String.valueOf(terminoproforma.getId());
			} else {
				sQuery=" INNER JOIN detalleterminoproforma.TerminoProforma WHERE detalleterminoproforma.TerminoProforma.id="+String.valueOf(terminoproforma.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleTerminoProformaDataAccess detalleterminoproformaDataAccess=new DetalleTerminoProformaDataAccess();

			detalleterminoproformaDataAccess.setConnexionType(this.connexionType);
			detalleterminoproformaDataAccess.setParameterDbType(this.parameterDbType);
			detalleterminoproformas=detalleterminoproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleterminoproformas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TerminoProforma terminoproforma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!terminoproforma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(terminoproforma.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(terminoproforma.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(terminoproforma.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_proforma=new ParameterValue<Long>();
					parameterMaintenanceValueid_proforma.setValue(terminoproforma.getid_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueatencion=new ParameterValue<String>();
					parameterMaintenanceValueatencion.setValue(terminoproforma.getatencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueatencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueregistro_sanitario=new ParameterValue<String>();
					parameterMaintenanceValueregistro_sanitario.setValue(terminoproforma.getregistro_sanitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueregistro_sanitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuereferencia=new ParameterValue<String>();
					parameterMaintenanceValuereferencia.setValue(terminoproforma.getreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(terminoproforma.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion2=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion2.setValue(terminoproforma.getdescripcion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemarca=new ParameterValue<String>();
					parameterMaintenanceValuemarca.setValue(terminoproforma.getmarca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemarca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorigen=new ParameterValue<String>();
					parameterMaintenanceValueorigen.setValue(terminoproforma.getorigen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorigen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuegarantia_tecnica=new ParameterValue<String>();
					parameterMaintenanceValuegarantia_tecnica.setValue(terminoproforma.getgarantia_tecnica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegarantia_tecnica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefecha_pago=new ParameterValue<String>();
					parameterMaintenanceValuefecha_pago.setValue(terminoproforma.getfecha_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefecha_entrega=new ParameterValue<String>();
					parameterMaintenanceValuefecha_entrega.setValue(terminoproforma.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueadjunto=new ParameterValue<String>();
					parameterMaintenanceValueadjunto.setValue(terminoproforma.getadjunto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueadjunto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(terminoproforma.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecargo=new ParameterValue<String>();
					parameterMaintenanceValuecargo.setValue(terminoproforma.getcargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecargo);
					parametersTemp.add(parameterMaintenance);
					
						if(!terminoproforma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(terminoproforma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(terminoproforma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(terminoproforma.getId());
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
	
	public void setIsNewIsChangedFalseTerminoProforma(TerminoProforma terminoproforma)throws Exception  {		
		terminoproforma.setIsNew(false);
		terminoproforma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTerminoProformas(List<TerminoProforma> terminoproformas)throws Exception  {				
		for(TerminoProforma terminoproforma:terminoproformas) {
			terminoproforma.setIsNew(false);
			terminoproforma.setIsChanged(false);
		}
	}
	
	public void generarExportarTerminoProforma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
