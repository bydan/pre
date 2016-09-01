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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//DetalleChequeGiradoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class DetalleChequeGiradoDataAccess extends  DetalleChequeGiradoDataAccessAdditional{ //DetalleChequeGiradoDataAccessAdditional,DataAccessHelper<DetalleChequeGirado>
	//static Logger logger = Logger.getLogger(DetalleChequeGiradoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_cheque_girado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_asiento_contable,id_empleado,id_cuenta_banco,numero_cheque,valor,cuenta,fecha,con,beneficiario,codigo,nombre_banco,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_asiento_contable=?,id_empleado=?,id_cuenta_banco=?,numero_cheque=?,valor=?,cuenta=?,fecha=?,con=?,beneficiario=?,codigo=?,nombre_banco=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallechequegirado from "+DetalleChequeGiradoConstantesFunciones.SPERSISTENCENAME+" detallechequegirado";
	public static String QUERYSELECTNATIVE="select "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".version_row,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_periodo,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_empleado,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".numero_cheque,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".valor,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".cuenta,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".fecha,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".con,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".beneficiario,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".codigo,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".nombre_banco,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_anio,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id_mes from "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME;//+" as "+DetalleChequeGiradoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".id,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".version_row,"+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+".codigo from "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME;//+" as "+DetalleChequeGiradoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleChequeGiradoConstantesFunciones.SCHEMA+"."+DetalleChequeGiradoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_asiento_contable=?,id_empleado=?,id_cuenta_banco=?,numero_cheque=?,valor=?,cuenta=?,fecha=?,con=?,beneficiario=?,codigo=?,nombre_banco=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECHEQUEGIRADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECHEQUEGIRADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECHEQUEGIRADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECHEQUEGIRADO_SELECT(?,?)";
	
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
	
	
	protected DetalleChequeGiradoDataAccessAdditional detallechequegiradoDataAccessAdditional=null;
	
	public DetalleChequeGiradoDataAccessAdditional getDetalleChequeGiradoDataAccessAdditional() {
		return this.detallechequegiradoDataAccessAdditional;
	}
	
	public void setDetalleChequeGiradoDataAccessAdditional(DetalleChequeGiradoDataAccessAdditional detallechequegiradoDataAccessAdditional) {
		try {
			this.detallechequegiradoDataAccessAdditional=detallechequegiradoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleChequeGiradoDataAccess() {
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
		DetalleChequeGiradoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleChequeGiradoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleChequeGiradoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleChequeGiradoOriginal(DetalleChequeGirado detallechequegirado)throws Exception  {
		detallechequegirado.setDetalleChequeGiradoOriginal((DetalleChequeGirado)detallechequegirado.clone());		
	}
	
	public void setDetalleChequeGiradosOriginal(List<DetalleChequeGirado> detallechequegirados)throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado:detallechequegirados){
			detallechequegirado.setDetalleChequeGiradoOriginal((DetalleChequeGirado)detallechequegirado.clone());
		}
	}
	
	public static void setDetalleChequeGiradoOriginalStatic(DetalleChequeGirado detallechequegirado)throws Exception  {
		detallechequegirado.setDetalleChequeGiradoOriginal((DetalleChequeGirado)detallechequegirado.clone());		
	}
	
	public static void setDetalleChequeGiradosOriginalStatic(List<DetalleChequeGirado> detallechequegirados)throws Exception  {
		
		for(DetalleChequeGirado detallechequegirado:detallechequegirados){
			detallechequegirado.setDetalleChequeGiradoOriginal((DetalleChequeGirado)detallechequegirado.clone());
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
	
	public  DetalleChequeGirado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();		
		
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
	
	public  DetalleChequeGirado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.DetalleChequeGirado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleChequeGiradoOriginal(new DetalleChequeGirado());
      	    	entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleChequeGirado("",entity,resultSet); 
				
				//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleChequeGirado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleChequeGirado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();
				
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
	
	public  DetalleChequeGirado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleChequeGiradoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.DetalleChequeGirado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleChequeGiradoOriginal(new DetalleChequeGirado());
      	    	entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleChequeGirado("",entity,resultSet);    
				
				//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleChequeGirado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleChequeGirado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleChequeGirado entity = new DetalleChequeGirado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleChequeGiradoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.DetalleChequeGirado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleChequeGirado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleChequeGirado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		
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
	
	public  List<DetalleChequeGirado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleChequeGiradoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleChequeGirado();
      	    	entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleChequeGirado("",entity,resultSet);
      	    	
				//entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
      	    	//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleChequeGirados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleChequeGirado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleChequeGirado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
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
	
	public  List<DetalleChequeGirado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleChequeGirado();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleChequeGirado();
					//entity.setMapDetalleChequeGirado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleChequeGiradoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleChequeGirado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleChequeGiradoDataAccess.getEntityDetalleChequeGirado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
					////entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleChequeGirados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleChequeGirado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleChequeGirado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
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
	
	public  DetalleChequeGirado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleChequeGirado();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleChequeGirado();
					//entity.setMapDetalleChequeGirado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleChequeGiradoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleChequeGirado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleChequeGiradoDataAccess.getEntityDetalleChequeGirado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
					////entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleChequeGirado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleChequeGirado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleChequeGirado getEntityDetalleChequeGirado(String strPrefijo,DetalleChequeGirado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleChequeGirado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleChequeGirado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleChequeGiradoDataAccess.setFieldReflectionDetalleChequeGirado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleChequeGirado=DetalleChequeGiradoConstantesFunciones.getTodosTiposColumnasDetalleChequeGirado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleChequeGirado) {
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
							field = DetalleChequeGirado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleChequeGirado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleChequeGiradoDataAccess.setFieldReflectionDetalleChequeGirado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleChequeGirado(Field field,String strPrefijo,String sColumn,DetalleChequeGirado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleChequeGiradoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.CUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.CON:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.NOMBREBANCO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleChequeGiradoConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleChequeGirado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleChequeGiradoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleChequeGirado();
					entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleChequeGirado("",entity,resultSet);
					
					//entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
					//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleChequeGirados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleChequeGirado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleChequeGirado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleChequeGiradoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleChequeGiradoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleChequeGirado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
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
	
	public  List<DetalleChequeGirado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleChequeGirado();
      	    	entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleChequeGirado("",entity,resultSet);
      	    	
				//entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
      	    	//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleChequeGirados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleChequeGirado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleChequeGirado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
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
	
	public  List<DetalleChequeGirado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleChequeGirado> entities = new  ArrayList<DetalleChequeGirado>();
		DetalleChequeGirado entity = new DetalleChequeGirado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleChequeGirado();
      	    	entity=super.getEntity("",entity,resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleChequeGirado("",entity,resultSet);
      	    	
				//entity.setDetalleChequeGiradoOriginal( new DetalleChequeGirado());
      	    	//entity.setDetalleChequeGiradoOriginal(super.getEntity("",entity.getDetalleChequeGiradoOriginal(),resultSet,DetalleChequeGiradoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleChequeGiradoOriginal(this.getEntityDetalleChequeGirado("",entity.getDetalleChequeGiradoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleChequeGirados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleChequeGirado getEntityDetalleChequeGirado(String strPrefijo,DetalleChequeGirado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDPERIODO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_empleado(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDEMPLEADO));
				entity.setid_cuenta_banco(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDCUENTABANCO));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.NUMEROCHEQUE));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleChequeGiradoConstantesFunciones.VALOR));
				entity.setcuenta(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.CUENTA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleChequeGiradoConstantesFunciones.FECHA).getTime()));
				entity.setcon(resultSet.getBoolean(strPrefijo+DetalleChequeGiradoConstantesFunciones.CON));
				entity.setbeneficiario(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.BENEFICIARIO));
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.CODIGO));
				entity.setnombre_banco(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.NOMBREBANCO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleChequeGiradoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleChequeGiradoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleChequeGirado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleChequeGirado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleChequeGiradoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleChequeGiradoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleChequeGiradoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleChequeGiradoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleChequeGiradoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleChequeGiradoDataAccess.TABLENAME,DetalleChequeGiradoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleChequeGiradoDataAccess.setDetalleChequeGiradoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallechequegirado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallechequegirado.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallechequegirado.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallechequegirado.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetallechequegirado.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Empleado getEmpleado(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,reldetallechequegirado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public CuentaBanco getCuentaBanco(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		CuentaBanco cuentabanco= new CuentaBanco();

		try {
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			cuentabanco=cuentabancoDataAccess.getEntity(connexion,reldetallechequegirado.getid_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabanco;

	}

	public Anio getAnio(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallechequegirado.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleChequeGirado reldetallechequegirado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallechequegirado.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleChequeGirado detallechequegirado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallechequegirado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallechequegirado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallechequegirado.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallechequegirado.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallechequegirado.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detallechequegirado.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(detallechequegirado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_banco.setValue(detallechequegirado.getid_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(detallechequegirado.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detallechequegirado.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecuenta=new ParameterValue<String>();
					parameterMaintenanceValuecuenta.setValue(detallechequegirado.getcuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detallechequegirado.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon.setValue(detallechequegirado.getcon());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuebeneficiario=new ParameterValue<String>();
					parameterMaintenanceValuebeneficiario.setValue(detallechequegirado.getbeneficiario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebeneficiario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(detallechequegirado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_banco=new ParameterValue<String>();
					parameterMaintenanceValuenombre_banco.setValue(detallechequegirado.getnombre_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallechequegirado.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallechequegirado.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallechequegirado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallechequegirado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallechequegirado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallechequegirado.getId());
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
	
	public void setIsNewIsChangedFalseDetalleChequeGirado(DetalleChequeGirado detallechequegirado)throws Exception  {		
		detallechequegirado.setIsNew(false);
		detallechequegirado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleChequeGirados(List<DetalleChequeGirado> detallechequegirados)throws Exception  {				
		for(DetalleChequeGirado detallechequegirado:detallechequegirados) {
			detallechequegirado.setIsNew(false);
			detallechequegirado.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleChequeGirado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
