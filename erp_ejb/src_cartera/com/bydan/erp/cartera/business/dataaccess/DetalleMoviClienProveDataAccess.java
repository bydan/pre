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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//DetalleMoviClienProveConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class DetalleMoviClienProveDataAccess extends  DetalleMoviClienProveDataAccessAdditional{ //DetalleMoviClienProveDataAccessAdditional,DataAccessHelper<DetalleMoviClienProve>
	//static Logger logger = Logger.getLogger(DetalleMoviClienProveDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_movi_clien_prove";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_asiento_contable,fecha_vence,id_cliente,id_factura,numero_factura,id_transaccion,debito_mone_local,credito_mone_local,debito_mone_extra,credito_mone_extra,id_moneda,cotizacion,descripcion,id_sucursal_movimiento,id_tipo_transaccion_modulo,id_estado_detalle_cliente,fecha_emision,monto_mone_local,monto_mone_extra,numero_comprobante)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_asiento_contable=?,fecha_vence=?,id_cliente=?,id_factura=?,numero_factura=?,id_transaccion=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,id_moneda=?,cotizacion=?,descripcion=?,id_sucursal_movimiento=?,id_tipo_transaccion_modulo=?,id_estado_detalle_cliente=?,fecha_emision=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallemoviclienprove from "+DetalleMoviClienProveConstantesFunciones.SPERSISTENCENAME+" detallemoviclienprove";
	public static String QUERYSELECTNATIVE="select "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".version_row,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_periodo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_anio,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_mes,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_modulo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".fecha_vence,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_cliente,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_factura,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".numero_factura,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".debito_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".credito_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".debito_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".credito_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_moneda,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".cotizacion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".descripcion,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_sucursal_movimiento,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id_estado_detalle_cliente,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".monto_mone_local,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".monto_mone_extra,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".numero_comprobante from "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME;//+" as "+DetalleMoviClienProveConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".id,"+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+".version_row from "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME;//+" as "+DetalleMoviClienProveConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleMoviClienProveConstantesFunciones.SCHEMA+"."+DetalleMoviClienProveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_asiento_contable=?,fecha_vence=?,id_cliente=?,id_factura=?,numero_factura=?,id_transaccion=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,id_moneda=?,cotizacion=?,descripcion=?,id_sucursal_movimiento=?,id_tipo_transaccion_modulo=?,id_estado_detalle_cliente=?,fecha_emision=?,monto_mone_local=?,monto_mone_extra=?,numero_comprobante=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEMOVICLIENPROVE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEMOVICLIENPROVE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEMOVICLIENPROVE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEMOVICLIENPROVE_SELECT(?,?)";
	
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
	
	
	protected DetalleMoviClienProveDataAccessAdditional detallemoviclienproveDataAccessAdditional=null;
	
	public DetalleMoviClienProveDataAccessAdditional getDetalleMoviClienProveDataAccessAdditional() {
		return this.detallemoviclienproveDataAccessAdditional;
	}
	
	public void setDetalleMoviClienProveDataAccessAdditional(DetalleMoviClienProveDataAccessAdditional detallemoviclienproveDataAccessAdditional) {
		try {
			this.detallemoviclienproveDataAccessAdditional=detallemoviclienproveDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleMoviClienProveDataAccess() {
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
		DetalleMoviClienProveDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleMoviClienProveDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleMoviClienProveDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleMoviClienProveOriginal(DetalleMoviClienProve detallemoviclienprove)throws Exception  {
		detallemoviclienprove.setDetalleMoviClienProveOriginal((DetalleMoviClienProve)detallemoviclienprove.clone());		
	}
	
	public void setDetalleMoviClienProvesOriginal(List<DetalleMoviClienProve> detallemoviclienproves)throws Exception  {
		
		for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves){
			detallemoviclienprove.setDetalleMoviClienProveOriginal((DetalleMoviClienProve)detallemoviclienprove.clone());
		}
	}
	
	public static void setDetalleMoviClienProveOriginalStatic(DetalleMoviClienProve detallemoviclienprove)throws Exception  {
		detallemoviclienprove.setDetalleMoviClienProveOriginal((DetalleMoviClienProve)detallemoviclienprove.clone());		
	}
	
	public static void setDetalleMoviClienProvesOriginalStatic(List<DetalleMoviClienProve> detallemoviclienproves)throws Exception  {
		
		for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves){
			detallemoviclienprove.setDetalleMoviClienProveOriginal((DetalleMoviClienProve)detallemoviclienprove.clone());
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
	
	public  DetalleMoviClienProve getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		
		
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
	
	public  DetalleMoviClienProve getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DetalleMoviClienProve.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleMoviClienProveOriginal(new DetalleMoviClienProve());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMoviClienProve("",entity,resultSet); 
				
				//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMoviClienProve(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleMoviClienProve getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();
				
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
	
	public  DetalleMoviClienProve getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMoviClienProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleMoviClienProve.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleMoviClienProveOriginal(new DetalleMoviClienProve());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMoviClienProve("",entity,resultSet);    
				
				//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMoviClienProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleMoviClienProve
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleMoviClienProve entity = new DetalleMoviClienProve();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMoviClienProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleMoviClienProve.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleMoviClienProve(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleMoviClienProve> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		
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
	
	public  List<DetalleMoviClienProve> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMoviClienProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMoviClienProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMoviClienProve("",entity,resultSet);
      	    	
				//entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
      	    	//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMoviClienProves(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMoviClienProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMoviClienProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
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
	
	public  List<DetalleMoviClienProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMoviClienProve();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMoviClienProve();
					//entity.setMapDetalleMoviClienProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleMoviClienProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMoviClienProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMoviClienProveDataAccess.getEntityDetalleMoviClienProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
					////entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMoviClienProves(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMoviClienProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleMoviClienProve getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
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
	
	public  DetalleMoviClienProve getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMoviClienProve();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMoviClienProve();
					//entity.setMapDetalleMoviClienProve(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleMoviClienProveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMoviClienProve().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMoviClienProveDataAccess.getEntityDetalleMoviClienProve("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
					////entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleMoviClienProve(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMoviClienProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleMoviClienProve getEntityDetalleMoviClienProve(String strPrefijo,DetalleMoviClienProve entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleMoviClienProve.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleMoviClienProve.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleMoviClienProveDataAccess.setFieldReflectionDetalleMoviClienProve(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleMoviClienProve=DetalleMoviClienProveConstantesFunciones.getTodosTiposColumnasDetalleMoviClienProve();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleMoviClienProve) {
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
							field = DetalleMoviClienProve.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleMoviClienProve.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleMoviClienProveDataAccess.setFieldReflectionDetalleMoviClienProve(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleMoviClienProve(Field field,String strPrefijo,String sColumn,DetalleMoviClienProve entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleMoviClienProveConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMoviClienProve>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMoviClienProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleMoviClienProve();
					entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleMoviClienProve("",entity,resultSet);
					
					//entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
					//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleMoviClienProves(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMoviClienProve(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMoviClienProve>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMoviClienProveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMoviClienProveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleMoviClienProve> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
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
	
	public  List<DetalleMoviClienProve> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMoviClienProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMoviClienProve("",entity,resultSet);
      	    	
				//entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
      	    	//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleMoviClienProves(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMoviClienProve(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMoviClienProve> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
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
	
	public  List<DetalleMoviClienProve> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMoviClienProve> entities = new  ArrayList<DetalleMoviClienProve>();
		DetalleMoviClienProve entity = new DetalleMoviClienProve();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMoviClienProve();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMoviClienProve("",entity,resultSet);
      	    	
				//entity.setDetalleMoviClienProveOriginal( new DetalleMoviClienProve());
      	    	//entity.setDetalleMoviClienProveOriginal(super.getEntity("",entity.getDetalleMoviClienProveOriginal(),resultSet,DetalleMoviClienProveDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMoviClienProveOriginal(this.getEntityDetalleMoviClienProve("",entity.getDetalleMoviClienProveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMoviClienProves(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleMoviClienProve getEntityDetalleMoviClienProve(String strPrefijo,DetalleMoviClienProve entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDMODULO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDASIENTOCONTABLE));
				entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+DetalleMoviClienProveConstantesFunciones.FECHAVENCE).getTime()));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setnumero_factura(resultSet.getString(strPrefijo+DetalleMoviClienProveConstantesFunciones.NUMEROFACTURA));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDTRANSACCION));
				entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.DEBITOMONELOCAL));
				entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.CREDITOMONELOCAL));
				entity.setdebito_mone_extra(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.DEBITOMONEEXTRA));
				entity.setcredito_mone_extra(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.CREDITOMONEEXTRA));
				entity.setid_moneda(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.COTIZACION));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleMoviClienProveConstantesFunciones.DESCRIPCION));
				entity.setid_sucursal_movimiento(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDSUCURSALMOVIMIENTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_estado_detalle_cliente(resultSet.getLong(strPrefijo+DetalleMoviClienProveConstantesFunciones.IDESTADODETALLECLIENTE));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetalleMoviClienProveConstantesFunciones.FECHAEMISION).getTime()));
				entity.setmonto_mone_local(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.MONTOMONELOCAL));
				entity.setmonto_mone_extra(resultSet.getDouble(strPrefijo+DetalleMoviClienProveConstantesFunciones.MONTOMONEEXTRA));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+DetalleMoviClienProveConstantesFunciones.NUMEROCOMPROBANTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleMoviClienProve(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleMoviClienProve entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleMoviClienProveDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleMoviClienProveDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleMoviClienProveDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleMoviClienProveDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleMoviClienProveConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleMoviClienProveDataAccess.TABLENAME,DetalleMoviClienProveDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleMoviClienProveDataAccess.setDetalleMoviClienProveOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Cliente getCliente(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Transaccion getTransaccion(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Moneda getMoneda(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Sucursal getSucursalMovimiento(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_sucursal_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public EstadoDetalleCliente getEstadoDetalleCliente(Connexion connexion,DetalleMoviClienProve reldetallemoviclienprove)throws SQLException,Exception {

		EstadoDetalleCliente estadodetallecliente= new EstadoDetalleCliente();

		try {
			EstadoDetalleClienteDataAccess estadodetalleclienteDataAccess=new EstadoDetalleClienteDataAccess();

			estadodetalleclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadodetalleclienteDataAccess.setConnexionType(this.connexionType);
			estadodetalleclienteDataAccess.setParameterDbType(this.parameterDbType);

			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,reldetallemoviclienprove.getid_estado_detalle_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadodetallecliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleMoviClienProve detallemoviclienprove) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallemoviclienprove.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallemoviclienprove.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallemoviclienprove.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallemoviclienprove.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallemoviclienprove.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallemoviclienprove.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallemoviclienprove.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(detallemoviclienprove.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detallemoviclienprove.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vence=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vence.setValue(detallemoviclienprove.getfecha_vence());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vence);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(detallemoviclienprove.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(detallemoviclienprove.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(detallemoviclienprove.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(detallemoviclienprove.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_local.setValue(detallemoviclienprove.getdebito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_local.setValue(detallemoviclienprove.getcredito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_extra.setValue(detallemoviclienprove.getdebito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_extra.setValue(detallemoviclienprove.getcredito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(detallemoviclienprove.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(detallemoviclienprove.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallemoviclienprove.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal_movimiento.setValue(detallemoviclienprove.getid_sucursal_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(detallemoviclienprove.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_detalle_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_detalle_cliente.setValue(detallemoviclienprove.getid_estado_detalle_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_detalle_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detallemoviclienprove.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_local.setValue(detallemoviclienprove.getmonto_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_mone_extra.setValue(detallemoviclienprove.getmonto_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(detallemoviclienprove.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallemoviclienprove.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallemoviclienprove.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallemoviclienprove.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallemoviclienprove.getId());
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
	
	public void setIsNewIsChangedFalseDetalleMoviClienProve(DetalleMoviClienProve detallemoviclienprove)throws Exception  {		
		detallemoviclienprove.setIsNew(false);
		detallemoviclienprove.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleMoviClienProves(List<DetalleMoviClienProve> detallemoviclienproves)throws Exception  {				
		for(DetalleMoviClienProve detallemoviclienprove:detallemoviclienproves) {
			detallemoviclienprove.setIsNew(false);
			detallemoviclienprove.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleMoviClienProve(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
