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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.ParametroTesoreriaConstantesFunciones;
import com.bydan.erp.tesoreria.util.ParametroTesoreriaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroTesoreriaConstantesFunciones extends ParametroTesoreriaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroTesoreria";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroTesoreria"+ParametroTesoreriaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroTesoreriaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroTesoreriaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroTesoreriaConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroTesoreriaConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroTesoreriaConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroTesoreriaConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroTesoreriaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroTesoreriaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroTesoreriaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroTesoreriaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Tesorerias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Tesoreria";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Tesoreria";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroTesoreria";
	public static final String OBJECTNAME="parametrotesoreria";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="parametro_tesoreria";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrotesoreria from "+ParametroTesoreriaConstantesFunciones.SPERSISTENCENAME+" parametrotesoreria";
	public static String QUERYSELECTNATIVE="select "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".version_row,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".con_anticipo_orden_compra,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".por_lotes,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_pago,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_debito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_credito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_pago,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_debito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_credito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".descripcion from "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME;//+" as "+ParametroTesoreriaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroTesoreriaConstantesFuncionesAdditional parametrotesoreriaConstantesFuncionesAdditional=null;
	
	public ParametroTesoreriaConstantesFuncionesAdditional getParametroTesoreriaConstantesFuncionesAdditional() {
		return this.parametrotesoreriaConstantesFuncionesAdditional;
	}
	
	public void setParametroTesoreriaConstantesFuncionesAdditional(ParametroTesoreriaConstantesFuncionesAdditional parametrotesoreriaConstantesFuncionesAdditional) {
		try {
			this.parametrotesoreriaConstantesFuncionesAdditional=parametrotesoreriaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CONANTICIPOORDENCOMPRA= "con_anticipo_orden_compra";
    public static final String PORLOTES= "por_lotes";
    public static final String IDTRANSACCIONCOBRARPAGO= "id_transaccion_cobrar_pago";
    public static final String IDTRANSACCIONCOBRARDEBITO= "id_transaccion_cobrar_debito";
    public static final String IDTRANSACCIONCOBRARCREDITO= "id_transaccion_cobrar_credito";
    public static final String IDTRANSACCIONPAGARPAGO= "id_transaccion_pagar_pago";
    public static final String IDTRANSACCIONPAGARDEBITO= "id_transaccion_pagar_debito";
    public static final String IDTRANSACCIONPAGARCREDITO= "id_transaccion_pagar_credito";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CONANTICIPOORDENCOMPRA= "Anticipo Orden Compra";
		public static final String LABEL_CONANTICIPOORDENCOMPRA_LOWER= "Con Anticipo Orden Compra";
    	public static final String LABEL_PORLOTES= "Por Lotes";
		public static final String LABEL_PORLOTES_LOWER= "Por Lotes";
    	public static final String LABEL_IDTRANSACCIONCOBRARPAGO= "Transaccion Pago";
		public static final String LABEL_IDTRANSACCIONCOBRARPAGO_LOWER= "Transaccion Cobrar Pago";
    	public static final String LABEL_IDTRANSACCIONCOBRARDEBITO= "Transaccion Debito";
		public static final String LABEL_IDTRANSACCIONCOBRARDEBITO_LOWER= "Transaccion Cobrar Debito";
    	public static final String LABEL_IDTRANSACCIONCOBRARCREDITO= "Transaccion Credito";
		public static final String LABEL_IDTRANSACCIONCOBRARCREDITO_LOWER= "Transaccion Cobrar Credito";
    	public static final String LABEL_IDTRANSACCIONPAGARPAGO= "Transaccion Pago.";
		public static final String LABEL_IDTRANSACCIONPAGARPAGO_LOWER= "Transaccion Pagar Pago";
    	public static final String LABEL_IDTRANSACCIONPAGARDEBITO= "Transaccion Debito.";
		public static final String LABEL_IDTRANSACCIONPAGARDEBITO_LOWER= "Transaccion Pagar Debito";
    	public static final String LABEL_IDTRANSACCIONPAGARCREDITO= "Transaccion Credito.";
		public static final String LABEL_IDTRANSACCIONPAGARCREDITO_LOWER= "Transaccion Pagar Credito";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParametroTesoreriaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_CONANTICIPOORDENCOMPRA;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.PORLOTES)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_PORLOTES;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARPAGO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARDEBITO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARCREDITO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARPAGO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARDEBITO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARCREDITO;}
		if(sNombreColumna.equals(ParametroTesoreriaConstantesFunciones.DESCRIPCION)) {sLabelColumna=ParametroTesoreriaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
		
	public static String getcon_anticipo_orden_compraDescripcion(ParametroTesoreria parametrotesoreria) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrotesoreria.getcon_anticipo_orden_compra()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_anticipo_orden_compraHtmlDescripcion(ParametroTesoreria parametrotesoreria) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrotesoreria.getId(),parametrotesoreria.getcon_anticipo_orden_compra());

		return sDescripcion;
	}	
		
	public static String getpor_lotesDescripcion(ParametroTesoreria parametrotesoreria) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrotesoreria.getpor_lotes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getpor_lotesHtmlDescripcion(ParametroTesoreria parametrotesoreria) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrotesoreria.getId(),parametrotesoreria.getpor_lotes());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
	
	public static String getParametroTesoreriaDescripcion(ParametroTesoreria parametrotesoreria) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrotesoreria !=null/* && parametrotesoreria.getId()!=0*/) {
			if(parametrotesoreria.getId()!=null) {
				sDescripcion=parametrotesoreria.getId().toString();
			}//parametrotesoreriaparametrotesoreria.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroTesoreriaDescripcionDetallado(ParametroTesoreria parametrotesoreria) {
		String sDescripcion="";
			
		sDescripcion+=ParametroTesoreriaConstantesFunciones.ID+"=";
		sDescripcion+=parametrotesoreria.getId().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrotesoreria.getVersionRow().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrotesoreria.getid_empresa().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA+"=";
		sDescripcion+=parametrotesoreria.getcon_anticipo_orden_compra().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.PORLOTES+"=";
		sDescripcion+=parametrotesoreria.getpor_lotes().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_cobrar_pago().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_cobrar_debito().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_cobrar_credito().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_pagar_pago().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_pagar_debito().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO+"=";
		sDescripcion+=parametrotesoreria.getid_transaccion_pagar_credito().toString()+",";
		sDescripcion+=ParametroTesoreriaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=parametrotesoreria.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroTesoreriaDescripcion(ParametroTesoreria parametrotesoreria,String sValor) throws Exception {			
		if(parametrotesoreria !=null) {
			//parametrotesoreriaparametrotesoreria.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTransaccionCobrarPagoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCobrarDebitoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionCobrarCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionPagarPagoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionPagarDebitoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccionPagarCreditoDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTransaccionCobrarCredito")) {
			sNombreIndice="Tipo=  Por Transaccion Credito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCobrarDebito")) {
			sNombreIndice="Tipo=  Por Transaccion Debito";
		} else if(sNombreIndice.equals("FK_IdTransaccionCobrarPago")) {
			sNombreIndice="Tipo=  Por Transaccion Pago";
		} else if(sNombreIndice.equals("FK_IdTransaccionPagarCredito")) {
			sNombreIndice="Tipo=  Por Transaccion Credito.";
		} else if(sNombreIndice.equals("FK_IdTransaccionPagarDebito")) {
			sNombreIndice="Tipo=  Por Transaccion Debito.";
		} else if(sNombreIndice.equals("FK_IdTransaccionPagarPago")) {
			sNombreIndice="Tipo=  Por Transaccion Pago.";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCobrarCredito(Long id_transaccion_cobrar_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cobrar_credito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Credito="+id_transaccion_cobrar_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCobrarDebito(Long id_transaccion_cobrar_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cobrar_debito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Debito="+id_transaccion_cobrar_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionCobrarPago(Long id_transaccion_cobrar_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_cobrar_pago!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Pago="+id_transaccion_cobrar_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionPagarCredito(Long id_transaccion_pagar_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_pagar_credito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Credito.="+id_transaccion_pagar_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionPagarDebito(Long id_transaccion_pagar_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_pagar_debito!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Debito.="+id_transaccion_pagar_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionPagarPago(Long id_transaccion_pagar_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_pagar_pago!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Pago.="+id_transaccion_pagar_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroTesoreria(ParametroTesoreria parametrotesoreria,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrotesoreria.setdescripcion(parametrotesoreria.getdescripcion().trim());
	}
	
	public static void quitarEspaciosParametroTesorerias(List<ParametroTesoreria> parametrotesorerias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroTesoreria parametrotesoreria: parametrotesorerias) {
			parametrotesoreria.setdescripcion(parametrotesoreria.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroTesoreria(ParametroTesoreria parametrotesoreria,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrotesoreria.getConCambioAuxiliar()) {
			parametrotesoreria.setIsDeleted(parametrotesoreria.getIsDeletedAuxiliar());	
			parametrotesoreria.setIsNew(parametrotesoreria.getIsNewAuxiliar());	
			parametrotesoreria.setIsChanged(parametrotesoreria.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrotesoreria.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrotesoreria.setIsDeletedAuxiliar(false);	
			parametrotesoreria.setIsNewAuxiliar(false);	
			parametrotesoreria.setIsChangedAuxiliar(false);
			
			parametrotesoreria.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroTesorerias(List<ParametroTesoreria> parametrotesorerias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroTesoreria parametrotesoreria : parametrotesorerias) {
			if(conAsignarBase && parametrotesoreria.getConCambioAuxiliar()) {
				parametrotesoreria.setIsDeleted(parametrotesoreria.getIsDeletedAuxiliar());	
				parametrotesoreria.setIsNew(parametrotesoreria.getIsNewAuxiliar());	
				parametrotesoreria.setIsChanged(parametrotesoreria.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrotesoreria.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrotesoreria.setIsDeletedAuxiliar(false);	
				parametrotesoreria.setIsNewAuxiliar(false);	
				parametrotesoreria.setIsChangedAuxiliar(false);
				
				parametrotesoreria.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroTesoreria(ParametroTesoreria parametrotesoreria,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroTesorerias(List<ParametroTesoreria> parametrotesorerias,Boolean conEnteros) throws Exception  {
		
		for(ParametroTesoreria parametrotesoreria: parametrotesorerias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroTesoreria(List<ParametroTesoreria> parametrotesorerias,ParametroTesoreria parametrotesoreriaAux) throws Exception  {
		ParametroTesoreriaConstantesFunciones.InicializarValoresParametroTesoreria(parametrotesoreriaAux,true);
		
		for(ParametroTesoreria parametrotesoreria: parametrotesorerias) {
			if(parametrotesoreria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroTesoreria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroTesoreriaConstantesFunciones.getArrayColumnasGlobalesParametroTesoreria(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroTesoreria(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroTesoreriaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroTesoreriaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroTesoreria(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroTesoreria> parametrotesorerias,ParametroTesoreria parametrotesoreria,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroTesoreria parametrotesoreriaAux: parametrotesorerias) {
			if(parametrotesoreriaAux!=null && parametrotesoreria!=null) {
				if((parametrotesoreriaAux.getId()==null && parametrotesoreria.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrotesoreriaAux.getId()!=null && parametrotesoreria.getId()!=null){
					if(parametrotesoreriaAux.getId().equals(parametrotesoreria.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroTesoreria(List<ParametroTesoreria> parametrotesorerias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroTesoreria parametrotesoreria: parametrotesorerias) {			
			if(parametrotesoreria.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroTesoreria() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_ID, ParametroTesoreriaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_VERSIONROW, ParametroTesoreriaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDEMPRESA, ParametroTesoreriaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_CONANTICIPOORDENCOMPRA, ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_PORLOTES, ParametroTesoreriaConstantesFunciones.PORLOTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARPAGO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARDEBITO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARCREDITO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARPAGO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARDEBITO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARCREDITO, ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaConstantesFunciones.LABEL_DESCRIPCION, ParametroTesoreriaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroTesoreria() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.PORLOTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreria() throws Exception  {
		return ParametroTesoreriaConstantesFunciones.getTiposSeleccionarParametroTesoreria(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreria(Boolean conFk) throws Exception  {
		return ParametroTesoreriaConstantesFunciones.getTiposSeleccionarParametroTesoreria(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreria(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_CONANTICIPOORDENCOMPRA);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_CONANTICIPOORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_PORLOTES);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_PORLOTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARPAGO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARDEBITO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARCREDITO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARPAGO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARDEBITO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARCREDITO);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ParametroTesoreriaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroTesoreria(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroTesoreria(ParametroTesoreria parametrotesoreriaAux) throws Exception {
		
			parametrotesoreriaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrotesoreriaAux.getEmpresa()));
			parametrotesoreriaAux.settransaccioncobrarpago_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarPago()));
			parametrotesoreriaAux.settransaccioncobrardebito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarDebito()));
			parametrotesoreriaAux.settransaccioncobrarcredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarCredito()));
			parametrotesoreriaAux.settransaccionpagarpago_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarPago()));
			parametrotesoreriaAux.settransaccionpagardebito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarDebito()));
			parametrotesoreriaAux.settransaccionpagarcredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroTesoreria(List<ParametroTesoreria> parametrotesoreriasTemp) throws Exception {
		for(ParametroTesoreria parametrotesoreriaAux:parametrotesoreriasTemp) {
			
			parametrotesoreriaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrotesoreriaAux.getEmpresa()));
			parametrotesoreriaAux.settransaccioncobrarpago_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarPago()));
			parametrotesoreriaAux.settransaccioncobrardebito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarDebito()));
			parametrotesoreriaAux.settransaccioncobrarcredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionCobrarCredito()));
			parametrotesoreriaAux.settransaccionpagarpago_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarPago()));
			parametrotesoreriaAux.settransaccionpagardebito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarDebito()));
			parametrotesoreriaAux.settransaccionpagarcredito_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrotesoreriaAux.getTransaccionPagarCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroTesoreriaConstantesFunciones.getClassesRelationshipsOfParametroTesoreria(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroTesoreriaConstantesFunciones.getClassesRelationshipsFromStringsOfParametroTesoreria(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroTesoreria(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(ParametroTesoreria parametrotesoreria,List<ParametroTesoreria> parametrotesorerias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroTesoreria parametrotesoreriaEncontrado=null;
			
			for(ParametroTesoreria parametrotesoreriaLocal:parametrotesorerias) {
				if(parametrotesoreriaLocal.getId().equals(parametrotesoreria.getId())) {
					parametrotesoreriaEncontrado=parametrotesoreriaLocal;
					
					parametrotesoreriaLocal.setIsChanged(parametrotesoreria.getIsChanged());
					parametrotesoreriaLocal.setIsNew(parametrotesoreria.getIsNew());
					parametrotesoreriaLocal.setIsDeleted(parametrotesoreria.getIsDeleted());
					
					parametrotesoreriaLocal.setGeneralEntityOriginal(parametrotesoreria.getGeneralEntityOriginal());
					
					parametrotesoreriaLocal.setId(parametrotesoreria.getId());	
					parametrotesoreriaLocal.setVersionRow(parametrotesoreria.getVersionRow());	
					parametrotesoreriaLocal.setid_empresa(parametrotesoreria.getid_empresa());	
					parametrotesoreriaLocal.setcon_anticipo_orden_compra(parametrotesoreria.getcon_anticipo_orden_compra());	
					parametrotesoreriaLocal.setpor_lotes(parametrotesoreria.getpor_lotes());	
					parametrotesoreriaLocal.setid_transaccion_cobrar_pago(parametrotesoreria.getid_transaccion_cobrar_pago());	
					parametrotesoreriaLocal.setid_transaccion_cobrar_debito(parametrotesoreria.getid_transaccion_cobrar_debito());	
					parametrotesoreriaLocal.setid_transaccion_cobrar_credito(parametrotesoreria.getid_transaccion_cobrar_credito());	
					parametrotesoreriaLocal.setid_transaccion_pagar_pago(parametrotesoreria.getid_transaccion_pagar_pago());	
					parametrotesoreriaLocal.setid_transaccion_pagar_debito(parametrotesoreria.getid_transaccion_pagar_debito());	
					parametrotesoreriaLocal.setid_transaccion_pagar_credito(parametrotesoreria.getid_transaccion_pagar_credito());	
					parametrotesoreriaLocal.setdescripcion(parametrotesoreria.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrotesoreria.getIsDeleted()) {
				if(!existe) {
					parametrotesorerias.add(parametrotesoreria);
				}
			} else {
				if(parametrotesoreriaEncontrado!=null && permiteQuitar)  {
					parametrotesorerias.remove(parametrotesoreriaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroTesoreria parametrotesoreria,List<ParametroTesoreria> parametrotesorerias) throws Exception {
		try	{			
			for(ParametroTesoreria parametrotesoreriaLocal:parametrotesorerias) {
				if(parametrotesoreriaLocal.getId().equals(parametrotesoreria.getId())) {
					parametrotesoreriaLocal.setIsSelected(parametrotesoreria.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroTesoreria(List<ParametroTesoreria> parametrotesoreriasAux) throws Exception {
		//this.parametrotesoreriasAux=parametrotesoreriasAux;
		
		for(ParametroTesoreria parametrotesoreriaAux:parametrotesoreriasAux) {
			if(parametrotesoreriaAux.getIsChanged()) {
				parametrotesoreriaAux.setIsChanged(false);
			}		
			
			if(parametrotesoreriaAux.getIsNew()) {
				parametrotesoreriaAux.setIsNew(false);
			}	
			
			if(parametrotesoreriaAux.getIsDeleted()) {
				parametrotesoreriaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroTesoreria(ParametroTesoreria parametrotesoreriaAux) throws Exception {
		//this.parametrotesoreriaAux=parametrotesoreriaAux;
		
			if(parametrotesoreriaAux.getIsChanged()) {
				parametrotesoreriaAux.setIsChanged(false);
			}		
			
			if(parametrotesoreriaAux.getIsNew()) {
				parametrotesoreriaAux.setIsNew(false);
			}	
			
			if(parametrotesoreriaAux.getIsDeleted()) {
				parametrotesoreriaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroTesoreria parametrotesoreriaAsignar,ParametroTesoreria parametrotesoreria) throws Exception {
		parametrotesoreriaAsignar.setId(parametrotesoreria.getId());	
		parametrotesoreriaAsignar.setVersionRow(parametrotesoreria.getVersionRow());	
		parametrotesoreriaAsignar.setid_empresa(parametrotesoreria.getid_empresa());
		parametrotesoreriaAsignar.setempresa_descripcion(parametrotesoreria.getempresa_descripcion());	
		parametrotesoreriaAsignar.setcon_anticipo_orden_compra(parametrotesoreria.getcon_anticipo_orden_compra());	
		parametrotesoreriaAsignar.setpor_lotes(parametrotesoreria.getpor_lotes());	
		parametrotesoreriaAsignar.setid_transaccion_cobrar_pago(parametrotesoreria.getid_transaccion_cobrar_pago());
		parametrotesoreriaAsignar.settransaccioncobrarpago_descripcion(parametrotesoreria.gettransaccioncobrarpago_descripcion());	
		parametrotesoreriaAsignar.setid_transaccion_cobrar_debito(parametrotesoreria.getid_transaccion_cobrar_debito());
		parametrotesoreriaAsignar.settransaccioncobrardebito_descripcion(parametrotesoreria.gettransaccioncobrardebito_descripcion());	
		parametrotesoreriaAsignar.setid_transaccion_cobrar_credito(parametrotesoreria.getid_transaccion_cobrar_credito());
		parametrotesoreriaAsignar.settransaccioncobrarcredito_descripcion(parametrotesoreria.gettransaccioncobrarcredito_descripcion());	
		parametrotesoreriaAsignar.setid_transaccion_pagar_pago(parametrotesoreria.getid_transaccion_pagar_pago());
		parametrotesoreriaAsignar.settransaccionpagarpago_descripcion(parametrotesoreria.gettransaccionpagarpago_descripcion());	
		parametrotesoreriaAsignar.setid_transaccion_pagar_debito(parametrotesoreria.getid_transaccion_pagar_debito());
		parametrotesoreriaAsignar.settransaccionpagardebito_descripcion(parametrotesoreria.gettransaccionpagardebito_descripcion());	
		parametrotesoreriaAsignar.setid_transaccion_pagar_credito(parametrotesoreria.getid_transaccion_pagar_credito());
		parametrotesoreriaAsignar.settransaccionpagarcredito_descripcion(parametrotesoreria.gettransaccionpagarcredito_descripcion());	
		parametrotesoreriaAsignar.setdescripcion(parametrotesoreria.getdescripcion());	
	}
	
	public static void inicializarParametroTesoreria(ParametroTesoreria parametrotesoreria) throws Exception {
		try {
				parametrotesoreria.setId(0L);	
					
				parametrotesoreria.setid_empresa(-1L);	
				parametrotesoreria.setcon_anticipo_orden_compra(false);	
				parametrotesoreria.setpor_lotes(false);	
				parametrotesoreria.setid_transaccion_cobrar_pago(-1L);	
				parametrotesoreria.setid_transaccion_cobrar_debito(-1L);	
				parametrotesoreria.setid_transaccion_cobrar_credito(-1L);	
				parametrotesoreria.setid_transaccion_pagar_pago(-1L);	
				parametrotesoreria.setid_transaccion_pagar_debito(-1L);	
				parametrotesoreria.setid_transaccion_pagar_credito(-1L);	
				parametrotesoreria.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroTesoreria(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_CONANTICIPOORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_PORLOTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONCOBRARCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_IDTRANSACCIONPAGARCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroTesoreria(String sTipo,Row row,Workbook workbook,ParametroTesoreria parametrotesoreria,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrotesoreria.getcon_anticipo_orden_compra()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrotesoreria.getpor_lotes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccioncobrarpago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccioncobrardebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccioncobrarcredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccionpagarpago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccionpagardebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.gettransaccionpagarcredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreria.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroTesoreria=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroTesoreria() {
		return this.sFinalQueryParametroTesoreria;
	}
	
	public void setsFinalQueryParametroTesoreria(String sFinalQueryParametroTesoreria) {
		this.sFinalQueryParametroTesoreria= sFinalQueryParametroTesoreria;
	}
	
	public Border resaltarSeleccionarParametroTesoreria=null;
	
	public Border setResaltarSeleccionarParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroTesoreria= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroTesoreria() {
		return this.resaltarSeleccionarParametroTesoreria;
	}
	
	public void setResaltarSeleccionarParametroTesoreria(Border borderResaltarSeleccionarParametroTesoreria) {
		this.resaltarSeleccionarParametroTesoreria= borderResaltarSeleccionarParametroTesoreria;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroTesoreria=null;
	public Boolean mostraridParametroTesoreria=true;
	public Boolean activaridParametroTesoreria=true;

	public Border resaltarid_empresaParametroTesoreria=null;
	public Boolean mostrarid_empresaParametroTesoreria=true;
	public Boolean activarid_empresaParametroTesoreria=true;
	public Boolean cargarid_empresaParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarcon_anticipo_orden_compraParametroTesoreria=null;
	public Boolean mostrarcon_anticipo_orden_compraParametroTesoreria=true;
	public Boolean activarcon_anticipo_orden_compraParametroTesoreria=true;

	public Border resaltarpor_lotesParametroTesoreria=null;
	public Boolean mostrarpor_lotesParametroTesoreria=true;
	public Boolean activarpor_lotesParametroTesoreria=true;

	public Border resaltarid_transaccion_cobrar_pagoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_cobrar_pagoParametroTesoreria=true;
	public Boolean activarid_transaccion_cobrar_pagoParametroTesoreria=true;
	public Boolean cargarid_transaccion_cobrar_pagoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cobrar_pagoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cobrar_debitoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_cobrar_debitoParametroTesoreria=true;
	public Boolean activarid_transaccion_cobrar_debitoParametroTesoreria=true;
	public Boolean cargarid_transaccion_cobrar_debitoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cobrar_debitoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarid_transaccion_cobrar_creditoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_cobrar_creditoParametroTesoreria=true;
	public Boolean activarid_transaccion_cobrar_creditoParametroTesoreria=true;
	public Boolean cargarid_transaccion_cobrar_creditoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_cobrar_creditoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarid_transaccion_pagar_pagoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_pagar_pagoParametroTesoreria=true;
	public Boolean activarid_transaccion_pagar_pagoParametroTesoreria=true;
	public Boolean cargarid_transaccion_pagar_pagoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_pagar_pagoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarid_transaccion_pagar_debitoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_pagar_debitoParametroTesoreria=true;
	public Boolean activarid_transaccion_pagar_debitoParametroTesoreria=true;
	public Boolean cargarid_transaccion_pagar_debitoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_pagar_debitoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltarid_transaccion_pagar_creditoParametroTesoreria=null;
	public Boolean mostrarid_transaccion_pagar_creditoParametroTesoreria=true;
	public Boolean activarid_transaccion_pagar_creditoParametroTesoreria=true;
	public Boolean cargarid_transaccion_pagar_creditoParametroTesoreria=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_pagar_creditoParametroTesoreria=false;//ConEventDepend=true

	public Border resaltardescripcionParametroTesoreria=null;
	public Boolean mostrardescripcionParametroTesoreria=true;
	public Boolean activardescripcionParametroTesoreria=true;

	
	

	public Border setResaltaridParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltaridParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroTesoreria() {
		return this.resaltaridParametroTesoreria;
	}

	public void setResaltaridParametroTesoreria(Border borderResaltar) {
		this.resaltaridParametroTesoreria= borderResaltar;
	}

	public Boolean getMostraridParametroTesoreria() {
		return this.mostraridParametroTesoreria;
	}

	public void setMostraridParametroTesoreria(Boolean mostraridParametroTesoreria) {
		this.mostraridParametroTesoreria= mostraridParametroTesoreria;
	}

	public Boolean getActivaridParametroTesoreria() {
		return this.activaridParametroTesoreria;
	}

	public void setActivaridParametroTesoreria(Boolean activaridParametroTesoreria) {
		this.activaridParametroTesoreria= activaridParametroTesoreria;
	}

	public Border setResaltarid_empresaParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroTesoreria() {
		return this.resaltarid_empresaParametroTesoreria;
	}

	public void setResaltarid_empresaParametroTesoreria(Border borderResaltar) {
		this.resaltarid_empresaParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroTesoreria() {
		return this.mostrarid_empresaParametroTesoreria;
	}

	public void setMostrarid_empresaParametroTesoreria(Boolean mostrarid_empresaParametroTesoreria) {
		this.mostrarid_empresaParametroTesoreria= mostrarid_empresaParametroTesoreria;
	}

	public Boolean getActivarid_empresaParametroTesoreria() {
		return this.activarid_empresaParametroTesoreria;
	}

	public void setActivarid_empresaParametroTesoreria(Boolean activarid_empresaParametroTesoreria) {
		this.activarid_empresaParametroTesoreria= activarid_empresaParametroTesoreria;
	}

	public Boolean getCargarid_empresaParametroTesoreria() {
		return this.cargarid_empresaParametroTesoreria;
	}

	public void setCargarid_empresaParametroTesoreria(Boolean cargarid_empresaParametroTesoreria) {
		this.cargarid_empresaParametroTesoreria= cargarid_empresaParametroTesoreria;
	}

	public Border setResaltarcon_anticipo_orden_compraParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarcon_anticipo_orden_compraParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_anticipo_orden_compraParametroTesoreria() {
		return this.resaltarcon_anticipo_orden_compraParametroTesoreria;
	}

	public void setResaltarcon_anticipo_orden_compraParametroTesoreria(Border borderResaltar) {
		this.resaltarcon_anticipo_orden_compraParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarcon_anticipo_orden_compraParametroTesoreria() {
		return this.mostrarcon_anticipo_orden_compraParametroTesoreria;
	}

	public void setMostrarcon_anticipo_orden_compraParametroTesoreria(Boolean mostrarcon_anticipo_orden_compraParametroTesoreria) {
		this.mostrarcon_anticipo_orden_compraParametroTesoreria= mostrarcon_anticipo_orden_compraParametroTesoreria;
	}

	public Boolean getActivarcon_anticipo_orden_compraParametroTesoreria() {
		return this.activarcon_anticipo_orden_compraParametroTesoreria;
	}

	public void setActivarcon_anticipo_orden_compraParametroTesoreria(Boolean activarcon_anticipo_orden_compraParametroTesoreria) {
		this.activarcon_anticipo_orden_compraParametroTesoreria= activarcon_anticipo_orden_compraParametroTesoreria;
	}

	public Border setResaltarpor_lotesParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarpor_lotesParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpor_lotesParametroTesoreria() {
		return this.resaltarpor_lotesParametroTesoreria;
	}

	public void setResaltarpor_lotesParametroTesoreria(Border borderResaltar) {
		this.resaltarpor_lotesParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarpor_lotesParametroTesoreria() {
		return this.mostrarpor_lotesParametroTesoreria;
	}

	public void setMostrarpor_lotesParametroTesoreria(Boolean mostrarpor_lotesParametroTesoreria) {
		this.mostrarpor_lotesParametroTesoreria= mostrarpor_lotesParametroTesoreria;
	}

	public Boolean getActivarpor_lotesParametroTesoreria() {
		return this.activarpor_lotesParametroTesoreria;
	}

	public void setActivarpor_lotesParametroTesoreria(Boolean activarpor_lotesParametroTesoreria) {
		this.activarpor_lotesParametroTesoreria= activarpor_lotesParametroTesoreria;
	}

	public Border setResaltarid_transaccion_cobrar_pagoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cobrar_pagoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cobrar_pagoParametroTesoreria() {
		return this.resaltarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public void setResaltarid_transaccion_cobrar_pagoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_cobrar_pagoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cobrar_pagoParametroTesoreria() {
		return this.mostrarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public void setMostrarid_transaccion_cobrar_pagoParametroTesoreria(Boolean mostrarid_transaccion_cobrar_pagoParametroTesoreria) {
		this.mostrarid_transaccion_cobrar_pagoParametroTesoreria= mostrarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_cobrar_pagoParametroTesoreria() {
		return this.activarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public void setActivarid_transaccion_cobrar_pagoParametroTesoreria(Boolean activarid_transaccion_cobrar_pagoParametroTesoreria) {
		this.activarid_transaccion_cobrar_pagoParametroTesoreria= activarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_cobrar_pagoParametroTesoreria() {
		return this.cargarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public void setCargarid_transaccion_cobrar_pagoParametroTesoreria(Boolean cargarid_transaccion_cobrar_pagoParametroTesoreria) {
		this.cargarid_transaccion_cobrar_pagoParametroTesoreria= cargarid_transaccion_cobrar_pagoParametroTesoreria;
	}

	public Border setResaltarid_transaccion_cobrar_debitoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cobrar_debitoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cobrar_debitoParametroTesoreria() {
		return this.resaltarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public void setResaltarid_transaccion_cobrar_debitoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_cobrar_debitoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cobrar_debitoParametroTesoreria() {
		return this.mostrarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public void setMostrarid_transaccion_cobrar_debitoParametroTesoreria(Boolean mostrarid_transaccion_cobrar_debitoParametroTesoreria) {
		this.mostrarid_transaccion_cobrar_debitoParametroTesoreria= mostrarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_cobrar_debitoParametroTesoreria() {
		return this.activarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public void setActivarid_transaccion_cobrar_debitoParametroTesoreria(Boolean activarid_transaccion_cobrar_debitoParametroTesoreria) {
		this.activarid_transaccion_cobrar_debitoParametroTesoreria= activarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_cobrar_debitoParametroTesoreria() {
		return this.cargarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public void setCargarid_transaccion_cobrar_debitoParametroTesoreria(Boolean cargarid_transaccion_cobrar_debitoParametroTesoreria) {
		this.cargarid_transaccion_cobrar_debitoParametroTesoreria= cargarid_transaccion_cobrar_debitoParametroTesoreria;
	}

	public Border setResaltarid_transaccion_cobrar_creditoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_cobrar_creditoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_cobrar_creditoParametroTesoreria() {
		return this.resaltarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public void setResaltarid_transaccion_cobrar_creditoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_cobrar_creditoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_cobrar_creditoParametroTesoreria() {
		return this.mostrarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public void setMostrarid_transaccion_cobrar_creditoParametroTesoreria(Boolean mostrarid_transaccion_cobrar_creditoParametroTesoreria) {
		this.mostrarid_transaccion_cobrar_creditoParametroTesoreria= mostrarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_cobrar_creditoParametroTesoreria() {
		return this.activarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public void setActivarid_transaccion_cobrar_creditoParametroTesoreria(Boolean activarid_transaccion_cobrar_creditoParametroTesoreria) {
		this.activarid_transaccion_cobrar_creditoParametroTesoreria= activarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_cobrar_creditoParametroTesoreria() {
		return this.cargarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public void setCargarid_transaccion_cobrar_creditoParametroTesoreria(Boolean cargarid_transaccion_cobrar_creditoParametroTesoreria) {
		this.cargarid_transaccion_cobrar_creditoParametroTesoreria= cargarid_transaccion_cobrar_creditoParametroTesoreria;
	}

	public Border setResaltarid_transaccion_pagar_pagoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_pagar_pagoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_pagar_pagoParametroTesoreria() {
		return this.resaltarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public void setResaltarid_transaccion_pagar_pagoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_pagar_pagoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_pagar_pagoParametroTesoreria() {
		return this.mostrarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public void setMostrarid_transaccion_pagar_pagoParametroTesoreria(Boolean mostrarid_transaccion_pagar_pagoParametroTesoreria) {
		this.mostrarid_transaccion_pagar_pagoParametroTesoreria= mostrarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_pagar_pagoParametroTesoreria() {
		return this.activarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public void setActivarid_transaccion_pagar_pagoParametroTesoreria(Boolean activarid_transaccion_pagar_pagoParametroTesoreria) {
		this.activarid_transaccion_pagar_pagoParametroTesoreria= activarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_pagar_pagoParametroTesoreria() {
		return this.cargarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public void setCargarid_transaccion_pagar_pagoParametroTesoreria(Boolean cargarid_transaccion_pagar_pagoParametroTesoreria) {
		this.cargarid_transaccion_pagar_pagoParametroTesoreria= cargarid_transaccion_pagar_pagoParametroTesoreria;
	}

	public Border setResaltarid_transaccion_pagar_debitoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_pagar_debitoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_pagar_debitoParametroTesoreria() {
		return this.resaltarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public void setResaltarid_transaccion_pagar_debitoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_pagar_debitoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_pagar_debitoParametroTesoreria() {
		return this.mostrarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public void setMostrarid_transaccion_pagar_debitoParametroTesoreria(Boolean mostrarid_transaccion_pagar_debitoParametroTesoreria) {
		this.mostrarid_transaccion_pagar_debitoParametroTesoreria= mostrarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_pagar_debitoParametroTesoreria() {
		return this.activarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public void setActivarid_transaccion_pagar_debitoParametroTesoreria(Boolean activarid_transaccion_pagar_debitoParametroTesoreria) {
		this.activarid_transaccion_pagar_debitoParametroTesoreria= activarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_pagar_debitoParametroTesoreria() {
		return this.cargarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public void setCargarid_transaccion_pagar_debitoParametroTesoreria(Boolean cargarid_transaccion_pagar_debitoParametroTesoreria) {
		this.cargarid_transaccion_pagar_debitoParametroTesoreria= cargarid_transaccion_pagar_debitoParametroTesoreria;
	}

	public Border setResaltarid_transaccion_pagar_creditoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_pagar_creditoParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_pagar_creditoParametroTesoreria() {
		return this.resaltarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public void setResaltarid_transaccion_pagar_creditoParametroTesoreria(Border borderResaltar) {
		this.resaltarid_transaccion_pagar_creditoParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_pagar_creditoParametroTesoreria() {
		return this.mostrarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public void setMostrarid_transaccion_pagar_creditoParametroTesoreria(Boolean mostrarid_transaccion_pagar_creditoParametroTesoreria) {
		this.mostrarid_transaccion_pagar_creditoParametroTesoreria= mostrarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public Boolean getActivarid_transaccion_pagar_creditoParametroTesoreria() {
		return this.activarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public void setActivarid_transaccion_pagar_creditoParametroTesoreria(Boolean activarid_transaccion_pagar_creditoParametroTesoreria) {
		this.activarid_transaccion_pagar_creditoParametroTesoreria= activarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public Boolean getCargarid_transaccion_pagar_creditoParametroTesoreria() {
		return this.cargarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public void setCargarid_transaccion_pagar_creditoParametroTesoreria(Boolean cargarid_transaccion_pagar_creditoParametroTesoreria) {
		this.cargarid_transaccion_pagar_creditoParametroTesoreria= cargarid_transaccion_pagar_creditoParametroTesoreria;
	}

	public Border setResaltardescripcionParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriaBeanSwingJInternalFrame.jTtoolBarParametroTesoreria.setBorder(borderResaltar);
		
		this.resaltardescripcionParametroTesoreria= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionParametroTesoreria() {
		return this.resaltardescripcionParametroTesoreria;
	}

	public void setResaltardescripcionParametroTesoreria(Border borderResaltar) {
		this.resaltardescripcionParametroTesoreria= borderResaltar;
	}

	public Boolean getMostrardescripcionParametroTesoreria() {
		return this.mostrardescripcionParametroTesoreria;
	}

	public void setMostrardescripcionParametroTesoreria(Boolean mostrardescripcionParametroTesoreria) {
		this.mostrardescripcionParametroTesoreria= mostrardescripcionParametroTesoreria;
	}

	public Boolean getActivardescripcionParametroTesoreria() {
		return this.activardescripcionParametroTesoreria;
	}

	public void setActivardescripcionParametroTesoreria(Boolean activardescripcionParametroTesoreria) {
		this.activardescripcionParametroTesoreria= activardescripcionParametroTesoreria;
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
		
		
		this.setMostraridParametroTesoreria(esInicial);
		this.setMostrarid_empresaParametroTesoreria(esInicial);
		this.setMostrarcon_anticipo_orden_compraParametroTesoreria(esInicial);
		this.setMostrarpor_lotesParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_cobrar_pagoParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_cobrar_debitoParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_cobrar_creditoParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_pagar_pagoParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_pagar_debitoParametroTesoreria(esInicial);
		this.setMostrarid_transaccion_pagar_creditoParametroTesoreria(esInicial);
		this.setMostrardescripcionParametroTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.ID)) {
				this.setMostraridParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA)) {
				this.setMostrarcon_anticipo_orden_compraParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.PORLOTES)) {
				this.setMostrarpor_lotesParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO)) {
				this.setMostrarid_transaccion_cobrar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO)) {
				this.setMostrarid_transaccion_cobrar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO)) {
				this.setMostrarid_transaccion_cobrar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO)) {
				this.setMostrarid_transaccion_pagar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO)) {
				this.setMostrarid_transaccion_pagar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO)) {
				this.setMostrarid_transaccion_pagar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionParametroTesoreria(esAsigna);
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
		
		
		this.setActivaridParametroTesoreria(esInicial);
		this.setActivarid_empresaParametroTesoreria(esInicial);
		this.setActivarcon_anticipo_orden_compraParametroTesoreria(esInicial);
		this.setActivarpor_lotesParametroTesoreria(esInicial);
		this.setActivarid_transaccion_cobrar_pagoParametroTesoreria(esInicial);
		this.setActivarid_transaccion_cobrar_debitoParametroTesoreria(esInicial);
		this.setActivarid_transaccion_cobrar_creditoParametroTesoreria(esInicial);
		this.setActivarid_transaccion_pagar_pagoParametroTesoreria(esInicial);
		this.setActivarid_transaccion_pagar_debitoParametroTesoreria(esInicial);
		this.setActivarid_transaccion_pagar_creditoParametroTesoreria(esInicial);
		this.setActivardescripcionParametroTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.ID)) {
				this.setActivaridParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA)) {
				this.setActivarcon_anticipo_orden_compraParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.PORLOTES)) {
				this.setActivarpor_lotesParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO)) {
				this.setActivarid_transaccion_cobrar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO)) {
				this.setActivarid_transaccion_cobrar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO)) {
				this.setActivarid_transaccion_cobrar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO)) {
				this.setActivarid_transaccion_pagar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO)) {
				this.setActivarid_transaccion_pagar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO)) {
				this.setActivarid_transaccion_pagar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionParametroTesoreria(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroTesoreria(esInicial);
		this.setResaltarid_empresaParametroTesoreria(esInicial);
		this.setResaltarcon_anticipo_orden_compraParametroTesoreria(esInicial);
		this.setResaltarpor_lotesParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_cobrar_pagoParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_cobrar_debitoParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_cobrar_creditoParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_pagar_pagoParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_pagar_debitoParametroTesoreria(esInicial);
		this.setResaltarid_transaccion_pagar_creditoParametroTesoreria(esInicial);
		this.setResaltardescripcionParametroTesoreria(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.ID)) {
				this.setResaltaridParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA)) {
				this.setResaltarcon_anticipo_orden_compraParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.PORLOTES)) {
				this.setResaltarpor_lotesParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO)) {
				this.setResaltarid_transaccion_cobrar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO)) {
				this.setResaltarid_transaccion_cobrar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO)) {
				this.setResaltarid_transaccion_cobrar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO)) {
				this.setResaltarid_transaccion_pagar_pagoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO)) {
				this.setResaltarid_transaccion_pagar_debitoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO)) {
				this.setResaltarid_transaccion_pagar_creditoParametroTesoreria(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionParametroTesoreria(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroTesoreria=true;

	public Boolean getMostrarFK_IdEmpresaParametroTesoreria() {
		return this.mostrarFK_IdEmpresaParametroTesoreria;
	}

	public void setMostrarFK_IdEmpresaParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCobrarCreditoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionCobrarCreditoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionCobrarCreditoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionCobrarCreditoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCobrarCreditoParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCobrarDebitoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionCobrarDebitoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionCobrarDebitoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionCobrarDebitoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCobrarDebitoParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCobrarPagoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionCobrarPagoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionCobrarPagoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionCobrarPagoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCobrarPagoParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionPagarCreditoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionPagarCreditoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionPagarCreditoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionPagarCreditoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionPagarCreditoParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionPagarDebitoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionPagarDebitoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionPagarDebitoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionPagarDebitoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionPagarDebitoParametroTesoreria= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionPagarPagoParametroTesoreria=true;

	public Boolean getMostrarFK_IdTransaccionPagarPagoParametroTesoreria() {
		return this.mostrarFK_IdTransaccionPagarPagoParametroTesoreria;
	}

	public void setMostrarFK_IdTransaccionPagarPagoParametroTesoreria(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionPagarPagoParametroTesoreria= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroTesoreria=true;

	public Boolean getActivarFK_IdEmpresaParametroTesoreria() {
		return this.activarFK_IdEmpresaParametroTesoreria;
	}

	public void setActivarFK_IdEmpresaParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCobrarCreditoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionCobrarCreditoParametroTesoreria() {
		return this.activarFK_IdTransaccionCobrarCreditoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionCobrarCreditoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCobrarCreditoParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCobrarDebitoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionCobrarDebitoParametroTesoreria() {
		return this.activarFK_IdTransaccionCobrarDebitoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionCobrarDebitoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCobrarDebitoParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCobrarPagoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionCobrarPagoParametroTesoreria() {
		return this.activarFK_IdTransaccionCobrarPagoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionCobrarPagoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCobrarPagoParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionPagarCreditoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionPagarCreditoParametroTesoreria() {
		return this.activarFK_IdTransaccionPagarCreditoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionPagarCreditoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionPagarCreditoParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionPagarDebitoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionPagarDebitoParametroTesoreria() {
		return this.activarFK_IdTransaccionPagarDebitoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionPagarDebitoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionPagarDebitoParametroTesoreria= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionPagarPagoParametroTesoreria=true;

	public Boolean getActivarFK_IdTransaccionPagarPagoParametroTesoreria() {
		return this.activarFK_IdTransaccionPagarPagoParametroTesoreria;
	}

	public void setActivarFK_IdTransaccionPagarPagoParametroTesoreria(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionPagarPagoParametroTesoreria= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroTesoreria=null;

	public Border getResaltarFK_IdEmpresaParametroTesoreria() {
		return this.resaltarFK_IdEmpresaParametroTesoreria;
	}

	public void setResaltarFK_IdEmpresaParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCobrarCreditoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionCobrarCreditoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionCobrarCreditoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionCobrarCreditoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCobrarCreditoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCobrarCreditoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCobrarCreditoParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCobrarDebitoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionCobrarDebitoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionCobrarDebitoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionCobrarDebitoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCobrarDebitoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCobrarDebitoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCobrarDebitoParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCobrarPagoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionCobrarPagoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionCobrarPagoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionCobrarPagoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCobrarPagoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCobrarPagoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCobrarPagoParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionPagarCreditoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionPagarCreditoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionPagarCreditoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionPagarCreditoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionPagarCreditoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionPagarCreditoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionPagarCreditoParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionPagarDebitoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionPagarDebitoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionPagarDebitoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionPagarDebitoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionPagarDebitoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionPagarDebitoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionPagarDebitoParametroTesoreria= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionPagarPagoParametroTesoreria=null;

	public Border getResaltarFK_IdTransaccionPagarPagoParametroTesoreria() {
		return this.resaltarFK_IdTransaccionPagarPagoParametroTesoreria;
	}

	public void setResaltarFK_IdTransaccionPagarPagoParametroTesoreria(Border borderResaltar) {
		this.resaltarFK_IdTransaccionPagarPagoParametroTesoreria= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionPagarPagoParametroTesoreria(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaBeanSwingJInternalFrame parametrotesoreriaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionPagarPagoParametroTesoreria= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}