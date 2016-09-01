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
import com.bydan.erp.facturacion.util.*;//NotaCreditoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class NotaCreditoDataAccess extends  NotaCreditoDataAccessAdditional{ //NotaCreditoDataAccessAdditional,DataAccessHelper<NotaCredito>
	//static Logger logger = Logger.getLogger(NotaCreditoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="nota_credito";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,codigo,numero,fecha_emision,numero_dias,fecha_vencimiento,id_moneda,cotizacion,id_empleado,id_formato,id_tipo_precio,id_cliente,id_factura,direccion,telefono,ruc,id_vendedor,id_responsable,id_estado_nota_credito,descripcion,descuento_porcentaje,total_iva,suman,descuento_valor,total_sin_iva,total_descuento,flete,total,sub_total,otro,iva,financiamiento,ice,otro_valor,retencion,fecha,es_cliente,id_centro_costo,id_tipo_cambio,id_transporte,id_transportista,fecha_cliente,fecha_autorizacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,codigo=?,numero=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,id_tipo_precio=?,id_cliente=?,id_factura=?,direccion=?,telefono=?,ruc=?,id_vendedor=?,id_responsable=?,id_estado_nota_credito=?,descripcion=?,descuento_porcentaje=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,flete=?,total=?,sub_total=?,otro=?,iva=?,financiamiento=?,ice=?,otro_valor=?,retencion=?,fecha=?,es_cliente=?,id_centro_costo=?,id_tipo_cambio=?,id_transporte=?,id_transportista=?,fecha_cliente=?,fecha_autorizacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select notacredito from "+NotaCreditoConstantesFunciones.SPERSISTENCENAME+" notacredito";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_ejercicio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_periodo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_anio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_mes,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".codigo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".numero,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_emision,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".numero_dias,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_moneda,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".cotizacion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_empleado,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_factura,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".direccion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".telefono,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".ruc,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_responsable,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_estado_nota_credito,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descripcion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descuento_porcentaje,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".suman,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descuento_valor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_descuento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".flete,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".otro,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".ice,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".otro_valor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".retencion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".es_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_centro_costo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_tipo_cambio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_transporte,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_transportista,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_autorizacion from "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME;//+" as "+NotaCreditoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".codigo from "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME;//+" as "+NotaCreditoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,codigo=?,numero=?,fecha_emision=?,numero_dias=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_formato=?,id_tipo_precio=?,id_cliente=?,id_factura=?,direccion=?,telefono=?,ruc=?,id_vendedor=?,id_responsable=?,id_estado_nota_credito=?,descripcion=?,descuento_porcentaje=?,total_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,flete=?,total=?,sub_total=?,otro=?,iva=?,financiamiento=?,ice=?,otro_valor=?,retencion=?,fecha=?,es_cliente=?,id_centro_costo=?,id_tipo_cambio=?,id_transporte=?,id_transportista=?,fecha_cliente=?,fecha_autorizacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOTACREDITO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOTACREDITO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOTACREDITO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOTACREDITO_SELECT(?,?)";
	
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
	
	
	protected NotaCreditoDataAccessAdditional notacreditoDataAccessAdditional=null;
	
	public NotaCreditoDataAccessAdditional getNotaCreditoDataAccessAdditional() {
		return this.notacreditoDataAccessAdditional;
	}
	
	public void setNotaCreditoDataAccessAdditional(NotaCreditoDataAccessAdditional notacreditoDataAccessAdditional) {
		try {
			this.notacreditoDataAccessAdditional=notacreditoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NotaCreditoDataAccess() {
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
		NotaCreditoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NotaCreditoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NotaCreditoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNotaCreditoOriginal(NotaCredito notacredito)throws Exception  {
		notacredito.setNotaCreditoOriginal((NotaCredito)notacredito.clone());		
	}
	
	public void setNotaCreditosOriginal(List<NotaCredito> notacreditos)throws Exception  {
		
		for(NotaCredito notacredito:notacreditos){
			notacredito.setNotaCreditoOriginal((NotaCredito)notacredito.clone());
		}
	}
	
	public static void setNotaCreditoOriginalStatic(NotaCredito notacredito)throws Exception  {
		notacredito.setNotaCreditoOriginal((NotaCredito)notacredito.clone());		
	}
	
	public static void setNotaCreditosOriginalStatic(List<NotaCredito> notacreditos)throws Exception  {
		
		for(NotaCredito notacredito:notacreditos){
			notacredito.setNotaCreditoOriginal((NotaCredito)notacredito.clone());
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
	
	public  NotaCredito getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();		
		
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
	
	public  NotaCredito getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.NotaCredito.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNotaCreditoOriginal(new NotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCredito("",entity,resultSet); 
				
				//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCredito(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NotaCredito getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();
				
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
	
	public  NotaCredito getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.NotaCredito.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNotaCreditoOriginal(new NotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCredito("",entity,resultSet);    
				
				//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NotaCredito
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NotaCredito entity = new NotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.NotaCredito.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NotaCredito> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		
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
	
	public  List<NotaCredito> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCredito("",entity,resultSet);
      	    	
				//entity.setNotaCreditoOriginal( new NotaCredito());
      	    	//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
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
	
	public  List<NotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCredito();
					//entity.setMapNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoDataAccess.getEntityNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoOriginal( new NotaCredito());
					////entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NotaCredito getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();		  
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
	
	public  NotaCredito getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCredito();
					//entity.setMapNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoDataAccess.getEntityNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoOriginal( new NotaCredito());
					////entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNotaCredito(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NotaCredito getEntityNotaCredito(String strPrefijo,NotaCredito entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NotaCredito.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NotaCreditoDataAccess.setFieldReflectionNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNotaCredito=NotaCreditoConstantesFunciones.getTodosTiposColumnasNotaCredito();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNotaCredito) {
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
							field = NotaCredito.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NotaCreditoDataAccess.setFieldReflectionNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNotaCredito(Field field,String strPrefijo,String sColumn,NotaCredito entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NotaCreditoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDRESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDESTADONOTACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.OTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.OTROVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.RETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoConstantesFunciones.ESCLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoConstantesFunciones.FECHACLIENTE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoConstantesFunciones.FECHAAUTORIZACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCredito>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NotaCredito();
					entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNotaCredito("",entity,resultSet);
					
					//entity.setNotaCreditoOriginal( new NotaCredito());
					//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
					//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNotaCreditos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCredito>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
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
	
	public  List<NotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCredito("",entity,resultSet);
      	    	
				//entity.setNotaCreditoOriginal( new NotaCredito());
      	    	//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNotaCreditos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCredito> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
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
	
	public  List<NotaCredito> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCredito> entities = new  ArrayList<NotaCredito>();
		NotaCredito entity = new NotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCredito("",entity,resultSet);
      	    	
				//entity.setNotaCreditoOriginal( new NotaCredito());
      	    	//entity.setNotaCreditoOriginal(super.getEntity("",entity.getNotaCreditoOriginal(),resultSet,NotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoOriginal(this.getEntityNotaCredito("",entity.getNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NotaCredito getEntityNotaCredito(String strPrefijo,NotaCredito entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDUSUARIO));
				entity.setcodigo(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.CODIGO));
				entity.setnumero(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+NotaCreditoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+NotaCreditoConstantesFunciones.NUMERODIAS));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+NotaCreditoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.COTIZACION));
				entity.setid_empleado(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDEMPLEADO));
				entity.setid_formato(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDTIPOPRECIO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDFACTURA));
				entity.setdireccion(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.TELEFONO));
				entity.setruc(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.RUC));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_responsable(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDRESPONSABLE));
				entity.setid_estado_nota_credito(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDESTADONOTACREDITO));
				entity.setdescripcion(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.DESCRIPCION));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.TOTALIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.DESCUENTOVALOR));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.TOTALSINIVA));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.TOTALDESCUENTO));
				entity.setflete(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.FLETE));
				entity.settotal(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.TOTAL));
				entity.setsub_total(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.SUBTOTAL));
				entity.setotro(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.OTRO));
				entity.setiva(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.IVA));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.FINANCIAMIENTO));
				entity.setice(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.ICE));
				entity.setotro_valor(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.OTROVALOR));
				entity.setretencion(resultSet.getDouble(strPrefijo+NotaCreditoConstantesFunciones.RETENCION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+NotaCreditoConstantesFunciones.FECHA).getTime()));
				entity.setes_cliente(resultSet.getBoolean(strPrefijo+NotaCreditoConstantesFunciones.ESCLIENTE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_transporte(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDTRANSPORTE));if(resultSet.wasNull()) {entity.setid_transporte(null); }
				entity.setid_transportista(resultSet.getLong(strPrefijo+NotaCreditoConstantesFunciones.IDTRANSPORTISTA));if(resultSet.wasNull()) {entity.setid_transportista(null); }
				entity.setfecha_cliente(new Date(resultSet.getDate(strPrefijo+NotaCreditoConstantesFunciones.FECHACLIENTE).getTime()));
				entity.setfecha_autorizacion(new Date(resultSet.getDate(strPrefijo+NotaCreditoConstantesFunciones.FECHAAUTORIZACION).getTime()));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+NotaCreditoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNotaCredito(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NotaCredito entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NotaCreditoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NotaCreditoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NotaCreditoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NotaCreditoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NotaCreditoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NotaCreditoDataAccess.TABLENAME,NotaCreditoDataAccess.ISWITHSTOREPROCEDURES);
			
			NotaCreditoDataAccess.setNotaCreditoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnotacredito.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relnotacredito.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relnotacredito.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relnotacredito.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relnotacredito.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relnotacredito.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relnotacredito.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relnotacredito.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relnotacredito.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relnotacredito.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relnotacredito.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Cliente getCliente(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relnotacredito.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relnotacredito.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Vendedor getVendedor(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relnotacredito.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Responsable getResponsable(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Responsable responsable= new Responsable();

		try {
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);

			responsable=responsableDataAccess.getEntity(connexion,relnotacredito.getid_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsable;

	}

	public EstadoNotaCredito getEstadoNotaCredito(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		EstadoNotaCredito estadonotacredito= new EstadoNotaCredito();

		try {
			EstadoNotaCreditoDataAccess estadonotacreditoDataAccess=new EstadoNotaCreditoDataAccess();

			estadonotacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadonotacreditoDataAccess.setConnexionType(this.connexionType);
			estadonotacreditoDataAccess.setParameterDbType(this.parameterDbType);

			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,relnotacredito.getid_estado_nota_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadonotacredito;

	}

	public CentroCosto getCentroCosto(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relnotacredito.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public TipoCambio getTipoCambio(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relnotacredito.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public Transporte getTransporte(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relnotacredito.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public Transportista getTransportista(Connexion connexion,NotaCredito relnotacredito)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relnotacredito.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}


		
		public List<DetaNotaCredito> getDetaNotaCreditos(Connexion connexion,NotaCredito notacredito)throws SQLException,Exception {

		List<DetaNotaCredito> detanotacreditos= new ArrayList<DetaNotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito ON "+DetaNotaCreditoConstantesFunciones.SCHEMA+".deta_nota_credito.id_nota_credito="+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id WHERE "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id="+String.valueOf(notacredito.getId());
			} else {
				sQuery=" INNER JOIN detanotacredito.NotaCredito WHERE detanotacredito.NotaCredito.id="+String.valueOf(notacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoDataAccess detanotacreditoDataAccess=new DetaNotaCreditoDataAccess();

			detanotacreditoDataAccess.setConnexionType(this.connexionType);
			detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NotaCredito notacredito) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!notacredito.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(notacredito.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(notacredito.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(notacredito.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(notacredito.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(notacredito.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(notacredito.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(notacredito.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(notacredito.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(notacredito.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(notacredito.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(notacredito.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(notacredito.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(notacredito.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(notacredito.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(notacredito.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(notacredito.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(notacredito.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(notacredito.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(notacredito.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(notacredito.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(notacredito.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(notacredito.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(notacredito.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable.setValue(notacredito.getid_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_nota_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_nota_credito.setValue(notacredito.getid_estado_nota_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_nota_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(notacredito.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(notacredito.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(notacredito.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(notacredito.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(notacredito.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(notacredito.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(notacredito.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(notacredito.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(notacredito.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(notacredito.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro=new ParameterValue<Double>();
					parameterMaintenanceValueotro.setValue(notacredito.getotro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(notacredito.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(notacredito.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(notacredito.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro_valor=new ParameterValue<Double>();
					parameterMaintenanceValueotro_valor.setValue(notacredito.getotro_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion=new ParameterValue<Double>();
					parameterMaintenanceValueretencion.setValue(notacredito.getretencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(notacredito.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_cliente.setValue(notacredito.getes_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(notacredito.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(notacredito.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(notacredito.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(notacredito.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_cliente=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_cliente.setValue(notacredito.getfecha_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autorizacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autorizacion.setValue(notacredito.getfecha_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!notacredito.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(notacredito.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(notacredito.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(notacredito.getId());
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
	
	public void setIsNewIsChangedFalseNotaCredito(NotaCredito notacredito)throws Exception  {		
		notacredito.setIsNew(false);
		notacredito.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNotaCreditos(List<NotaCredito> notacreditos)throws Exception  {				
		for(NotaCredito notacredito:notacreditos) {
			notacredito.setIsNew(false);
			notacredito.setIsChanged(false);
		}
	}
	
	public void generarExportarNotaCredito(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
