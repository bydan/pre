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
import com.bydan.erp.nomina.util.*;//CargaFamiliar_NMConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class CargaFamiliar_NMDataAccess extends  CargaFamiliar_NMDataAccessAdditional{ //CargaFamiliar_NMDataAccessAdditional,DataAccessHelper<CargaFamiliar_NM>
	//static Logger logger = Logger.getLogger(CargaFamiliar_NMDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="carga_familiar__n_m";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_tipo_carga_fami,id_tipo_genero,id_estado_civil,cedula,apellido,nombre,direccion,fecha_nacimiento,valor_cupo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_carga_fami=?,id_tipo_genero=?,id_estado_civil=?,cedula=?,apellido=?,nombre=?,direccion=?,fecha_nacimiento=?,valor_cupo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cargafamiliar_nm from "+CargaFamiliar_NMConstantesFunciones.SPERSISTENCENAME+" cargafamiliar_nm";
	public static String QUERYSELECTNATIVE="select "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_empresa,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_empleado,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_tipo_carga_fami,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_tipo_genero,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id_estado_civil,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".cedula,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".apellido,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".nombre,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".direccion,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".fecha_nacimiento,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".valor_cupo from "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME;//+" as "+CargaFamiliar_NMConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".id,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".version_row,"+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+".nombre from "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME;//+" as "+CargaFamiliar_NMConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CargaFamiliar_NMConstantesFunciones.SCHEMA+"."+CargaFamiliar_NMConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_carga_fami=?,id_tipo_genero=?,id_estado_civil=?,cedula=?,apellido=?,nombre=?,direccion=?,fecha_nacimiento=?,valor_cupo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CARGAFAMILIAR_NM_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CARGAFAMILIAR_NM_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CARGAFAMILIAR_NM_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CARGAFAMILIAR_NM_SELECT(?,?)";
	
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
	
	
	protected CargaFamiliar_NMDataAccessAdditional cargafamiliar_nmDataAccessAdditional=null;
	
	public CargaFamiliar_NMDataAccessAdditional getCargaFamiliar_NMDataAccessAdditional() {
		return this.cargafamiliar_nmDataAccessAdditional;
	}
	
	public void setCargaFamiliar_NMDataAccessAdditional(CargaFamiliar_NMDataAccessAdditional cargafamiliar_nmDataAccessAdditional) {
		try {
			this.cargafamiliar_nmDataAccessAdditional=cargafamiliar_nmDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CargaFamiliar_NMDataAccess() {
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
		CargaFamiliar_NMDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CargaFamiliar_NMDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CargaFamiliar_NMDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCargaFamiliar_NMOriginal(CargaFamiliar_NM cargafamiliar_nm)throws Exception  {
		cargafamiliar_nm.setCargaFamiliar_NMOriginal((CargaFamiliar_NM)cargafamiliar_nm.clone());		
	}
	
	public void setCargaFamiliar_NMsOriginal(List<CargaFamiliar_NM> cargafamiliar_nms)throws Exception  {
		
		for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms){
			cargafamiliar_nm.setCargaFamiliar_NMOriginal((CargaFamiliar_NM)cargafamiliar_nm.clone());
		}
	}
	
	public static void setCargaFamiliar_NMOriginalStatic(CargaFamiliar_NM cargafamiliar_nm)throws Exception  {
		cargafamiliar_nm.setCargaFamiliar_NMOriginal((CargaFamiliar_NM)cargafamiliar_nm.clone());		
	}
	
	public static void setCargaFamiliar_NMsOriginalStatic(List<CargaFamiliar_NM> cargafamiliar_nms)throws Exception  {
		
		for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms){
			cargafamiliar_nm.setCargaFamiliar_NMOriginal((CargaFamiliar_NM)cargafamiliar_nm.clone());
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
	
	public  CargaFamiliar_NM getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		
		
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
	
	public  CargaFamiliar_NM getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.CargaFamiliar_NM.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCargaFamiliar_NMOriginal(new CargaFamiliar_NM());
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargaFamiliar_NM("",entity,resultSet); 
				
				//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCargaFamiliar_NM(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CargaFamiliar_NM getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();
				
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
	
	public  CargaFamiliar_NM getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliar_NMDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CargaFamiliar_NM.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCargaFamiliar_NMOriginal(new CargaFamiliar_NM());
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargaFamiliar_NM("",entity,resultSet);    
				
				//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCargaFamiliar_NM(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CargaFamiliar_NM
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CargaFamiliar_NM entity = new CargaFamiliar_NM();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliar_NMDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CargaFamiliar_NM.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCargaFamiliar_NM(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CargaFamiliar_NM> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		
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
	
	public  List<CargaFamiliar_NM> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliar_NMDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar_NM();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar_NM("",entity,resultSet);
      	    	
				//entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
      	    	//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliar_NMs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar_NM(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CargaFamiliar_NM> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
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
	
	public  List<CargaFamiliar_NM> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar_NM();
				
				if(conMapGenerico) {
					entity.inicializarMapCargaFamiliar_NM();
					//entity.setMapCargaFamiliar_NM(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCargaFamiliar_NMValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargaFamiliar_NM().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
					entity=CargaFamiliar_NMDataAccess.getEntityCargaFamiliar_NM("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
					////entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
					////entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliar_NMs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar_NM(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CargaFamiliar_NM getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
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
	
	public  CargaFamiliar_NM getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar_NM();
				
				if(conMapGenerico) {
					entity.inicializarMapCargaFamiliar_NM();
					//entity.setMapCargaFamiliar_NM(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCargaFamiliar_NMValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargaFamiliar_NM().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
					entity=CargaFamiliar_NMDataAccess.getEntityCargaFamiliar_NM("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
					////entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
					////entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCargaFamiliar_NM(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar_NM(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CargaFamiliar_NM getEntityCargaFamiliar_NM(String strPrefijo,CargaFamiliar_NM entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CargaFamiliar_NM.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CargaFamiliar_NM.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CargaFamiliar_NMDataAccess.setFieldReflectionCargaFamiliar_NM(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCargaFamiliar_NM=CargaFamiliar_NMConstantesFunciones.getTodosTiposColumnasCargaFamiliar_NM();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCargaFamiliar_NM) {
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
							field = CargaFamiliar_NM.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CargaFamiliar_NM.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CargaFamiliar_NMDataAccess.setFieldReflectionCargaFamiliar_NM(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCargaFamiliar_NM(Field field,String strPrefijo,String sColumn,CargaFamiliar_NM entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CargaFamiliar_NMConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.CEDULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CargaFamiliar_NMConstantesFunciones.VALORCUPO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CargaFamiliar_NM>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliar_NMDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CargaFamiliar_NM();
					entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCargaFamiliar_NM("",entity,resultSet);
					
					//entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
					//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
					//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCargaFamiliar_NMs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar_NM(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CargaFamiliar_NM>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargaFamiliar_NMDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargaFamiliar_NMDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CargaFamiliar_NM> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
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
	
	public  List<CargaFamiliar_NM> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar_NM();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar_NM("",entity,resultSet);
      	    	
				//entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
      	    	//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCargaFamiliar_NMs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargaFamiliar_NM(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CargaFamiliar_NM> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
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
	
	public  List<CargaFamiliar_NM> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CargaFamiliar_NM> entities = new  ArrayList<CargaFamiliar_NM>();
		CargaFamiliar_NM entity = new CargaFamiliar_NM();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CargaFamiliar_NM();
      	    	entity=super.getEntity("",entity,resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargaFamiliar_NM("",entity,resultSet);
      	    	
				//entity.setCargaFamiliar_NMOriginal( new CargaFamiliar_NM());
      	    	//entity.setCargaFamiliar_NMOriginal(super.getEntity("",entity.getCargaFamiliar_NMOriginal(),resultSet,CargaFamiliar_NMDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargaFamiliar_NMOriginal(this.getEntityCargaFamiliar_NM("",entity.getCargaFamiliar_NMOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargaFamiliar_NMs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CargaFamiliar_NM getEntityCargaFamiliar_NM(String strPrefijo,CargaFamiliar_NM entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CargaFamiliar_NMConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+CargaFamiliar_NMConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_carga_fami(resultSet.getLong(strPrefijo+CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL));
				entity.setcedula(resultSet.getString(strPrefijo+CargaFamiliar_NMConstantesFunciones.CEDULA));
				entity.setapellido(resultSet.getString(strPrefijo+CargaFamiliar_NMConstantesFunciones.APELLIDO));
				entity.setnombre(resultSet.getString(strPrefijo+CargaFamiliar_NMConstantesFunciones.NOMBRE));
				entity.setdireccion(resultSet.getString(strPrefijo+CargaFamiliar_NMConstantesFunciones.DIRECCION));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setvalor_cupo(resultSet.getDouble(strPrefijo+CargaFamiliar_NMConstantesFunciones.VALORCUPO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CargaFamiliar_NMConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCargaFamiliar_NM(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CargaFamiliar_NM entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CargaFamiliar_NMDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CargaFamiliar_NMDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CargaFamiliar_NMDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CargaFamiliar_NMDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CargaFamiliar_NMConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CargaFamiliar_NMDataAccess.TABLENAME,CargaFamiliar_NMDataAccess.ISWITHSTOREPROCEDURES);
			
			CargaFamiliar_NMDataAccess.setCargaFamiliar_NMOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CargaFamiliar_NM relcargafamiliar_nm)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcargafamiliar_nm.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,CargaFamiliar_NM relcargafamiliar_nm)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcargafamiliar_nm.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoCargaFami getTipoCargaFami(Connexion connexion,CargaFamiliar_NM relcargafamiliar_nm)throws SQLException,Exception {

		TipoCargaFami tipocargafami= new TipoCargaFami();

		try {
			TipoCargaFamiDataAccess tipocargafamiDataAccess=new TipoCargaFamiDataAccess();

			tipocargafamiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocargafamiDataAccess.setConnexionType(this.connexionType);
			tipocargafamiDataAccess.setParameterDbType(this.parameterDbType);

			tipocargafami=tipocargafamiDataAccess.getEntity(connexion,relcargafamiliar_nm.getid_tipo_carga_fami());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocargafami;

	}

	public TipoGenero getTipoGenero(Connexion connexion,CargaFamiliar_NM relcargafamiliar_nm)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relcargafamiliar_nm.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,CargaFamiliar_NM relcargafamiliar_nm)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relcargafamiliar_nm.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CargaFamiliar_NM cargafamiliar_nm) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cargafamiliar_nm.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cargafamiliar_nm.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(cargafamiliar_nm.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_carga_fami=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_carga_fami.setValue(cargafamiliar_nm.getid_tipo_carga_fami());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_carga_fami);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(cargafamiliar_nm.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(cargafamiliar_nm.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecedula=new ParameterValue<String>();
					parameterMaintenanceValuecedula.setValue(cargafamiliar_nm.getcedula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecedula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(cargafamiliar_nm.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cargafamiliar_nm.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(cargafamiliar_nm.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(cargafamiliar_nm.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cupo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cupo.setValue(cargafamiliar_nm.getvalor_cupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cupo);
					parametersTemp.add(parameterMaintenance);
					
						if(!cargafamiliar_nm.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cargafamiliar_nm.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cargafamiliar_nm.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cargafamiliar_nm.getId());
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
	
	public void setIsNewIsChangedFalseCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm)throws Exception  {		
		cargafamiliar_nm.setIsNew(false);
		cargafamiliar_nm.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCargaFamiliar_NMs(List<CargaFamiliar_NM> cargafamiliar_nms)throws Exception  {				
		for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
			cargafamiliar_nm.setIsNew(false);
			cargafamiliar_nm.setIsChanged(false);
		}
	}
	
	public void generarExportarCargaFamiliar_NM(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
