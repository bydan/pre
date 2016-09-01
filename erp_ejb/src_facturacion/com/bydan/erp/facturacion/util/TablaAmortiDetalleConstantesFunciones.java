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


import com.bydan.erp.facturacion.util.TablaAmortiDetalleConstantesFunciones;
import com.bydan.erp.facturacion.util.TablaAmortiDetalleParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TablaAmortiDetalleParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TablaAmortiDetalleConstantesFunciones extends TablaAmortiDetalleConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TablaAmortiDetalle";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TablaAmortiDetalle"+TablaAmortiDetalleConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TablaAmortiDetalleHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TablaAmortiDetalleHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TablaAmortiDetalleConstantesFunciones.SCHEMA+"_"+TablaAmortiDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TablaAmortiDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TablaAmortiDetalleConstantesFunciones.SCHEMA+"_"+TablaAmortiDetalleConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TablaAmortiDetalleConstantesFunciones.SCHEMA+"_"+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TablaAmortiDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TablaAmortiDetalleConstantesFunciones.SCHEMA+"_"+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaAmortiDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaAmortiDetalleHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiDetalleConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TablaAmortiDetalleConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TablaAmortiDetalleConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TablaAmortiDetalleConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TablaAmortiDetalleConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tabla Amortizacion Detalles";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tabla Amortizacion Detalle";
	public static final String SCLASSWEBTITULO_LOWER="Tabla Amorti Detalle";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TablaAmortiDetalle";
	public static final String OBJECTNAME="tablaamortidetalle";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tabla_amorti_detalle";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tablaamortidetalle from "+TablaAmortiDetalleConstantesFunciones.SPERSISTENCENAME+" tablaamortidetalle";
	public static String QUERYSELECTNATIVE="select "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".version_row,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_empresa,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_ejercicio,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_periodo,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_tasa,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_factura,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_emision,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_vencimiento,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_inicial,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_final,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".valor,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".interes,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".capital,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".numero_cuotas,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_anio,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_mes from "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME;//+" as "+TablaAmortiDetalleConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TablaAmortiDetalleConstantesFuncionesAdditional tablaamortidetalleConstantesFuncionesAdditional=null;
	
	public TablaAmortiDetalleConstantesFuncionesAdditional getTablaAmortiDetalleConstantesFuncionesAdditional() {
		return this.tablaamortidetalleConstantesFuncionesAdditional;
	}
	
	public void setTablaAmortiDetalleConstantesFuncionesAdditional(TablaAmortiDetalleConstantesFuncionesAdditional tablaamortidetalleConstantesFuncionesAdditional) {
		try {
			this.tablaamortidetalleConstantesFuncionesAdditional=tablaamortidetalleConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDTASA= "id_tasa";
    public static final String IDFACTURA= "id_factura";
    public static final String IDTIPOINTERVALO= "id_tipo_intervalo";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String FECHAINICIAL= "fecha_inicial";
    public static final String FECHAFINAL= "fecha_final";
    public static final String VALOR= "valor";
    public static final String INTERES= "interes";
    public static final String CAPITAL= "capital";
    public static final String NUMEROCUOTA= "numero_cuotas";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDTASA= "Tasa";
		public static final String LABEL_IDTASA_LOWER= "Tasa";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDTIPOINTERVALO= "Tipo Intervalo";
		public static final String LABEL_IDTIPOINTERVALO_LOWER= "Tipo Intervalo";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_FECHAINICIAL= "Fecha Inicial";
		public static final String LABEL_FECHAINICIAL_LOWER= "Fecha Inicial";
    	public static final String LABEL_FECHAFINAL= "Fecha Final";
		public static final String LABEL_FECHAFINAL_LOWER= "Fecha Final";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_INTERES= "Interes";
		public static final String LABEL_INTERES_LOWER= "Interes";
    	public static final String LABEL_CAPITAL= "Capital";
		public static final String LABEL_CAPITAL_LOWER= "Capital";
    	public static final String LABEL_NUMEROCUOTA= "Numero Cuotas";
		public static final String LABEL_NUMEROCUOTA_LOWER= "Numero Cuota";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getTablaAmortiDetalleLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDEMPRESA)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDPERIODO)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDTASA)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDTASA;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDFACTURA)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDTIPOINTERVALO;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.FECHAEMISION)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.FECHAINICIAL)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_FECHAINICIAL;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.FECHAFINAL)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_FECHAFINAL;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.VALOR)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.INTERES)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_INTERES;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.CAPITAL)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_NUMEROCUOTA;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDANIO)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(TablaAmortiDetalleConstantesFunciones.IDMES)) {sLabelColumna=TablaAmortiDetalleConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTablaAmortiDetalleDescripcion(TablaAmortiDetalle tablaamortidetalle) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tablaamortidetalle !=null/* && tablaamortidetalle.getId()!=0*/) {
			if(tablaamortidetalle.getId()!=null) {
				sDescripcion=tablaamortidetalle.getId().toString();
			}//tablaamortidetalletablaamortidetalle.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTablaAmortiDetalleDescripcionDetallado(TablaAmortiDetalle tablaamortidetalle) {
		String sDescripcion="";
			
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.ID+"=";
		sDescripcion+=tablaamortidetalle.getId().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tablaamortidetalle.getVersionRow().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tablaamortidetalle.getid_empresa().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tablaamortidetalle.getid_sucursal().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=tablaamortidetalle.getid_ejercicio().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=tablaamortidetalle.getid_periodo().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDTASA+"=";
		sDescripcion+=tablaamortidetalle.getid_tasa().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=tablaamortidetalle.getid_factura().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO+"=";
		sDescripcion+=tablaamortidetalle.getid_tipo_intervalo().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=tablaamortidetalle.getfecha_emision().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=tablaamortidetalle.getfecha_vencimiento().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.FECHAINICIAL+"=";
		sDescripcion+=tablaamortidetalle.getfecha_inicial().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.FECHAFINAL+"=";
		sDescripcion+=tablaamortidetalle.getfecha_final().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.VALOR+"=";
		sDescripcion+=tablaamortidetalle.getvalor().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.INTERES+"=";
		sDescripcion+=tablaamortidetalle.getinteres().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.CAPITAL+"=";
		sDescripcion+=tablaamortidetalle.getcapital().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA+"=";
		sDescripcion+=tablaamortidetalle.getnumero_cuotas().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDANIO+"=";
		sDescripcion+=tablaamortidetalle.getid_anio().toString()+",";
		sDescripcion+=TablaAmortiDetalleConstantesFunciones.IDMES+"=";
		sDescripcion+=tablaamortidetalle.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTablaAmortiDetalleDescripcion(TablaAmortiDetalle tablaamortidetalle,String sValor) throws Exception {			
		if(tablaamortidetalle !=null) {
			//tablaamortidetalletablaamortidetalle.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getTasaDescripcion(Tasa tasa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tasa!=null/*&&tasa.getId()>0*/) {
			sDescripcion=TasaConstantesFunciones.getTasaDescripcion(tasa);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTasa")) {
			sNombreIndice="Tipo=  Por Tasa";
		} else if(sNombreIndice.equals("FK_IdTipoIntervalo")) {
			sNombreIndice="Tipo=  Por Tipo Intervalo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTasa(Long id_tasa) {
		String sDetalleIndice=" Parametros->";
		if(id_tasa!=null) {sDetalleIndice+=" Codigo Unico De Tasa="+id_tasa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIntervalo(Long id_tipo_intervalo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_intervalo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Intervalo="+id_tipo_intervalo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTablaAmortiDetalles(List<TablaAmortiDetalle> tablaamortidetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TablaAmortiDetalle tablaamortidetalle: tablaamortidetalles) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tablaamortidetalle.getConCambioAuxiliar()) {
			tablaamortidetalle.setIsDeleted(tablaamortidetalle.getIsDeletedAuxiliar());	
			tablaamortidetalle.setIsNew(tablaamortidetalle.getIsNewAuxiliar());	
			tablaamortidetalle.setIsChanged(tablaamortidetalle.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tablaamortidetalle.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tablaamortidetalle.setIsDeletedAuxiliar(false);	
			tablaamortidetalle.setIsNewAuxiliar(false);	
			tablaamortidetalle.setIsChangedAuxiliar(false);
			
			tablaamortidetalle.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaAmortiDetalles(List<TablaAmortiDetalle> tablaamortidetalles,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TablaAmortiDetalle tablaamortidetalle : tablaamortidetalles) {
			if(conAsignarBase && tablaamortidetalle.getConCambioAuxiliar()) {
				tablaamortidetalle.setIsDeleted(tablaamortidetalle.getIsDeletedAuxiliar());	
				tablaamortidetalle.setIsNew(tablaamortidetalle.getIsNewAuxiliar());	
				tablaamortidetalle.setIsChanged(tablaamortidetalle.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tablaamortidetalle.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tablaamortidetalle.setIsDeletedAuxiliar(false);	
				tablaamortidetalle.setIsNewAuxiliar(false);	
				tablaamortidetalle.setIsChangedAuxiliar(false);
				
				tablaamortidetalle.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle,Boolean conEnteros) throws Exception  {
		tablaamortidetalle.setvalor(0.0);
		tablaamortidetalle.setinteres(0.0);
		tablaamortidetalle.setcapital(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			tablaamortidetalle.setnumero_cuotas(0);
		}
	}		
	
	public static void InicializarValoresTablaAmortiDetalles(List<TablaAmortiDetalle> tablaamortidetalles,Boolean conEnteros) throws Exception  {
		
		for(TablaAmortiDetalle tablaamortidetalle: tablaamortidetalles) {
			tablaamortidetalle.setvalor(0.0);
			tablaamortidetalle.setinteres(0.0);
			tablaamortidetalle.setcapital(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				tablaamortidetalle.setnumero_cuotas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTablaAmortiDetalle(List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalle tablaamortidetalleAux) throws Exception  {
		TablaAmortiDetalleConstantesFunciones.InicializarValoresTablaAmortiDetalle(tablaamortidetalleAux,true);
		
		for(TablaAmortiDetalle tablaamortidetalle: tablaamortidetalles) {
			if(tablaamortidetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tablaamortidetalleAux.setvalor(tablaamortidetalleAux.getvalor()+tablaamortidetalle.getvalor());			
			tablaamortidetalleAux.setinteres(tablaamortidetalleAux.getinteres()+tablaamortidetalle.getinteres());			
			tablaamortidetalleAux.setcapital(tablaamortidetalleAux.getcapital()+tablaamortidetalle.getcapital());			
			tablaamortidetalleAux.setnumero_cuotas(tablaamortidetalleAux.getnumero_cuotas()+tablaamortidetalle.getnumero_cuotas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaAmortiDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TablaAmortiDetalleConstantesFunciones.getArrayColumnasGlobalesTablaAmortiDetalle(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaAmortiDetalle(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiDetalleConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiDetalleConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiDetalleConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiDetalleConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTablaAmortiDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TablaAmortiDetalle> tablaamortidetalles,TablaAmortiDetalle tablaamortidetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TablaAmortiDetalle tablaamortidetalleAux: tablaamortidetalles) {
			if(tablaamortidetalleAux!=null && tablaamortidetalle!=null) {
				if((tablaamortidetalleAux.getId()==null && tablaamortidetalle.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tablaamortidetalleAux.getId()!=null && tablaamortidetalle.getId()!=null){
					if(tablaamortidetalleAux.getId().equals(tablaamortidetalle.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTablaAmortiDetalle(List<TablaAmortiDetalle> tablaamortidetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double interesTotal=0.0;
		Double capitalTotal=0.0;
	
		for(TablaAmortiDetalle tablaamortidetalle: tablaamortidetalles) {			
			if(tablaamortidetalle.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=tablaamortidetalle.getvalor();
			interesTotal+=tablaamortidetalle.getinteres();
			capitalTotal+=tablaamortidetalle.getcapital();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaAmortiDetalleConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaAmortiDetalleConstantesFunciones.INTERES);
		datoGeneral.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_INTERES);
		datoGeneral.setdValorDouble(interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaAmortiDetalleConstantesFunciones.CAPITAL);
		datoGeneral.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL);
		datoGeneral.setdValorDouble(capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTablaAmortiDetalle() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_ID, TablaAmortiDetalleConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_VERSIONROW, TablaAmortiDetalleConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDEMPRESA, TablaAmortiDetalleConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDSUCURSAL, TablaAmortiDetalleConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDEJERCICIO, TablaAmortiDetalleConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDPERIODO, TablaAmortiDetalleConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDTASA, TablaAmortiDetalleConstantesFunciones.IDTASA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDFACTURA, TablaAmortiDetalleConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDTIPOINTERVALO, TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_FECHAEMISION, TablaAmortiDetalleConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_FECHAVENCIMIENTO, TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_FECHAINICIAL, TablaAmortiDetalleConstantesFunciones.FECHAINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_FECHAFINAL, TablaAmortiDetalleConstantesFunciones.FECHAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_VALOR, TablaAmortiDetalleConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_INTERES, TablaAmortiDetalleConstantesFunciones.INTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL, TablaAmortiDetalleConstantesFunciones.CAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_NUMEROCUOTA, TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDANIO, TablaAmortiDetalleConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiDetalleConstantesFunciones.LABEL_IDMES, TablaAmortiDetalleConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTablaAmortiDetalle() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDTASA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.FECHAINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.FECHAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.INTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.CAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiDetalleConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmortiDetalle() throws Exception  {
		return TablaAmortiDetalleConstantesFunciones.getTiposSeleccionarTablaAmortiDetalle(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmortiDetalle(Boolean conFk) throws Exception  {
		return TablaAmortiDetalleConstantesFunciones.getTiposSeleccionarTablaAmortiDetalle(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmortiDetalle(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDTASA);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDTASA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDTIPOINTERVALO);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDTIPOINTERVALO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAINICIAL);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAFINAL);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_INTERES);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_INTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_NUMEROCUOTA);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_NUMEROCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiDetalleConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(TablaAmortiDetalleConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTablaAmortiDetalle(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalleAux) throws Exception {
		
			tablaamortidetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaamortidetalleAux.getEmpresa()));
			tablaamortidetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tablaamortidetalleAux.getSucursal()));
			tablaamortidetalleAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(tablaamortidetalleAux.getEjercicio()));
			tablaamortidetalleAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(tablaamortidetalleAux.getPeriodo()));
			tablaamortidetalleAux.settasa_descripcion(TasaConstantesFunciones.getTasaDescripcion(tablaamortidetalleAux.getTasa()));
			tablaamortidetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tablaamortidetalleAux.getFactura()));
			tablaamortidetalleAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(tablaamortidetalleAux.getTipoIntervalo()));
			tablaamortidetalleAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(tablaamortidetalleAux.getAnio()));
			tablaamortidetalleAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(tablaamortidetalleAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTablaAmortiDetalle(List<TablaAmortiDetalle> tablaamortidetallesTemp) throws Exception {
		for(TablaAmortiDetalle tablaamortidetalleAux:tablaamortidetallesTemp) {
			
			tablaamortidetalleAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaamortidetalleAux.getEmpresa()));
			tablaamortidetalleAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tablaamortidetalleAux.getSucursal()));
			tablaamortidetalleAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(tablaamortidetalleAux.getEjercicio()));
			tablaamortidetalleAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(tablaamortidetalleAux.getPeriodo()));
			tablaamortidetalleAux.settasa_descripcion(TasaConstantesFunciones.getTasaDescripcion(tablaamortidetalleAux.getTasa()));
			tablaamortidetalleAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tablaamortidetalleAux.getFactura()));
			tablaamortidetalleAux.settipointervalo_descripcion(TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(tablaamortidetalleAux.getTipoIntervalo()));
			tablaamortidetalleAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(tablaamortidetalleAux.getAnio()));
			tablaamortidetalleAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(tablaamortidetalleAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTablaAmortiDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Tasa.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(TipoIntervalo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Tasa.class)) {
						classes.add(new Classe(Tasa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIntervalo.class)) {
						classes.add(new Classe(TipoIntervalo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTablaAmortiDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Tasa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Tasa.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Tasa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Tasa.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoIntervalo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIntervalo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmortiDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaAmortiDetalleConstantesFunciones.getClassesRelationshipsOfTablaAmortiDetalle(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmortiDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaAmortiDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaAmortiDetalleConstantesFunciones.getClassesRelationshipsFromStringsOfTablaAmortiDetalle(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaAmortiDetalle(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TablaAmortiDetalle tablaamortidetalle,List<TablaAmortiDetalle> tablaamortidetalles,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TablaAmortiDetalle tablaamortidetalleEncontrado=null;
			
			for(TablaAmortiDetalle tablaamortidetalleLocal:tablaamortidetalles) {
				if(tablaamortidetalleLocal.getId().equals(tablaamortidetalle.getId())) {
					tablaamortidetalleEncontrado=tablaamortidetalleLocal;
					
					tablaamortidetalleLocal.setIsChanged(tablaamortidetalle.getIsChanged());
					tablaamortidetalleLocal.setIsNew(tablaamortidetalle.getIsNew());
					tablaamortidetalleLocal.setIsDeleted(tablaamortidetalle.getIsDeleted());
					
					tablaamortidetalleLocal.setGeneralEntityOriginal(tablaamortidetalle.getGeneralEntityOriginal());
					
					tablaamortidetalleLocal.setId(tablaamortidetalle.getId());	
					tablaamortidetalleLocal.setVersionRow(tablaamortidetalle.getVersionRow());	
					tablaamortidetalleLocal.setid_empresa(tablaamortidetalle.getid_empresa());	
					tablaamortidetalleLocal.setid_sucursal(tablaamortidetalle.getid_sucursal());	
					tablaamortidetalleLocal.setid_ejercicio(tablaamortidetalle.getid_ejercicio());	
					tablaamortidetalleLocal.setid_periodo(tablaamortidetalle.getid_periodo());	
					tablaamortidetalleLocal.setid_tasa(tablaamortidetalle.getid_tasa());	
					tablaamortidetalleLocal.setid_factura(tablaamortidetalle.getid_factura());	
					tablaamortidetalleLocal.setid_tipo_intervalo(tablaamortidetalle.getid_tipo_intervalo());	
					tablaamortidetalleLocal.setfecha_emision(tablaamortidetalle.getfecha_emision());	
					tablaamortidetalleLocal.setfecha_vencimiento(tablaamortidetalle.getfecha_vencimiento());	
					tablaamortidetalleLocal.setfecha_inicial(tablaamortidetalle.getfecha_inicial());	
					tablaamortidetalleLocal.setfecha_final(tablaamortidetalle.getfecha_final());	
					tablaamortidetalleLocal.setvalor(tablaamortidetalle.getvalor());	
					tablaamortidetalleLocal.setinteres(tablaamortidetalle.getinteres());	
					tablaamortidetalleLocal.setcapital(tablaamortidetalle.getcapital());	
					tablaamortidetalleLocal.setnumero_cuotas(tablaamortidetalle.getnumero_cuotas());	
					tablaamortidetalleLocal.setid_anio(tablaamortidetalle.getid_anio());	
					tablaamortidetalleLocal.setid_mes(tablaamortidetalle.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tablaamortidetalle.getIsDeleted()) {
				if(!existe) {
					tablaamortidetalles.add(tablaamortidetalle);
				}
			} else {
				if(tablaamortidetalleEncontrado!=null && permiteQuitar)  {
					tablaamortidetalles.remove(tablaamortidetalleEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TablaAmortiDetalle tablaamortidetalle,List<TablaAmortiDetalle> tablaamortidetalles) throws Exception {
		try	{			
			for(TablaAmortiDetalle tablaamortidetalleLocal:tablaamortidetalles) {
				if(tablaamortidetalleLocal.getId().equals(tablaamortidetalle.getId())) {
					tablaamortidetalleLocal.setIsSelected(tablaamortidetalle.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTablaAmortiDetalle(List<TablaAmortiDetalle> tablaamortidetallesAux) throws Exception {
		//this.tablaamortidetallesAux=tablaamortidetallesAux;
		
		for(TablaAmortiDetalle tablaamortidetalleAux:tablaamortidetallesAux) {
			if(tablaamortidetalleAux.getIsChanged()) {
				tablaamortidetalleAux.setIsChanged(false);
			}		
			
			if(tablaamortidetalleAux.getIsNew()) {
				tablaamortidetalleAux.setIsNew(false);
			}	
			
			if(tablaamortidetalleAux.getIsDeleted()) {
				tablaamortidetalleAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalleAux) throws Exception {
		//this.tablaamortidetalleAux=tablaamortidetalleAux;
		
			if(tablaamortidetalleAux.getIsChanged()) {
				tablaamortidetalleAux.setIsChanged(false);
			}		
			
			if(tablaamortidetalleAux.getIsNew()) {
				tablaamortidetalleAux.setIsNew(false);
			}	
			
			if(tablaamortidetalleAux.getIsDeleted()) {
				tablaamortidetalleAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TablaAmortiDetalle tablaamortidetalleAsignar,TablaAmortiDetalle tablaamortidetalle) throws Exception {
		tablaamortidetalleAsignar.setId(tablaamortidetalle.getId());	
		tablaamortidetalleAsignar.setVersionRow(tablaamortidetalle.getVersionRow());	
		tablaamortidetalleAsignar.setid_empresa(tablaamortidetalle.getid_empresa());
		tablaamortidetalleAsignar.setempresa_descripcion(tablaamortidetalle.getempresa_descripcion());	
		tablaamortidetalleAsignar.setid_sucursal(tablaamortidetalle.getid_sucursal());
		tablaamortidetalleAsignar.setsucursal_descripcion(tablaamortidetalle.getsucursal_descripcion());	
		tablaamortidetalleAsignar.setid_ejercicio(tablaamortidetalle.getid_ejercicio());
		tablaamortidetalleAsignar.setejercicio_descripcion(tablaamortidetalle.getejercicio_descripcion());	
		tablaamortidetalleAsignar.setid_periodo(tablaamortidetalle.getid_periodo());
		tablaamortidetalleAsignar.setperiodo_descripcion(tablaamortidetalle.getperiodo_descripcion());	
		tablaamortidetalleAsignar.setid_tasa(tablaamortidetalle.getid_tasa());
		tablaamortidetalleAsignar.settasa_descripcion(tablaamortidetalle.gettasa_descripcion());	
		tablaamortidetalleAsignar.setid_factura(tablaamortidetalle.getid_factura());
		tablaamortidetalleAsignar.setfactura_descripcion(tablaamortidetalle.getfactura_descripcion());	
		tablaamortidetalleAsignar.setid_tipo_intervalo(tablaamortidetalle.getid_tipo_intervalo());
		tablaamortidetalleAsignar.settipointervalo_descripcion(tablaamortidetalle.gettipointervalo_descripcion());	
		tablaamortidetalleAsignar.setfecha_emision(tablaamortidetalle.getfecha_emision());	
		tablaamortidetalleAsignar.setfecha_vencimiento(tablaamortidetalle.getfecha_vencimiento());	
		tablaamortidetalleAsignar.setfecha_inicial(tablaamortidetalle.getfecha_inicial());	
		tablaamortidetalleAsignar.setfecha_final(tablaamortidetalle.getfecha_final());	
		tablaamortidetalleAsignar.setvalor(tablaamortidetalle.getvalor());	
		tablaamortidetalleAsignar.setinteres(tablaamortidetalle.getinteres());	
		tablaamortidetalleAsignar.setcapital(tablaamortidetalle.getcapital());	
		tablaamortidetalleAsignar.setnumero_cuotas(tablaamortidetalle.getnumero_cuotas());	
		tablaamortidetalleAsignar.setid_anio(tablaamortidetalle.getid_anio());
		tablaamortidetalleAsignar.setanio_descripcion(tablaamortidetalle.getanio_descripcion());	
		tablaamortidetalleAsignar.setid_mes(tablaamortidetalle.getid_mes());
		tablaamortidetalleAsignar.setmes_descripcion(tablaamortidetalle.getmes_descripcion());	
	}
	
	public static void inicializarTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle) throws Exception {
		try {
				tablaamortidetalle.setId(0L);	
					
				tablaamortidetalle.setid_empresa(-1L);	
				tablaamortidetalle.setid_sucursal(-1L);	
				tablaamortidetalle.setid_ejercicio(-1L);	
				tablaamortidetalle.setid_periodo(-1L);	
				tablaamortidetalle.setid_tasa(-1L);	
				tablaamortidetalle.setid_factura(-1L);	
				tablaamortidetalle.setid_tipo_intervalo(-1L);	
				tablaamortidetalle.setfecha_emision(new Date());	
				tablaamortidetalle.setfecha_vencimiento(new Date());	
				tablaamortidetalle.setfecha_inicial(new Date());	
				tablaamortidetalle.setfecha_final(new Date());	
				tablaamortidetalle.setvalor(0.0);	
				tablaamortidetalle.setinteres(0.0);	
				tablaamortidetalle.setcapital(0.0);	
				tablaamortidetalle.setnumero_cuotas(0);	
				tablaamortidetalle.setid_anio(null);	
				tablaamortidetalle.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTablaAmortiDetalle(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDTASA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDTIPOINTERVALO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_FECHAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_INTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_CAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_NUMEROCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiDetalleConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTablaAmortiDetalle(String sTipo,Row row,Workbook workbook,TablaAmortiDetalle tablaamortidetalle,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.gettasa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.gettipointervalo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getfecha_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getfecha_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getinteres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getcapital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getnumero_cuotas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamortidetalle.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTablaAmortiDetalle=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTablaAmortiDetalle() {
		return this.sFinalQueryTablaAmortiDetalle;
	}
	
	public void setsFinalQueryTablaAmortiDetalle(String sFinalQueryTablaAmortiDetalle) {
		this.sFinalQueryTablaAmortiDetalle= sFinalQueryTablaAmortiDetalle;
	}
	
	public Border resaltarSeleccionarTablaAmortiDetalle=null;
	
	public Border setResaltarSeleccionarTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTablaAmortiDetalle= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTablaAmortiDetalle() {
		return this.resaltarSeleccionarTablaAmortiDetalle;
	}
	
	public void setResaltarSeleccionarTablaAmortiDetalle(Border borderResaltarSeleccionarTablaAmortiDetalle) {
		this.resaltarSeleccionarTablaAmortiDetalle= borderResaltarSeleccionarTablaAmortiDetalle;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTablaAmortiDetalle=null;
	public Boolean mostraridTablaAmortiDetalle=true;
	public Boolean activaridTablaAmortiDetalle=true;

	public Border resaltarid_empresaTablaAmortiDetalle=null;
	public Boolean mostrarid_empresaTablaAmortiDetalle=true;
	public Boolean activarid_empresaTablaAmortiDetalle=true;
	public Boolean cargarid_empresaTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_sucursalTablaAmortiDetalle=null;
	public Boolean mostrarid_sucursalTablaAmortiDetalle=true;
	public Boolean activarid_sucursalTablaAmortiDetalle=true;
	public Boolean cargarid_sucursalTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_ejercicioTablaAmortiDetalle=null;
	public Boolean mostrarid_ejercicioTablaAmortiDetalle=true;
	public Boolean activarid_ejercicioTablaAmortiDetalle=true;
	public Boolean cargarid_ejercicioTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_periodoTablaAmortiDetalle=null;
	public Boolean mostrarid_periodoTablaAmortiDetalle=true;
	public Boolean activarid_periodoTablaAmortiDetalle=true;
	public Boolean cargarid_periodoTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_tasaTablaAmortiDetalle=null;
	public Boolean mostrarid_tasaTablaAmortiDetalle=true;
	public Boolean activarid_tasaTablaAmortiDetalle=true;
	public Boolean cargarid_tasaTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tasaTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_facturaTablaAmortiDetalle=null;
	public Boolean mostrarid_facturaTablaAmortiDetalle=true;
	public Boolean activarid_facturaTablaAmortiDetalle=true;
	public Boolean cargarid_facturaTablaAmortiDetalle=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_tipo_intervaloTablaAmortiDetalle=null;
	public Boolean mostrarid_tipo_intervaloTablaAmortiDetalle=true;
	public Boolean activarid_tipo_intervaloTablaAmortiDetalle=true;
	public Boolean cargarid_tipo_intervaloTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_intervaloTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarfecha_emisionTablaAmortiDetalle=null;
	public Boolean mostrarfecha_emisionTablaAmortiDetalle=true;
	public Boolean activarfecha_emisionTablaAmortiDetalle=false;

	public Border resaltarfecha_vencimientoTablaAmortiDetalle=null;
	public Boolean mostrarfecha_vencimientoTablaAmortiDetalle=true;
	public Boolean activarfecha_vencimientoTablaAmortiDetalle=false;

	public Border resaltarfecha_inicialTablaAmortiDetalle=null;
	public Boolean mostrarfecha_inicialTablaAmortiDetalle=true;
	public Boolean activarfecha_inicialTablaAmortiDetalle=false;

	public Border resaltarfecha_finalTablaAmortiDetalle=null;
	public Boolean mostrarfecha_finalTablaAmortiDetalle=true;
	public Boolean activarfecha_finalTablaAmortiDetalle=false;

	public Border resaltarvalorTablaAmortiDetalle=null;
	public Boolean mostrarvalorTablaAmortiDetalle=true;
	public Boolean activarvalorTablaAmortiDetalle=true;

	public Border resaltarinteresTablaAmortiDetalle=null;
	public Boolean mostrarinteresTablaAmortiDetalle=true;
	public Boolean activarinteresTablaAmortiDetalle=true;

	public Border resaltarcapitalTablaAmortiDetalle=null;
	public Boolean mostrarcapitalTablaAmortiDetalle=true;
	public Boolean activarcapitalTablaAmortiDetalle=true;

	public Border resaltarnumero_cuotasTablaAmortiDetalle=null;
	public Boolean mostrarnumero_cuotasTablaAmortiDetalle=true;
	public Boolean activarnumero_cuotasTablaAmortiDetalle=true;

	public Border resaltarid_anioTablaAmortiDetalle=null;
	public Boolean mostrarid_anioTablaAmortiDetalle=true;
	public Boolean activarid_anioTablaAmortiDetalle=false;
	public Boolean cargarid_anioTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioTablaAmortiDetalle=false;//ConEventDepend=true

	public Border resaltarid_mesTablaAmortiDetalle=null;
	public Boolean mostrarid_mesTablaAmortiDetalle=true;
	public Boolean activarid_mesTablaAmortiDetalle=false;
	public Boolean cargarid_mesTablaAmortiDetalle=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesTablaAmortiDetalle=false;//ConEventDepend=true

	
	

	public Border setResaltaridTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltaridTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTablaAmortiDetalle() {
		return this.resaltaridTablaAmortiDetalle;
	}

	public void setResaltaridTablaAmortiDetalle(Border borderResaltar) {
		this.resaltaridTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostraridTablaAmortiDetalle() {
		return this.mostraridTablaAmortiDetalle;
	}

	public void setMostraridTablaAmortiDetalle(Boolean mostraridTablaAmortiDetalle) {
		this.mostraridTablaAmortiDetalle= mostraridTablaAmortiDetalle;
	}

	public Boolean getActivaridTablaAmortiDetalle() {
		return this.activaridTablaAmortiDetalle;
	}

	public void setActivaridTablaAmortiDetalle(Boolean activaridTablaAmortiDetalle) {
		this.activaridTablaAmortiDetalle= activaridTablaAmortiDetalle;
	}

	public Border setResaltarid_empresaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_empresaTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTablaAmortiDetalle() {
		return this.resaltarid_empresaTablaAmortiDetalle;
	}

	public void setResaltarid_empresaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_empresaTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_empresaTablaAmortiDetalle() {
		return this.mostrarid_empresaTablaAmortiDetalle;
	}

	public void setMostrarid_empresaTablaAmortiDetalle(Boolean mostrarid_empresaTablaAmortiDetalle) {
		this.mostrarid_empresaTablaAmortiDetalle= mostrarid_empresaTablaAmortiDetalle;
	}

	public Boolean getActivarid_empresaTablaAmortiDetalle() {
		return this.activarid_empresaTablaAmortiDetalle;
	}

	public void setActivarid_empresaTablaAmortiDetalle(Boolean activarid_empresaTablaAmortiDetalle) {
		this.activarid_empresaTablaAmortiDetalle= activarid_empresaTablaAmortiDetalle;
	}

	public Boolean getCargarid_empresaTablaAmortiDetalle() {
		return this.cargarid_empresaTablaAmortiDetalle;
	}

	public void setCargarid_empresaTablaAmortiDetalle(Boolean cargarid_empresaTablaAmortiDetalle) {
		this.cargarid_empresaTablaAmortiDetalle= cargarid_empresaTablaAmortiDetalle;
	}

	public Border setResaltarid_sucursalTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTablaAmortiDetalle() {
		return this.resaltarid_sucursalTablaAmortiDetalle;
	}

	public void setResaltarid_sucursalTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_sucursalTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTablaAmortiDetalle() {
		return this.mostrarid_sucursalTablaAmortiDetalle;
	}

	public void setMostrarid_sucursalTablaAmortiDetalle(Boolean mostrarid_sucursalTablaAmortiDetalle) {
		this.mostrarid_sucursalTablaAmortiDetalle= mostrarid_sucursalTablaAmortiDetalle;
	}

	public Boolean getActivarid_sucursalTablaAmortiDetalle() {
		return this.activarid_sucursalTablaAmortiDetalle;
	}

	public void setActivarid_sucursalTablaAmortiDetalle(Boolean activarid_sucursalTablaAmortiDetalle) {
		this.activarid_sucursalTablaAmortiDetalle= activarid_sucursalTablaAmortiDetalle;
	}

	public Boolean getCargarid_sucursalTablaAmortiDetalle() {
		return this.cargarid_sucursalTablaAmortiDetalle;
	}

	public void setCargarid_sucursalTablaAmortiDetalle(Boolean cargarid_sucursalTablaAmortiDetalle) {
		this.cargarid_sucursalTablaAmortiDetalle= cargarid_sucursalTablaAmortiDetalle;
	}

	public Border setResaltarid_ejercicioTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioTablaAmortiDetalle() {
		return this.resaltarid_ejercicioTablaAmortiDetalle;
	}

	public void setResaltarid_ejercicioTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_ejercicioTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioTablaAmortiDetalle() {
		return this.mostrarid_ejercicioTablaAmortiDetalle;
	}

	public void setMostrarid_ejercicioTablaAmortiDetalle(Boolean mostrarid_ejercicioTablaAmortiDetalle) {
		this.mostrarid_ejercicioTablaAmortiDetalle= mostrarid_ejercicioTablaAmortiDetalle;
	}

	public Boolean getActivarid_ejercicioTablaAmortiDetalle() {
		return this.activarid_ejercicioTablaAmortiDetalle;
	}

	public void setActivarid_ejercicioTablaAmortiDetalle(Boolean activarid_ejercicioTablaAmortiDetalle) {
		this.activarid_ejercicioTablaAmortiDetalle= activarid_ejercicioTablaAmortiDetalle;
	}

	public Boolean getCargarid_ejercicioTablaAmortiDetalle() {
		return this.cargarid_ejercicioTablaAmortiDetalle;
	}

	public void setCargarid_ejercicioTablaAmortiDetalle(Boolean cargarid_ejercicioTablaAmortiDetalle) {
		this.cargarid_ejercicioTablaAmortiDetalle= cargarid_ejercicioTablaAmortiDetalle;
	}

	public Border setResaltarid_periodoTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_periodoTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoTablaAmortiDetalle() {
		return this.resaltarid_periodoTablaAmortiDetalle;
	}

	public void setResaltarid_periodoTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_periodoTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_periodoTablaAmortiDetalle() {
		return this.mostrarid_periodoTablaAmortiDetalle;
	}

	public void setMostrarid_periodoTablaAmortiDetalle(Boolean mostrarid_periodoTablaAmortiDetalle) {
		this.mostrarid_periodoTablaAmortiDetalle= mostrarid_periodoTablaAmortiDetalle;
	}

	public Boolean getActivarid_periodoTablaAmortiDetalle() {
		return this.activarid_periodoTablaAmortiDetalle;
	}

	public void setActivarid_periodoTablaAmortiDetalle(Boolean activarid_periodoTablaAmortiDetalle) {
		this.activarid_periodoTablaAmortiDetalle= activarid_periodoTablaAmortiDetalle;
	}

	public Boolean getCargarid_periodoTablaAmortiDetalle() {
		return this.cargarid_periodoTablaAmortiDetalle;
	}

	public void setCargarid_periodoTablaAmortiDetalle(Boolean cargarid_periodoTablaAmortiDetalle) {
		this.cargarid_periodoTablaAmortiDetalle= cargarid_periodoTablaAmortiDetalle;
	}

	public Border setResaltarid_tasaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_tasaTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tasaTablaAmortiDetalle() {
		return this.resaltarid_tasaTablaAmortiDetalle;
	}

	public void setResaltarid_tasaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_tasaTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_tasaTablaAmortiDetalle() {
		return this.mostrarid_tasaTablaAmortiDetalle;
	}

	public void setMostrarid_tasaTablaAmortiDetalle(Boolean mostrarid_tasaTablaAmortiDetalle) {
		this.mostrarid_tasaTablaAmortiDetalle= mostrarid_tasaTablaAmortiDetalle;
	}

	public Boolean getActivarid_tasaTablaAmortiDetalle() {
		return this.activarid_tasaTablaAmortiDetalle;
	}

	public void setActivarid_tasaTablaAmortiDetalle(Boolean activarid_tasaTablaAmortiDetalle) {
		this.activarid_tasaTablaAmortiDetalle= activarid_tasaTablaAmortiDetalle;
	}

	public Boolean getCargarid_tasaTablaAmortiDetalle() {
		return this.cargarid_tasaTablaAmortiDetalle;
	}

	public void setCargarid_tasaTablaAmortiDetalle(Boolean cargarid_tasaTablaAmortiDetalle) {
		this.cargarid_tasaTablaAmortiDetalle= cargarid_tasaTablaAmortiDetalle;
	}

	public Border setResaltarid_facturaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_facturaTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaTablaAmortiDetalle() {
		return this.resaltarid_facturaTablaAmortiDetalle;
	}

	public void setResaltarid_facturaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_facturaTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_facturaTablaAmortiDetalle() {
		return this.mostrarid_facturaTablaAmortiDetalle;
	}

	public void setMostrarid_facturaTablaAmortiDetalle(Boolean mostrarid_facturaTablaAmortiDetalle) {
		this.mostrarid_facturaTablaAmortiDetalle= mostrarid_facturaTablaAmortiDetalle;
	}

	public Boolean getActivarid_facturaTablaAmortiDetalle() {
		return this.activarid_facturaTablaAmortiDetalle;
	}

	public void setActivarid_facturaTablaAmortiDetalle(Boolean activarid_facturaTablaAmortiDetalle) {
		this.activarid_facturaTablaAmortiDetalle= activarid_facturaTablaAmortiDetalle;
	}

	public Boolean getCargarid_facturaTablaAmortiDetalle() {
		return this.cargarid_facturaTablaAmortiDetalle;
	}

	public void setCargarid_facturaTablaAmortiDetalle(Boolean cargarid_facturaTablaAmortiDetalle) {
		this.cargarid_facturaTablaAmortiDetalle= cargarid_facturaTablaAmortiDetalle;
	}

	public Border setResaltarid_tipo_intervaloTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_tipo_intervaloTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_intervaloTablaAmortiDetalle() {
		return this.resaltarid_tipo_intervaloTablaAmortiDetalle;
	}

	public void setResaltarid_tipo_intervaloTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_tipo_intervaloTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_tipo_intervaloTablaAmortiDetalle() {
		return this.mostrarid_tipo_intervaloTablaAmortiDetalle;
	}

	public void setMostrarid_tipo_intervaloTablaAmortiDetalle(Boolean mostrarid_tipo_intervaloTablaAmortiDetalle) {
		this.mostrarid_tipo_intervaloTablaAmortiDetalle= mostrarid_tipo_intervaloTablaAmortiDetalle;
	}

	public Boolean getActivarid_tipo_intervaloTablaAmortiDetalle() {
		return this.activarid_tipo_intervaloTablaAmortiDetalle;
	}

	public void setActivarid_tipo_intervaloTablaAmortiDetalle(Boolean activarid_tipo_intervaloTablaAmortiDetalle) {
		this.activarid_tipo_intervaloTablaAmortiDetalle= activarid_tipo_intervaloTablaAmortiDetalle;
	}

	public Boolean getCargarid_tipo_intervaloTablaAmortiDetalle() {
		return this.cargarid_tipo_intervaloTablaAmortiDetalle;
	}

	public void setCargarid_tipo_intervaloTablaAmortiDetalle(Boolean cargarid_tipo_intervaloTablaAmortiDetalle) {
		this.cargarid_tipo_intervaloTablaAmortiDetalle= cargarid_tipo_intervaloTablaAmortiDetalle;
	}

	public Border setResaltarfecha_emisionTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionTablaAmortiDetalle() {
		return this.resaltarfecha_emisionTablaAmortiDetalle;
	}

	public void setResaltarfecha_emisionTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarfecha_emisionTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionTablaAmortiDetalle() {
		return this.mostrarfecha_emisionTablaAmortiDetalle;
	}

	public void setMostrarfecha_emisionTablaAmortiDetalle(Boolean mostrarfecha_emisionTablaAmortiDetalle) {
		this.mostrarfecha_emisionTablaAmortiDetalle= mostrarfecha_emisionTablaAmortiDetalle;
	}

	public Boolean getActivarfecha_emisionTablaAmortiDetalle() {
		return this.activarfecha_emisionTablaAmortiDetalle;
	}

	public void setActivarfecha_emisionTablaAmortiDetalle(Boolean activarfecha_emisionTablaAmortiDetalle) {
		this.activarfecha_emisionTablaAmortiDetalle= activarfecha_emisionTablaAmortiDetalle;
	}

	public Border setResaltarfecha_vencimientoTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoTablaAmortiDetalle() {
		return this.resaltarfecha_vencimientoTablaAmortiDetalle;
	}

	public void setResaltarfecha_vencimientoTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarfecha_vencimientoTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoTablaAmortiDetalle() {
		return this.mostrarfecha_vencimientoTablaAmortiDetalle;
	}

	public void setMostrarfecha_vencimientoTablaAmortiDetalle(Boolean mostrarfecha_vencimientoTablaAmortiDetalle) {
		this.mostrarfecha_vencimientoTablaAmortiDetalle= mostrarfecha_vencimientoTablaAmortiDetalle;
	}

	public Boolean getActivarfecha_vencimientoTablaAmortiDetalle() {
		return this.activarfecha_vencimientoTablaAmortiDetalle;
	}

	public void setActivarfecha_vencimientoTablaAmortiDetalle(Boolean activarfecha_vencimientoTablaAmortiDetalle) {
		this.activarfecha_vencimientoTablaAmortiDetalle= activarfecha_vencimientoTablaAmortiDetalle;
	}

	public Border setResaltarfecha_inicialTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_inicialTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicialTablaAmortiDetalle() {
		return this.resaltarfecha_inicialTablaAmortiDetalle;
	}

	public void setResaltarfecha_inicialTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarfecha_inicialTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_inicialTablaAmortiDetalle() {
		return this.mostrarfecha_inicialTablaAmortiDetalle;
	}

	public void setMostrarfecha_inicialTablaAmortiDetalle(Boolean mostrarfecha_inicialTablaAmortiDetalle) {
		this.mostrarfecha_inicialTablaAmortiDetalle= mostrarfecha_inicialTablaAmortiDetalle;
	}

	public Boolean getActivarfecha_inicialTablaAmortiDetalle() {
		return this.activarfecha_inicialTablaAmortiDetalle;
	}

	public void setActivarfecha_inicialTablaAmortiDetalle(Boolean activarfecha_inicialTablaAmortiDetalle) {
		this.activarfecha_inicialTablaAmortiDetalle= activarfecha_inicialTablaAmortiDetalle;
	}

	public Border setResaltarfecha_finalTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarfecha_finalTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalTablaAmortiDetalle() {
		return this.resaltarfecha_finalTablaAmortiDetalle;
	}

	public void setResaltarfecha_finalTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarfecha_finalTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarfecha_finalTablaAmortiDetalle() {
		return this.mostrarfecha_finalTablaAmortiDetalle;
	}

	public void setMostrarfecha_finalTablaAmortiDetalle(Boolean mostrarfecha_finalTablaAmortiDetalle) {
		this.mostrarfecha_finalTablaAmortiDetalle= mostrarfecha_finalTablaAmortiDetalle;
	}

	public Boolean getActivarfecha_finalTablaAmortiDetalle() {
		return this.activarfecha_finalTablaAmortiDetalle;
	}

	public void setActivarfecha_finalTablaAmortiDetalle(Boolean activarfecha_finalTablaAmortiDetalle) {
		this.activarfecha_finalTablaAmortiDetalle= activarfecha_finalTablaAmortiDetalle;
	}

	public Border setResaltarvalorTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarvalorTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorTablaAmortiDetalle() {
		return this.resaltarvalorTablaAmortiDetalle;
	}

	public void setResaltarvalorTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarvalorTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarvalorTablaAmortiDetalle() {
		return this.mostrarvalorTablaAmortiDetalle;
	}

	public void setMostrarvalorTablaAmortiDetalle(Boolean mostrarvalorTablaAmortiDetalle) {
		this.mostrarvalorTablaAmortiDetalle= mostrarvalorTablaAmortiDetalle;
	}

	public Boolean getActivarvalorTablaAmortiDetalle() {
		return this.activarvalorTablaAmortiDetalle;
	}

	public void setActivarvalorTablaAmortiDetalle(Boolean activarvalorTablaAmortiDetalle) {
		this.activarvalorTablaAmortiDetalle= activarvalorTablaAmortiDetalle;
	}

	public Border setResaltarinteresTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarinteresTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteresTablaAmortiDetalle() {
		return this.resaltarinteresTablaAmortiDetalle;
	}

	public void setResaltarinteresTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarinteresTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarinteresTablaAmortiDetalle() {
		return this.mostrarinteresTablaAmortiDetalle;
	}

	public void setMostrarinteresTablaAmortiDetalle(Boolean mostrarinteresTablaAmortiDetalle) {
		this.mostrarinteresTablaAmortiDetalle= mostrarinteresTablaAmortiDetalle;
	}

	public Boolean getActivarinteresTablaAmortiDetalle() {
		return this.activarinteresTablaAmortiDetalle;
	}

	public void setActivarinteresTablaAmortiDetalle(Boolean activarinteresTablaAmortiDetalle) {
		this.activarinteresTablaAmortiDetalle= activarinteresTablaAmortiDetalle;
	}

	public Border setResaltarcapitalTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarcapitalTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcapitalTablaAmortiDetalle() {
		return this.resaltarcapitalTablaAmortiDetalle;
	}

	public void setResaltarcapitalTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarcapitalTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarcapitalTablaAmortiDetalle() {
		return this.mostrarcapitalTablaAmortiDetalle;
	}

	public void setMostrarcapitalTablaAmortiDetalle(Boolean mostrarcapitalTablaAmortiDetalle) {
		this.mostrarcapitalTablaAmortiDetalle= mostrarcapitalTablaAmortiDetalle;
	}

	public Boolean getActivarcapitalTablaAmortiDetalle() {
		return this.activarcapitalTablaAmortiDetalle;
	}

	public void setActivarcapitalTablaAmortiDetalle(Boolean activarcapitalTablaAmortiDetalle) {
		this.activarcapitalTablaAmortiDetalle= activarcapitalTablaAmortiDetalle;
	}

	public Border setResaltarnumero_cuotasTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotasTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotasTablaAmortiDetalle() {
		return this.resaltarnumero_cuotasTablaAmortiDetalle;
	}

	public void setResaltarnumero_cuotasTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarnumero_cuotasTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotasTablaAmortiDetalle() {
		return this.mostrarnumero_cuotasTablaAmortiDetalle;
	}

	public void setMostrarnumero_cuotasTablaAmortiDetalle(Boolean mostrarnumero_cuotasTablaAmortiDetalle) {
		this.mostrarnumero_cuotasTablaAmortiDetalle= mostrarnumero_cuotasTablaAmortiDetalle;
	}

	public Boolean getActivarnumero_cuotasTablaAmortiDetalle() {
		return this.activarnumero_cuotasTablaAmortiDetalle;
	}

	public void setActivarnumero_cuotasTablaAmortiDetalle(Boolean activarnumero_cuotasTablaAmortiDetalle) {
		this.activarnumero_cuotasTablaAmortiDetalle= activarnumero_cuotasTablaAmortiDetalle;
	}

	public Border setResaltarid_anioTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_anioTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioTablaAmortiDetalle() {
		return this.resaltarid_anioTablaAmortiDetalle;
	}

	public void setResaltarid_anioTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_anioTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_anioTablaAmortiDetalle() {
		return this.mostrarid_anioTablaAmortiDetalle;
	}

	public void setMostrarid_anioTablaAmortiDetalle(Boolean mostrarid_anioTablaAmortiDetalle) {
		this.mostrarid_anioTablaAmortiDetalle= mostrarid_anioTablaAmortiDetalle;
	}

	public Boolean getActivarid_anioTablaAmortiDetalle() {
		return this.activarid_anioTablaAmortiDetalle;
	}

	public void setActivarid_anioTablaAmortiDetalle(Boolean activarid_anioTablaAmortiDetalle) {
		this.activarid_anioTablaAmortiDetalle= activarid_anioTablaAmortiDetalle;
	}

	public Boolean getCargarid_anioTablaAmortiDetalle() {
		return this.cargarid_anioTablaAmortiDetalle;
	}

	public void setCargarid_anioTablaAmortiDetalle(Boolean cargarid_anioTablaAmortiDetalle) {
		this.cargarid_anioTablaAmortiDetalle= cargarid_anioTablaAmortiDetalle;
	}

	public Border setResaltarid_mesTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortidetalleBeanSwingJInternalFrame.jTtoolBarTablaAmortiDetalle.setBorder(borderResaltar);
		
		this.resaltarid_mesTablaAmortiDetalle= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesTablaAmortiDetalle() {
		return this.resaltarid_mesTablaAmortiDetalle;
	}

	public void setResaltarid_mesTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarid_mesTablaAmortiDetalle= borderResaltar;
	}

	public Boolean getMostrarid_mesTablaAmortiDetalle() {
		return this.mostrarid_mesTablaAmortiDetalle;
	}

	public void setMostrarid_mesTablaAmortiDetalle(Boolean mostrarid_mesTablaAmortiDetalle) {
		this.mostrarid_mesTablaAmortiDetalle= mostrarid_mesTablaAmortiDetalle;
	}

	public Boolean getActivarid_mesTablaAmortiDetalle() {
		return this.activarid_mesTablaAmortiDetalle;
	}

	public void setActivarid_mesTablaAmortiDetalle(Boolean activarid_mesTablaAmortiDetalle) {
		this.activarid_mesTablaAmortiDetalle= activarid_mesTablaAmortiDetalle;
	}

	public Boolean getCargarid_mesTablaAmortiDetalle() {
		return this.cargarid_mesTablaAmortiDetalle;
	}

	public void setCargarid_mesTablaAmortiDetalle(Boolean cargarid_mesTablaAmortiDetalle) {
		this.cargarid_mesTablaAmortiDetalle= cargarid_mesTablaAmortiDetalle;
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
		
		
		this.setMostraridTablaAmortiDetalle(esInicial);
		this.setMostrarid_empresaTablaAmortiDetalle(esInicial);
		this.setMostrarid_sucursalTablaAmortiDetalle(esInicial);
		this.setMostrarid_ejercicioTablaAmortiDetalle(esInicial);
		this.setMostrarid_periodoTablaAmortiDetalle(esInicial);
		this.setMostrarid_tasaTablaAmortiDetalle(esInicial);
		this.setMostrarid_facturaTablaAmortiDetalle(esInicial);
		this.setMostrarid_tipo_intervaloTablaAmortiDetalle(esInicial);
		this.setMostrarfecha_emisionTablaAmortiDetalle(esInicial);
		this.setMostrarfecha_vencimientoTablaAmortiDetalle(esInicial);
		this.setMostrarfecha_inicialTablaAmortiDetalle(esInicial);
		this.setMostrarfecha_finalTablaAmortiDetalle(esInicial);
		this.setMostrarvalorTablaAmortiDetalle(esInicial);
		this.setMostrarinteresTablaAmortiDetalle(esInicial);
		this.setMostrarcapitalTablaAmortiDetalle(esInicial);
		this.setMostrarnumero_cuotasTablaAmortiDetalle(esInicial);
		this.setMostrarid_anioTablaAmortiDetalle(esInicial);
		this.setMostrarid_mesTablaAmortiDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.ID)) {
				this.setMostraridTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTASA)) {
				this.setMostrarid_tasaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO)) {
				this.setMostrarid_tipo_intervaloTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAINICIAL)) {
				this.setMostrarfecha_inicialTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAFINAL)) {
				this.setMostrarfecha_finalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.VALOR)) {
				this.setMostrarvalorTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.INTERES)) {
				this.setMostrarinteresTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.CAPITAL)) {
				this.setMostrarcapitalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA)) {
				this.setMostrarnumero_cuotasTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDMES)) {
				this.setMostrarid_mesTablaAmortiDetalle(esAsigna);
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
		
		
		this.setActivaridTablaAmortiDetalle(esInicial);
		this.setActivarid_empresaTablaAmortiDetalle(esInicial);
		this.setActivarid_sucursalTablaAmortiDetalle(esInicial);
		this.setActivarid_ejercicioTablaAmortiDetalle(esInicial);
		this.setActivarid_periodoTablaAmortiDetalle(esInicial);
		this.setActivarid_tasaTablaAmortiDetalle(esInicial);
		this.setActivarid_facturaTablaAmortiDetalle(esInicial);
		this.setActivarid_tipo_intervaloTablaAmortiDetalle(esInicial);
		this.setActivarfecha_emisionTablaAmortiDetalle(esInicial);
		this.setActivarfecha_vencimientoTablaAmortiDetalle(esInicial);
		this.setActivarfecha_inicialTablaAmortiDetalle(esInicial);
		this.setActivarfecha_finalTablaAmortiDetalle(esInicial);
		this.setActivarvalorTablaAmortiDetalle(esInicial);
		this.setActivarinteresTablaAmortiDetalle(esInicial);
		this.setActivarcapitalTablaAmortiDetalle(esInicial);
		this.setActivarnumero_cuotasTablaAmortiDetalle(esInicial);
		this.setActivarid_anioTablaAmortiDetalle(esInicial);
		this.setActivarid_mesTablaAmortiDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.ID)) {
				this.setActivaridTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTASA)) {
				this.setActivarid_tasaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO)) {
				this.setActivarid_tipo_intervaloTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAINICIAL)) {
				this.setActivarfecha_inicialTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAFINAL)) {
				this.setActivarfecha_finalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.VALOR)) {
				this.setActivarvalorTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.INTERES)) {
				this.setActivarinteresTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.CAPITAL)) {
				this.setActivarcapitalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA)) {
				this.setActivarnumero_cuotasTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDANIO)) {
				this.setActivarid_anioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDMES)) {
				this.setActivarid_mesTablaAmortiDetalle(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTablaAmortiDetalle(esInicial);
		this.setResaltarid_empresaTablaAmortiDetalle(esInicial);
		this.setResaltarid_sucursalTablaAmortiDetalle(esInicial);
		this.setResaltarid_ejercicioTablaAmortiDetalle(esInicial);
		this.setResaltarid_periodoTablaAmortiDetalle(esInicial);
		this.setResaltarid_tasaTablaAmortiDetalle(esInicial);
		this.setResaltarid_facturaTablaAmortiDetalle(esInicial);
		this.setResaltarid_tipo_intervaloTablaAmortiDetalle(esInicial);
		this.setResaltarfecha_emisionTablaAmortiDetalle(esInicial);
		this.setResaltarfecha_vencimientoTablaAmortiDetalle(esInicial);
		this.setResaltarfecha_inicialTablaAmortiDetalle(esInicial);
		this.setResaltarfecha_finalTablaAmortiDetalle(esInicial);
		this.setResaltarvalorTablaAmortiDetalle(esInicial);
		this.setResaltarinteresTablaAmortiDetalle(esInicial);
		this.setResaltarcapitalTablaAmortiDetalle(esInicial);
		this.setResaltarnumero_cuotasTablaAmortiDetalle(esInicial);
		this.setResaltarid_anioTablaAmortiDetalle(esInicial);
		this.setResaltarid_mesTablaAmortiDetalle(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.ID)) {
				this.setResaltaridTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTASA)) {
				this.setResaltarid_tasaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO)) {
				this.setResaltarid_tipo_intervaloTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAINICIAL)) {
				this.setResaltarfecha_inicialTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.FECHAFINAL)) {
				this.setResaltarfecha_finalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.VALOR)) {
				this.setResaltarvalorTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.INTERES)) {
				this.setResaltarinteresTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.CAPITAL)) {
				this.setResaltarcapitalTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA)) {
				this.setResaltarnumero_cuotasTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioTablaAmortiDetalle(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiDetalleConstantesFunciones.IDMES)) {
				this.setResaltarid_mesTablaAmortiDetalle(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdEjercicioTablaAmortiDetalle() {
		return this.mostrarFK_IdEjercicioTablaAmortiDetalle;
	}

	public void setMostrarFK_IdEjercicioTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdEmpresaTablaAmortiDetalle() {
		return this.mostrarFK_IdEmpresaTablaAmortiDetalle;
	}

	public void setMostrarFK_IdEmpresaTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdFacturaTablaAmortiDetalle() {
		return this.mostrarFK_IdFacturaTablaAmortiDetalle;
	}

	public void setMostrarFK_IdFacturaTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdPeriodoTablaAmortiDetalle() {
		return this.mostrarFK_IdPeriodoTablaAmortiDetalle;
	}

	public void setMostrarFK_IdPeriodoTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdSucursalTablaAmortiDetalle() {
		return this.mostrarFK_IdSucursalTablaAmortiDetalle;
	}

	public void setMostrarFK_IdSucursalTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTasaTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdTasaTablaAmortiDetalle() {
		return this.mostrarFK_IdTasaTablaAmortiDetalle;
	}

	public void setMostrarFK_IdTasaTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTasaTablaAmortiDetalle= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIntervaloTablaAmortiDetalle=true;

	public Boolean getMostrarFK_IdTipoIntervaloTablaAmortiDetalle() {
		return this.mostrarFK_IdTipoIntervaloTablaAmortiDetalle;
	}

	public void setMostrarFK_IdTipoIntervaloTablaAmortiDetalle(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIntervaloTablaAmortiDetalle= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdEjercicioTablaAmortiDetalle() {
		return this.activarFK_IdEjercicioTablaAmortiDetalle;
	}

	public void setActivarFK_IdEjercicioTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdEmpresaTablaAmortiDetalle() {
		return this.activarFK_IdEmpresaTablaAmortiDetalle;
	}

	public void setActivarFK_IdEmpresaTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdFacturaTablaAmortiDetalle() {
		return this.activarFK_IdFacturaTablaAmortiDetalle;
	}

	public void setActivarFK_IdFacturaTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdPeriodoTablaAmortiDetalle() {
		return this.activarFK_IdPeriodoTablaAmortiDetalle;
	}

	public void setActivarFK_IdPeriodoTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdSucursalTablaAmortiDetalle() {
		return this.activarFK_IdSucursalTablaAmortiDetalle;
	}

	public void setActivarFK_IdSucursalTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdTasaTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdTasaTablaAmortiDetalle() {
		return this.activarFK_IdTasaTablaAmortiDetalle;
	}

	public void setActivarFK_IdTasaTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdTasaTablaAmortiDetalle= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIntervaloTablaAmortiDetalle=true;

	public Boolean getActivarFK_IdTipoIntervaloTablaAmortiDetalle() {
		return this.activarFK_IdTipoIntervaloTablaAmortiDetalle;
	}

	public void setActivarFK_IdTipoIntervaloTablaAmortiDetalle(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIntervaloTablaAmortiDetalle= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioTablaAmortiDetalle=null;

	public Border getResaltarFK_IdEjercicioTablaAmortiDetalle() {
		return this.resaltarFK_IdEjercicioTablaAmortiDetalle;
	}

	public void setResaltarFK_IdEjercicioTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdEjercicioTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTablaAmortiDetalle=null;

	public Border getResaltarFK_IdEmpresaTablaAmortiDetalle() {
		return this.resaltarFK_IdEmpresaTablaAmortiDetalle;
	}

	public void setResaltarFK_IdEmpresaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdFacturaTablaAmortiDetalle=null;

	public Border getResaltarFK_IdFacturaTablaAmortiDetalle() {
		return this.resaltarFK_IdFacturaTablaAmortiDetalle;
	}

	public void setResaltarFK_IdFacturaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdFacturaTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdFacturaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoTablaAmortiDetalle=null;

	public Border getResaltarFK_IdPeriodoTablaAmortiDetalle() {
		return this.resaltarFK_IdPeriodoTablaAmortiDetalle;
	}

	public void setResaltarFK_IdPeriodoTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdPeriodoTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTablaAmortiDetalle=null;

	public Border getResaltarFK_IdSucursalTablaAmortiDetalle() {
		return this.resaltarFK_IdSucursalTablaAmortiDetalle;
	}

	public void setResaltarFK_IdSucursalTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdSucursalTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdTasaTablaAmortiDetalle=null;

	public Border getResaltarFK_IdTasaTablaAmortiDetalle() {
		return this.resaltarFK_IdTasaTablaAmortiDetalle;
	}

	public void setResaltarFK_IdTasaTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdTasaTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdTasaTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTasaTablaAmortiDetalle= borderResaltar;
	}

	public Border resaltarFK_IdTipoIntervaloTablaAmortiDetalle=null;

	public Border getResaltarFK_IdTipoIntervaloTablaAmortiDetalle() {
		return this.resaltarFK_IdTipoIntervaloTablaAmortiDetalle;
	}

	public void setResaltarFK_IdTipoIntervaloTablaAmortiDetalle(Border borderResaltar) {
		this.resaltarFK_IdTipoIntervaloTablaAmortiDetalle= borderResaltar;
	}

	public void setResaltarFK_IdTipoIntervaloTablaAmortiDetalle(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiDetalleBeanSwingJInternalFrame tablaamortidetalleBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIntervaloTablaAmortiDetalle= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}