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
import com.bydan.erp.facturacion.util.*;//ParametroFactuSecuencialConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ParametroFactuSecuencialDataAccess extends  ParametroFactuSecuencialDataAccessAdditional{ //ParametroFactuSecuencialDataAccessAdditional,DataAccessHelper<ParametroFactuSecuencial>
	//static Logger logger = Logger.getLogger(ParametroFactuSecuencialDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_factu_secuencial";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_documento_general,secuencial,numero_digitos,numero_items,numero_descuento,numero_adiicionales,numero_digito_inicio,numero_digito_fin,numero_dias_plazo,con_detalle,con_lector,id_bodega,id_tipo_param_factu_plazo,id_formato,con_transferencia,id_bodega_transferencia,id_transaccion_transferencia)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_documento_general=?,secuencial=?,numero_digitos=?,numero_items=?,numero_descuento=?,numero_adiicionales=?,numero_digito_inicio=?,numero_digito_fin=?,numero_dias_plazo=?,con_detalle=?,con_lector=?,id_bodega=?,id_tipo_param_factu_plazo=?,id_formato=?,con_transferencia=?,id_bodega_transferencia=?,id_transaccion_transferencia=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofactusecuencial from "+ParametroFactuSecuencialConstantesFunciones.SPERSISTENCENAME+" parametrofactusecuencial";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".secuencial,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digitos,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_items,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_descuento,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_adiicionales,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digito_inicio,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digito_fin,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_dias_plazo,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_detalle,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_lector,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_bodega,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_tipo_param_factu_plazo,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_formato,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_transferencia,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_bodega_transferencia,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_transaccion_transferencia from "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME;//+" as "+ParametroFactuSecuencialConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".version_row from "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME;//+" as "+ParametroFactuSecuencialConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_documento_general=?,secuencial=?,numero_digitos=?,numero_items=?,numero_descuento=?,numero_adiicionales=?,numero_digito_inicio=?,numero_digito_fin=?,numero_dias_plazo=?,con_detalle=?,con_lector=?,id_bodega=?,id_tipo_param_factu_plazo=?,id_formato=?,con_transferencia=?,id_bodega_transferencia=?,id_transaccion_transferencia=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTUSECUENCIAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTUSECUENCIAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTUSECUENCIAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTUSECUENCIAL_SELECT(?,?)";
	
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
	
	
	protected ParametroFactuSecuencialDataAccessAdditional parametrofactusecuencialDataAccessAdditional=null;
	
	public ParametroFactuSecuencialDataAccessAdditional getParametroFactuSecuencialDataAccessAdditional() {
		return this.parametrofactusecuencialDataAccessAdditional;
	}
	
	public void setParametroFactuSecuencialDataAccessAdditional(ParametroFactuSecuencialDataAccessAdditional parametrofactusecuencialDataAccessAdditional) {
		try {
			this.parametrofactusecuencialDataAccessAdditional=parametrofactusecuencialDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFactuSecuencialDataAccess() {
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
		ParametroFactuSecuencialDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFactuSecuencialDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFactuSecuencialDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFactuSecuencialOriginal(ParametroFactuSecuencial parametrofactusecuencial)throws Exception  {
		parametrofactusecuencial.setParametroFactuSecuencialOriginal((ParametroFactuSecuencial)parametrofactusecuencial.clone());		
	}
	
	public void setParametroFactuSecuencialsOriginal(List<ParametroFactuSecuencial> parametrofactusecuencials)throws Exception  {
		
		for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials){
			parametrofactusecuencial.setParametroFactuSecuencialOriginal((ParametroFactuSecuencial)parametrofactusecuencial.clone());
		}
	}
	
	public static void setParametroFactuSecuencialOriginalStatic(ParametroFactuSecuencial parametrofactusecuencial)throws Exception  {
		parametrofactusecuencial.setParametroFactuSecuencialOriginal((ParametroFactuSecuencial)parametrofactusecuencial.clone());		
	}
	
	public static void setParametroFactuSecuencialsOriginalStatic(List<ParametroFactuSecuencial> parametrofactusecuencials)throws Exception  {
		
		for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials){
			parametrofactusecuencial.setParametroFactuSecuencialOriginal((ParametroFactuSecuencial)parametrofactusecuencial.clone());
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
	
	public  ParametroFactuSecuencial getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		
		
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
	
	public  ParametroFactuSecuencial getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFactuSecuencial.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFactuSecuencialOriginal(new ParametroFactuSecuencial());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuSecuencial("",entity,resultSet); 
				
				//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuSecuencial(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFactuSecuencial getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();
				
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
	
	public  ParametroFactuSecuencial getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuSecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuSecuencial.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFactuSecuencialOriginal(new ParametroFactuSecuencial());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFactuSecuencial("",entity,resultSet);    
				
				//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFactuSecuencial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFactuSecuencial
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuSecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFactuSecuencial.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFactuSecuencial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFactuSecuencial> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		
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
	
	public  List<ParametroFactuSecuencial> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuSecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuSecuencial();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuSecuencial("",entity,resultSet);
      	    	
				//entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
      	    	//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuSecuencials(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuSecuencial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
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
	
	public  List<ParametroFactuSecuencial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuSecuencial();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuSecuencial();
					//entity.setMapParametroFactuSecuencial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFactuSecuencialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuSecuencial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuSecuencialDataAccess.getEntityParametroFactuSecuencial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
					////entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuSecuencials(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFactuSecuencial getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
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
	
	public  ParametroFactuSecuencial getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuSecuencial();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFactuSecuencial();
					//entity.setMapParametroFactuSecuencial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFactuSecuencialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFactuSecuencial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFactuSecuencialDataAccess.getEntityParametroFactuSecuencial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
					////entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFactuSecuencial(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFactuSecuencial getEntityParametroFactuSecuencial(String strPrefijo,ParametroFactuSecuencial entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFactuSecuencial.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFactuSecuencial.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFactuSecuencialDataAccess.setFieldReflectionParametroFactuSecuencial(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFactuSecuencial=ParametroFactuSecuencialConstantesFunciones.getTodosTiposColumnasParametroFactuSecuencial();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFactuSecuencial) {
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
							field = ParametroFactuSecuencial.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFactuSecuencial.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFactuSecuencialDataAccess.setFieldReflectionParametroFactuSecuencial(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFactuSecuencial(Field field,String strPrefijo,String sColumn,ParametroFactuSecuencial entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFactuSecuencialConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.CONDETALLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.CONLECTOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuSecuencial>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuSecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFactuSecuencial();
					entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFactuSecuencial("",entity,resultSet);
					
					//entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
					//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFactuSecuencials(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFactuSecuencial>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFactuSecuencialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFactuSecuencialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFactuSecuencial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
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
	
	public  List<ParametroFactuSecuencial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuSecuencial();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuSecuencial("",entity,resultSet);
      	    	
				//entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
      	    	//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFactuSecuencials(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFactuSecuencial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFactuSecuencial> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
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
	
	public  List<ParametroFactuSecuencial> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFactuSecuencial> entities = new  ArrayList<ParametroFactuSecuencial>();
		ParametroFactuSecuencial entity = new ParametroFactuSecuencial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFactuSecuencial();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFactuSecuencial("",entity,resultSet);
      	    	
				//entity.setParametroFactuSecuencialOriginal( new ParametroFactuSecuencial());
      	    	//entity.setParametroFactuSecuencialOriginal(super.getEntity("",entity.getParametroFactuSecuencialOriginal(),resultSet,ParametroFactuSecuencialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFactuSecuencialOriginal(this.getEntityParametroFactuSecuencial("",entity.getParametroFactuSecuencialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFactuSecuencials(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFactuSecuencial getEntityParametroFactuSecuencial(String strPrefijo,ParametroFactuSecuencial entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_documento_general(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL));
				entity.setsecuencial(resultSet.getString(strPrefijo+ParametroFactuSecuencialConstantesFunciones.SECUENCIAL));
				entity.setnumero_digitos(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS));
				entity.setnumero_items(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS));
				entity.setnumero_descuento(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO));
				entity.setnumero_adiicionales(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES));
				entity.setnumero_digito_inicio(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO));
				entity.setnumero_digito_fin(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN));
				entity.setnumero_dias_plazo(resultSet.getInt(strPrefijo+ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO));
				entity.setcon_detalle(resultSet.getBoolean(strPrefijo+ParametroFactuSecuencialConstantesFunciones.CONDETALLE));
				entity.setcon_lector(resultSet.getBoolean(strPrefijo+ParametroFactuSecuencialConstantesFunciones.CONLECTOR));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDBODEGA));
				entity.setid_tipo_param_factu_plazo(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO));
				entity.setid_formato(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDFORMATO));
				entity.setcon_transferencia(resultSet.getBoolean(strPrefijo+ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA));
				entity.setid_bodega_transferencia(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA));
				entity.setid_transaccion_transferencia(resultSet.getLong(strPrefijo+ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFactuSecuencial(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFactuSecuencial entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFactuSecuencialDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFactuSecuencialDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFactuSecuencialDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFactuSecuencialDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFactuSecuencialConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFactuSecuencialDataAccess.TABLENAME,ParametroFactuSecuencialDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFactuSecuencialDataAccess.setParametroFactuSecuencialOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoDocumentoGeneral getTipoDocumentoGeneral(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		TipoDocumentoGeneral tipodocumentogeneral= new TipoDocumentoGeneral();

		try {
			TipoDocumentoGeneralDataAccess tipodocumentogeneralDataAccess=new TipoDocumentoGeneralDataAccess();

			tipodocumentogeneralDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentogeneralDataAccess.setConnexionType(this.connexionType);
			tipodocumentogeneralDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_tipo_documento_general());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumentogeneral;

	}

	public Bodega getBodega(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public TipoParamFactuPlazo getTipoParamFactuPlazo(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		TipoParamFactuPlazo tipoparamfactuplazo= new TipoParamFactuPlazo();

		try {
			TipoParamFactuPlazoDataAccess tipoparamfactuplazoDataAccess=new TipoParamFactuPlazoDataAccess();

			tipoparamfactuplazoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparamfactuplazoDataAccess.setConnexionType(this.connexionType);
			tipoparamfactuplazoDataAccess.setParameterDbType(this.parameterDbType);

			tipoparamfactuplazo=tipoparamfactuplazoDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_tipo_param_factu_plazo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparamfactuplazo;

	}

	public Formato getFormato(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Bodega getBodegaTransferencia(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_bodega_transferencia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Transaccion getTransaccionTransferencia(Connexion connexion,ParametroFactuSecuencial relparametrofactusecuencial)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrofactusecuencial.getid_transaccion_transferencia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofactusecuencial.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofactusecuencial.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofactusecuencial.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_general=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_general.setValue(parametrofactusecuencial.getid_tipo_documento_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(parametrofactusecuencial.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_digitos=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_digitos.setValue(parametrofactusecuencial.getnumero_digitos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_digitos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_items=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_items.setValue(parametrofactusecuencial.getnumero_items());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_descuento=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_descuento.setValue(parametrofactusecuencial.getnumero_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_adiicionales=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_adiicionales.setValue(parametrofactusecuencial.getnumero_adiicionales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_adiicionales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_digito_inicio=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_digito_inicio.setValue(parametrofactusecuencial.getnumero_digito_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_digito_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_digito_fin=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_digito_fin.setValue(parametrofactusecuencial.getnumero_digito_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_digito_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias_plazo=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias_plazo.setValue(parametrofactusecuencial.getnumero_dias_plazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias_plazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle.setValue(parametrofactusecuencial.getcon_detalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lector=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lector.setValue(parametrofactusecuencial.getcon_lector());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lector);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametrofactusecuencial.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_param_factu_plazo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_param_factu_plazo.setValue(parametrofactusecuencial.getid_tipo_param_factu_plazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_param_factu_plazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(parametrofactusecuencial.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_transferencia=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_transferencia.setValue(parametrofactusecuencial.getcon_transferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_transferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_transferencia=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_transferencia.setValue(parametrofactusecuencial.getid_bodega_transferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_transferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_transferencia=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_transferencia.setValue(parametrofactusecuencial.getid_transaccion_transferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_transferencia);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofactusecuencial.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofactusecuencial.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofactusecuencial.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofactusecuencial.getId());
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
	
	public void setIsNewIsChangedFalseParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial)throws Exception  {		
		parametrofactusecuencial.setIsNew(false);
		parametrofactusecuencial.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFactuSecuencials(List<ParametroFactuSecuencial> parametrofactusecuencials)throws Exception  {				
		for(ParametroFactuSecuencial parametrofactusecuencial:parametrofactusecuencials) {
			parametrofactusecuencial.setIsNew(false);
			parametrofactusecuencial.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFactuSecuencial(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
