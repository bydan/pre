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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.CuentaContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CuentaContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaContableConstantesFunciones extends CuentaContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaContable"+CuentaContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaContableConstantesFunciones.SCHEMA+"_"+CuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaContableConstantesFunciones.SCHEMA+"_"+CuentaContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaContableConstantesFunciones.SCHEMA+"_"+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaContableConstantesFunciones.SCHEMA+"_"+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Contable";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaContable";
	public static final String OBJECTNAME="cuentacontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="cuenta_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentacontable from "+CuentaContableConstantesFunciones.SPERSISTENCENAME+" cuentacontable";
	public static String QUERYSELECTNATIVE="select "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".version_row,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".codigo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".nombre,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".codigo_extranjero,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".nombre_extranjero,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_nivel_cuenta,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_centro_costo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_modulo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".descripcion,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_movimiento,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_centro_costo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_centro_actividad,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_activo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_relacion,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_para_f52,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_moneda,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_tipo_flujo_efectivo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".orden from "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME;//+" as "+CuentaContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaContableConstantesFuncionesAdditional cuentacontableConstantesFuncionesAdditional=null;
	
	public CuentaContableConstantesFuncionesAdditional getCuentaContableConstantesFuncionesAdditional() {
		return this.cuentacontableConstantesFuncionesAdditional;
	}
	
	public void setCuentaContableConstantesFuncionesAdditional(CuentaContableConstantesFuncionesAdditional cuentacontableConstantesFuncionesAdditional) {
		try {
			this.cuentacontableConstantesFuncionesAdditional=cuentacontableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String CODIGOEXTRANJERO= "codigo_extranjero";
    public static final String NOMBREEXTRANJERO= "nombre_extranjero";
    public static final String IDNIVELCUENTA= "id_nivel_cuenta";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDMODULO= "id_modulo";
    public static final String DESCRIPCION= "descripcion";
    public static final String ESMOVIMIENTO= "es_movimiento";
    public static final String ESCENTROCOSTO= "es_centro_costo";
    public static final String ESCENTROACTIVIDAD= "es_centro_actividad";
    public static final String ESACTIVO= "es_activo";
    public static final String ESRELACION= "es_relacion";
    public static final String ESPARAF52= "es_para_f52";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDTIPOINTERVALO= "id_tipo_intervalo";
    public static final String IDTIPOFLUJOEFECTIVO= "id_tipo_flujo_efectivo";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String ORDEN= "orden";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOEXTRANJERO= "Codigo Extranjero";
		public static final String LABEL_CODIGOEXTRANJERO_LOWER= "Codigo Extranjero";
    	public static final String LABEL_NOMBREEXTRANJERO= "Nombre Extranjero";
		public static final String LABEL_NOMBREEXTRANJERO_LOWER= "Nombre Extranjero";
    	public static final String LABEL_IDNIVELCUENTA= "Nivel Cuenta";
		public static final String LABEL_IDNIVELCUENTA_LOWER= "Nivel Cuenta";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable Padre";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_ESMOVIMIENTO= "Es Movimiento";
		public static final String LABEL_ESMOVIMIENTO_LOWER= "Es Movimiento";
    	public static final String LABEL_ESCENTROCOSTO= "Es Centro Costo";
		public static final String LABEL_ESCENTROCOSTO_LOWER= "Es Centro Costo";
    	public static final String LABEL_ESCENTROACTIVIDAD= "Es Centro Actividad";
		public static final String LABEL_ESCENTROACTIVIDAD_LOWER= "Es Centro Actividad";
    	public static final String LABEL_ESACTIVO= "Es Activo";
		public static final String LABEL_ESACTIVO_LOWER= "Es Activo";
    	public static final String LABEL_ESRELACION= "Es Relacion";
		public static final String LABEL_ESRELACION_LOWER= "Es Relacion";
    	public static final String LABEL_ESPARAF52= "Es Para F52";
		public static final String LABEL_ESPARAF52_LOWER= "Es Para F52";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDTIPOINTERVALO= "Tipo Intervalo";
		public static final String LABEL_IDTIPOINTERVALO_LOWER= "Tipo Intervalo";
    	public static final String LABEL_IDTIPOFLUJOEFECTIVO= "T Flujo Efectivo";
		public static final String LABEL_IDTIPOFLUJOEFECTIVO_LOWER= "Tipo Flujo Efectivo";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta C. Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta C. Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_EXTRANJERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_EXTRANJERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_EXTRANJERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_EXTRANJERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCuentaContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.CODIGO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.NOMBRE)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.CODIGOEXTRANJERO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_CODIGOEXTRANJERO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.NOMBREEXTRANJERO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_NOMBREEXTRANJERO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDNIVELCUENTA)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDNIVELCUENTA;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDMODULO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.DESCRIPCION)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESMOVIMIENTO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESMOVIMIENTO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESCENTROCOSTO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESCENTROCOSTO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESCENTROACTIVIDAD)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESCENTROACTIVIDAD;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESACTIVO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESACTIVO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESRELACION)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESRELACION;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ESPARAF52)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ESPARAF52;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDMONEDA)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDTIPOINTERVALO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDTIPOINTERVALO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDTIPOFLUJOEFECTIVO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(CuentaContableConstantesFunciones.ORDEN)) {sLabelColumna=CuentaContableConstantesFunciones.LABEL_ORDEN;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_movimientoDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_movimiento()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_movimientoHtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_movimiento());

		return sDescripcion;
	}	
		
	public static String getes_centro_costoDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_centro_costo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_centro_costoHtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_centro_costo());

		return sDescripcion;
	}	
		
	public static String getes_centro_actividadDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_centro_actividad()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_centro_actividadHtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_centro_actividad());

		return sDescripcion;
	}	
		
	public static String getes_activoDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_activoHtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_activo());

		return sDescripcion;
	}	
		
	public static String getes_relacionDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_relacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_relacionHtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_relacion());

		return sDescripcion;
	}	
		
	public static String getes_para_f52Descripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentacontable.getes_para_f52()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_f52HtmlDescripcion(CuentaContable cuentacontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentacontable.getId(),cuentacontable.getes_para_f52());

		return sDescripcion;
	}	
			
			
			
			
			
			
	
	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentacontable !=null/* && cuentacontable.getId()!=0*/) {
			sDescripcion=cuentacontable.getcodigo()+"-"+cuentacontable.getnombre();//cuentacontablecuentacontable.getcodigo().trim()+"-"+cuentacontable.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaContableDescripcionDetallado(CuentaContable cuentacontable) {
		String sDescripcion="";
			
		sDescripcion+=CuentaContableConstantesFunciones.ID+"=";
		sDescripcion+=cuentacontable.getId().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentacontable.getVersionRow().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentacontable.getid_empresa().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.CODIGO+"=";
		sDescripcion+=cuentacontable.getcodigo()+",";
		sDescripcion+=CuentaContableConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cuentacontable.getnombre()+",";
		sDescripcion+=CuentaContableConstantesFunciones.CODIGOEXTRANJERO+"=";
		sDescripcion+=cuentacontable.getcodigo_extranjero()+",";
		sDescripcion+=CuentaContableConstantesFunciones.NOMBREEXTRANJERO+"=";
		sDescripcion+=cuentacontable.getnombre_extranjero()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDNIVELCUENTA+"=";
		sDescripcion+=cuentacontable.getid_nivel_cuenta().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentacontable.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=cuentacontable.getid_centro_costo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDMODULO+"=";
		sDescripcion+=cuentacontable.getid_modulo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=cuentacontable.getdescripcion()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESMOVIMIENTO+"=";
		sDescripcion+=cuentacontable.getes_movimiento().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESCENTROCOSTO+"=";
		sDescripcion+=cuentacontable.getes_centro_costo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESCENTROACTIVIDAD+"=";
		sDescripcion+=cuentacontable.getes_centro_actividad().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESACTIVO+"=";
		sDescripcion+=cuentacontable.getes_activo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESRELACION+"=";
		sDescripcion+=cuentacontable.getes_relacion().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ESPARAF52+"=";
		sDescripcion+=cuentacontable.getes_para_f52().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=cuentacontable.getid_moneda().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDTIPOINTERVALO+"=";
		sDescripcion+=cuentacontable.getid_tipo_intervalo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO+"=";
		sDescripcion+=cuentacontable.getid_tipo_flujo_efectivo().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=cuentacontable.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=cuentacontable.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=CuentaContableConstantesFunciones.ORDEN+"=";
		sDescripcion+=cuentacontable.getorden().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaContableDescripcion(CuentaContable cuentacontable,String sValor) throws Exception {			
		if(cuentacontable !=null) {
			cuentacontable.setcodigo(sValor);
cuentacontable.setnombre(sValor);;//cuentacontablecuentacontable.getcodigo().trim()+"-"+cuentacontable.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getNivelCuentaDescripcion(NivelCuenta nivelcuenta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(nivelcuenta!=null/*&&nivelcuenta.getId()>0*/) {
			sDescripcion=NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(nivelcuenta);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getTipoIntervaloDescripcion(TipoIntervalo tipointervalo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipointervalo!=null/*&&tipointervalo.getId()>0*/) {
			sDescripcion=TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(tipointervalo);
		}

		return sDescripcion;
	}

	public static String getTipoFlujoEfectivoDescripcion(TipoFlujoEfectivo tipoflujoefectivo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoflujoefectivo!=null/*&&tipoflujoefectivo.getId()>0*/) {
			sDescripcion=TipoFlujoEfectivoConstantesFunciones.getTipoFlujoEfectivoDescripcion(tipoflujoefectivo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Padre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdNivelCuenta")) {
			sNombreIndice="Tipo=  Por Nivel Cuenta";
		} else if(sNombreIndice.equals("FK_IdTipoFlujoEfectivo")) {
			sNombreIndice="Tipo=  Por T Flujo Efectivo";
		} else if(sNombreIndice.equals("FK_IdTipoIntervalo")) {
			sNombreIndice="Tipo=  Por Tipo Intervalo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Padre="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Debito="+id_cuenta_contable_debito.toString();} 

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

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNivelCuenta(Long id_nivel_cuenta) {
		String sDetalleIndice=" Parametros->";
		if(id_nivel_cuenta!=null) {sDetalleIndice+=" Codigo Unico De Nivel Cuenta="+id_nivel_cuenta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFlujoEfectivo(Long id_tipo_flujo_efectivo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_flujo_efectivo!=null) {sDetalleIndice+=" Codigo Unico De T Flujo Efectivo="+id_tipo_flujo_efectivo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIntervalo(Long id_tipo_intervalo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_intervalo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Intervalo="+id_tipo_intervalo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaContable(CuentaContable cuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentacontable.setcodigo(cuentacontable.getcodigo().trim());
		cuentacontable.setnombre(cuentacontable.getnombre().trim());
		cuentacontable.setcodigo_extranjero(cuentacontable.getcodigo_extranjero().trim());
		cuentacontable.setnombre_extranjero(cuentacontable.getnombre_extranjero().trim());
		cuentacontable.setdescripcion(cuentacontable.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCuentaContables(List<CuentaContable> cuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaContable cuentacontable: cuentacontables) {
			cuentacontable.setcodigo(cuentacontable.getcodigo().trim());
			cuentacontable.setnombre(cuentacontable.getnombre().trim());
			cuentacontable.setcodigo_extranjero(cuentacontable.getcodigo_extranjero().trim());
			cuentacontable.setnombre_extranjero(cuentacontable.getnombre_extranjero().trim());
			cuentacontable.setdescripcion(cuentacontable.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContable(CuentaContable cuentacontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentacontable.getConCambioAuxiliar()) {
			cuentacontable.setIsDeleted(cuentacontable.getIsDeletedAuxiliar());	
			cuentacontable.setIsNew(cuentacontable.getIsNewAuxiliar());	
			cuentacontable.setIsChanged(cuentacontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentacontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentacontable.setIsDeletedAuxiliar(false);	
			cuentacontable.setIsNewAuxiliar(false);	
			cuentacontable.setIsChangedAuxiliar(false);
			
			cuentacontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaContables(List<CuentaContable> cuentacontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaContable cuentacontable : cuentacontables) {
			if(conAsignarBase && cuentacontable.getConCambioAuxiliar()) {
				cuentacontable.setIsDeleted(cuentacontable.getIsDeletedAuxiliar());	
				cuentacontable.setIsNew(cuentacontable.getIsNewAuxiliar());	
				cuentacontable.setIsChanged(cuentacontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentacontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentacontable.setIsDeletedAuxiliar(false);	
				cuentacontable.setIsNewAuxiliar(false);	
				cuentacontable.setIsChangedAuxiliar(false);
				
				cuentacontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaContable(CuentaContable cuentacontable,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			cuentacontable.setorden(0);
		}
	}		
	
	public static void InicializarValoresCuentaContables(List<CuentaContable> cuentacontables,Boolean conEnteros) throws Exception  {
		
		for(CuentaContable cuentacontable: cuentacontables) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				cuentacontable.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaContable(List<CuentaContable> cuentacontables,CuentaContable cuentacontableAux) throws Exception  {
		CuentaContableConstantesFunciones.InicializarValoresCuentaContable(cuentacontableAux,true);
		
		for(CuentaContable cuentacontable: cuentacontables) {
			if(cuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cuentacontableAux.setorden(cuentacontableAux.getorden()+cuentacontable.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaContableConstantesFunciones.getArrayColumnasGlobalesCuentaContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaContableConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaContableConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaContableConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaContableConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CuentaContableConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaContable> cuentacontables,CuentaContable cuentacontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaContable cuentacontableAux: cuentacontables) {
			if(cuentacontableAux!=null && cuentacontable!=null) {
				if((cuentacontableAux.getId()==null && cuentacontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentacontableAux.getId()!=null && cuentacontable.getId()!=null){
					if(cuentacontableAux.getId().equals(cuentacontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaContable(List<CuentaContable> cuentacontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaContable cuentacontable: cuentacontables) {			
			if(cuentacontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ID, CuentaContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_VERSIONROW, CuentaContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDEMPRESA, CuentaContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_CODIGO, CuentaContableConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_NOMBRE, CuentaContableConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_CODIGOEXTRANJERO, CuentaContableConstantesFunciones.CODIGOEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_NOMBREEXTRANJERO, CuentaContableConstantesFunciones.NOMBREEXTRANJERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDNIVELCUENTA, CuentaContableConstantesFunciones.IDNIVELCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaContableConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO, CuentaContableConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDMODULO, CuentaContableConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_DESCRIPCION, CuentaContableConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESMOVIMIENTO, CuentaContableConstantesFunciones.ESMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESCENTROCOSTO, CuentaContableConstantesFunciones.ESCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESCENTROACTIVIDAD, CuentaContableConstantesFunciones.ESCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESACTIVO, CuentaContableConstantesFunciones.ESACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESRELACION, CuentaContableConstantesFunciones.ESRELACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ESPARAF52, CuentaContableConstantesFunciones.ESPARAF52,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDMONEDA, CuentaContableConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDTIPOINTERVALO, CuentaContableConstantesFunciones.IDTIPOINTERVALO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDTIPOFLUJOEFECTIVO, CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaContableConstantesFunciones.LABEL_ORDEN, CuentaContableConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.CODIGOEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.NOMBREEXTRANJERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDNIVELCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESRELACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ESPARAF52;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDTIPOINTERVALO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaContableConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContable() throws Exception  {
		return CuentaContableConstantesFunciones.getTiposSeleccionarCuentaContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContable(Boolean conFk) throws Exception  {
		return CuentaContableConstantesFunciones.getTiposSeleccionarCuentaContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_CODIGOEXTRANJERO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_CODIGOEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_NOMBREEXTRANJERO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_NOMBREEXTRANJERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDNIVELCUENTA);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDNIVELCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESMOVIMIENTO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESCENTROCOSTO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESCENTROACTIVIDAD);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESACTIVO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESRELACION);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESRELACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ESPARAF52);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ESPARAF52);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDTIPOINTERVALO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDTIPOINTERVALO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDTIPOFLUJOEFECTIVO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDTIPOFLUJOEFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaContableConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(CuentaContableConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContable(CuentaContable cuentacontableAux) throws Exception {
		
			cuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacontableAux.getEmpresa()));
			cuentacontableAux.setnivelcuenta_descripcion(NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(cuentacontableAux.getNivelCuenta()));
			cuentacontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContable()));
			cuentacontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(cuentacontableAux.getCentroCosto()));
			cuentacontableAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(cuentacontableAux.getModulo()));
			cuentacontableAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(cuentacontableAux.getMoneda()));
			cuentacontableAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(cuentacontableAux.getTipoIntervalo()));
			cuentacontableAux.settipoflujoefectivo_descripcion(TipoFlujoEfectivoConstantesFunciones.getTipoFlujoEfectivoDescripcion(cuentacontableAux.getTipoFlujoEfectivo()));
			cuentacontableAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContableDebito()));
			cuentacontableAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaContable(List<CuentaContable> cuentacontablesTemp) throws Exception {
		for(CuentaContable cuentacontableAux:cuentacontablesTemp) {
			
			cuentacontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentacontableAux.getEmpresa()));
			cuentacontableAux.setnivelcuenta_descripcion(NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(cuentacontableAux.getNivelCuenta()));
			cuentacontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContable()));
			cuentacontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(cuentacontableAux.getCentroCosto()));
			cuentacontableAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(cuentacontableAux.getModulo()));
			cuentacontableAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(cuentacontableAux.getMoneda()));
			cuentacontableAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(cuentacontableAux.getTipoIntervalo()));
			cuentacontableAux.settipoflujoefectivo_descripcion(TipoFlujoEfectivoConstantesFunciones.getTipoFlujoEfectivoDescripcion(cuentacontableAux.getTipoFlujoEfectivo()));
			cuentacontableAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContableDebito()));
			cuentacontableAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontableAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(NivelCuenta.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoIntervalo.class));
				classes.add(new Classe(TipoFlujoEfectivo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NivelCuenta.class)) {
						classes.add(new Classe(NivelCuenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIntervalo.class)) {
						classes.add(new Classe(TipoIntervalo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFlujoEfectivo.class)) {
						classes.add(new Classe(TipoFlujoEfectivo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(NivelCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelCuenta.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(TipoFlujoEfectivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFlujoEfectivo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(NivelCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NivelCuenta.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(TipoFlujoEfectivo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFlujoEfectivo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContableConstantesFunciones.getClassesRelationshipsOfCuentaContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaContableConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(CuentaContable cuentacontable,List<CuentaContable> cuentacontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaContable cuentacontableEncontrado=null;
			
			for(CuentaContable cuentacontableLocal:cuentacontables) {
				if(cuentacontableLocal.getId().equals(cuentacontable.getId())) {
					cuentacontableEncontrado=cuentacontableLocal;
					
					cuentacontableLocal.setIsChanged(cuentacontable.getIsChanged());
					cuentacontableLocal.setIsNew(cuentacontable.getIsNew());
					cuentacontableLocal.setIsDeleted(cuentacontable.getIsDeleted());
					
					cuentacontableLocal.setGeneralEntityOriginal(cuentacontable.getGeneralEntityOriginal());
					
					cuentacontableLocal.setId(cuentacontable.getId());	
					cuentacontableLocal.setVersionRow(cuentacontable.getVersionRow());	
					cuentacontableLocal.setid_empresa(cuentacontable.getid_empresa());	
					cuentacontableLocal.setcodigo(cuentacontable.getcodigo());	
					cuentacontableLocal.setnombre(cuentacontable.getnombre());	
					cuentacontableLocal.setcodigo_extranjero(cuentacontable.getcodigo_extranjero());	
					cuentacontableLocal.setnombre_extranjero(cuentacontable.getnombre_extranjero());	
					cuentacontableLocal.setid_nivel_cuenta(cuentacontable.getid_nivel_cuenta());	
					cuentacontableLocal.setid_cuenta_contable(cuentacontable.getid_cuenta_contable());	
					cuentacontableLocal.setid_centro_costo(cuentacontable.getid_centro_costo());	
					cuentacontableLocal.setid_modulo(cuentacontable.getid_modulo());	
					cuentacontableLocal.setdescripcion(cuentacontable.getdescripcion());	
					cuentacontableLocal.setes_movimiento(cuentacontable.getes_movimiento());	
					cuentacontableLocal.setes_centro_costo(cuentacontable.getes_centro_costo());	
					cuentacontableLocal.setes_centro_actividad(cuentacontable.getes_centro_actividad());	
					cuentacontableLocal.setes_activo(cuentacontable.getes_activo());	
					cuentacontableLocal.setes_relacion(cuentacontable.getes_relacion());	
					cuentacontableLocal.setes_para_f52(cuentacontable.getes_para_f52());	
					cuentacontableLocal.setid_moneda(cuentacontable.getid_moneda());	
					cuentacontableLocal.setid_tipo_intervalo(cuentacontable.getid_tipo_intervalo());	
					cuentacontableLocal.setid_tipo_flujo_efectivo(cuentacontable.getid_tipo_flujo_efectivo());	
					cuentacontableLocal.setid_cuenta_contable_debito(cuentacontable.getid_cuenta_contable_debito());	
					cuentacontableLocal.setid_cuenta_contable_credito(cuentacontable.getid_cuenta_contable_credito());	
					cuentacontableLocal.setorden(cuentacontable.getorden());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentacontable.getIsDeleted()) {
				if(!existe) {
					cuentacontables.add(cuentacontable);
				}
			} else {
				if(cuentacontableEncontrado!=null && permiteQuitar)  {
					cuentacontables.remove(cuentacontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaContable cuentacontable,List<CuentaContable> cuentacontables) throws Exception {
		try	{			
			for(CuentaContable cuentacontableLocal:cuentacontables) {
				if(cuentacontableLocal.getId().equals(cuentacontable.getId())) {
					cuentacontableLocal.setIsSelected(cuentacontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaContable(List<CuentaContable> cuentacontablesAux) throws Exception {
		//this.cuentacontablesAux=cuentacontablesAux;
		
		for(CuentaContable cuentacontableAux:cuentacontablesAux) {
			if(cuentacontableAux.getIsChanged()) {
				cuentacontableAux.setIsChanged(false);
			}		
			
			if(cuentacontableAux.getIsNew()) {
				cuentacontableAux.setIsNew(false);
			}	
			
			if(cuentacontableAux.getIsDeleted()) {
				cuentacontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaContable(CuentaContable cuentacontableAux) throws Exception {
		//this.cuentacontableAux=cuentacontableAux;
		
			if(cuentacontableAux.getIsChanged()) {
				cuentacontableAux.setIsChanged(false);
			}		
			
			if(cuentacontableAux.getIsNew()) {
				cuentacontableAux.setIsNew(false);
			}	
			
			if(cuentacontableAux.getIsDeleted()) {
				cuentacontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaContable cuentacontableAsignar,CuentaContable cuentacontable) throws Exception {
		cuentacontableAsignar.setId(cuentacontable.getId());	
		cuentacontableAsignar.setVersionRow(cuentacontable.getVersionRow());	
		cuentacontableAsignar.setid_empresa(cuentacontable.getid_empresa());
		cuentacontableAsignar.setempresa_descripcion(cuentacontable.getempresa_descripcion());	
		cuentacontableAsignar.setcodigo(cuentacontable.getcodigo());	
		cuentacontableAsignar.setnombre(cuentacontable.getnombre());	
		cuentacontableAsignar.setcodigo_extranjero(cuentacontable.getcodigo_extranjero());	
		cuentacontableAsignar.setnombre_extranjero(cuentacontable.getnombre_extranjero());	
		cuentacontableAsignar.setid_nivel_cuenta(cuentacontable.getid_nivel_cuenta());
		cuentacontableAsignar.setnivelcuenta_descripcion(cuentacontable.getnivelcuenta_descripcion());	
		cuentacontableAsignar.setid_cuenta_contable(cuentacontable.getid_cuenta_contable());
		cuentacontableAsignar.setcuentacontable_descripcion(cuentacontable.getcuentacontable_descripcion());	
		cuentacontableAsignar.setid_centro_costo(cuentacontable.getid_centro_costo());
		cuentacontableAsignar.setcentrocosto_descripcion(cuentacontable.getcentrocosto_descripcion());	
		cuentacontableAsignar.setid_modulo(cuentacontable.getid_modulo());
		cuentacontableAsignar.setmodulo_descripcion(cuentacontable.getmodulo_descripcion());	
		cuentacontableAsignar.setdescripcion(cuentacontable.getdescripcion());	
		cuentacontableAsignar.setes_movimiento(cuentacontable.getes_movimiento());	
		cuentacontableAsignar.setes_centro_costo(cuentacontable.getes_centro_costo());	
		cuentacontableAsignar.setes_centro_actividad(cuentacontable.getes_centro_actividad());	
		cuentacontableAsignar.setes_activo(cuentacontable.getes_activo());	
		cuentacontableAsignar.setes_relacion(cuentacontable.getes_relacion());	
		cuentacontableAsignar.setes_para_f52(cuentacontable.getes_para_f52());	
		cuentacontableAsignar.setid_moneda(cuentacontable.getid_moneda());
		cuentacontableAsignar.setmoneda_descripcion(cuentacontable.getmoneda_descripcion());	
		cuentacontableAsignar.setid_tipo_intervalo(cuentacontable.getid_tipo_intervalo());
		cuentacontableAsignar.settipointervalo_descripcion(cuentacontable.gettipointervalo_descripcion());	
		cuentacontableAsignar.setid_tipo_flujo_efectivo(cuentacontable.getid_tipo_flujo_efectivo());
		cuentacontableAsignar.settipoflujoefectivo_descripcion(cuentacontable.gettipoflujoefectivo_descripcion());	
		cuentacontableAsignar.setid_cuenta_contable_debito(cuentacontable.getid_cuenta_contable_debito());
		cuentacontableAsignar.setcuentacontabledebito_descripcion(cuentacontable.getcuentacontabledebito_descripcion());	
		cuentacontableAsignar.setid_cuenta_contable_credito(cuentacontable.getid_cuenta_contable_credito());
		cuentacontableAsignar.setcuentacontablecredito_descripcion(cuentacontable.getcuentacontablecredito_descripcion());	
		cuentacontableAsignar.setorden(cuentacontable.getorden());	
	}
	
	public static void inicializarCuentaContable(CuentaContable cuentacontable) throws Exception {
		try {
				cuentacontable.setId(0L);	
					
				cuentacontable.setid_empresa(-1L);	
				cuentacontable.setcodigo("");	
				cuentacontable.setnombre("");	
				cuentacontable.setcodigo_extranjero("");	
				cuentacontable.setnombre_extranjero("");	
				cuentacontable.setid_nivel_cuenta(-1L);	
				cuentacontable.setid_cuenta_contable(null);	
				cuentacontable.setid_centro_costo(null);	
				cuentacontable.setid_modulo(-1L);	
				cuentacontable.setdescripcion("");	
				cuentacontable.setes_movimiento(false);	
				cuentacontable.setes_centro_costo(false);	
				cuentacontable.setes_centro_actividad(false);	
				cuentacontable.setes_activo(false);	
				cuentacontable.setes_relacion(false);	
				cuentacontable.setes_para_f52(false);	
				cuentacontable.setid_moneda(-1L);	
				cuentacontable.setid_tipo_intervalo(-1L);	
				cuentacontable.setid_tipo_flujo_efectivo(null);	
				cuentacontable.setid_cuenta_contable_debito(null);	
				cuentacontable.setid_cuenta_contable_credito(null);	
				cuentacontable.setorden(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_CODIGOEXTRANJERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_NOMBREEXTRANJERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDNIVELCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESRELACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ESPARAF52);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDTIPOINTERVALO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDTIPOFLUJOEFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaContableConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaContable(String sTipo,Row row,Workbook workbook,CuentaContable cuentacontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcodigo_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getnombre_extranjero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getnivelcuenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_movimiento()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_centro_costo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_centro_actividad()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_relacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentacontable.getes_para_f52()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.gettipointervalo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.gettipoflujoefectivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentacontable.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaContable() {
		return this.sFinalQueryCuentaContable;
	}
	
	public void setsFinalQueryCuentaContable(String sFinalQueryCuentaContable) {
		this.sFinalQueryCuentaContable= sFinalQueryCuentaContable;
	}
	
	public Border resaltarSeleccionarCuentaContable=null;
	
	public Border setResaltarSeleccionarCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaContable() {
		return this.resaltarSeleccionarCuentaContable;
	}
	
	public void setResaltarSeleccionarCuentaContable(Border borderResaltarSeleccionarCuentaContable) {
		this.resaltarSeleccionarCuentaContable= borderResaltarSeleccionarCuentaContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaContable=null;
	public Boolean mostraridCuentaContable=true;
	public Boolean activaridCuentaContable=true;

	public Border resaltarid_empresaCuentaContable=null;
	public Boolean mostrarid_empresaCuentaContable=true;
	public Boolean activarid_empresaCuentaContable=true;
	public Boolean cargarid_empresaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaContable=false;//ConEventDepend=true

	public Border resaltarcodigoCuentaContable=null;
	public Boolean mostrarcodigoCuentaContable=true;
	public Boolean activarcodigoCuentaContable=true;

	public Border resaltarnombreCuentaContable=null;
	public Boolean mostrarnombreCuentaContable=true;
	public Boolean activarnombreCuentaContable=true;

	public Border resaltarcodigo_extranjeroCuentaContable=null;
	public Boolean mostrarcodigo_extranjeroCuentaContable=true;
	public Boolean activarcodigo_extranjeroCuentaContable=true;

	public Border resaltarnombre_extranjeroCuentaContable=null;
	public Boolean mostrarnombre_extranjeroCuentaContable=true;
	public Boolean activarnombre_extranjeroCuentaContable=true;

	public Border resaltarid_nivel_cuentaCuentaContable=null;
	public Boolean mostrarid_nivel_cuentaCuentaContable=true;
	public Boolean activarid_nivel_cuentaCuentaContable=true;
	public Boolean cargarid_nivel_cuentaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nivel_cuentaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCuentaContable=null;
	public Boolean mostrarid_cuenta_contableCuentaContable=true;
	public Boolean activarid_cuenta_contableCuentaContable=true;
	public Boolean cargarid_cuenta_contableCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_centro_costoCuentaContable=null;
	public Boolean mostrarid_centro_costoCuentaContable=true;
	public Boolean activarid_centro_costoCuentaContable=true;
	public Boolean cargarid_centro_costoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_moduloCuentaContable=null;
	public Boolean mostrarid_moduloCuentaContable=true;
	public Boolean activarid_moduloCuentaContable=true;
	public Boolean cargarid_moduloCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloCuentaContable=false;//ConEventDepend=true

	public Border resaltardescripcionCuentaContable=null;
	public Boolean mostrardescripcionCuentaContable=true;
	public Boolean activardescripcionCuentaContable=true;

	public Border resaltares_movimientoCuentaContable=null;
	public Boolean mostrares_movimientoCuentaContable=true;
	public Boolean activares_movimientoCuentaContable=true;

	public Border resaltares_centro_costoCuentaContable=null;
	public Boolean mostrares_centro_costoCuentaContable=true;
	public Boolean activares_centro_costoCuentaContable=true;

	public Border resaltares_centro_actividadCuentaContable=null;
	public Boolean mostrares_centro_actividadCuentaContable=true;
	public Boolean activares_centro_actividadCuentaContable=true;

	public Border resaltares_activoCuentaContable=null;
	public Boolean mostrares_activoCuentaContable=true;
	public Boolean activares_activoCuentaContable=true;

	public Border resaltares_relacionCuentaContable=null;
	public Boolean mostrares_relacionCuentaContable=true;
	public Boolean activares_relacionCuentaContable=true;

	public Border resaltares_para_f52CuentaContable=null;
	public Boolean mostrares_para_f52CuentaContable=true;
	public Boolean activares_para_f52CuentaContable=true;

	public Border resaltarid_monedaCuentaContable=null;
	public Boolean mostrarid_monedaCuentaContable=true;
	public Boolean activarid_monedaCuentaContable=true;
	public Boolean cargarid_monedaCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_tipo_intervaloCuentaContable=null;
	public Boolean mostrarid_tipo_intervaloCuentaContable=true;
	public Boolean activarid_tipo_intervaloCuentaContable=true;
	public Boolean cargarid_tipo_intervaloCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_intervaloCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_tipo_flujo_efectivoCuentaContable=null;
	public Boolean mostrarid_tipo_flujo_efectivoCuentaContable=true;
	public Boolean activarid_tipo_flujo_efectivoCuentaContable=true;
	public Boolean cargarid_tipo_flujo_efectivoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_flujo_efectivoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_debitoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_debitoCuentaContable=true;
	public Boolean activarid_cuenta_contable_debitoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_debitoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoCuentaContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoCuentaContable=null;
	public Boolean mostrarid_cuenta_contable_creditoCuentaContable=true;
	public Boolean activarid_cuenta_contable_creditoCuentaContable=true;
	public Boolean cargarid_cuenta_contable_creditoCuentaContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoCuentaContable=false;//ConEventDepend=true

	public Border resaltarordenCuentaContable=null;
	public Boolean mostrarordenCuentaContable=true;
	public Boolean activarordenCuentaContable=true;

	
	

	public Border setResaltaridCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltaridCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaContable() {
		return this.resaltaridCuentaContable;
	}

	public void setResaltaridCuentaContable(Border borderResaltar) {
		this.resaltaridCuentaContable= borderResaltar;
	}

	public Boolean getMostraridCuentaContable() {
		return this.mostraridCuentaContable;
	}

	public void setMostraridCuentaContable(Boolean mostraridCuentaContable) {
		this.mostraridCuentaContable= mostraridCuentaContable;
	}

	public Boolean getActivaridCuentaContable() {
		return this.activaridCuentaContable;
	}

	public void setActivaridCuentaContable(Boolean activaridCuentaContable) {
		this.activaridCuentaContable= activaridCuentaContable;
	}

	public Border setResaltarid_empresaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaContable() {
		return this.resaltarid_empresaCuentaContable;
	}

	public void setResaltarid_empresaCuentaContable(Border borderResaltar) {
		this.resaltarid_empresaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaContable() {
		return this.mostrarid_empresaCuentaContable;
	}

	public void setMostrarid_empresaCuentaContable(Boolean mostrarid_empresaCuentaContable) {
		this.mostrarid_empresaCuentaContable= mostrarid_empresaCuentaContable;
	}

	public Boolean getActivarid_empresaCuentaContable() {
		return this.activarid_empresaCuentaContable;
	}

	public void setActivarid_empresaCuentaContable(Boolean activarid_empresaCuentaContable) {
		this.activarid_empresaCuentaContable= activarid_empresaCuentaContable;
	}

	public Boolean getCargarid_empresaCuentaContable() {
		return this.cargarid_empresaCuentaContable;
	}

	public void setCargarid_empresaCuentaContable(Boolean cargarid_empresaCuentaContable) {
		this.cargarid_empresaCuentaContable= cargarid_empresaCuentaContable;
	}

	public Border setResaltarcodigoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarcodigoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCuentaContable() {
		return this.resaltarcodigoCuentaContable;
	}

	public void setResaltarcodigoCuentaContable(Border borderResaltar) {
		this.resaltarcodigoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarcodigoCuentaContable() {
		return this.mostrarcodigoCuentaContable;
	}

	public void setMostrarcodigoCuentaContable(Boolean mostrarcodigoCuentaContable) {
		this.mostrarcodigoCuentaContable= mostrarcodigoCuentaContable;
	}

	public Boolean getActivarcodigoCuentaContable() {
		return this.activarcodigoCuentaContable;
	}

	public void setActivarcodigoCuentaContable(Boolean activarcodigoCuentaContable) {
		this.activarcodigoCuentaContable= activarcodigoCuentaContable;
	}

	public Border setResaltarnombreCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarnombreCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCuentaContable() {
		return this.resaltarnombreCuentaContable;
	}

	public void setResaltarnombreCuentaContable(Border borderResaltar) {
		this.resaltarnombreCuentaContable= borderResaltar;
	}

	public Boolean getMostrarnombreCuentaContable() {
		return this.mostrarnombreCuentaContable;
	}

	public void setMostrarnombreCuentaContable(Boolean mostrarnombreCuentaContable) {
		this.mostrarnombreCuentaContable= mostrarnombreCuentaContable;
	}

	public Boolean getActivarnombreCuentaContable() {
		return this.activarnombreCuentaContable;
	}

	public void setActivarnombreCuentaContable(Boolean activarnombreCuentaContable) {
		this.activarnombreCuentaContable= activarnombreCuentaContable;
	}

	public Border setResaltarcodigo_extranjeroCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarcodigo_extranjeroCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_extranjeroCuentaContable() {
		return this.resaltarcodigo_extranjeroCuentaContable;
	}

	public void setResaltarcodigo_extranjeroCuentaContable(Border borderResaltar) {
		this.resaltarcodigo_extranjeroCuentaContable= borderResaltar;
	}

	public Boolean getMostrarcodigo_extranjeroCuentaContable() {
		return this.mostrarcodigo_extranjeroCuentaContable;
	}

	public void setMostrarcodigo_extranjeroCuentaContable(Boolean mostrarcodigo_extranjeroCuentaContable) {
		this.mostrarcodigo_extranjeroCuentaContable= mostrarcodigo_extranjeroCuentaContable;
	}

	public Boolean getActivarcodigo_extranjeroCuentaContable() {
		return this.activarcodigo_extranjeroCuentaContable;
	}

	public void setActivarcodigo_extranjeroCuentaContable(Boolean activarcodigo_extranjeroCuentaContable) {
		this.activarcodigo_extranjeroCuentaContable= activarcodigo_extranjeroCuentaContable;
	}

	public Border setResaltarnombre_extranjeroCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarnombre_extranjeroCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_extranjeroCuentaContable() {
		return this.resaltarnombre_extranjeroCuentaContable;
	}

	public void setResaltarnombre_extranjeroCuentaContable(Border borderResaltar) {
		this.resaltarnombre_extranjeroCuentaContable= borderResaltar;
	}

	public Boolean getMostrarnombre_extranjeroCuentaContable() {
		return this.mostrarnombre_extranjeroCuentaContable;
	}

	public void setMostrarnombre_extranjeroCuentaContable(Boolean mostrarnombre_extranjeroCuentaContable) {
		this.mostrarnombre_extranjeroCuentaContable= mostrarnombre_extranjeroCuentaContable;
	}

	public Boolean getActivarnombre_extranjeroCuentaContable() {
		return this.activarnombre_extranjeroCuentaContable;
	}

	public void setActivarnombre_extranjeroCuentaContable(Boolean activarnombre_extranjeroCuentaContable) {
		this.activarnombre_extranjeroCuentaContable= activarnombre_extranjeroCuentaContable;
	}

	public Border setResaltarid_nivel_cuentaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_nivel_cuentaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nivel_cuentaCuentaContable() {
		return this.resaltarid_nivel_cuentaCuentaContable;
	}

	public void setResaltarid_nivel_cuentaCuentaContable(Border borderResaltar) {
		this.resaltarid_nivel_cuentaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_nivel_cuentaCuentaContable() {
		return this.mostrarid_nivel_cuentaCuentaContable;
	}

	public void setMostrarid_nivel_cuentaCuentaContable(Boolean mostrarid_nivel_cuentaCuentaContable) {
		this.mostrarid_nivel_cuentaCuentaContable= mostrarid_nivel_cuentaCuentaContable;
	}

	public Boolean getActivarid_nivel_cuentaCuentaContable() {
		return this.activarid_nivel_cuentaCuentaContable;
	}

	public void setActivarid_nivel_cuentaCuentaContable(Boolean activarid_nivel_cuentaCuentaContable) {
		this.activarid_nivel_cuentaCuentaContable= activarid_nivel_cuentaCuentaContable;
	}

	public Boolean getCargarid_nivel_cuentaCuentaContable() {
		return this.cargarid_nivel_cuentaCuentaContable;
	}

	public void setCargarid_nivel_cuentaCuentaContable(Boolean cargarid_nivel_cuentaCuentaContable) {
		this.cargarid_nivel_cuentaCuentaContable= cargarid_nivel_cuentaCuentaContable;
	}

	public Border setResaltarid_cuenta_contableCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaContable() {
		return this.resaltarid_cuenta_contableCuentaContable;
	}

	public void setResaltarid_cuenta_contableCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaContable() {
		return this.mostrarid_cuenta_contableCuentaContable;
	}

	public void setMostrarid_cuenta_contableCuentaContable(Boolean mostrarid_cuenta_contableCuentaContable) {
		this.mostrarid_cuenta_contableCuentaContable= mostrarid_cuenta_contableCuentaContable;
	}

	public Boolean getActivarid_cuenta_contableCuentaContable() {
		return this.activarid_cuenta_contableCuentaContable;
	}

	public void setActivarid_cuenta_contableCuentaContable(Boolean activarid_cuenta_contableCuentaContable) {
		this.activarid_cuenta_contableCuentaContable= activarid_cuenta_contableCuentaContable;
	}

	public Boolean getCargarid_cuenta_contableCuentaContable() {
		return this.cargarid_cuenta_contableCuentaContable;
	}

	public void setCargarid_cuenta_contableCuentaContable(Boolean cargarid_cuenta_contableCuentaContable) {
		this.cargarid_cuenta_contableCuentaContable= cargarid_cuenta_contableCuentaContable;
	}

	public Border setResaltarid_centro_costoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCuentaContable() {
		return this.resaltarid_centro_costoCuentaContable;
	}

	public void setResaltarid_centro_costoCuentaContable(Border borderResaltar) {
		this.resaltarid_centro_costoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCuentaContable() {
		return this.mostrarid_centro_costoCuentaContable;
	}

	public void setMostrarid_centro_costoCuentaContable(Boolean mostrarid_centro_costoCuentaContable) {
		this.mostrarid_centro_costoCuentaContable= mostrarid_centro_costoCuentaContable;
	}

	public Boolean getActivarid_centro_costoCuentaContable() {
		return this.activarid_centro_costoCuentaContable;
	}

	public void setActivarid_centro_costoCuentaContable(Boolean activarid_centro_costoCuentaContable) {
		this.activarid_centro_costoCuentaContable= activarid_centro_costoCuentaContable;
	}

	public Boolean getCargarid_centro_costoCuentaContable() {
		return this.cargarid_centro_costoCuentaContable;
	}

	public void setCargarid_centro_costoCuentaContable(Boolean cargarid_centro_costoCuentaContable) {
		this.cargarid_centro_costoCuentaContable= cargarid_centro_costoCuentaContable;
	}

	public Border setResaltarid_moduloCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_moduloCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloCuentaContable() {
		return this.resaltarid_moduloCuentaContable;
	}

	public void setResaltarid_moduloCuentaContable(Border borderResaltar) {
		this.resaltarid_moduloCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_moduloCuentaContable() {
		return this.mostrarid_moduloCuentaContable;
	}

	public void setMostrarid_moduloCuentaContable(Boolean mostrarid_moduloCuentaContable) {
		this.mostrarid_moduloCuentaContable= mostrarid_moduloCuentaContable;
	}

	public Boolean getActivarid_moduloCuentaContable() {
		return this.activarid_moduloCuentaContable;
	}

	public void setActivarid_moduloCuentaContable(Boolean activarid_moduloCuentaContable) {
		this.activarid_moduloCuentaContable= activarid_moduloCuentaContable;
	}

	public Boolean getCargarid_moduloCuentaContable() {
		return this.cargarid_moduloCuentaContable;
	}

	public void setCargarid_moduloCuentaContable(Boolean cargarid_moduloCuentaContable) {
		this.cargarid_moduloCuentaContable= cargarid_moduloCuentaContable;
	}

	public Border setResaltardescripcionCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltardescripcionCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCuentaContable() {
		return this.resaltardescripcionCuentaContable;
	}

	public void setResaltardescripcionCuentaContable(Border borderResaltar) {
		this.resaltardescripcionCuentaContable= borderResaltar;
	}

	public Boolean getMostrardescripcionCuentaContable() {
		return this.mostrardescripcionCuentaContable;
	}

	public void setMostrardescripcionCuentaContable(Boolean mostrardescripcionCuentaContable) {
		this.mostrardescripcionCuentaContable= mostrardescripcionCuentaContable;
	}

	public Boolean getActivardescripcionCuentaContable() {
		return this.activardescripcionCuentaContable;
	}

	public void setActivardescripcionCuentaContable(Boolean activardescripcionCuentaContable) {
		this.activardescripcionCuentaContable= activardescripcionCuentaContable;
	}

	public Border setResaltares_movimientoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_movimientoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_movimientoCuentaContable() {
		return this.resaltares_movimientoCuentaContable;
	}

	public void setResaltares_movimientoCuentaContable(Border borderResaltar) {
		this.resaltares_movimientoCuentaContable= borderResaltar;
	}

	public Boolean getMostrares_movimientoCuentaContable() {
		return this.mostrares_movimientoCuentaContable;
	}

	public void setMostrares_movimientoCuentaContable(Boolean mostrares_movimientoCuentaContable) {
		this.mostrares_movimientoCuentaContable= mostrares_movimientoCuentaContable;
	}

	public Boolean getActivares_movimientoCuentaContable() {
		return this.activares_movimientoCuentaContable;
	}

	public void setActivares_movimientoCuentaContable(Boolean activares_movimientoCuentaContable) {
		this.activares_movimientoCuentaContable= activares_movimientoCuentaContable;
	}

	public Border setResaltares_centro_costoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_centro_costoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_centro_costoCuentaContable() {
		return this.resaltares_centro_costoCuentaContable;
	}

	public void setResaltares_centro_costoCuentaContable(Border borderResaltar) {
		this.resaltares_centro_costoCuentaContable= borderResaltar;
	}

	public Boolean getMostrares_centro_costoCuentaContable() {
		return this.mostrares_centro_costoCuentaContable;
	}

	public void setMostrares_centro_costoCuentaContable(Boolean mostrares_centro_costoCuentaContable) {
		this.mostrares_centro_costoCuentaContable= mostrares_centro_costoCuentaContable;
	}

	public Boolean getActivares_centro_costoCuentaContable() {
		return this.activares_centro_costoCuentaContable;
	}

	public void setActivares_centro_costoCuentaContable(Boolean activares_centro_costoCuentaContable) {
		this.activares_centro_costoCuentaContable= activares_centro_costoCuentaContable;
	}

	public Border setResaltares_centro_actividadCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_centro_actividadCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_centro_actividadCuentaContable() {
		return this.resaltares_centro_actividadCuentaContable;
	}

	public void setResaltares_centro_actividadCuentaContable(Border borderResaltar) {
		this.resaltares_centro_actividadCuentaContable= borderResaltar;
	}

	public Boolean getMostrares_centro_actividadCuentaContable() {
		return this.mostrares_centro_actividadCuentaContable;
	}

	public void setMostrares_centro_actividadCuentaContable(Boolean mostrares_centro_actividadCuentaContable) {
		this.mostrares_centro_actividadCuentaContable= mostrares_centro_actividadCuentaContable;
	}

	public Boolean getActivares_centro_actividadCuentaContable() {
		return this.activares_centro_actividadCuentaContable;
	}

	public void setActivares_centro_actividadCuentaContable(Boolean activares_centro_actividadCuentaContable) {
		this.activares_centro_actividadCuentaContable= activares_centro_actividadCuentaContable;
	}

	public Border setResaltares_activoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_activoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_activoCuentaContable() {
		return this.resaltares_activoCuentaContable;
	}

	public void setResaltares_activoCuentaContable(Border borderResaltar) {
		this.resaltares_activoCuentaContable= borderResaltar;
	}

	public Boolean getMostrares_activoCuentaContable() {
		return this.mostrares_activoCuentaContable;
	}

	public void setMostrares_activoCuentaContable(Boolean mostrares_activoCuentaContable) {
		this.mostrares_activoCuentaContable= mostrares_activoCuentaContable;
	}

	public Boolean getActivares_activoCuentaContable() {
		return this.activares_activoCuentaContable;
	}

	public void setActivares_activoCuentaContable(Boolean activares_activoCuentaContable) {
		this.activares_activoCuentaContable= activares_activoCuentaContable;
	}

	public Border setResaltares_relacionCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_relacionCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_relacionCuentaContable() {
		return this.resaltares_relacionCuentaContable;
	}

	public void setResaltares_relacionCuentaContable(Border borderResaltar) {
		this.resaltares_relacionCuentaContable= borderResaltar;
	}

	public Boolean getMostrares_relacionCuentaContable() {
		return this.mostrares_relacionCuentaContable;
	}

	public void setMostrares_relacionCuentaContable(Boolean mostrares_relacionCuentaContable) {
		this.mostrares_relacionCuentaContable= mostrares_relacionCuentaContable;
	}

	public Boolean getActivares_relacionCuentaContable() {
		return this.activares_relacionCuentaContable;
	}

	public void setActivares_relacionCuentaContable(Boolean activares_relacionCuentaContable) {
		this.activares_relacionCuentaContable= activares_relacionCuentaContable;
	}

	public Border setResaltares_para_f52CuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltares_para_f52CuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_f52CuentaContable() {
		return this.resaltares_para_f52CuentaContable;
	}

	public void setResaltares_para_f52CuentaContable(Border borderResaltar) {
		this.resaltares_para_f52CuentaContable= borderResaltar;
	}

	public Boolean getMostrares_para_f52CuentaContable() {
		return this.mostrares_para_f52CuentaContable;
	}

	public void setMostrares_para_f52CuentaContable(Boolean mostrares_para_f52CuentaContable) {
		this.mostrares_para_f52CuentaContable= mostrares_para_f52CuentaContable;
	}

	public Boolean getActivares_para_f52CuentaContable() {
		return this.activares_para_f52CuentaContable;
	}

	public void setActivares_para_f52CuentaContable(Boolean activares_para_f52CuentaContable) {
		this.activares_para_f52CuentaContable= activares_para_f52CuentaContable;
	}

	public Border setResaltarid_monedaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_monedaCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaCuentaContable() {
		return this.resaltarid_monedaCuentaContable;
	}

	public void setResaltarid_monedaCuentaContable(Border borderResaltar) {
		this.resaltarid_monedaCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_monedaCuentaContable() {
		return this.mostrarid_monedaCuentaContable;
	}

	public void setMostrarid_monedaCuentaContable(Boolean mostrarid_monedaCuentaContable) {
		this.mostrarid_monedaCuentaContable= mostrarid_monedaCuentaContable;
	}

	public Boolean getActivarid_monedaCuentaContable() {
		return this.activarid_monedaCuentaContable;
	}

	public void setActivarid_monedaCuentaContable(Boolean activarid_monedaCuentaContable) {
		this.activarid_monedaCuentaContable= activarid_monedaCuentaContable;
	}

	public Boolean getCargarid_monedaCuentaContable() {
		return this.cargarid_monedaCuentaContable;
	}

	public void setCargarid_monedaCuentaContable(Boolean cargarid_monedaCuentaContable) {
		this.cargarid_monedaCuentaContable= cargarid_monedaCuentaContable;
	}

	public Border setResaltarid_tipo_intervaloCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_intervaloCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_intervaloCuentaContable() {
		return this.resaltarid_tipo_intervaloCuentaContable;
	}

	public void setResaltarid_tipo_intervaloCuentaContable(Border borderResaltar) {
		this.resaltarid_tipo_intervaloCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_intervaloCuentaContable() {
		return this.mostrarid_tipo_intervaloCuentaContable;
	}

	public void setMostrarid_tipo_intervaloCuentaContable(Boolean mostrarid_tipo_intervaloCuentaContable) {
		this.mostrarid_tipo_intervaloCuentaContable= mostrarid_tipo_intervaloCuentaContable;
	}

	public Boolean getActivarid_tipo_intervaloCuentaContable() {
		return this.activarid_tipo_intervaloCuentaContable;
	}

	public void setActivarid_tipo_intervaloCuentaContable(Boolean activarid_tipo_intervaloCuentaContable) {
		this.activarid_tipo_intervaloCuentaContable= activarid_tipo_intervaloCuentaContable;
	}

	public Boolean getCargarid_tipo_intervaloCuentaContable() {
		return this.cargarid_tipo_intervaloCuentaContable;
	}

	public void setCargarid_tipo_intervaloCuentaContable(Boolean cargarid_tipo_intervaloCuentaContable) {
		this.cargarid_tipo_intervaloCuentaContable= cargarid_tipo_intervaloCuentaContable;
	}

	public Border setResaltarid_tipo_flujo_efectivoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_flujo_efectivoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_flujo_efectivoCuentaContable() {
		return this.resaltarid_tipo_flujo_efectivoCuentaContable;
	}

	public void setResaltarid_tipo_flujo_efectivoCuentaContable(Border borderResaltar) {
		this.resaltarid_tipo_flujo_efectivoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_flujo_efectivoCuentaContable() {
		return this.mostrarid_tipo_flujo_efectivoCuentaContable;
	}

	public void setMostrarid_tipo_flujo_efectivoCuentaContable(Boolean mostrarid_tipo_flujo_efectivoCuentaContable) {
		this.mostrarid_tipo_flujo_efectivoCuentaContable= mostrarid_tipo_flujo_efectivoCuentaContable;
	}

	public Boolean getActivarid_tipo_flujo_efectivoCuentaContable() {
		return this.activarid_tipo_flujo_efectivoCuentaContable;
	}

	public void setActivarid_tipo_flujo_efectivoCuentaContable(Boolean activarid_tipo_flujo_efectivoCuentaContable) {
		this.activarid_tipo_flujo_efectivoCuentaContable= activarid_tipo_flujo_efectivoCuentaContable;
	}

	public Boolean getCargarid_tipo_flujo_efectivoCuentaContable() {
		return this.cargarid_tipo_flujo_efectivoCuentaContable;
	}

	public void setCargarid_tipo_flujo_efectivoCuentaContable(Boolean cargarid_tipo_flujo_efectivoCuentaContable) {
		this.cargarid_tipo_flujo_efectivoCuentaContable= cargarid_tipo_flujo_efectivoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_debitoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoCuentaContable() {
		return this.resaltarid_cuenta_contable_debitoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_debitoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoCuentaContable() {
		return this.mostrarid_cuenta_contable_debitoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_debitoCuentaContable(Boolean mostrarid_cuenta_contable_debitoCuentaContable) {
		this.mostrarid_cuenta_contable_debitoCuentaContable= mostrarid_cuenta_contable_debitoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_debitoCuentaContable() {
		return this.activarid_cuenta_contable_debitoCuentaContable;
	}

	public void setActivarid_cuenta_contable_debitoCuentaContable(Boolean activarid_cuenta_contable_debitoCuentaContable) {
		this.activarid_cuenta_contable_debitoCuentaContable= activarid_cuenta_contable_debitoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_debitoCuentaContable() {
		return this.cargarid_cuenta_contable_debitoCuentaContable;
	}

	public void setCargarid_cuenta_contable_debitoCuentaContable(Boolean cargarid_cuenta_contable_debitoCuentaContable) {
		this.cargarid_cuenta_contable_debitoCuentaContable= cargarid_cuenta_contable_debitoCuentaContable;
	}

	public Border setResaltarid_cuenta_contable_creditoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoCuentaContable() {
		return this.resaltarid_cuenta_contable_creditoCuentaContable;
	}

	public void setResaltarid_cuenta_contable_creditoCuentaContable(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoCuentaContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoCuentaContable() {
		return this.mostrarid_cuenta_contable_creditoCuentaContable;
	}

	public void setMostrarid_cuenta_contable_creditoCuentaContable(Boolean mostrarid_cuenta_contable_creditoCuentaContable) {
		this.mostrarid_cuenta_contable_creditoCuentaContable= mostrarid_cuenta_contable_creditoCuentaContable;
	}

	public Boolean getActivarid_cuenta_contable_creditoCuentaContable() {
		return this.activarid_cuenta_contable_creditoCuentaContable;
	}

	public void setActivarid_cuenta_contable_creditoCuentaContable(Boolean activarid_cuenta_contable_creditoCuentaContable) {
		this.activarid_cuenta_contable_creditoCuentaContable= activarid_cuenta_contable_creditoCuentaContable;
	}

	public Boolean getCargarid_cuenta_contable_creditoCuentaContable() {
		return this.cargarid_cuenta_contable_creditoCuentaContable;
	}

	public void setCargarid_cuenta_contable_creditoCuentaContable(Boolean cargarid_cuenta_contable_creditoCuentaContable) {
		this.cargarid_cuenta_contable_creditoCuentaContable= cargarid_cuenta_contable_creditoCuentaContable;
	}

	public Border setResaltarordenCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentacontableBeanSwingJInternalFrame.jTtoolBarCuentaContable.setBorder(borderResaltar);
		
		this.resaltarordenCuentaContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenCuentaContable() {
		return this.resaltarordenCuentaContable;
	}

	public void setResaltarordenCuentaContable(Border borderResaltar) {
		this.resaltarordenCuentaContable= borderResaltar;
	}

	public Boolean getMostrarordenCuentaContable() {
		return this.mostrarordenCuentaContable;
	}

	public void setMostrarordenCuentaContable(Boolean mostrarordenCuentaContable) {
		this.mostrarordenCuentaContable= mostrarordenCuentaContable;
	}

	public Boolean getActivarordenCuentaContable() {
		return this.activarordenCuentaContable;
	}

	public void setActivarordenCuentaContable(Boolean activarordenCuentaContable) {
		this.activarordenCuentaContable= activarordenCuentaContable;
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
		
		
		this.setMostraridCuentaContable(esInicial);
		this.setMostrarid_empresaCuentaContable(esInicial);
		this.setMostrarcodigoCuentaContable(esInicial);
		this.setMostrarnombreCuentaContable(esInicial);
		this.setMostrarcodigo_extranjeroCuentaContable(esInicial);
		this.setMostrarnombre_extranjeroCuentaContable(esInicial);
		this.setMostrarid_nivel_cuentaCuentaContable(esInicial);
		this.setMostrarid_cuenta_contableCuentaContable(esInicial);
		this.setMostrarid_centro_costoCuentaContable(esInicial);
		this.setMostrarid_moduloCuentaContable(esInicial);
		this.setMostrardescripcionCuentaContable(esInicial);
		this.setMostrares_movimientoCuentaContable(esInicial);
		this.setMostrares_centro_costoCuentaContable(esInicial);
		this.setMostrares_centro_actividadCuentaContable(esInicial);
		this.setMostrares_activoCuentaContable(esInicial);
		this.setMostrares_relacionCuentaContable(esInicial);
		this.setMostrares_para_f52CuentaContable(esInicial);
		this.setMostrarid_monedaCuentaContable(esInicial);
		this.setMostrarid_tipo_intervaloCuentaContable(esInicial);
		this.setMostrarid_tipo_flujo_efectivoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_debitoCuentaContable(esInicial);
		this.setMostrarid_cuenta_contable_creditoCuentaContable(esInicial);
		this.setMostrarordenCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableConstantesFunciones.ID)) {
				this.setMostraridCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGOEXTRANJERO)) {
				this.setMostrarcodigo_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setMostrarnombre_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDNIVELCUENTA)) {
				this.setMostrarid_nivel_cuentaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESMOVIMIENTO)) {
				this.setMostrares_movimientoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROCOSTO)) {
				this.setMostrares_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setMostrares_centro_actividadCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESACTIVO)) {
				this.setMostrares_activoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESRELACION)) {
				this.setMostrares_relacionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESPARAF52)) {
				this.setMostrares_para_f52CuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOINTERVALO)) {
				this.setMostrarid_tipo_intervaloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO)) {
				this.setMostrarid_tipo_flujo_efectivoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ORDEN)) {
				this.setMostrarordenCuentaContable(esAsigna);
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
		
		
		this.setActivaridCuentaContable(esInicial);
		this.setActivarid_empresaCuentaContable(esInicial);
		this.setActivarcodigoCuentaContable(esInicial);
		this.setActivarnombreCuentaContable(esInicial);
		this.setActivarcodigo_extranjeroCuentaContable(esInicial);
		this.setActivarnombre_extranjeroCuentaContable(esInicial);
		this.setActivarid_nivel_cuentaCuentaContable(esInicial);
		this.setActivarid_cuenta_contableCuentaContable(esInicial);
		this.setActivarid_centro_costoCuentaContable(esInicial);
		this.setActivarid_moduloCuentaContable(esInicial);
		this.setActivardescripcionCuentaContable(esInicial);
		this.setActivares_movimientoCuentaContable(esInicial);
		this.setActivares_centro_costoCuentaContable(esInicial);
		this.setActivares_centro_actividadCuentaContable(esInicial);
		this.setActivares_activoCuentaContable(esInicial);
		this.setActivares_relacionCuentaContable(esInicial);
		this.setActivares_para_f52CuentaContable(esInicial);
		this.setActivarid_monedaCuentaContable(esInicial);
		this.setActivarid_tipo_intervaloCuentaContable(esInicial);
		this.setActivarid_tipo_flujo_efectivoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_debitoCuentaContable(esInicial);
		this.setActivarid_cuenta_contable_creditoCuentaContable(esInicial);
		this.setActivarordenCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableConstantesFunciones.ID)) {
				this.setActivaridCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGOEXTRANJERO)) {
				this.setActivarcodigo_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setActivarnombre_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDNIVELCUENTA)) {
				this.setActivarid_nivel_cuentaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESMOVIMIENTO)) {
				this.setActivares_movimientoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROCOSTO)) {
				this.setActivares_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setActivares_centro_actividadCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESACTIVO)) {
				this.setActivares_activoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESRELACION)) {
				this.setActivares_relacionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESPARAF52)) {
				this.setActivares_para_f52CuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOINTERVALO)) {
				this.setActivarid_tipo_intervaloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO)) {
				this.setActivarid_tipo_flujo_efectivoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ORDEN)) {
				this.setActivarordenCuentaContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaContable(esInicial);
		this.setResaltarid_empresaCuentaContable(esInicial);
		this.setResaltarcodigoCuentaContable(esInicial);
		this.setResaltarnombreCuentaContable(esInicial);
		this.setResaltarcodigo_extranjeroCuentaContable(esInicial);
		this.setResaltarnombre_extranjeroCuentaContable(esInicial);
		this.setResaltarid_nivel_cuentaCuentaContable(esInicial);
		this.setResaltarid_cuenta_contableCuentaContable(esInicial);
		this.setResaltarid_centro_costoCuentaContable(esInicial);
		this.setResaltarid_moduloCuentaContable(esInicial);
		this.setResaltardescripcionCuentaContable(esInicial);
		this.setResaltares_movimientoCuentaContable(esInicial);
		this.setResaltares_centro_costoCuentaContable(esInicial);
		this.setResaltares_centro_actividadCuentaContable(esInicial);
		this.setResaltares_activoCuentaContable(esInicial);
		this.setResaltares_relacionCuentaContable(esInicial);
		this.setResaltares_para_f52CuentaContable(esInicial);
		this.setResaltarid_monedaCuentaContable(esInicial);
		this.setResaltarid_tipo_intervaloCuentaContable(esInicial);
		this.setResaltarid_tipo_flujo_efectivoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_debitoCuentaContable(esInicial);
		this.setResaltarid_cuenta_contable_creditoCuentaContable(esInicial);
		this.setResaltarordenCuentaContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaContableConstantesFunciones.ID)) {
				this.setResaltaridCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.CODIGOEXTRANJERO)) {
				this.setResaltarcodigo_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.NOMBREEXTRANJERO)) {
				this.setResaltarnombre_extranjeroCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDNIVELCUENTA)) {
				this.setResaltarid_nivel_cuentaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESMOVIMIENTO)) {
				this.setResaltares_movimientoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROCOSTO)) {
				this.setResaltares_centro_costoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESCENTROACTIVIDAD)) {
				this.setResaltares_centro_actividadCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESACTIVO)) {
				this.setResaltares_activoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESRELACION)) {
				this.setResaltares_relacionCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ESPARAF52)) {
				this.setResaltares_para_f52CuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOINTERVALO)) {
				this.setResaltarid_tipo_intervaloCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO)) {
				this.setResaltarid_tipo_flujo_efectivoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoCuentaContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaContableConstantesFunciones.ORDEN)) {
				this.setResaltarordenCuentaContable(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoCuentaContable=true;

	public Boolean getMostrarBusquedaPorCodigoCuentaContable() {
		return this.mostrarBusquedaPorCodigoCuentaContable;
	}

	public void setMostrarBusquedaPorCodigoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreCuentaContable=true;

	public Boolean getMostrarBusquedaPorNombreCuentaContable() {
		return this.mostrarBusquedaPorNombreCuentaContable;
	}

	public void setMostrarBusquedaPorNombreCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoCuentaContable=true;

	public Boolean getMostrarFK_IdCentroCostoCuentaContable() {
		return this.mostrarFK_IdCentroCostoCuentaContable;
	}

	public void setMostrarFK_IdCentroCostoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCuentaContable=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaContable() {
		return this.mostrarFK_IdCuentaContableCuentaContable;
	}

	public void setMostrarFK_IdCuentaContableCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaContable=true;

	public Boolean getMostrarFK_IdEmpresaCuentaContable() {
		return this.mostrarFK_IdEmpresaCuentaContable;
	}

	public void setMostrarFK_IdEmpresaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloCuentaContable=true;

	public Boolean getMostrarFK_IdModuloCuentaContable() {
		return this.mostrarFK_IdModuloCuentaContable;
	}

	public void setMostrarFK_IdModuloCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNivelCuentaCuentaContable=true;

	public Boolean getMostrarFK_IdNivelCuentaCuentaContable() {
		return this.mostrarFK_IdNivelCuentaCuentaContable;
	}

	public void setMostrarFK_IdNivelCuentaCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNivelCuentaCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFlujoEfectivoCuentaContable=true;

	public Boolean getMostrarFK_IdTipoFlujoEfectivoCuentaContable() {
		return this.mostrarFK_IdTipoFlujoEfectivoCuentaContable;
	}

	public void setMostrarFK_IdTipoFlujoEfectivoCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFlujoEfectivoCuentaContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIntervaloCuentaContable=true;

	public Boolean getMostrarFK_IdTipoIntervaloCuentaContable() {
		return this.mostrarFK_IdTipoIntervaloCuentaContable;
	}

	public void setMostrarFK_IdTipoIntervaloCuentaContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIntervaloCuentaContable= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoCuentaContable=true;

	public Boolean getActivarBusquedaPorCodigoCuentaContable() {
		return this.activarBusquedaPorCodigoCuentaContable;
	}

	public void setActivarBusquedaPorCodigoCuentaContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoCuentaContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreCuentaContable=true;

	public Boolean getActivarBusquedaPorNombreCuentaContable() {
		return this.activarBusquedaPorNombreCuentaContable;
	}

	public void setActivarBusquedaPorNombreCuentaContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoCuentaContable=true;

	public Boolean getActivarFK_IdCentroCostoCuentaContable() {
		return this.activarFK_IdCentroCostoCuentaContable;
	}

	public void setActivarFK_IdCentroCostoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCuentaContable=true;

	public Boolean getActivarFK_IdCuentaContableCuentaContable() {
		return this.activarFK_IdCuentaContableCuentaContable;
	}

	public void setActivarFK_IdCuentaContableCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaContable=true;

	public Boolean getActivarFK_IdEmpresaCuentaContable() {
		return this.activarFK_IdEmpresaCuentaContable;
	}

	public void setActivarFK_IdEmpresaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloCuentaContable=true;

	public Boolean getActivarFK_IdModuloCuentaContable() {
		return this.activarFK_IdModuloCuentaContable;
	}

	public void setActivarFK_IdModuloCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdModuloCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdNivelCuentaCuentaContable=true;

	public Boolean getActivarFK_IdNivelCuentaCuentaContable() {
		return this.activarFK_IdNivelCuentaCuentaContable;
	}

	public void setActivarFK_IdNivelCuentaCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdNivelCuentaCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFlujoEfectivoCuentaContable=true;

	public Boolean getActivarFK_IdTipoFlujoEfectivoCuentaContable() {
		return this.activarFK_IdTipoFlujoEfectivoCuentaContable;
	}

	public void setActivarFK_IdTipoFlujoEfectivoCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFlujoEfectivoCuentaContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIntervaloCuentaContable=true;

	public Boolean getActivarFK_IdTipoIntervaloCuentaContable() {
		return this.activarFK_IdTipoIntervaloCuentaContable;
	}

	public void setActivarFK_IdTipoIntervaloCuentaContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIntervaloCuentaContable= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoCuentaContable=null;

	public Border getResaltarBusquedaPorCodigoCuentaContable() {
		return this.resaltarBusquedaPorCodigoCuentaContable;
	}

	public void setResaltarBusquedaPorCodigoCuentaContable(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoCuentaContable= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoCuentaContable= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreCuentaContable=null;

	public Border getResaltarBusquedaPorNombreCuentaContable() {
		return this.resaltarBusquedaPorNombreCuentaContable;
	}

	public void setResaltarBusquedaPorNombreCuentaContable(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCuentaContable= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoCuentaContable=null;

	public Border getResaltarFK_IdCentroCostoCuentaContable() {
		return this.resaltarFK_IdCentroCostoCuentaContable;
	}

	public void setResaltarFK_IdCentroCostoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCuentaContable=null;

	public Border getResaltarFK_IdCuentaContableCuentaContable() {
		return this.resaltarFK_IdCuentaContableCuentaContable;
	}

	public void setResaltarFK_IdCuentaContableCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaContable=null;

	public Border getResaltarFK_IdEmpresaCuentaContable() {
		return this.resaltarFK_IdEmpresaCuentaContable;
	}

	public void setResaltarFK_IdEmpresaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdModuloCuentaContable=null;

	public Border getResaltarFK_IdModuloCuentaContable() {
		return this.resaltarFK_IdModuloCuentaContable;
	}

	public void setResaltarFK_IdModuloCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdModuloCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdModuloCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdNivelCuentaCuentaContable=null;

	public Border getResaltarFK_IdNivelCuentaCuentaContable() {
		return this.resaltarFK_IdNivelCuentaCuentaContable;
	}

	public void setResaltarFK_IdNivelCuentaCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdNivelCuentaCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdNivelCuentaCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNivelCuentaCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoFlujoEfectivoCuentaContable=null;

	public Border getResaltarFK_IdTipoFlujoEfectivoCuentaContable() {
		return this.resaltarFK_IdTipoFlujoEfectivoCuentaContable;
	}

	public void setResaltarFK_IdTipoFlujoEfectivoCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdTipoFlujoEfectivoCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoFlujoEfectivoCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFlujoEfectivoCuentaContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoIntervaloCuentaContable=null;

	public Border getResaltarFK_IdTipoIntervaloCuentaContable() {
		return this.resaltarFK_IdTipoIntervaloCuentaContable;
	}

	public void setResaltarFK_IdTipoIntervaloCuentaContable(Border borderResaltar) {
		this.resaltarFK_IdTipoIntervaloCuentaContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoIntervaloCuentaContable(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaContableBeanSwingJInternalFrame cuentacontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIntervaloCuentaContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}