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
package com.bydan.erp.facturacion.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.facturacion.util.TipoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFormaPagoConstantesFunciones extends TipoFormaPagoConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="TipoFormaPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFormaPago"+TipoFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFormaPagoConstantesFunciones.SCHEMA+"_"+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFormaPago";
	public static final String OBJECTNAME="tipoformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tipo_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoformapago from "+TipoFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipoformapago";
	public static String QUERYSELECTNATIVE="select "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_modulo,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".nombre,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".siglas,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".con_detalle,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".con_cuotas,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_transaccion,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".descripcion from "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoFormaPagoConstantesFuncionesAdditional tipoformapagoConstantesFuncionesAdditional=null;
	
	public TipoFormaPagoConstantesFuncionesAdditional getTipoFormaPagoConstantesFuncionesAdditional() {
		return this.tipoformapagoConstantesFuncionesAdditional;
	}
	
	public void setTipoFormaPagoConstantesFuncionesAdditional(TipoFormaPagoConstantesFuncionesAdditional tipoformapagoConstantesFuncionesAdditional) {
		try {
			this.tipoformapagoConstantesFuncionesAdditional=tipoformapagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOGRUPOFORMAPAGO= "id_tipo_grupo_forma_pago";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String CONDETALLE= "con_detalle";
    public static final String CONCUOTAS= "con_cuotas";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOGRUPOFORMAPAGO= "T. Forma Pago";
		public static final String LABEL_IDTIPOGRUPOFORMAPAGO_LOWER= "Tipo Grupo Forma Pago";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_CONDETALLE= "Con Detalle";
		public static final String LABEL_CONDETALLE_LOWER= "Con Detalle";
    	public static final String LABEL_CONCUOTAS= "Con Cuotas";
		public static final String LABEL_CONCUOTAS_LOWER= "Con Cuotas";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDMODULO)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.SIGLAS)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.CONDETALLE)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_CONDETALLE;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.CONCUOTAS)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_CONCUOTAS;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TipoFormaPagoConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoFormaPagoConstantesFunciones.LABEL_DESCRIPCION;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getcon_detalleDescripcion(TipoFormaPago tipoformapago) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipoformapago.getcon_detalle()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalleHtmlDescripcion(TipoFormaPago tipoformapago) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipoformapago.getId(),tipoformapago.getcon_detalle());

		return sDescripcion;
	}	
		
	public static String getcon_cuotasDescripcion(TipoFormaPago tipoformapago) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipoformapago.getcon_cuotas()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuotasHtmlDescripcion(TipoFormaPago tipoformapago) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipoformapago.getId(),tipoformapago.getcon_cuotas());

		return sDescripcion;
	}	
			
			
			
			
	
	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoformapago !=null/* && tipoformapago.getId()!=0*/) {
			sDescripcion=tipoformapago.getnombre();//tipoformapagotipoformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFormaPagoDescripcionDetallado(TipoFormaPago tipoformapago) {
		String sDescripcion="";
			
		sDescripcion+=TipoFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=tipoformapago.getId().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoformapago.getVersionRow().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoformapago.getid_empresa().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tipoformapago.getid_sucursal().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipoformapago.getid_modulo().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO+"=";
		sDescripcion+=tipoformapago.getid_tipo_grupo_forma_pago().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoformapago.getnombre()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.SIGLAS+"=";
		sDescripcion+=tipoformapago.getsiglas()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.CONDETALLE+"=";
		sDescripcion+=tipoformapago.getcon_detalle().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.CONCUOTAS+"=";
		sDescripcion+=tipoformapago.getcon_cuotas().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=tipoformapago.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=tipoformapago.getid_transaccion().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=tipoformapago.getid_cuenta_contable().toString()+",";
		sDescripcion+=TipoFormaPagoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoformapago.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFormaPagoDescripcion(TipoFormaPago tipoformapago,String sValor) throws Exception {			
		if(tipoformapago !=null) {
			tipoformapago.setnombre(sValor);//tipoformapagotipoformapago.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoGrupoFormaPagoDescripcion(TipoGrupoFormaPago tipogrupoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogrupoformapago!=null/*&&tipogrupoformapago.getId()>0*/) {
			sDescripcion=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(tipogrupoformapago);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFormaPago")) {
			sNombreIndice="Tipo=  Por T. Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFormaPago(Long id_tipo_grupo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De T. Forma Pago="+id_tipo_grupo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoFormaPago(TipoFormaPago tipoformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoformapago.setnombre(tipoformapago.getnombre().trim());
		tipoformapago.setsiglas(tipoformapago.getsiglas().trim());
		tipoformapago.setdescripcion(tipoformapago.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoFormaPagos(List<TipoFormaPago> tipoformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFormaPago tipoformapago: tipoformapagos) {
			tipoformapago.setnombre(tipoformapago.getnombre().trim());
			tipoformapago.setsiglas(tipoformapago.getsiglas().trim());
			tipoformapago.setdescripcion(tipoformapago.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormaPago(TipoFormaPago tipoformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoformapago.getConCambioAuxiliar()) {
			tipoformapago.setIsDeleted(tipoformapago.getIsDeletedAuxiliar());	
			tipoformapago.setIsNew(tipoformapago.getIsNewAuxiliar());	
			tipoformapago.setIsChanged(tipoformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoformapago.setIsDeletedAuxiliar(false);	
			tipoformapago.setIsNewAuxiliar(false);	
			tipoformapago.setIsChangedAuxiliar(false);
			
			tipoformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormaPagos(List<TipoFormaPago> tipoformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFormaPago tipoformapago : tipoformapagos) {
			if(conAsignarBase && tipoformapago.getConCambioAuxiliar()) {
				tipoformapago.setIsDeleted(tipoformapago.getIsDeletedAuxiliar());	
				tipoformapago.setIsNew(tipoformapago.getIsNewAuxiliar());	
				tipoformapago.setIsChanged(tipoformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoformapago.setIsDeletedAuxiliar(false);	
				tipoformapago.setIsNewAuxiliar(false);	
				tipoformapago.setIsChangedAuxiliar(false);
				
				tipoformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFormaPago(TipoFormaPago tipoformapago,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFormaPagos(List<TipoFormaPago> tipoformapagos,Boolean conEnteros) throws Exception  {
		
		for(TipoFormaPago tipoformapago: tipoformapagos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFormaPago(List<TipoFormaPago> tipoformapagos,TipoFormaPago tipoformapagoAux) throws Exception  {
		TipoFormaPagoConstantesFunciones.InicializarValoresTipoFormaPago(tipoformapagoAux,true);
		
		for(TipoFormaPago tipoformapago: tipoformapagos) {
			if(tipoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFormaPagoConstantesFunciones.getArrayColumnasGlobalesTipoFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFormaPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFormaPagoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFormaPagoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFormaPago> tipoformapagos,TipoFormaPago tipoformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFormaPago tipoformapagoAux: tipoformapagos) {
			if(tipoformapagoAux!=null && tipoformapago!=null) {
				if((tipoformapagoAux.getId()==null && tipoformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoformapagoAux.getId()!=null && tipoformapago.getId()!=null){
					if(tipoformapagoAux.getId().equals(tipoformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFormaPago(List<TipoFormaPago> tipoformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFormaPago tipoformapago: tipoformapagos) {			
			if(tipoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_ID, TipoFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_VERSIONROW, TipoFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDEMPRESA, TipoFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL, TipoFormaPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDMODULO, TipoFormaPagoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO, TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_NOMBRE, TipoFormaPagoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_SIGLAS, TipoFormaPagoConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_CONDETALLE, TipoFormaPagoConstantesFunciones.CONDETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_CONCUOTAS, TipoFormaPagoConstantesFunciones.CONCUOTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDTRANSACCION, TipoFormaPagoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE, TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoConstantesFunciones.LABEL_DESCRIPCION, TipoFormaPagoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.CONDETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.CONCUOTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPago() throws Exception  {
		return TipoFormaPagoConstantesFunciones.getTiposSeleccionarTipoFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPago(Boolean conFk) throws Exception  {
		return TipoFormaPagoConstantesFunciones.getTiposSeleccionarTipoFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_CONDETALLE);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_CONDETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_CONCUOTAS);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_CONCUOTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoFormaPagoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormaPago(TipoFormaPago tipoformapagoAux) throws Exception {
		
			tipoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformapagoAux.getEmpresa()));
			tipoformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipoformapagoAux.getSucursal()));
			tipoformapagoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipoformapagoAux.getModulo()));
			tipoformapagoAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(tipoformapagoAux.getTipoGrupoFormaPago()));
			tipoformapagoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipoformapagoAux.getTipoTransaccionModulo()));
			tipoformapagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(tipoformapagoAux.getTransaccion()));
			tipoformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipoformapagoAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormaPago(List<TipoFormaPago> tipoformapagosTemp) throws Exception {
		for(TipoFormaPago tipoformapagoAux:tipoformapagosTemp) {
			
			tipoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformapagoAux.getEmpresa()));
			tipoformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tipoformapagoAux.getSucursal()));
			tipoformapagoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipoformapagoAux.getModulo()));
			tipoformapagoAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(tipoformapagoAux.getTipoGrupoFormaPago()));
			tipoformapagoAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipoformapagoAux.getTipoTransaccionModulo()));
			tipoformapagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(tipoformapagoAux.getTransaccion()));
			tipoformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tipoformapagoAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoGrupoFormaPago.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFormaPago.class)) {
						classes.add(new Classe(TipoGrupoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(RegistroFormaPagoBanco.class));
				classes.add(new Classe(DetaFormaPagoFactu.class));
				classes.add(new Classe(GrupoClienteFormaPago.class));
				classes.add(new Classe(DetaFormaPago.class));
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				classes.add(new Classe(ChequePostFechado.class));
				classes.add(new Classe(FormaPago.class));
				classes.add(new Classe(FormaPagoInven.class));
				classes.add(new Classe(DetallePago.class));
				classes.add(new Classe(CierreCaja.class));
				classes.add(new Classe(HistorialFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(RegistroFormaPagoBanco.class)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPagoFactu.class)) {
						classes.add(new Classe(DetaFormaPagoFactu.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoClienteFormaPago.class)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPago.class)) {
						classes.add(new Classe(DetaFormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ChequePostFechado.class)) {
						classes.add(new Classe(ChequePostFechado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPago.class)) {
						classes.add(new Classe(FormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoInven.class)) {
						classes.add(new Classe(FormaPagoInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePago.class)) {
						classes.add(new Classe(DetallePago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CierreCaja.class)) {
						classes.add(new Classe(CierreCaja.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(HistorialFormaPago.class)) {
						classes.add(new Classe(HistorialFormaPago.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(RegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); continue;
					}

					if(DetaFormaPagoFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPagoFactu.class)); continue;
					}

					if(GrupoClienteFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); continue;
					}

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(ChequePostFechado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ChequePostFechado.class)); continue;
					}

					if(FormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPago.class)); continue;
					}

					if(FormaPagoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoInven.class)); continue;
					}

					if(DetallePago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePago.class)); continue;
					}

					if(CierreCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreCaja.class)); continue;
					}

					if(HistorialFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(RegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RegistroFormaPagoBanco.class)); continue;
					}

					if(DetaFormaPagoFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPagoFactu.class)); continue;
					}

					if(GrupoClienteFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoClienteFormaPago.class)); continue;
					}

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}

					if(ChequePostFechado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ChequePostFechado.class)); continue;
					}

					if(FormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPago.class)); continue;
					}

					if(FormaPagoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoInven.class)); continue;
					}

					if(DetallePago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePago.class)); continue;
					}

					if(CierreCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CierreCaja.class)); continue;
					}

					if(HistorialFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(HistorialFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoFormaPago tipoformapago,List<TipoFormaPago> tipoformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFormaPago tipoformapagoEncontrado=null;
			
			for(TipoFormaPago tipoformapagoLocal:tipoformapagos) {
				if(tipoformapagoLocal.getId().equals(tipoformapago.getId())) {
					tipoformapagoEncontrado=tipoformapagoLocal;
					
					tipoformapagoLocal.setIsChanged(tipoformapago.getIsChanged());
					tipoformapagoLocal.setIsNew(tipoformapago.getIsNew());
					tipoformapagoLocal.setIsDeleted(tipoformapago.getIsDeleted());
					
					tipoformapagoLocal.setGeneralEntityOriginal(tipoformapago.getGeneralEntityOriginal());
					
					tipoformapagoLocal.setId(tipoformapago.getId());	
					tipoformapagoLocal.setVersionRow(tipoformapago.getVersionRow());	
					tipoformapagoLocal.setid_empresa(tipoformapago.getid_empresa());	
					tipoformapagoLocal.setid_sucursal(tipoformapago.getid_sucursal());	
					tipoformapagoLocal.setid_modulo(tipoformapago.getid_modulo());	
					tipoformapagoLocal.setid_tipo_grupo_forma_pago(tipoformapago.getid_tipo_grupo_forma_pago());	
					tipoformapagoLocal.setnombre(tipoformapago.getnombre());	
					tipoformapagoLocal.setsiglas(tipoformapago.getsiglas());	
					tipoformapagoLocal.setcon_detalle(tipoformapago.getcon_detalle());	
					tipoformapagoLocal.setcon_cuotas(tipoformapago.getcon_cuotas());	
					tipoformapagoLocal.setid_tipo_transaccion_modulo(tipoformapago.getid_tipo_transaccion_modulo());	
					tipoformapagoLocal.setid_transaccion(tipoformapago.getid_transaccion());	
					tipoformapagoLocal.setid_cuenta_contable(tipoformapago.getid_cuenta_contable());	
					tipoformapagoLocal.setdescripcion(tipoformapago.getdescripcion());	
					
					
					tipoformapagoLocal.setRegistroFormaPagoBancos(tipoformapago.getRegistroFormaPagoBancos());
					tipoformapagoLocal.setDetaFormaPagoFactus(tipoformapago.getDetaFormaPagoFactus());
					tipoformapagoLocal.setGrupoClienteFormaPagos(tipoformapago.getGrupoClienteFormaPagos());
					tipoformapagoLocal.setDetaFormaPagos(tipoformapago.getDetaFormaPagos());
					tipoformapagoLocal.setFormaPagoPuntoVentas(tipoformapago.getFormaPagoPuntoVentas());
					tipoformapagoLocal.setFormaPagos(tipoformapago.getFormaPagos());
					tipoformapagoLocal.setFormaPagoInvens(tipoformapago.getFormaPagoInvens());
					tipoformapagoLocal.setCierreCajas(tipoformapago.getCierreCajas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoformapago.getIsDeleted()) {
				if(!existe) {
					tipoformapagos.add(tipoformapago);
				}
			} else {
				if(tipoformapagoEncontrado!=null && permiteQuitar)  {
					tipoformapagos.remove(tipoformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFormaPago tipoformapago,List<TipoFormaPago> tipoformapagos) throws Exception {
		try	{			
			for(TipoFormaPago tipoformapagoLocal:tipoformapagos) {
				if(tipoformapagoLocal.getId().equals(tipoformapago.getId())) {
					tipoformapagoLocal.setIsSelected(tipoformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFormaPago(List<TipoFormaPago> tipoformapagosAux) throws Exception {
		//this.tipoformapagosAux=tipoformapagosAux;
		
		for(TipoFormaPago tipoformapagoAux:tipoformapagosAux) {
			if(tipoformapagoAux.getIsChanged()) {
				tipoformapagoAux.setIsChanged(false);
			}		
			
			if(tipoformapagoAux.getIsNew()) {
				tipoformapagoAux.setIsNew(false);
			}	
			
			if(tipoformapagoAux.getIsDeleted()) {
				tipoformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFormaPago(TipoFormaPago tipoformapagoAux) throws Exception {
		//this.tipoformapagoAux=tipoformapagoAux;
		
			if(tipoformapagoAux.getIsChanged()) {
				tipoformapagoAux.setIsChanged(false);
			}		
			
			if(tipoformapagoAux.getIsNew()) {
				tipoformapagoAux.setIsNew(false);
			}	
			
			if(tipoformapagoAux.getIsDeleted()) {
				tipoformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFormaPago tipoformapagoAsignar,TipoFormaPago tipoformapago) throws Exception {
		tipoformapagoAsignar.setId(tipoformapago.getId());	
		tipoformapagoAsignar.setVersionRow(tipoformapago.getVersionRow());	
		tipoformapagoAsignar.setid_empresa(tipoformapago.getid_empresa());
		tipoformapagoAsignar.setempresa_descripcion(tipoformapago.getempresa_descripcion());	
		tipoformapagoAsignar.setid_sucursal(tipoformapago.getid_sucursal());
		tipoformapagoAsignar.setsucursal_descripcion(tipoformapago.getsucursal_descripcion());	
		tipoformapagoAsignar.setid_modulo(tipoformapago.getid_modulo());
		tipoformapagoAsignar.setmodulo_descripcion(tipoformapago.getmodulo_descripcion());	
		tipoformapagoAsignar.setid_tipo_grupo_forma_pago(tipoformapago.getid_tipo_grupo_forma_pago());
		tipoformapagoAsignar.settipogrupoformapago_descripcion(tipoformapago.gettipogrupoformapago_descripcion());	
		tipoformapagoAsignar.setnombre(tipoformapago.getnombre());	
		tipoformapagoAsignar.setsiglas(tipoformapago.getsiglas());	
		tipoformapagoAsignar.setcon_detalle(tipoformapago.getcon_detalle());	
		tipoformapagoAsignar.setcon_cuotas(tipoformapago.getcon_cuotas());	
		tipoformapagoAsignar.setid_tipo_transaccion_modulo(tipoformapago.getid_tipo_transaccion_modulo());
		tipoformapagoAsignar.settipotransaccionmodulo_descripcion(tipoformapago.gettipotransaccionmodulo_descripcion());	
		tipoformapagoAsignar.setid_transaccion(tipoformapago.getid_transaccion());
		tipoformapagoAsignar.settransaccion_descripcion(tipoformapago.gettransaccion_descripcion());	
		tipoformapagoAsignar.setid_cuenta_contable(tipoformapago.getid_cuenta_contable());
		tipoformapagoAsignar.setcuentacontable_descripcion(tipoformapago.getcuentacontable_descripcion());	
		tipoformapagoAsignar.setdescripcion(tipoformapago.getdescripcion());	
	}
	
	public static void inicializarTipoFormaPago(TipoFormaPago tipoformapago) throws Exception {
		try {
				tipoformapago.setId(0L);	
					
				tipoformapago.setid_empresa(-1L);	
				tipoformapago.setid_sucursal(-1L);	
				tipoformapago.setid_modulo(null);	
				tipoformapago.setid_tipo_grupo_forma_pago(-1L);	
				tipoformapago.setnombre("");	
				tipoformapago.setsiglas("");	
				tipoformapago.setcon_detalle(false);	
				tipoformapago.setcon_cuotas(false);	
				tipoformapago.setid_tipo_transaccion_modulo(null);	
				tipoformapago.setid_transaccion(null);	
				tipoformapago.setid_cuenta_contable(null);	
				tipoformapago.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_CONDETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_CONCUOTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFormaPago(String sTipo,Row row,Workbook workbook,TipoFormaPago tipoformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.gettipogrupoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipoformapago.getcon_detalle()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipoformapago.getcon_cuotas()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapago.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFormaPago() {
		return this.sFinalQueryTipoFormaPago;
	}
	
	public void setsFinalQueryTipoFormaPago(String sFinalQueryTipoFormaPago) {
		this.sFinalQueryTipoFormaPago= sFinalQueryTipoFormaPago;
	}
	
	public Border resaltarSeleccionarTipoFormaPago=null;
	
	public Border setResaltarSeleccionarTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFormaPago() {
		return this.resaltarSeleccionarTipoFormaPago;
	}
	
	public void setResaltarSeleccionarTipoFormaPago(Border borderResaltarSeleccionarTipoFormaPago) {
		this.resaltarSeleccionarTipoFormaPago= borderResaltarSeleccionarTipoFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFormaPago=null;
	public Boolean mostraridTipoFormaPago=true;
	public Boolean activaridTipoFormaPago=true;

	public Border resaltarid_empresaTipoFormaPago=null;
	public Boolean mostrarid_empresaTipoFormaPago=true;
	public Boolean activarid_empresaTipoFormaPago=true;
	public Boolean cargarid_empresaTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalTipoFormaPago=null;
	public Boolean mostrarid_sucursalTipoFormaPago=true;
	public Boolean activarid_sucursalTipoFormaPago=true;
	public Boolean cargarid_sucursalTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTipoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_moduloTipoFormaPago=null;
	public Boolean mostrarid_moduloTipoFormaPago=true;
	public Boolean activarid_moduloTipoFormaPago=true;
	public Boolean cargarid_moduloTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_grupo_forma_pagoTipoFormaPago=null;
	public Boolean mostrarid_tipo_grupo_forma_pagoTipoFormaPago=true;
	public Boolean activarid_tipo_grupo_forma_pagoTipoFormaPago=true;
	public Boolean cargarid_tipo_grupo_forma_pagoTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_forma_pagoTipoFormaPago=false;//ConEventDepend=true

	public Border resaltarnombreTipoFormaPago=null;
	public Boolean mostrarnombreTipoFormaPago=true;
	public Boolean activarnombreTipoFormaPago=true;

	public Border resaltarsiglasTipoFormaPago=null;
	public Boolean mostrarsiglasTipoFormaPago=true;
	public Boolean activarsiglasTipoFormaPago=true;

	public Border resaltarcon_detalleTipoFormaPago=null;
	public Boolean mostrarcon_detalleTipoFormaPago=true;
	public Boolean activarcon_detalleTipoFormaPago=true;

	public Border resaltarcon_cuotasTipoFormaPago=null;
	public Boolean mostrarcon_cuotasTipoFormaPago=true;
	public Boolean activarcon_cuotasTipoFormaPago=true;

	public Border resaltarid_tipo_transaccion_moduloTipoFormaPago=null;
	public Boolean mostrarid_tipo_transaccion_moduloTipoFormaPago=true;
	public Boolean activarid_tipo_transaccion_moduloTipoFormaPago=false;
	public Boolean cargarid_tipo_transaccion_moduloTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloTipoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_transaccionTipoFormaPago=null;
	public Boolean mostrarid_transaccionTipoFormaPago=true;
	public Boolean activarid_transaccionTipoFormaPago=true;
	public Boolean cargarid_transaccionTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionTipoFormaPago=true;//ConEventDepend=true

	public Border resaltarid_cuenta_contableTipoFormaPago=null;
	public Boolean mostrarid_cuenta_contableTipoFormaPago=true;
	public Boolean activarid_cuenta_contableTipoFormaPago=true;
	public Boolean cargarid_cuenta_contableTipoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTipoFormaPago=false;//ConEventDepend=true

	public Border resaltardescripcionTipoFormaPago=null;
	public Boolean mostrardescripcionTipoFormaPago=true;
	public Boolean activardescripcionTipoFormaPago=true;

	
	

	public Border setResaltaridTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltaridTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFormaPago() {
		return this.resaltaridTipoFormaPago;
	}

	public void setResaltaridTipoFormaPago(Border borderResaltar) {
		this.resaltaridTipoFormaPago= borderResaltar;
	}

	public Boolean getMostraridTipoFormaPago() {
		return this.mostraridTipoFormaPago;
	}

	public void setMostraridTipoFormaPago(Boolean mostraridTipoFormaPago) {
		this.mostraridTipoFormaPago= mostraridTipoFormaPago;
	}

	public Boolean getActivaridTipoFormaPago() {
		return this.activaridTipoFormaPago;
	}

	public void setActivaridTipoFormaPago(Boolean activaridTipoFormaPago) {
		this.activaridTipoFormaPago= activaridTipoFormaPago;
	}

	public Border setResaltarid_empresaTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoFormaPago() {
		return this.resaltarid_empresaTipoFormaPago;
	}

	public void setResaltarid_empresaTipoFormaPago(Border borderResaltar) {
		this.resaltarid_empresaTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoFormaPago() {
		return this.mostrarid_empresaTipoFormaPago;
	}

	public void setMostrarid_empresaTipoFormaPago(Boolean mostrarid_empresaTipoFormaPago) {
		this.mostrarid_empresaTipoFormaPago= mostrarid_empresaTipoFormaPago;
	}

	public Boolean getActivarid_empresaTipoFormaPago() {
		return this.activarid_empresaTipoFormaPago;
	}

	public void setActivarid_empresaTipoFormaPago(Boolean activarid_empresaTipoFormaPago) {
		this.activarid_empresaTipoFormaPago= activarid_empresaTipoFormaPago;
	}

	public Boolean getCargarid_empresaTipoFormaPago() {
		return this.cargarid_empresaTipoFormaPago;
	}

	public void setCargarid_empresaTipoFormaPago(Boolean cargarid_empresaTipoFormaPago) {
		this.cargarid_empresaTipoFormaPago= cargarid_empresaTipoFormaPago;
	}

	public Border setResaltarid_sucursalTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTipoFormaPago() {
		return this.resaltarid_sucursalTipoFormaPago;
	}

	public void setResaltarid_sucursalTipoFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTipoFormaPago() {
		return this.mostrarid_sucursalTipoFormaPago;
	}

	public void setMostrarid_sucursalTipoFormaPago(Boolean mostrarid_sucursalTipoFormaPago) {
		this.mostrarid_sucursalTipoFormaPago= mostrarid_sucursalTipoFormaPago;
	}

	public Boolean getActivarid_sucursalTipoFormaPago() {
		return this.activarid_sucursalTipoFormaPago;
	}

	public void setActivarid_sucursalTipoFormaPago(Boolean activarid_sucursalTipoFormaPago) {
		this.activarid_sucursalTipoFormaPago= activarid_sucursalTipoFormaPago;
	}

	public Boolean getCargarid_sucursalTipoFormaPago() {
		return this.cargarid_sucursalTipoFormaPago;
	}

	public void setCargarid_sucursalTipoFormaPago(Boolean cargarid_sucursalTipoFormaPago) {
		this.cargarid_sucursalTipoFormaPago= cargarid_sucursalTipoFormaPago;
	}

	public Border setResaltarid_moduloTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoFormaPago() {
		return this.resaltarid_moduloTipoFormaPago;
	}

	public void setResaltarid_moduloTipoFormaPago(Border borderResaltar) {
		this.resaltarid_moduloTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoFormaPago() {
		return this.mostrarid_moduloTipoFormaPago;
	}

	public void setMostrarid_moduloTipoFormaPago(Boolean mostrarid_moduloTipoFormaPago) {
		this.mostrarid_moduloTipoFormaPago= mostrarid_moduloTipoFormaPago;
	}

	public Boolean getActivarid_moduloTipoFormaPago() {
		return this.activarid_moduloTipoFormaPago;
	}

	public void setActivarid_moduloTipoFormaPago(Boolean activarid_moduloTipoFormaPago) {
		this.activarid_moduloTipoFormaPago= activarid_moduloTipoFormaPago;
	}

	public Boolean getCargarid_moduloTipoFormaPago() {
		return this.cargarid_moduloTipoFormaPago;
	}

	public void setCargarid_moduloTipoFormaPago(Boolean cargarid_moduloTipoFormaPago) {
		this.cargarid_moduloTipoFormaPago= cargarid_moduloTipoFormaPago;
	}

	public Border setResaltarid_tipo_grupo_forma_pagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_forma_pagoTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_forma_pagoTipoFormaPago() {
		return this.resaltarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public void setResaltarid_tipo_grupo_forma_pagoTipoFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_grupo_forma_pagoTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_forma_pagoTipoFormaPago() {
		return this.mostrarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public void setMostrarid_tipo_grupo_forma_pagoTipoFormaPago(Boolean mostrarid_tipo_grupo_forma_pagoTipoFormaPago) {
		this.mostrarid_tipo_grupo_forma_pagoTipoFormaPago= mostrarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public Boolean getActivarid_tipo_grupo_forma_pagoTipoFormaPago() {
		return this.activarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public void setActivarid_tipo_grupo_forma_pagoTipoFormaPago(Boolean activarid_tipo_grupo_forma_pagoTipoFormaPago) {
		this.activarid_tipo_grupo_forma_pagoTipoFormaPago= activarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public Boolean getCargarid_tipo_grupo_forma_pagoTipoFormaPago() {
		return this.cargarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public void setCargarid_tipo_grupo_forma_pagoTipoFormaPago(Boolean cargarid_tipo_grupo_forma_pagoTipoFormaPago) {
		this.cargarid_tipo_grupo_forma_pagoTipoFormaPago= cargarid_tipo_grupo_forma_pagoTipoFormaPago;
	}

	public Border setResaltarnombreTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFormaPago() {
		return this.resaltarnombreTipoFormaPago;
	}

	public void setResaltarnombreTipoFormaPago(Border borderResaltar) {
		this.resaltarnombreTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFormaPago() {
		return this.mostrarnombreTipoFormaPago;
	}

	public void setMostrarnombreTipoFormaPago(Boolean mostrarnombreTipoFormaPago) {
		this.mostrarnombreTipoFormaPago= mostrarnombreTipoFormaPago;
	}

	public Boolean getActivarnombreTipoFormaPago() {
		return this.activarnombreTipoFormaPago;
	}

	public void setActivarnombreTipoFormaPago(Boolean activarnombreTipoFormaPago) {
		this.activarnombreTipoFormaPago= activarnombreTipoFormaPago;
	}

	public Border setResaltarsiglasTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarsiglasTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasTipoFormaPago() {
		return this.resaltarsiglasTipoFormaPago;
	}

	public void setResaltarsiglasTipoFormaPago(Border borderResaltar) {
		this.resaltarsiglasTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarsiglasTipoFormaPago() {
		return this.mostrarsiglasTipoFormaPago;
	}

	public void setMostrarsiglasTipoFormaPago(Boolean mostrarsiglasTipoFormaPago) {
		this.mostrarsiglasTipoFormaPago= mostrarsiglasTipoFormaPago;
	}

	public Boolean getActivarsiglasTipoFormaPago() {
		return this.activarsiglasTipoFormaPago;
	}

	public void setActivarsiglasTipoFormaPago(Boolean activarsiglasTipoFormaPago) {
		this.activarsiglasTipoFormaPago= activarsiglasTipoFormaPago;
	}

	public Border setResaltarcon_detalleTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarcon_detalleTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalleTipoFormaPago() {
		return this.resaltarcon_detalleTipoFormaPago;
	}

	public void setResaltarcon_detalleTipoFormaPago(Border borderResaltar) {
		this.resaltarcon_detalleTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarcon_detalleTipoFormaPago() {
		return this.mostrarcon_detalleTipoFormaPago;
	}

	public void setMostrarcon_detalleTipoFormaPago(Boolean mostrarcon_detalleTipoFormaPago) {
		this.mostrarcon_detalleTipoFormaPago= mostrarcon_detalleTipoFormaPago;
	}

	public Boolean getActivarcon_detalleTipoFormaPago() {
		return this.activarcon_detalleTipoFormaPago;
	}

	public void setActivarcon_detalleTipoFormaPago(Boolean activarcon_detalleTipoFormaPago) {
		this.activarcon_detalleTipoFormaPago= activarcon_detalleTipoFormaPago;
	}

	public Border setResaltarcon_cuotasTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarcon_cuotasTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuotasTipoFormaPago() {
		return this.resaltarcon_cuotasTipoFormaPago;
	}

	public void setResaltarcon_cuotasTipoFormaPago(Border borderResaltar) {
		this.resaltarcon_cuotasTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarcon_cuotasTipoFormaPago() {
		return this.mostrarcon_cuotasTipoFormaPago;
	}

	public void setMostrarcon_cuotasTipoFormaPago(Boolean mostrarcon_cuotasTipoFormaPago) {
		this.mostrarcon_cuotasTipoFormaPago= mostrarcon_cuotasTipoFormaPago;
	}

	public Boolean getActivarcon_cuotasTipoFormaPago() {
		return this.activarcon_cuotasTipoFormaPago;
	}

	public void setActivarcon_cuotasTipoFormaPago(Boolean activarcon_cuotasTipoFormaPago) {
		this.activarcon_cuotasTipoFormaPago= activarcon_cuotasTipoFormaPago;
	}

	public Border setResaltarid_tipo_transaccion_moduloTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloTipoFormaPago() {
		return this.resaltarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public void setResaltarid_tipo_transaccion_moduloTipoFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloTipoFormaPago() {
		return this.mostrarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public void setMostrarid_tipo_transaccion_moduloTipoFormaPago(Boolean mostrarid_tipo_transaccion_moduloTipoFormaPago) {
		this.mostrarid_tipo_transaccion_moduloTipoFormaPago= mostrarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public Boolean getActivarid_tipo_transaccion_moduloTipoFormaPago() {
		return this.activarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public void setActivarid_tipo_transaccion_moduloTipoFormaPago(Boolean activarid_tipo_transaccion_moduloTipoFormaPago) {
		this.activarid_tipo_transaccion_moduloTipoFormaPago= activarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public Boolean getCargarid_tipo_transaccion_moduloTipoFormaPago() {
		return this.cargarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public void setCargarid_tipo_transaccion_moduloTipoFormaPago(Boolean cargarid_tipo_transaccion_moduloTipoFormaPago) {
		this.cargarid_tipo_transaccion_moduloTipoFormaPago= cargarid_tipo_transaccion_moduloTipoFormaPago;
	}

	public Border setResaltarid_transaccionTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_transaccionTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionTipoFormaPago() {
		return this.resaltarid_transaccionTipoFormaPago;
	}

	public void setResaltarid_transaccionTipoFormaPago(Border borderResaltar) {
		this.resaltarid_transaccionTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_transaccionTipoFormaPago() {
		return this.mostrarid_transaccionTipoFormaPago;
	}

	public void setMostrarid_transaccionTipoFormaPago(Boolean mostrarid_transaccionTipoFormaPago) {
		this.mostrarid_transaccionTipoFormaPago= mostrarid_transaccionTipoFormaPago;
	}

	public Boolean getActivarid_transaccionTipoFormaPago() {
		return this.activarid_transaccionTipoFormaPago;
	}

	public void setActivarid_transaccionTipoFormaPago(Boolean activarid_transaccionTipoFormaPago) {
		this.activarid_transaccionTipoFormaPago= activarid_transaccionTipoFormaPago;
	}

	public Boolean getCargarid_transaccionTipoFormaPago() {
		return this.cargarid_transaccionTipoFormaPago;
	}

	public void setCargarid_transaccionTipoFormaPago(Boolean cargarid_transaccionTipoFormaPago) {
		this.cargarid_transaccionTipoFormaPago= cargarid_transaccionTipoFormaPago;
	}

	public Border setResaltarid_cuenta_contableTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTipoFormaPago() {
		return this.resaltarid_cuenta_contableTipoFormaPago;
	}

	public void setResaltarid_cuenta_contableTipoFormaPago(Border borderResaltar) {
		this.resaltarid_cuenta_contableTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTipoFormaPago() {
		return this.mostrarid_cuenta_contableTipoFormaPago;
	}

	public void setMostrarid_cuenta_contableTipoFormaPago(Boolean mostrarid_cuenta_contableTipoFormaPago) {
		this.mostrarid_cuenta_contableTipoFormaPago= mostrarid_cuenta_contableTipoFormaPago;
	}

	public Boolean getActivarid_cuenta_contableTipoFormaPago() {
		return this.activarid_cuenta_contableTipoFormaPago;
	}

	public void setActivarid_cuenta_contableTipoFormaPago(Boolean activarid_cuenta_contableTipoFormaPago) {
		this.activarid_cuenta_contableTipoFormaPago= activarid_cuenta_contableTipoFormaPago;
	}

	public Boolean getCargarid_cuenta_contableTipoFormaPago() {
		return this.cargarid_cuenta_contableTipoFormaPago;
	}

	public void setCargarid_cuenta_contableTipoFormaPago(Boolean cargarid_cuenta_contableTipoFormaPago) {
		this.cargarid_cuenta_contableTipoFormaPago= cargarid_cuenta_contableTipoFormaPago;
	}

	public Border setResaltardescripcionTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoFormaPago() {
		return this.resaltardescripcionTipoFormaPago;
	}

	public void setResaltardescripcionTipoFormaPago(Border borderResaltar) {
		this.resaltardescripcionTipoFormaPago= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoFormaPago() {
		return this.mostrardescripcionTipoFormaPago;
	}

	public void setMostrardescripcionTipoFormaPago(Boolean mostrardescripcionTipoFormaPago) {
		this.mostrardescripcionTipoFormaPago= mostrardescripcionTipoFormaPago;
	}

	public Boolean getActivardescripcionTipoFormaPago() {
		return this.activardescripcionTipoFormaPago;
	}

	public void setActivardescripcionTipoFormaPago(Boolean activardescripcionTipoFormaPago) {
		this.activardescripcionTipoFormaPago= activardescripcionTipoFormaPago;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridTipoFormaPago(esInicial);
		this.setMostrarid_empresaTipoFormaPago(esInicial);
		this.setMostrarid_sucursalTipoFormaPago(esInicial);
		this.setMostrarid_moduloTipoFormaPago(esInicial);
		this.setMostrarid_tipo_grupo_forma_pagoTipoFormaPago(esInicial);
		this.setMostrarnombreTipoFormaPago(esInicial);
		this.setMostrarsiglasTipoFormaPago(esInicial);
		this.setMostrarcon_detalleTipoFormaPago(esInicial);
		this.setMostrarcon_cuotasTipoFormaPago(esInicial);
		this.setMostrarid_tipo_transaccion_moduloTipoFormaPago(esInicial);
		this.setMostrarid_transaccionTipoFormaPago(esInicial);
		this.setMostrarid_cuenta_contableTipoFormaPago(esInicial);
		this.setMostrardescripcionTipoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.ID)) {
				this.setMostraridTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setMostrarid_tipo_grupo_forma_pagoTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONDETALLE)) {
				this.setMostrarcon_detalleTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONCUOTAS)) {
				this.setMostrarcon_cuotasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridTipoFormaPago(esInicial);
		this.setActivarid_empresaTipoFormaPago(esInicial);
		this.setActivarid_sucursalTipoFormaPago(esInicial);
		this.setActivarid_moduloTipoFormaPago(esInicial);
		this.setActivarid_tipo_grupo_forma_pagoTipoFormaPago(esInicial);
		this.setActivarnombreTipoFormaPago(esInicial);
		this.setActivarsiglasTipoFormaPago(esInicial);
		this.setActivarcon_detalleTipoFormaPago(esInicial);
		this.setActivarcon_cuotasTipoFormaPago(esInicial);
		this.setActivarid_tipo_transaccion_moduloTipoFormaPago(esInicial);
		this.setActivarid_transaccionTipoFormaPago(esInicial);
		this.setActivarid_cuenta_contableTipoFormaPago(esInicial);
		this.setActivardescripcionTipoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.ID)) {
				this.setActivaridTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setActivarid_tipo_grupo_forma_pagoTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONDETALLE)) {
				this.setActivarcon_detalleTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONCUOTAS)) {
				this.setActivarcon_cuotasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFormaPago(esInicial);
		this.setResaltarid_empresaTipoFormaPago(esInicial);
		this.setResaltarid_sucursalTipoFormaPago(esInicial);
		this.setResaltarid_moduloTipoFormaPago(esInicial);
		this.setResaltarid_tipo_grupo_forma_pagoTipoFormaPago(esInicial);
		this.setResaltarnombreTipoFormaPago(esInicial);
		this.setResaltarsiglasTipoFormaPago(esInicial);
		this.setResaltarcon_detalleTipoFormaPago(esInicial);
		this.setResaltarcon_cuotasTipoFormaPago(esInicial);
		this.setResaltarid_tipo_transaccion_moduloTipoFormaPago(esInicial);
		this.setResaltarid_transaccionTipoFormaPago(esInicial);
		this.setResaltarid_cuenta_contableTipoFormaPago(esInicial);
		this.setResaltardescripcionTipoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setResaltarid_tipo_grupo_forma_pagoTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONDETALLE)) {
				this.setResaltarcon_detalleTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.CONCUOTAS)) {
				this.setResaltarcon_cuotasTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTipoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRegistroFormaPagoBancoTipoFormaPago=null;

	public Border getResaltarRegistroFormaPagoBancoTipoFormaPago() {
		return this.resaltarRegistroFormaPagoBancoTipoFormaPago;
	}

	public void setResaltarRegistroFormaPagoBancoTipoFormaPago(Border borderResaltarRegistroFormaPagoBanco) {
		if(borderResaltarRegistroFormaPagoBanco!=null) {
			this.resaltarRegistroFormaPagoBancoTipoFormaPago= borderResaltarRegistroFormaPagoBanco;
		}
	}

	public Border setResaltarRegistroFormaPagoBancoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarRegistroFormaPagoBanco=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarRegistroFormaPagoBanco);
			
		this.resaltarRegistroFormaPagoBancoTipoFormaPago= borderResaltarRegistroFormaPagoBanco;

		 return borderResaltarRegistroFormaPagoBanco;
	}



	public Boolean mostrarRegistroFormaPagoBancoTipoFormaPago=true;

	public Boolean getMostrarRegistroFormaPagoBancoTipoFormaPago() {
		return this.mostrarRegistroFormaPagoBancoTipoFormaPago;
	}

	public void setMostrarRegistroFormaPagoBancoTipoFormaPago(Boolean visibilidadResaltarRegistroFormaPagoBanco) {
		this.mostrarRegistroFormaPagoBancoTipoFormaPago= visibilidadResaltarRegistroFormaPagoBanco;
	}



	public Boolean activarRegistroFormaPagoBancoTipoFormaPago=true;

	public Boolean gethabilitarResaltarRegistroFormaPagoBancoTipoFormaPago() {
		return this.activarRegistroFormaPagoBancoTipoFormaPago;
	}

	public void setActivarRegistroFormaPagoBancoTipoFormaPago(Boolean habilitarResaltarRegistroFormaPagoBanco) {
		this.activarRegistroFormaPagoBancoTipoFormaPago= habilitarResaltarRegistroFormaPagoBanco;
	}


	public Border resaltarDetaFormaPagoFactuTipoFormaPago=null;

	public Border getResaltarDetaFormaPagoFactuTipoFormaPago() {
		return this.resaltarDetaFormaPagoFactuTipoFormaPago;
	}

	public void setResaltarDetaFormaPagoFactuTipoFormaPago(Border borderResaltarDetaFormaPagoFactu) {
		if(borderResaltarDetaFormaPagoFactu!=null) {
			this.resaltarDetaFormaPagoFactuTipoFormaPago= borderResaltarDetaFormaPagoFactu;
		}
	}

	public Border setResaltarDetaFormaPagoFactuTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaFormaPagoFactu=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarDetaFormaPagoFactu);
			
		this.resaltarDetaFormaPagoFactuTipoFormaPago= borderResaltarDetaFormaPagoFactu;

		 return borderResaltarDetaFormaPagoFactu;
	}



	public Boolean mostrarDetaFormaPagoFactuTipoFormaPago=true;

	public Boolean getMostrarDetaFormaPagoFactuTipoFormaPago() {
		return this.mostrarDetaFormaPagoFactuTipoFormaPago;
	}

	public void setMostrarDetaFormaPagoFactuTipoFormaPago(Boolean visibilidadResaltarDetaFormaPagoFactu) {
		this.mostrarDetaFormaPagoFactuTipoFormaPago= visibilidadResaltarDetaFormaPagoFactu;
	}



	public Boolean activarDetaFormaPagoFactuTipoFormaPago=true;

	public Boolean gethabilitarResaltarDetaFormaPagoFactuTipoFormaPago() {
		return this.activarDetaFormaPagoFactuTipoFormaPago;
	}

	public void setActivarDetaFormaPagoFactuTipoFormaPago(Boolean habilitarResaltarDetaFormaPagoFactu) {
		this.activarDetaFormaPagoFactuTipoFormaPago= habilitarResaltarDetaFormaPagoFactu;
	}


	public Border resaltarGrupoClienteFormaPagoTipoFormaPago=null;

	public Border getResaltarGrupoClienteFormaPagoTipoFormaPago() {
		return this.resaltarGrupoClienteFormaPagoTipoFormaPago;
	}

	public void setResaltarGrupoClienteFormaPagoTipoFormaPago(Border borderResaltarGrupoClienteFormaPago) {
		if(borderResaltarGrupoClienteFormaPago!=null) {
			this.resaltarGrupoClienteFormaPagoTipoFormaPago= borderResaltarGrupoClienteFormaPago;
		}
	}

	public Border setResaltarGrupoClienteFormaPagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarGrupoClienteFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarGrupoClienteFormaPago);
			
		this.resaltarGrupoClienteFormaPagoTipoFormaPago= borderResaltarGrupoClienteFormaPago;

		 return borderResaltarGrupoClienteFormaPago;
	}



	public Boolean mostrarGrupoClienteFormaPagoTipoFormaPago=true;

	public Boolean getMostrarGrupoClienteFormaPagoTipoFormaPago() {
		return this.mostrarGrupoClienteFormaPagoTipoFormaPago;
	}

	public void setMostrarGrupoClienteFormaPagoTipoFormaPago(Boolean visibilidadResaltarGrupoClienteFormaPago) {
		this.mostrarGrupoClienteFormaPagoTipoFormaPago= visibilidadResaltarGrupoClienteFormaPago;
	}



	public Boolean activarGrupoClienteFormaPagoTipoFormaPago=true;

	public Boolean gethabilitarResaltarGrupoClienteFormaPagoTipoFormaPago() {
		return this.activarGrupoClienteFormaPagoTipoFormaPago;
	}

	public void setActivarGrupoClienteFormaPagoTipoFormaPago(Boolean habilitarResaltarGrupoClienteFormaPago) {
		this.activarGrupoClienteFormaPagoTipoFormaPago= habilitarResaltarGrupoClienteFormaPago;
	}


	public Border resaltarDetaFormaPagoTipoFormaPago=null;

	public Border getResaltarDetaFormaPagoTipoFormaPago() {
		return this.resaltarDetaFormaPagoTipoFormaPago;
	}

	public void setResaltarDetaFormaPagoTipoFormaPago(Border borderResaltarDetaFormaPago) {
		if(borderResaltarDetaFormaPago!=null) {
			this.resaltarDetaFormaPagoTipoFormaPago= borderResaltarDetaFormaPago;
		}
	}

	public Border setResaltarDetaFormaPagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarDetaFormaPago);
			
		this.resaltarDetaFormaPagoTipoFormaPago= borderResaltarDetaFormaPago;

		 return borderResaltarDetaFormaPago;
	}



	public Boolean mostrarDetaFormaPagoTipoFormaPago=true;

	public Boolean getMostrarDetaFormaPagoTipoFormaPago() {
		return this.mostrarDetaFormaPagoTipoFormaPago;
	}

	public void setMostrarDetaFormaPagoTipoFormaPago(Boolean visibilidadResaltarDetaFormaPago) {
		this.mostrarDetaFormaPagoTipoFormaPago= visibilidadResaltarDetaFormaPago;
	}



	public Boolean activarDetaFormaPagoTipoFormaPago=true;

	public Boolean gethabilitarResaltarDetaFormaPagoTipoFormaPago() {
		return this.activarDetaFormaPagoTipoFormaPago;
	}

	public void setActivarDetaFormaPagoTipoFormaPago(Boolean habilitarResaltarDetaFormaPago) {
		this.activarDetaFormaPagoTipoFormaPago= habilitarResaltarDetaFormaPago;
	}


	public Border resaltarFormaPagoPuntoVentaTipoFormaPago=null;

	public Border getResaltarFormaPagoPuntoVentaTipoFormaPago() {
		return this.resaltarFormaPagoPuntoVentaTipoFormaPago;
	}

	public void setResaltarFormaPagoPuntoVentaTipoFormaPago(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaTipoFormaPago= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaTipoFormaPago= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaTipoFormaPago=true;

	public Boolean getMostrarFormaPagoPuntoVentaTipoFormaPago() {
		return this.mostrarFormaPagoPuntoVentaTipoFormaPago;
	}

	public void setMostrarFormaPagoPuntoVentaTipoFormaPago(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaTipoFormaPago= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaTipoFormaPago=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaTipoFormaPago() {
		return this.activarFormaPagoPuntoVentaTipoFormaPago;
	}

	public void setActivarFormaPagoPuntoVentaTipoFormaPago(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaTipoFormaPago= habilitarResaltarFormaPagoPuntoVenta;
	}


	public Border resaltarFormaPagoTipoFormaPago=null;

	public Border getResaltarFormaPagoTipoFormaPago() {
		return this.resaltarFormaPagoTipoFormaPago;
	}

	public void setResaltarFormaPagoTipoFormaPago(Border borderResaltarFormaPago) {
		if(borderResaltarFormaPago!=null) {
			this.resaltarFormaPagoTipoFormaPago= borderResaltarFormaPago;
		}
	}

	public Border setResaltarFormaPagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarFormaPago);
			
		this.resaltarFormaPagoTipoFormaPago= borderResaltarFormaPago;

		 return borderResaltarFormaPago;
	}



	public Boolean mostrarFormaPagoTipoFormaPago=true;

	public Boolean getMostrarFormaPagoTipoFormaPago() {
		return this.mostrarFormaPagoTipoFormaPago;
	}

	public void setMostrarFormaPagoTipoFormaPago(Boolean visibilidadResaltarFormaPago) {
		this.mostrarFormaPagoTipoFormaPago= visibilidadResaltarFormaPago;
	}



	public Boolean activarFormaPagoTipoFormaPago=true;

	public Boolean gethabilitarResaltarFormaPagoTipoFormaPago() {
		return this.activarFormaPagoTipoFormaPago;
	}

	public void setActivarFormaPagoTipoFormaPago(Boolean habilitarResaltarFormaPago) {
		this.activarFormaPagoTipoFormaPago= habilitarResaltarFormaPago;
	}


	public Border resaltarFormaPagoInvenTipoFormaPago=null;

	public Border getResaltarFormaPagoInvenTipoFormaPago() {
		return this.resaltarFormaPagoInvenTipoFormaPago;
	}

	public void setResaltarFormaPagoInvenTipoFormaPago(Border borderResaltarFormaPagoInven) {
		if(borderResaltarFormaPagoInven!=null) {
			this.resaltarFormaPagoInvenTipoFormaPago= borderResaltarFormaPagoInven;
		}
	}

	public Border setResaltarFormaPagoInvenTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarFormaPagoInven);
			
		this.resaltarFormaPagoInvenTipoFormaPago= borderResaltarFormaPagoInven;

		 return borderResaltarFormaPagoInven;
	}



	public Boolean mostrarFormaPagoInvenTipoFormaPago=true;

	public Boolean getMostrarFormaPagoInvenTipoFormaPago() {
		return this.mostrarFormaPagoInvenTipoFormaPago;
	}

	public void setMostrarFormaPagoInvenTipoFormaPago(Boolean visibilidadResaltarFormaPagoInven) {
		this.mostrarFormaPagoInvenTipoFormaPago= visibilidadResaltarFormaPagoInven;
	}



	public Boolean activarFormaPagoInvenTipoFormaPago=true;

	public Boolean gethabilitarResaltarFormaPagoInvenTipoFormaPago() {
		return this.activarFormaPagoInvenTipoFormaPago;
	}

	public void setActivarFormaPagoInvenTipoFormaPago(Boolean habilitarResaltarFormaPagoInven) {
		this.activarFormaPagoInvenTipoFormaPago= habilitarResaltarFormaPagoInven;
	}


	public Border resaltarCierreCajaTipoFormaPago=null;

	public Border getResaltarCierreCajaTipoFormaPago() {
		return this.resaltarCierreCajaTipoFormaPago;
	}

	public void setResaltarCierreCajaTipoFormaPago(Border borderResaltarCierreCaja) {
		if(borderResaltarCierreCaja!=null) {
			this.resaltarCierreCajaTipoFormaPago= borderResaltarCierreCaja;
		}
	}

	public Border setResaltarCierreCajaTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarCierreCaja=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformapagoBeanSwingJInternalFrame.jTtoolBarTipoFormaPago.setBorder(borderResaltarCierreCaja);
			
		this.resaltarCierreCajaTipoFormaPago= borderResaltarCierreCaja;

		 return borderResaltarCierreCaja;
	}



	public Boolean mostrarCierreCajaTipoFormaPago=true;

	public Boolean getMostrarCierreCajaTipoFormaPago() {
		return this.mostrarCierreCajaTipoFormaPago;
	}

	public void setMostrarCierreCajaTipoFormaPago(Boolean visibilidadResaltarCierreCaja) {
		this.mostrarCierreCajaTipoFormaPago= visibilidadResaltarCierreCaja;
	}



	public Boolean activarCierreCajaTipoFormaPago=true;

	public Boolean gethabilitarResaltarCierreCajaTipoFormaPago() {
		return this.activarCierreCajaTipoFormaPago;
	}

	public void setActivarCierreCajaTipoFormaPago(Boolean habilitarResaltarCierreCaja) {
		this.activarCierreCajaTipoFormaPago= habilitarResaltarCierreCaja;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarRegistroFormaPagoBancoTipoFormaPago(esInicial);
		this.setMostrarDetaFormaPagoFactuTipoFormaPago(esInicial);
		this.setMostrarGrupoClienteFormaPagoTipoFormaPago(esInicial);
		this.setMostrarDetaFormaPagoTipoFormaPago(esInicial);
		this.setMostrarFormaPagoPuntoVentaTipoFormaPago(esInicial);
		this.setMostrarFormaPagoTipoFormaPago(esInicial);
		this.setMostrarFormaPagoInvenTipoFormaPago(esInicial);
		this.setMostrarCierreCajaTipoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setMostrarRegistroFormaPagoBancoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPagoFactu.class)) {
				this.setMostrarDetaFormaPagoFactuTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setMostrarGrupoClienteFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setMostrarDetaFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPago.class)) {
				this.setMostrarFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setMostrarFormaPagoInvenTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setMostrarCierreCajaTipoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarRegistroFormaPagoBancoTipoFormaPago(esInicial);
		this.setActivarDetaFormaPagoFactuTipoFormaPago(esInicial);
		this.setActivarGrupoClienteFormaPagoTipoFormaPago(esInicial);
		this.setActivarDetaFormaPagoTipoFormaPago(esInicial);
		this.setActivarFormaPagoPuntoVentaTipoFormaPago(esInicial);
		this.setActivarFormaPagoTipoFormaPago(esInicial);
		this.setActivarFormaPagoInvenTipoFormaPago(esInicial);
		this.setActivarCierreCajaTipoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setActivarRegistroFormaPagoBancoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPagoFactu.class)) {
				this.setActivarDetaFormaPagoFactuTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setActivarGrupoClienteFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setActivarDetaFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPago.class)) {
				this.setActivarFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setActivarFormaPagoInvenTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setActivarCierreCajaTipoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRegistroFormaPagoBancoTipoFormaPago(esInicial);
		this.setResaltarDetaFormaPagoFactuTipoFormaPago(esInicial);
		this.setResaltarGrupoClienteFormaPagoTipoFormaPago(esInicial);
		this.setResaltarDetaFormaPagoTipoFormaPago(esInicial);
		this.setResaltarFormaPagoPuntoVentaTipoFormaPago(esInicial);
		this.setResaltarFormaPagoTipoFormaPago(esInicial);
		this.setResaltarFormaPagoInvenTipoFormaPago(esInicial);
		this.setResaltarCierreCajaTipoFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(RegistroFormaPagoBanco.class)) {
				this.setResaltarRegistroFormaPagoBancoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPagoFactu.class)) {
				this.setResaltarDetaFormaPagoFactuTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(GrupoClienteFormaPago.class)) {
				this.setResaltarGrupoClienteFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setResaltarDetaFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPago.class)) {
				this.setResaltarFormaPagoTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoInven.class)) {
				this.setResaltarFormaPagoInvenTipoFormaPago(esAsigna);
				continue;
			}

			if(clase.clas.equals(CierreCaja.class)) {
				this.setResaltarCierreCajaTipoFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreTipoFormaPago=true;

	public Boolean getMostrarBusquedaPorNombreTipoFormaPago() {
		return this.mostrarBusquedaPorNombreTipoFormaPago;
	}

	public void setMostrarBusquedaPorNombreTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasTipoFormaPago=true;

	public Boolean getMostrarBusquedaPorSiglasTipoFormaPago() {
		return this.mostrarBusquedaPorSiglasTipoFormaPago;
	}

	public void setMostrarBusquedaPorSiglasTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaTipoFormaPago() {
		return this.mostrarFK_IdEmpresaTipoFormaPago;
	}

	public void setMostrarFK_IdEmpresaTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTipoFormaPago=true;

	public Boolean getMostrarFK_IdModuloTipoFormaPago() {
		return this.mostrarFK_IdModuloTipoFormaPago;
	}

	public void setMostrarFK_IdModuloTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTipoFormaPago=true;

	public Boolean getMostrarFK_IdSucursalTipoFormaPago() {
		return this.mostrarFK_IdSucursalTipoFormaPago;
	}

	public void setMostrarFK_IdSucursalTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoTipoFormaPago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoTipoFormaPago() {
		return this.mostrarFK_IdTipoFormaPagoTipoFormaPago;
	}

	public void setMostrarFK_IdTipoFormaPagoTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoFormaPagoTipoFormaPago=true;

	public Boolean getMostrarFK_IdTipoGrupoFormaPagoTipoFormaPago() {
		return this.mostrarFK_IdTipoGrupoFormaPagoTipoFormaPago;
	}

	public void setMostrarFK_IdTipoGrupoFormaPagoTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoFormaPagoTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloTipoFormaPago=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloTipoFormaPago() {
		return this.mostrarFK_IdTipoTransaccionModuloTipoFormaPago;
	}

	public void setMostrarFK_IdTipoTransaccionModuloTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloTipoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionTipoFormaPago=true;

	public Boolean getMostrarFK_IdTransaccionTipoFormaPago() {
		return this.mostrarFK_IdTransaccionTipoFormaPago;
	}

	public void setMostrarFK_IdTransaccionTipoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionTipoFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTipoFormaPago=true;

	public Boolean getActivarBusquedaPorNombreTipoFormaPago() {
		return this.activarBusquedaPorNombreTipoFormaPago;
	}

	public void setActivarBusquedaPorNombreTipoFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasTipoFormaPago=true;

	public Boolean getActivarBusquedaPorSiglasTipoFormaPago() {
		return this.activarBusquedaPorSiglasTipoFormaPago;
	}

	public void setActivarBusquedaPorSiglasTipoFormaPago(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoFormaPago=true;

	public Boolean getActivarFK_IdEmpresaTipoFormaPago() {
		return this.activarFK_IdEmpresaTipoFormaPago;
	}

	public void setActivarFK_IdEmpresaTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTipoFormaPago=true;

	public Boolean getActivarFK_IdModuloTipoFormaPago() {
		return this.activarFK_IdModuloTipoFormaPago;
	}

	public void setActivarFK_IdModuloTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTipoFormaPago=true;

	public Boolean getActivarFK_IdSucursalTipoFormaPago() {
		return this.activarFK_IdSucursalTipoFormaPago;
	}

	public void setActivarFK_IdSucursalTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoTipoFormaPago=true;

	public Boolean getActivarFK_IdTipoFormaPagoTipoFormaPago() {
		return this.activarFK_IdTipoFormaPagoTipoFormaPago;
	}

	public void setActivarFK_IdTipoFormaPagoTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoFormaPagoTipoFormaPago=true;

	public Boolean getActivarFK_IdTipoGrupoFormaPagoTipoFormaPago() {
		return this.activarFK_IdTipoGrupoFormaPagoTipoFormaPago;
	}

	public void setActivarFK_IdTipoGrupoFormaPagoTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoFormaPagoTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloTipoFormaPago=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloTipoFormaPago() {
		return this.activarFK_IdTipoTransaccionModuloTipoFormaPago;
	}

	public void setActivarFK_IdTipoTransaccionModuloTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloTipoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionTipoFormaPago=true;

	public Boolean getActivarFK_IdTransaccionTipoFormaPago() {
		return this.activarFK_IdTransaccionTipoFormaPago;
	}

	public void setActivarFK_IdTransaccionTipoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionTipoFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTipoFormaPago=null;

	public Border getResaltarBusquedaPorNombreTipoFormaPago() {
		return this.resaltarBusquedaPorNombreTipoFormaPago;
	}

	public void setResaltarBusquedaPorNombreTipoFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoFormaPago= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasTipoFormaPago=null;

	public Border getResaltarBusquedaPorSiglasTipoFormaPago() {
		return this.resaltarBusquedaPorSiglasTipoFormaPago;
	}

	public void setResaltarBusquedaPorSiglasTipoFormaPago(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasTipoFormaPago= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoFormaPago=null;

	public Border getResaltarFK_IdEmpresaTipoFormaPago() {
		return this.resaltarFK_IdEmpresaTipoFormaPago;
	}

	public void setResaltarFK_IdEmpresaTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdModuloTipoFormaPago=null;

	public Border getResaltarFK_IdModuloTipoFormaPago() {
		return this.resaltarFK_IdModuloTipoFormaPago;
	}

	public void setResaltarFK_IdModuloTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTipoFormaPago=null;

	public Border getResaltarFK_IdSucursalTipoFormaPago() {
		return this.resaltarFK_IdSucursalTipoFormaPago;
	}

	public void setResaltarFK_IdSucursalTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoTipoFormaPago=null;

	public Border getResaltarFK_IdTipoFormaPagoTipoFormaPago() {
		return this.resaltarFK_IdTipoFormaPagoTipoFormaPago;
	}

	public void setResaltarFK_IdTipoFormaPagoTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoFormaPagoTipoFormaPago=null;

	public Border getResaltarFK_IdTipoGrupoFormaPagoTipoFormaPago() {
		return this.resaltarFK_IdTipoGrupoFormaPagoTipoFormaPago;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoFormaPagoTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoFormaPagoTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloTipoFormaPago=null;

	public Border getResaltarFK_IdTipoTransaccionModuloTipoFormaPago() {
		return this.resaltarFK_IdTipoTransaccionModuloTipoFormaPago;
	}

	public void setResaltarFK_IdTipoTransaccionModuloTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloTipoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionTipoFormaPago=null;

	public Border getResaltarFK_IdTransaccionTipoFormaPago() {
		return this.resaltarFK_IdTransaccionTipoFormaPago;
	}

	public void setResaltarFK_IdTransaccionTipoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTransaccionTipoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionTipoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoBeanSwingJInternalFrame tipoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionTipoFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}