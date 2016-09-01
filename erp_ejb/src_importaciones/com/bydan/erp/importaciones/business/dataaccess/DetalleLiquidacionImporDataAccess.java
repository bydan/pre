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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//DetalleLiquidacionImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleLiquidacionImporDataAccess extends  DetalleLiquidacionImporDataAccessAdditional{ //DetalleLiquidacionImporDataAccessAdditional,DataAccessHelper<DetalleLiquidacionImpor>
	//static Logger logger = Logger.getLogger(DetalleLiquidacionImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_liquidacion_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+"(version_row,id_liquidacion_impor,id_empresa,id_sucursal,id_usuario,id_centro_costo,id_costo_gasto_impor,valor,fecha,referencia,impuesto,impuesto2,impuesto3,impuesto4,impuesto5)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_liquidacion_impor=?,id_empresa=?,id_sucursal=?,id_usuario=?,id_centro_costo=?,id_costo_gasto_impor=?,valor=?,fecha=?,referencia=?,impuesto=?,impuesto2=?,impuesto3=?,impuesto4=?,impuesto5=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleliquidacionimpor from "+DetalleLiquidacionImporConstantesFunciones.SPERSISTENCENAME+" detalleliquidacionimpor";
	public static String QUERYSELECTNATIVE="select "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".version_row,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_liquidacion_impor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_empresa,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_usuario,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id_costo_gasto_impor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".valor,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".fecha,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".referencia,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto2,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto3,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto4,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".impuesto5 from "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".id,"+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+".version_row from "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME;//+" as "+DetalleLiquidacionImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+"."+DetalleLiquidacionImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_liquidacion_impor=?,id_empresa=?,id_sucursal=?,id_usuario=?,id_centro_costo=?,id_costo_gasto_impor=?,valor=?,fecha=?,referencia=?,impuesto=?,impuesto2=?,impuesto3=?,impuesto4=?,impuesto5=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLELIQUIDACIONIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLELIQUIDACIONIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLELIQUIDACIONIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLELIQUIDACIONIMPOR_SELECT(?,?)";
	
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
	
	
	protected DetalleLiquidacionImporDataAccessAdditional detalleliquidacionimporDataAccessAdditional=null;
	
	public DetalleLiquidacionImporDataAccessAdditional getDetalleLiquidacionImporDataAccessAdditional() {
		return this.detalleliquidacionimporDataAccessAdditional;
	}
	
	public void setDetalleLiquidacionImporDataAccessAdditional(DetalleLiquidacionImporDataAccessAdditional detalleliquidacionimporDataAccessAdditional) {
		try {
			this.detalleliquidacionimporDataAccessAdditional=detalleliquidacionimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleLiquidacionImporDataAccess() {
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
		DetalleLiquidacionImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleLiquidacionImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleLiquidacionImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleLiquidacionImporOriginal(DetalleLiquidacionImpor detalleliquidacionimpor)throws Exception  {
		detalleliquidacionimpor.setDetalleLiquidacionImporOriginal((DetalleLiquidacionImpor)detalleliquidacionimpor.clone());		
	}
	
	public void setDetalleLiquidacionImporsOriginal(List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors){
			detalleliquidacionimpor.setDetalleLiquidacionImporOriginal((DetalleLiquidacionImpor)detalleliquidacionimpor.clone());
		}
	}
	
	public static void setDetalleLiquidacionImporOriginalStatic(DetalleLiquidacionImpor detalleliquidacionimpor)throws Exception  {
		detalleliquidacionimpor.setDetalleLiquidacionImporOriginal((DetalleLiquidacionImpor)detalleliquidacionimpor.clone());		
	}
	
	public static void setDetalleLiquidacionImporsOriginalStatic(List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception  {
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors){
			detalleliquidacionimpor.setDetalleLiquidacionImporOriginal((DetalleLiquidacionImpor)detalleliquidacionimpor.clone());
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
	
	public  DetalleLiquidacionImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		
		
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
	
	public  DetalleLiquidacionImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.DetalleLiquidacionImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleLiquidacionImporOriginal(new DetalleLiquidacionImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet); 
				
				//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleLiquidacionImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleLiquidacionImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();
				
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
	
	public  DetalleLiquidacionImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetalleLiquidacionImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleLiquidacionImporOriginal(new DetalleLiquidacionImpor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet);    
				
				//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleLiquidacionImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleLiquidacionImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.DetalleLiquidacionImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleLiquidacionImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleLiquidacionImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		
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
	
	public  List<DetalleLiquidacionImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
      	    	//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleLiquidacionImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
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
	
	public  List<DetalleLiquidacionImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleLiquidacionImpor();
					//entity.setMapDetalleLiquidacionImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleLiquidacionImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleLiquidacionImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=DetalleLiquidacionImporDataAccess.getEntityDetalleLiquidacionImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
					////entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleLiquidacionImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
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
	
	public  DetalleLiquidacionImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleLiquidacionImpor();
					//entity.setMapDetalleLiquidacionImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleLiquidacionImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleLiquidacionImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=DetalleLiquidacionImporDataAccess.getEntityDetalleLiquidacionImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
					////entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleLiquidacionImpor getEntityDetalleLiquidacionImpor(String strPrefijo,DetalleLiquidacionImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleLiquidacionImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleLiquidacionImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleLiquidacionImporDataAccess.setFieldReflectionDetalleLiquidacionImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleLiquidacionImpor=DetalleLiquidacionImporConstantesFunciones.getTodosTiposColumnasDetalleLiquidacionImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleLiquidacionImpor) {
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
							field = DetalleLiquidacionImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleLiquidacionImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleLiquidacionImporDataAccess.setFieldReflectionDetalleLiquidacionImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleLiquidacionImpor(Field field,String strPrefijo,String sColumn,DetalleLiquidacionImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleLiquidacionImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IMPUESTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IMPUESTO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IMPUESTO4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleLiquidacionImporConstantesFunciones.IMPUESTO5:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleLiquidacionImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleLiquidacionImpor();
					entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet);
					
					//entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
					//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleLiquidacionImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleLiquidacionImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleLiquidacionImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleLiquidacionImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleLiquidacionImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
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
	
	public  List<DetalleLiquidacionImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
      	    	//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleLiquidacionImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleLiquidacionImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleLiquidacionImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
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
	
	public  List<DetalleLiquidacionImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleLiquidacionImpor> entities = new  ArrayList<DetalleLiquidacionImpor>();
		DetalleLiquidacionImpor entity = new DetalleLiquidacionImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleLiquidacionImpor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleLiquidacionImpor("",entity,resultSet);
      	    	
				//entity.setDetalleLiquidacionImporOriginal( new DetalleLiquidacionImpor());
      	    	//entity.setDetalleLiquidacionImporOriginal(super.getEntity("",entity.getDetalleLiquidacionImporOriginal(),resultSet,DetalleLiquidacionImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleLiquidacionImporOriginal(this.getEntityDetalleLiquidacionImpor("",entity.getDetalleLiquidacionImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleLiquidacionImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleLiquidacionImpor getEntityDetalleLiquidacionImpor(String strPrefijo,DetalleLiquidacionImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_liquidacion_impor(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDUSUARIO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_costo_gasto_impor(resultSet.getLong(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.VALOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleLiquidacionImporConstantesFunciones.FECHA).getTime()));
				entity.setreferencia(resultSet.getString(strPrefijo+DetalleLiquidacionImporConstantesFunciones.REFERENCIA));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IMPUESTO));
				entity.setimpuesto2(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IMPUESTO2));
				entity.setimpuesto3(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IMPUESTO3));
				entity.setimpuesto4(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IMPUESTO4));
				entity.setimpuesto5(resultSet.getDouble(strPrefijo+DetalleLiquidacionImporConstantesFunciones.IMPUESTO5));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleLiquidacionImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleLiquidacionImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleLiquidacionImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleLiquidacionImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleLiquidacionImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleLiquidacionImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleLiquidacionImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleLiquidacionImporDataAccess.TABLENAME,DetalleLiquidacionImporDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleLiquidacionImporDataAccess.setDetalleLiquidacionImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public LiquidacionImpor getLiquidacionImpor(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		LiquidacionImpor liquidacionimpor= new LiquidacionImpor();

		try {
			LiquidacionImporDataAccess liquidacionimporDataAccess=new LiquidacionImporDataAccess();

			liquidacionimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			liquidacionimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimporDataAccess.setParameterDbType(this.parameterDbType);

			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_liquidacion_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpor;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CostoGastoImpor getCostoGastoImpor(Connexion connexion,DetalleLiquidacionImpor reldetalleliquidacionimpor)throws SQLException,Exception {

		CostoGastoImpor costogastoimpor= new CostoGastoImpor();

		try {
			CostoGastoImporDataAccess costogastoimporDataAccess=new CostoGastoImporDataAccess();

			costogastoimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			costogastoimporDataAccess.setConnexionType(this.connexionType);
			costogastoimporDataAccess.setParameterDbType(this.parameterDbType);

			costogastoimpor=costogastoimporDataAccess.getEntity(connexion,reldetalleliquidacionimpor.getid_costo_gasto_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return costogastoimpor;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleliquidacionimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_liquidacion_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_liquidacion_impor.setValue(detalleliquidacionimpor.getid_liquidacion_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_liquidacion_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleliquidacionimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleliquidacionimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(detalleliquidacionimpor.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detalleliquidacionimpor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_costo_gasto_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_costo_gasto_impor.setValue(detalleliquidacionimpor.getid_costo_gasto_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_costo_gasto_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detalleliquidacionimpor.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detalleliquidacionimpor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuereferencia=new ParameterValue<String>();
					parameterMaintenanceValuereferencia.setValue(detalleliquidacionimpor.getreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(detalleliquidacionimpor.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto2=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto2.setValue(detalleliquidacionimpor.getimpuesto2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto3=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto3.setValue(detalleliquidacionimpor.getimpuesto3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto4=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto4.setValue(detalleliquidacionimpor.getimpuesto4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto5=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto5.setValue(detalleliquidacionimpor.getimpuesto5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto5);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleliquidacionimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleliquidacionimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleliquidacionimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleliquidacionimpor.getId());
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
	
	public void setIsNewIsChangedFalseDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor)throws Exception  {		
		detalleliquidacionimpor.setIsNew(false);
		detalleliquidacionimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception  {				
		for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
			detalleliquidacionimpor.setIsNew(false);
			detalleliquidacionimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleLiquidacionImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
