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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionVentaCobroConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionVentaCobroParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionVentaCobroParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionVentaCobroConstantesFunciones extends ComisionVentaCobroConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionVentaCobro";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionVentaCobro"+ComisionVentaCobroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionVentaCobroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionVentaCobroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionVentaCobroConstantesFunciones.SCHEMA+"_"+ComisionVentaCobroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionVentaCobroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionVentaCobroConstantesFunciones.SCHEMA+"_"+ComisionVentaCobroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionVentaCobroConstantesFunciones.SCHEMA+"_"+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionVentaCobroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionVentaCobroConstantesFunciones.SCHEMA+"_"+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionVentaCobroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionVentaCobroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionVentaCobroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionVentaCobroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionVentaCobroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionVentaCobroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionVentaCobroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Venta Cobroes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Comision Venta Cobro";
	public static final String SCLASSWEBTITULO_LOWER="Comision Venta Cobro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionVentaCobro";
	public static final String OBJECTNAME="comisionventacobro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_venta_cobro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisionventacobro from "+ComisionVentaCobroConstantesFunciones.SPERSISTENCENAME+" comisionventacobro";
	public static String QUERYSELECTNATIVE="select "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".version_row,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_empresa,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_ejercicio,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_periodo,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".fecha_pago,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".nombre_cliente,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_comprobante,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".estado,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_abono,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".porcentaje_comision,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_comision_cobro,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_dias from "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME;//+" as "+ComisionVentaCobroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionVentaCobroConstantesFuncionesAdditional comisionventacobroConstantesFuncionesAdditional=null;
	
	public ComisionVentaCobroConstantesFuncionesAdditional getComisionVentaCobroConstantesFuncionesAdditional() {
		return this.comisionventacobroConstantesFuncionesAdditional;
	}
	
	public void setComisionVentaCobroConstantesFuncionesAdditional(ComisionVentaCobroConstantesFuncionesAdditional comisionventacobroConstantesFuncionesAdditional) {
		try {
			this.comisionventacobroConstantesFuncionesAdditional=comisionventacobroConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String ESTADO= "estado";
    public static final String TOTALFACTURA= "total_factura";
    public static final String TOTALABONO= "total_abono";
    public static final String PORCENTAJECOMISION= "porcentaje_comision";
    public static final String TOTALCOMISIONCOBRO= "total_comision_cobro";
    public static final String NUMERODIAS= "numero_dias";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "Nro Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Nro Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
    	public static final String LABEL_TOTALFACTURA= "Total Factura";
		public static final String LABEL_TOTALFACTURA_LOWER= "Total Factura";
    	public static final String LABEL_TOTALABONO= "Total Abono";
		public static final String LABEL_TOTALABONO_LOWER= "Total Abono";
    	public static final String LABEL_PORCENTAJECOMISION= "% Comision";
		public static final String LABEL_PORCENTAJECOMISION_LOWER= "Porcentaje Comision";
    	public static final String LABEL_TOTALCOMISIONCOBRO= "Total Comision Cobro";
		public static final String LABEL_TOTALCOMISIONCOBRO_LOWER= "Total Comision Cobro";
    	public static final String LABEL_NUMERODIAS= "Nro Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXESTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXESTADO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getComisionVentaCobroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.IDPERIODO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.IDFACTURA)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.FECHAPAGO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.ESTADO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_ESTADO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.TOTALFACTURA)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.TOTALABONO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO;}
		if(sNombreColumna.equals(ComisionVentaCobroConstantesFunciones.NUMERODIAS)) {sLabelColumna=ComisionVentaCobroConstantesFunciones.LABEL_NUMERODIAS;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComisionVentaCobroDescripcion(ComisionVentaCobro comisionventacobro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisionventacobro !=null/* && comisionventacobro.getId()!=0*/) {
			if(comisionventacobro.getId()!=null) {
				sDescripcion=comisionventacobro.getId().toString();
			}//comisionventacobrocomisionventacobro.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionVentaCobroDescripcionDetallado(ComisionVentaCobro comisionventacobro) {
		String sDescripcion="";
			
		sDescripcion+=ComisionVentaCobroConstantesFunciones.ID+"=";
		sDescripcion+=comisionventacobro.getId().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisionventacobro.getVersionRow().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisionventacobro.getid_empresa().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=comisionventacobro.getid_ejercicio().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=comisionventacobro.getid_periodo().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comisionventacobro.getid_vendedor().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=comisionventacobro.getid_factura().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=comisionventacobro.getnumero_factura()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=comisionventacobro.getfecha_pago().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=comisionventacobro.getnombre_cliente()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=comisionventacobro.getnumero_comprobante()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.ESTADO+"=";
		sDescripcion+=comisionventacobro.getestado()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.TOTALFACTURA+"=";
		sDescripcion+=comisionventacobro.gettotal_factura().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.TOTALABONO+"=";
		sDescripcion+=comisionventacobro.gettotal_abono().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION+"=";
		sDescripcion+=comisionventacobro.getporcentaje_comision().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO+"=";
		sDescripcion+=comisionventacobro.gettotal_comision_cobro().toString()+",";
		sDescripcion+=ComisionVentaCobroConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=comisionventacobro.getnumero_dias().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionVentaCobroDescripcion(ComisionVentaCobro comisionventacobro,String sValor) throws Exception {			
		if(comisionventacobro !=null) {
			//comisionventacobrocomisionventacobro.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionVentaCobro(ComisionVentaCobro comisionventacobro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisionventacobro.setnumero_factura(comisionventacobro.getnumero_factura().trim());
		comisionventacobro.setnombre_cliente(comisionventacobro.getnombre_cliente().trim());
		comisionventacobro.setnumero_comprobante(comisionventacobro.getnumero_comprobante().trim());
		comisionventacobro.setestado(comisionventacobro.getestado().trim());
	}
	
	public static void quitarEspaciosComisionVentaCobros(List<ComisionVentaCobro> comisionventacobros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionVentaCobro comisionventacobro: comisionventacobros) {
			comisionventacobro.setnumero_factura(comisionventacobro.getnumero_factura().trim());
			comisionventacobro.setnombre_cliente(comisionventacobro.getnombre_cliente().trim());
			comisionventacobro.setnumero_comprobante(comisionventacobro.getnumero_comprobante().trim());
			comisionventacobro.setestado(comisionventacobro.getestado().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionVentaCobro(ComisionVentaCobro comisionventacobro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisionventacobro.getConCambioAuxiliar()) {
			comisionventacobro.setIsDeleted(comisionventacobro.getIsDeletedAuxiliar());	
			comisionventacobro.setIsNew(comisionventacobro.getIsNewAuxiliar());	
			comisionventacobro.setIsChanged(comisionventacobro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisionventacobro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisionventacobro.setIsDeletedAuxiliar(false);	
			comisionventacobro.setIsNewAuxiliar(false);	
			comisionventacobro.setIsChangedAuxiliar(false);
			
			comisionventacobro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionVentaCobros(List<ComisionVentaCobro> comisionventacobros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionVentaCobro comisionventacobro : comisionventacobros) {
			if(conAsignarBase && comisionventacobro.getConCambioAuxiliar()) {
				comisionventacobro.setIsDeleted(comisionventacobro.getIsDeletedAuxiliar());	
				comisionventacobro.setIsNew(comisionventacobro.getIsNewAuxiliar());	
				comisionventacobro.setIsChanged(comisionventacobro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisionventacobro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisionventacobro.setIsDeletedAuxiliar(false);	
				comisionventacobro.setIsNewAuxiliar(false);	
				comisionventacobro.setIsChangedAuxiliar(false);
				
				comisionventacobro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionVentaCobro(ComisionVentaCobro comisionventacobro,Boolean conEnteros) throws Exception  {
		comisionventacobro.settotal_factura(0.0);
		comisionventacobro.settotal_abono(0.0);
		comisionventacobro.setporcentaje_comision(0.0);
		comisionventacobro.settotal_comision_cobro(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			comisionventacobro.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresComisionVentaCobros(List<ComisionVentaCobro> comisionventacobros,Boolean conEnteros) throws Exception  {
		
		for(ComisionVentaCobro comisionventacobro: comisionventacobros) {
			comisionventacobro.settotal_factura(0.0);
			comisionventacobro.settotal_abono(0.0);
			comisionventacobro.setporcentaje_comision(0.0);
			comisionventacobro.settotal_comision_cobro(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				comisionventacobro.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionVentaCobro(List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobro comisionventacobroAux) throws Exception  {
		ComisionVentaCobroConstantesFunciones.InicializarValoresComisionVentaCobro(comisionventacobroAux,true);
		
		for(ComisionVentaCobro comisionventacobro: comisionventacobros) {
			if(comisionventacobro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisionventacobroAux.settotal_factura(comisionventacobroAux.gettotal_factura()+comisionventacobro.gettotal_factura());			
			comisionventacobroAux.settotal_abono(comisionventacobroAux.gettotal_abono()+comisionventacobro.gettotal_abono());			
			comisionventacobroAux.setporcentaje_comision(comisionventacobroAux.getporcentaje_comision()+comisionventacobro.getporcentaje_comision());			
			comisionventacobroAux.settotal_comision_cobro(comisionventacobroAux.gettotal_comision_cobro()+comisionventacobro.gettotal_comision_cobro());			
			comisionventacobroAux.setnumero_dias(comisionventacobroAux.getnumero_dias()+comisionventacobro.getnumero_dias());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionVentaCobro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionVentaCobroConstantesFunciones.getArrayColumnasGlobalesComisionVentaCobro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionVentaCobro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionVentaCobroConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionVentaCobroConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionVentaCobroConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionVentaCobroConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionVentaCobroConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionVentaCobroConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionVentaCobro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComisionVentaCobroConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(ComisionVentaCobroConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionVentaCobro> comisionventacobros,ComisionVentaCobro comisionventacobro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionVentaCobro comisionventacobroAux: comisionventacobros) {
			if(comisionventacobroAux!=null && comisionventacobro!=null) {
				if((comisionventacobroAux.getId()==null && comisionventacobro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisionventacobroAux.getId()!=null && comisionventacobro.getId()!=null){
					if(comisionventacobroAux.getId().equals(comisionventacobro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionVentaCobro(List<ComisionVentaCobro> comisionventacobros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_facturaTotal=0.0;
		Double total_abonoTotal=0.0;
		Double porcentaje_comisionTotal=0.0;
		Double total_comision_cobroTotal=0.0;
	
		for(ComisionVentaCobro comisionventacobro: comisionventacobros) {			
			if(comisionventacobro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_facturaTotal+=comisionventacobro.gettotal_factura();
			total_abonoTotal+=comisionventacobro.gettotal_abono();
			porcentaje_comisionTotal+=comisionventacobro.getporcentaje_comision();
			total_comision_cobroTotal+=comisionventacobro.gettotal_comision_cobro();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionVentaCobroConstantesFunciones.TOTALFACTURA);
		datoGeneral.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA);
		datoGeneral.setdValorDouble(total_facturaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionVentaCobroConstantesFunciones.TOTALABONO);
		datoGeneral.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO);
		datoGeneral.setdValorDouble(total_abonoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION);
		datoGeneral.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION);
		datoGeneral.setdValorDouble(porcentaje_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO);
		datoGeneral.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO);
		datoGeneral.setdValorDouble(total_comision_cobroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionVentaCobro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_ID, ComisionVentaCobroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_VERSIONROW, ComisionVentaCobroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_IDEMPRESA, ComisionVentaCobroConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_IDEJERCICIO, ComisionVentaCobroConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_IDPERIODO, ComisionVentaCobroConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_IDVENDEDOR, ComisionVentaCobroConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_IDFACTURA, ComisionVentaCobroConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_NUMEROFACTURA, ComisionVentaCobroConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_FECHAPAGO, ComisionVentaCobroConstantesFunciones.FECHAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_NOMBRECLIENTE, ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_NUMEROCOMPROBANTE, ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_ESTADO, ComisionVentaCobroConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA, ComisionVentaCobroConstantesFunciones.TOTALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO, ComisionVentaCobroConstantesFunciones.TOTALABONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION, ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO, ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionVentaCobroConstantesFunciones.LABEL_NUMERODIAS, ComisionVentaCobroConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionVentaCobro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.FECHAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.TOTALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.TOTALABONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionVentaCobroConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionVentaCobro() throws Exception  {
		return ComisionVentaCobroConstantesFunciones.getTiposSeleccionarComisionVentaCobro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionVentaCobro(Boolean conFk) throws Exception  {
		return ComisionVentaCobroConstantesFunciones.getTiposSeleccionarComisionVentaCobro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionVentaCobro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionVentaCobroConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(ComisionVentaCobroConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionVentaCobro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionVentaCobro(ComisionVentaCobro comisionventacobroAux) throws Exception {
		
			comisionventacobroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionventacobroAux.getEmpresa()));
			comisionventacobroAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comisionventacobroAux.getEjercicio()));
			comisionventacobroAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(comisionventacobroAux.getPeriodo()));
			comisionventacobroAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionventacobroAux.getVendedor()));
			comisionventacobroAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(comisionventacobroAux.getFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionVentaCobro(List<ComisionVentaCobro> comisionventacobrosTemp) throws Exception {
		for(ComisionVentaCobro comisionventacobroAux:comisionventacobrosTemp) {
			
			comisionventacobroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisionventacobroAux.getEmpresa()));
			comisionventacobroAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comisionventacobroAux.getEjercicio()));
			comisionventacobroAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(comisionventacobroAux.getPeriodo()));
			comisionventacobroAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisionventacobroAux.getVendedor()));
			comisionventacobroAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(comisionventacobroAux.getFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionVentaCobro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Factura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionVentaCobro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionVentaCobro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionVentaCobroConstantesFunciones.getClassesRelationshipsOfComisionVentaCobro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionVentaCobro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionVentaCobro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionVentaCobroConstantesFunciones.getClassesRelationshipsFromStringsOfComisionVentaCobro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionVentaCobro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionVentaCobro comisionventacobro,List<ComisionVentaCobro> comisionventacobros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionVentaCobro comisionventacobroEncontrado=null;
			
			for(ComisionVentaCobro comisionventacobroLocal:comisionventacobros) {
				if(comisionventacobroLocal.getId().equals(comisionventacobro.getId())) {
					comisionventacobroEncontrado=comisionventacobroLocal;
					
					comisionventacobroLocal.setIsChanged(comisionventacobro.getIsChanged());
					comisionventacobroLocal.setIsNew(comisionventacobro.getIsNew());
					comisionventacobroLocal.setIsDeleted(comisionventacobro.getIsDeleted());
					
					comisionventacobroLocal.setGeneralEntityOriginal(comisionventacobro.getGeneralEntityOriginal());
					
					comisionventacobroLocal.setId(comisionventacobro.getId());	
					comisionventacobroLocal.setVersionRow(comisionventacobro.getVersionRow());	
					comisionventacobroLocal.setid_empresa(comisionventacobro.getid_empresa());	
					comisionventacobroLocal.setid_ejercicio(comisionventacobro.getid_ejercicio());	
					comisionventacobroLocal.setid_periodo(comisionventacobro.getid_periodo());	
					comisionventacobroLocal.setid_vendedor(comisionventacobro.getid_vendedor());	
					comisionventacobroLocal.setid_factura(comisionventacobro.getid_factura());	
					comisionventacobroLocal.setnumero_factura(comisionventacobro.getnumero_factura());	
					comisionventacobroLocal.setfecha_pago(comisionventacobro.getfecha_pago());	
					comisionventacobroLocal.setnombre_cliente(comisionventacobro.getnombre_cliente());	
					comisionventacobroLocal.setnumero_comprobante(comisionventacobro.getnumero_comprobante());	
					comisionventacobroLocal.setestado(comisionventacobro.getestado());	
					comisionventacobroLocal.settotal_factura(comisionventacobro.gettotal_factura());	
					comisionventacobroLocal.settotal_abono(comisionventacobro.gettotal_abono());	
					comisionventacobroLocal.setporcentaje_comision(comisionventacobro.getporcentaje_comision());	
					comisionventacobroLocal.settotal_comision_cobro(comisionventacobro.gettotal_comision_cobro());	
					comisionventacobroLocal.setnumero_dias(comisionventacobro.getnumero_dias());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisionventacobro.getIsDeleted()) {
				if(!existe) {
					comisionventacobros.add(comisionventacobro);
				}
			} else {
				if(comisionventacobroEncontrado!=null && permiteQuitar)  {
					comisionventacobros.remove(comisionventacobroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionVentaCobro comisionventacobro,List<ComisionVentaCobro> comisionventacobros) throws Exception {
		try	{			
			for(ComisionVentaCobro comisionventacobroLocal:comisionventacobros) {
				if(comisionventacobroLocal.getId().equals(comisionventacobro.getId())) {
					comisionventacobroLocal.setIsSelected(comisionventacobro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionVentaCobro(List<ComisionVentaCobro> comisionventacobrosAux) throws Exception {
		//this.comisionventacobrosAux=comisionventacobrosAux;
		
		for(ComisionVentaCobro comisionventacobroAux:comisionventacobrosAux) {
			if(comisionventacobroAux.getIsChanged()) {
				comisionventacobroAux.setIsChanged(false);
			}		
			
			if(comisionventacobroAux.getIsNew()) {
				comisionventacobroAux.setIsNew(false);
			}	
			
			if(comisionventacobroAux.getIsDeleted()) {
				comisionventacobroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionVentaCobro(ComisionVentaCobro comisionventacobroAux) throws Exception {
		//this.comisionventacobroAux=comisionventacobroAux;
		
			if(comisionventacobroAux.getIsChanged()) {
				comisionventacobroAux.setIsChanged(false);
			}		
			
			if(comisionventacobroAux.getIsNew()) {
				comisionventacobroAux.setIsNew(false);
			}	
			
			if(comisionventacobroAux.getIsDeleted()) {
				comisionventacobroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionVentaCobro comisionventacobroAsignar,ComisionVentaCobro comisionventacobro) throws Exception {
		comisionventacobroAsignar.setId(comisionventacobro.getId());	
		comisionventacobroAsignar.setVersionRow(comisionventacobro.getVersionRow());	
		comisionventacobroAsignar.setid_empresa(comisionventacobro.getid_empresa());
		comisionventacobroAsignar.setempresa_descripcion(comisionventacobro.getempresa_descripcion());	
		comisionventacobroAsignar.setid_ejercicio(comisionventacobro.getid_ejercicio());
		comisionventacobroAsignar.setejercicio_descripcion(comisionventacobro.getejercicio_descripcion());	
		comisionventacobroAsignar.setid_periodo(comisionventacobro.getid_periodo());
		comisionventacobroAsignar.setperiodo_descripcion(comisionventacobro.getperiodo_descripcion());	
		comisionventacobroAsignar.setid_vendedor(comisionventacobro.getid_vendedor());
		comisionventacobroAsignar.setvendedor_descripcion(comisionventacobro.getvendedor_descripcion());	
		comisionventacobroAsignar.setid_factura(comisionventacobro.getid_factura());
		comisionventacobroAsignar.setfactura_descripcion(comisionventacobro.getfactura_descripcion());	
		comisionventacobroAsignar.setnumero_factura(comisionventacobro.getnumero_factura());	
		comisionventacobroAsignar.setfecha_pago(comisionventacobro.getfecha_pago());	
		comisionventacobroAsignar.setnombre_cliente(comisionventacobro.getnombre_cliente());	
		comisionventacobroAsignar.setnumero_comprobante(comisionventacobro.getnumero_comprobante());	
		comisionventacobroAsignar.setestado(comisionventacobro.getestado());	
		comisionventacobroAsignar.settotal_factura(comisionventacobro.gettotal_factura());	
		comisionventacobroAsignar.settotal_abono(comisionventacobro.gettotal_abono());	
		comisionventacobroAsignar.setporcentaje_comision(comisionventacobro.getporcentaje_comision());	
		comisionventacobroAsignar.settotal_comision_cobro(comisionventacobro.gettotal_comision_cobro());	
		comisionventacobroAsignar.setnumero_dias(comisionventacobro.getnumero_dias());	
	}
	
	public static void inicializarComisionVentaCobro(ComisionVentaCobro comisionventacobro) throws Exception {
		try {
				comisionventacobro.setId(0L);	
					
				comisionventacobro.setid_empresa(-1L);	
				comisionventacobro.setid_ejercicio(-1L);	
				comisionventacobro.setid_periodo(-1L);	
				comisionventacobro.setid_vendedor(-1L);	
				comisionventacobro.setid_factura(-1L);	
				comisionventacobro.setnumero_factura("");	
				comisionventacobro.setfecha_pago(new Date());	
				comisionventacobro.setnombre_cliente("");	
				comisionventacobro.setnumero_comprobante("");	
				comisionventacobro.setestado("");	
				comisionventacobro.settotal_factura(0.0);	
				comisionventacobro.settotal_abono(0.0);	
				comisionventacobro.setporcentaje_comision(0.0);	
				comisionventacobro.settotal_comision_cobro(0.0);	
				comisionventacobro.setnumero_dias(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionVentaCobro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_TOTALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_TOTALABONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_PORCENTAJECOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_TOTALCOMISIONCOBRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionVentaCobroConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionVentaCobro(String sTipo,Row row,Workbook workbook,ComisionVentaCobro comisionventacobro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getestado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.gettotal_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.gettotal_abono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getporcentaje_comision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.gettotal_comision_cobro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisionventacobro.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionVentaCobro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionVentaCobro() {
		return this.sFinalQueryComisionVentaCobro;
	}
	
	public void setsFinalQueryComisionVentaCobro(String sFinalQueryComisionVentaCobro) {
		this.sFinalQueryComisionVentaCobro= sFinalQueryComisionVentaCobro;
	}
	
	public Border resaltarSeleccionarComisionVentaCobro=null;
	
	public Border setResaltarSeleccionarComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionVentaCobro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionVentaCobro() {
		return this.resaltarSeleccionarComisionVentaCobro;
	}
	
	public void setResaltarSeleccionarComisionVentaCobro(Border borderResaltarSeleccionarComisionVentaCobro) {
		this.resaltarSeleccionarComisionVentaCobro= borderResaltarSeleccionarComisionVentaCobro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionVentaCobro=null;
	public Boolean mostraridComisionVentaCobro=true;
	public Boolean activaridComisionVentaCobro=true;

	public Border resaltarid_empresaComisionVentaCobro=null;
	public Boolean mostrarid_empresaComisionVentaCobro=true;
	public Boolean activarid_empresaComisionVentaCobro=true;
	public Boolean cargarid_empresaComisionVentaCobro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionVentaCobro=false;//ConEventDepend=true

	public Border resaltarid_ejercicioComisionVentaCobro=null;
	public Boolean mostrarid_ejercicioComisionVentaCobro=true;
	public Boolean activarid_ejercicioComisionVentaCobro=true;
	public Boolean cargarid_ejercicioComisionVentaCobro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioComisionVentaCobro=false;//ConEventDepend=true

	public Border resaltarid_periodoComisionVentaCobro=null;
	public Boolean mostrarid_periodoComisionVentaCobro=true;
	public Boolean activarid_periodoComisionVentaCobro=true;
	public Boolean cargarid_periodoComisionVentaCobro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoComisionVentaCobro=false;//ConEventDepend=true

	public Border resaltarid_vendedorComisionVentaCobro=null;
	public Boolean mostrarid_vendedorComisionVentaCobro=true;
	public Boolean activarid_vendedorComisionVentaCobro=true;
	public Boolean cargarid_vendedorComisionVentaCobro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComisionVentaCobro=false;//ConEventDepend=true

	public Border resaltarid_facturaComisionVentaCobro=null;
	public Boolean mostrarid_facturaComisionVentaCobro=true;
	public Boolean activarid_facturaComisionVentaCobro=true;
	public Boolean cargarid_facturaComisionVentaCobro=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaComisionVentaCobro=false;//ConEventDepend=true

	public Border resaltarnumero_facturaComisionVentaCobro=null;
	public Boolean mostrarnumero_facturaComisionVentaCobro=true;
	public Boolean activarnumero_facturaComisionVentaCobro=true;

	public Border resaltarfecha_pagoComisionVentaCobro=null;
	public Boolean mostrarfecha_pagoComisionVentaCobro=true;
	public Boolean activarfecha_pagoComisionVentaCobro=false;

	public Border resaltarnombre_clienteComisionVentaCobro=null;
	public Boolean mostrarnombre_clienteComisionVentaCobro=true;
	public Boolean activarnombre_clienteComisionVentaCobro=true;

	public Border resaltarnumero_comprobanteComisionVentaCobro=null;
	public Boolean mostrarnumero_comprobanteComisionVentaCobro=true;
	public Boolean activarnumero_comprobanteComisionVentaCobro=true;

	public Border resaltarestadoComisionVentaCobro=null;
	public Boolean mostrarestadoComisionVentaCobro=true;
	public Boolean activarestadoComisionVentaCobro=true;

	public Border resaltartotal_facturaComisionVentaCobro=null;
	public Boolean mostrartotal_facturaComisionVentaCobro=true;
	public Boolean activartotal_facturaComisionVentaCobro=true;

	public Border resaltartotal_abonoComisionVentaCobro=null;
	public Boolean mostrartotal_abonoComisionVentaCobro=true;
	public Boolean activartotal_abonoComisionVentaCobro=true;

	public Border resaltarporcentaje_comisionComisionVentaCobro=null;
	public Boolean mostrarporcentaje_comisionComisionVentaCobro=true;
	public Boolean activarporcentaje_comisionComisionVentaCobro=true;

	public Border resaltartotal_comision_cobroComisionVentaCobro=null;
	public Boolean mostrartotal_comision_cobroComisionVentaCobro=true;
	public Boolean activartotal_comision_cobroComisionVentaCobro=true;

	public Border resaltarnumero_diasComisionVentaCobro=null;
	public Boolean mostrarnumero_diasComisionVentaCobro=true;
	public Boolean activarnumero_diasComisionVentaCobro=true;

	
	

	public Border setResaltaridComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltaridComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionVentaCobro() {
		return this.resaltaridComisionVentaCobro;
	}

	public void setResaltaridComisionVentaCobro(Border borderResaltar) {
		this.resaltaridComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostraridComisionVentaCobro() {
		return this.mostraridComisionVentaCobro;
	}

	public void setMostraridComisionVentaCobro(Boolean mostraridComisionVentaCobro) {
		this.mostraridComisionVentaCobro= mostraridComisionVentaCobro;
	}

	public Boolean getActivaridComisionVentaCobro() {
		return this.activaridComisionVentaCobro;
	}

	public void setActivaridComisionVentaCobro(Boolean activaridComisionVentaCobro) {
		this.activaridComisionVentaCobro= activaridComisionVentaCobro;
	}

	public Border setResaltarid_empresaComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionVentaCobro() {
		return this.resaltarid_empresaComisionVentaCobro;
	}

	public void setResaltarid_empresaComisionVentaCobro(Border borderResaltar) {
		this.resaltarid_empresaComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionVentaCobro() {
		return this.mostrarid_empresaComisionVentaCobro;
	}

	public void setMostrarid_empresaComisionVentaCobro(Boolean mostrarid_empresaComisionVentaCobro) {
		this.mostrarid_empresaComisionVentaCobro= mostrarid_empresaComisionVentaCobro;
	}

	public Boolean getActivarid_empresaComisionVentaCobro() {
		return this.activarid_empresaComisionVentaCobro;
	}

	public void setActivarid_empresaComisionVentaCobro(Boolean activarid_empresaComisionVentaCobro) {
		this.activarid_empresaComisionVentaCobro= activarid_empresaComisionVentaCobro;
	}

	public Boolean getCargarid_empresaComisionVentaCobro() {
		return this.cargarid_empresaComisionVentaCobro;
	}

	public void setCargarid_empresaComisionVentaCobro(Boolean cargarid_empresaComisionVentaCobro) {
		this.cargarid_empresaComisionVentaCobro= cargarid_empresaComisionVentaCobro;
	}

	public Border setResaltarid_ejercicioComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioComisionVentaCobro() {
		return this.resaltarid_ejercicioComisionVentaCobro;
	}

	public void setResaltarid_ejercicioComisionVentaCobro(Border borderResaltar) {
		this.resaltarid_ejercicioComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioComisionVentaCobro() {
		return this.mostrarid_ejercicioComisionVentaCobro;
	}

	public void setMostrarid_ejercicioComisionVentaCobro(Boolean mostrarid_ejercicioComisionVentaCobro) {
		this.mostrarid_ejercicioComisionVentaCobro= mostrarid_ejercicioComisionVentaCobro;
	}

	public Boolean getActivarid_ejercicioComisionVentaCobro() {
		return this.activarid_ejercicioComisionVentaCobro;
	}

	public void setActivarid_ejercicioComisionVentaCobro(Boolean activarid_ejercicioComisionVentaCobro) {
		this.activarid_ejercicioComisionVentaCobro= activarid_ejercicioComisionVentaCobro;
	}

	public Boolean getCargarid_ejercicioComisionVentaCobro() {
		return this.cargarid_ejercicioComisionVentaCobro;
	}

	public void setCargarid_ejercicioComisionVentaCobro(Boolean cargarid_ejercicioComisionVentaCobro) {
		this.cargarid_ejercicioComisionVentaCobro= cargarid_ejercicioComisionVentaCobro;
	}

	public Border setResaltarid_periodoComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarid_periodoComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoComisionVentaCobro() {
		return this.resaltarid_periodoComisionVentaCobro;
	}

	public void setResaltarid_periodoComisionVentaCobro(Border borderResaltar) {
		this.resaltarid_periodoComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarid_periodoComisionVentaCobro() {
		return this.mostrarid_periodoComisionVentaCobro;
	}

	public void setMostrarid_periodoComisionVentaCobro(Boolean mostrarid_periodoComisionVentaCobro) {
		this.mostrarid_periodoComisionVentaCobro= mostrarid_periodoComisionVentaCobro;
	}

	public Boolean getActivarid_periodoComisionVentaCobro() {
		return this.activarid_periodoComisionVentaCobro;
	}

	public void setActivarid_periodoComisionVentaCobro(Boolean activarid_periodoComisionVentaCobro) {
		this.activarid_periodoComisionVentaCobro= activarid_periodoComisionVentaCobro;
	}

	public Boolean getCargarid_periodoComisionVentaCobro() {
		return this.cargarid_periodoComisionVentaCobro;
	}

	public void setCargarid_periodoComisionVentaCobro(Boolean cargarid_periodoComisionVentaCobro) {
		this.cargarid_periodoComisionVentaCobro= cargarid_periodoComisionVentaCobro;
	}

	public Border setResaltarid_vendedorComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComisionVentaCobro() {
		return this.resaltarid_vendedorComisionVentaCobro;
	}

	public void setResaltarid_vendedorComisionVentaCobro(Border borderResaltar) {
		this.resaltarid_vendedorComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComisionVentaCobro() {
		return this.mostrarid_vendedorComisionVentaCobro;
	}

	public void setMostrarid_vendedorComisionVentaCobro(Boolean mostrarid_vendedorComisionVentaCobro) {
		this.mostrarid_vendedorComisionVentaCobro= mostrarid_vendedorComisionVentaCobro;
	}

	public Boolean getActivarid_vendedorComisionVentaCobro() {
		return this.activarid_vendedorComisionVentaCobro;
	}

	public void setActivarid_vendedorComisionVentaCobro(Boolean activarid_vendedorComisionVentaCobro) {
		this.activarid_vendedorComisionVentaCobro= activarid_vendedorComisionVentaCobro;
	}

	public Boolean getCargarid_vendedorComisionVentaCobro() {
		return this.cargarid_vendedorComisionVentaCobro;
	}

	public void setCargarid_vendedorComisionVentaCobro(Boolean cargarid_vendedorComisionVentaCobro) {
		this.cargarid_vendedorComisionVentaCobro= cargarid_vendedorComisionVentaCobro;
	}

	public Border setResaltarid_facturaComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarid_facturaComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaComisionVentaCobro() {
		return this.resaltarid_facturaComisionVentaCobro;
	}

	public void setResaltarid_facturaComisionVentaCobro(Border borderResaltar) {
		this.resaltarid_facturaComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarid_facturaComisionVentaCobro() {
		return this.mostrarid_facturaComisionVentaCobro;
	}

	public void setMostrarid_facturaComisionVentaCobro(Boolean mostrarid_facturaComisionVentaCobro) {
		this.mostrarid_facturaComisionVentaCobro= mostrarid_facturaComisionVentaCobro;
	}

	public Boolean getActivarid_facturaComisionVentaCobro() {
		return this.activarid_facturaComisionVentaCobro;
	}

	public void setActivarid_facturaComisionVentaCobro(Boolean activarid_facturaComisionVentaCobro) {
		this.activarid_facturaComisionVentaCobro= activarid_facturaComisionVentaCobro;
	}

	public Boolean getCargarid_facturaComisionVentaCobro() {
		return this.cargarid_facturaComisionVentaCobro;
	}

	public void setCargarid_facturaComisionVentaCobro(Boolean cargarid_facturaComisionVentaCobro) {
		this.cargarid_facturaComisionVentaCobro= cargarid_facturaComisionVentaCobro;
	}

	public Border setResaltarnumero_facturaComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaComisionVentaCobro() {
		return this.resaltarnumero_facturaComisionVentaCobro;
	}

	public void setResaltarnumero_facturaComisionVentaCobro(Border borderResaltar) {
		this.resaltarnumero_facturaComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaComisionVentaCobro() {
		return this.mostrarnumero_facturaComisionVentaCobro;
	}

	public void setMostrarnumero_facturaComisionVentaCobro(Boolean mostrarnumero_facturaComisionVentaCobro) {
		this.mostrarnumero_facturaComisionVentaCobro= mostrarnumero_facturaComisionVentaCobro;
	}

	public Boolean getActivarnumero_facturaComisionVentaCobro() {
		return this.activarnumero_facturaComisionVentaCobro;
	}

	public void setActivarnumero_facturaComisionVentaCobro(Boolean activarnumero_facturaComisionVentaCobro) {
		this.activarnumero_facturaComisionVentaCobro= activarnumero_facturaComisionVentaCobro;
	}

	public Border setResaltarfecha_pagoComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoComisionVentaCobro() {
		return this.resaltarfecha_pagoComisionVentaCobro;
	}

	public void setResaltarfecha_pagoComisionVentaCobro(Border borderResaltar) {
		this.resaltarfecha_pagoComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoComisionVentaCobro() {
		return this.mostrarfecha_pagoComisionVentaCobro;
	}

	public void setMostrarfecha_pagoComisionVentaCobro(Boolean mostrarfecha_pagoComisionVentaCobro) {
		this.mostrarfecha_pagoComisionVentaCobro= mostrarfecha_pagoComisionVentaCobro;
	}

	public Boolean getActivarfecha_pagoComisionVentaCobro() {
		return this.activarfecha_pagoComisionVentaCobro;
	}

	public void setActivarfecha_pagoComisionVentaCobro(Boolean activarfecha_pagoComisionVentaCobro) {
		this.activarfecha_pagoComisionVentaCobro= activarfecha_pagoComisionVentaCobro;
	}

	public Border setResaltarnombre_clienteComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteComisionVentaCobro() {
		return this.resaltarnombre_clienteComisionVentaCobro;
	}

	public void setResaltarnombre_clienteComisionVentaCobro(Border borderResaltar) {
		this.resaltarnombre_clienteComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteComisionVentaCobro() {
		return this.mostrarnombre_clienteComisionVentaCobro;
	}

	public void setMostrarnombre_clienteComisionVentaCobro(Boolean mostrarnombre_clienteComisionVentaCobro) {
		this.mostrarnombre_clienteComisionVentaCobro= mostrarnombre_clienteComisionVentaCobro;
	}

	public Boolean getActivarnombre_clienteComisionVentaCobro() {
		return this.activarnombre_clienteComisionVentaCobro;
	}

	public void setActivarnombre_clienteComisionVentaCobro(Boolean activarnombre_clienteComisionVentaCobro) {
		this.activarnombre_clienteComisionVentaCobro= activarnombre_clienteComisionVentaCobro;
	}

	public Border setResaltarnumero_comprobanteComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteComisionVentaCobro() {
		return this.resaltarnumero_comprobanteComisionVentaCobro;
	}

	public void setResaltarnumero_comprobanteComisionVentaCobro(Border borderResaltar) {
		this.resaltarnumero_comprobanteComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteComisionVentaCobro() {
		return this.mostrarnumero_comprobanteComisionVentaCobro;
	}

	public void setMostrarnumero_comprobanteComisionVentaCobro(Boolean mostrarnumero_comprobanteComisionVentaCobro) {
		this.mostrarnumero_comprobanteComisionVentaCobro= mostrarnumero_comprobanteComisionVentaCobro;
	}

	public Boolean getActivarnumero_comprobanteComisionVentaCobro() {
		return this.activarnumero_comprobanteComisionVentaCobro;
	}

	public void setActivarnumero_comprobanteComisionVentaCobro(Boolean activarnumero_comprobanteComisionVentaCobro) {
		this.activarnumero_comprobanteComisionVentaCobro= activarnumero_comprobanteComisionVentaCobro;
	}

	public Border setResaltarestadoComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarestadoComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoComisionVentaCobro() {
		return this.resaltarestadoComisionVentaCobro;
	}

	public void setResaltarestadoComisionVentaCobro(Border borderResaltar) {
		this.resaltarestadoComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarestadoComisionVentaCobro() {
		return this.mostrarestadoComisionVentaCobro;
	}

	public void setMostrarestadoComisionVentaCobro(Boolean mostrarestadoComisionVentaCobro) {
		this.mostrarestadoComisionVentaCobro= mostrarestadoComisionVentaCobro;
	}

	public Boolean getActivarestadoComisionVentaCobro() {
		return this.activarestadoComisionVentaCobro;
	}

	public void setActivarestadoComisionVentaCobro(Boolean activarestadoComisionVentaCobro) {
		this.activarestadoComisionVentaCobro= activarestadoComisionVentaCobro;
	}

	public Border setResaltartotal_facturaComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltartotal_facturaComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_facturaComisionVentaCobro() {
		return this.resaltartotal_facturaComisionVentaCobro;
	}

	public void setResaltartotal_facturaComisionVentaCobro(Border borderResaltar) {
		this.resaltartotal_facturaComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrartotal_facturaComisionVentaCobro() {
		return this.mostrartotal_facturaComisionVentaCobro;
	}

	public void setMostrartotal_facturaComisionVentaCobro(Boolean mostrartotal_facturaComisionVentaCobro) {
		this.mostrartotal_facturaComisionVentaCobro= mostrartotal_facturaComisionVentaCobro;
	}

	public Boolean getActivartotal_facturaComisionVentaCobro() {
		return this.activartotal_facturaComisionVentaCobro;
	}

	public void setActivartotal_facturaComisionVentaCobro(Boolean activartotal_facturaComisionVentaCobro) {
		this.activartotal_facturaComisionVentaCobro= activartotal_facturaComisionVentaCobro;
	}

	public Border setResaltartotal_abonoComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltartotal_abonoComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_abonoComisionVentaCobro() {
		return this.resaltartotal_abonoComisionVentaCobro;
	}

	public void setResaltartotal_abonoComisionVentaCobro(Border borderResaltar) {
		this.resaltartotal_abonoComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrartotal_abonoComisionVentaCobro() {
		return this.mostrartotal_abonoComisionVentaCobro;
	}

	public void setMostrartotal_abonoComisionVentaCobro(Boolean mostrartotal_abonoComisionVentaCobro) {
		this.mostrartotal_abonoComisionVentaCobro= mostrartotal_abonoComisionVentaCobro;
	}

	public Boolean getActivartotal_abonoComisionVentaCobro() {
		return this.activartotal_abonoComisionVentaCobro;
	}

	public void setActivartotal_abonoComisionVentaCobro(Boolean activartotal_abonoComisionVentaCobro) {
		this.activartotal_abonoComisionVentaCobro= activartotal_abonoComisionVentaCobro;
	}

	public Border setResaltarporcentaje_comisionComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarporcentaje_comisionComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_comisionComisionVentaCobro() {
		return this.resaltarporcentaje_comisionComisionVentaCobro;
	}

	public void setResaltarporcentaje_comisionComisionVentaCobro(Border borderResaltar) {
		this.resaltarporcentaje_comisionComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarporcentaje_comisionComisionVentaCobro() {
		return this.mostrarporcentaje_comisionComisionVentaCobro;
	}

	public void setMostrarporcentaje_comisionComisionVentaCobro(Boolean mostrarporcentaje_comisionComisionVentaCobro) {
		this.mostrarporcentaje_comisionComisionVentaCobro= mostrarporcentaje_comisionComisionVentaCobro;
	}

	public Boolean getActivarporcentaje_comisionComisionVentaCobro() {
		return this.activarporcentaje_comisionComisionVentaCobro;
	}

	public void setActivarporcentaje_comisionComisionVentaCobro(Boolean activarporcentaje_comisionComisionVentaCobro) {
		this.activarporcentaje_comisionComisionVentaCobro= activarporcentaje_comisionComisionVentaCobro;
	}

	public Border setResaltartotal_comision_cobroComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltartotal_comision_cobroComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_comision_cobroComisionVentaCobro() {
		return this.resaltartotal_comision_cobroComisionVentaCobro;
	}

	public void setResaltartotal_comision_cobroComisionVentaCobro(Border borderResaltar) {
		this.resaltartotal_comision_cobroComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrartotal_comision_cobroComisionVentaCobro() {
		return this.mostrartotal_comision_cobroComisionVentaCobro;
	}

	public void setMostrartotal_comision_cobroComisionVentaCobro(Boolean mostrartotal_comision_cobroComisionVentaCobro) {
		this.mostrartotal_comision_cobroComisionVentaCobro= mostrartotal_comision_cobroComisionVentaCobro;
	}

	public Boolean getActivartotal_comision_cobroComisionVentaCobro() {
		return this.activartotal_comision_cobroComisionVentaCobro;
	}

	public void setActivartotal_comision_cobroComisionVentaCobro(Boolean activartotal_comision_cobroComisionVentaCobro) {
		this.activartotal_comision_cobroComisionVentaCobro= activartotal_comision_cobroComisionVentaCobro;
	}

	public Border setResaltarnumero_diasComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisionventacobroBeanSwingJInternalFrame.jTtoolBarComisionVentaCobro.setBorder(borderResaltar);
		
		this.resaltarnumero_diasComisionVentaCobro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasComisionVentaCobro() {
		return this.resaltarnumero_diasComisionVentaCobro;
	}

	public void setResaltarnumero_diasComisionVentaCobro(Border borderResaltar) {
		this.resaltarnumero_diasComisionVentaCobro= borderResaltar;
	}

	public Boolean getMostrarnumero_diasComisionVentaCobro() {
		return this.mostrarnumero_diasComisionVentaCobro;
	}

	public void setMostrarnumero_diasComisionVentaCobro(Boolean mostrarnumero_diasComisionVentaCobro) {
		this.mostrarnumero_diasComisionVentaCobro= mostrarnumero_diasComisionVentaCobro;
	}

	public Boolean getActivarnumero_diasComisionVentaCobro() {
		return this.activarnumero_diasComisionVentaCobro;
	}

	public void setActivarnumero_diasComisionVentaCobro(Boolean activarnumero_diasComisionVentaCobro) {
		this.activarnumero_diasComisionVentaCobro= activarnumero_diasComisionVentaCobro;
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
		
		
		this.setMostraridComisionVentaCobro(esInicial);
		this.setMostrarid_empresaComisionVentaCobro(esInicial);
		this.setMostrarid_ejercicioComisionVentaCobro(esInicial);
		this.setMostrarid_periodoComisionVentaCobro(esInicial);
		this.setMostrarid_vendedorComisionVentaCobro(esInicial);
		this.setMostrarid_facturaComisionVentaCobro(esInicial);
		this.setMostrarnumero_facturaComisionVentaCobro(esInicial);
		this.setMostrarfecha_pagoComisionVentaCobro(esInicial);
		this.setMostrarnombre_clienteComisionVentaCobro(esInicial);
		this.setMostrarnumero_comprobanteComisionVentaCobro(esInicial);
		this.setMostrarestadoComisionVentaCobro(esInicial);
		this.setMostrartotal_facturaComisionVentaCobro(esInicial);
		this.setMostrartotal_abonoComisionVentaCobro(esInicial);
		this.setMostrarporcentaje_comisionComisionVentaCobro(esInicial);
		this.setMostrartotal_comision_cobroComisionVentaCobro(esInicial);
		this.setMostrarnumero_diasComisionVentaCobro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ID)) {
				this.setMostraridComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ESTADO)) {
				this.setMostrarestadoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALFACTURA)) {
				this.setMostrartotal_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALABONO)) {
				this.setMostrartotal_abonoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION)) {
				this.setMostrarporcentaje_comisionComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO)) {
				this.setMostrartotal_comision_cobroComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasComisionVentaCobro(esAsigna);
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
		
		
		this.setActivaridComisionVentaCobro(esInicial);
		this.setActivarid_empresaComisionVentaCobro(esInicial);
		this.setActivarid_ejercicioComisionVentaCobro(esInicial);
		this.setActivarid_periodoComisionVentaCobro(esInicial);
		this.setActivarid_vendedorComisionVentaCobro(esInicial);
		this.setActivarid_facturaComisionVentaCobro(esInicial);
		this.setActivarnumero_facturaComisionVentaCobro(esInicial);
		this.setActivarfecha_pagoComisionVentaCobro(esInicial);
		this.setActivarnombre_clienteComisionVentaCobro(esInicial);
		this.setActivarnumero_comprobanteComisionVentaCobro(esInicial);
		this.setActivarestadoComisionVentaCobro(esInicial);
		this.setActivartotal_facturaComisionVentaCobro(esInicial);
		this.setActivartotal_abonoComisionVentaCobro(esInicial);
		this.setActivarporcentaje_comisionComisionVentaCobro(esInicial);
		this.setActivartotal_comision_cobroComisionVentaCobro(esInicial);
		this.setActivarnumero_diasComisionVentaCobro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ID)) {
				this.setActivaridComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ESTADO)) {
				this.setActivarestadoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALFACTURA)) {
				this.setActivartotal_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALABONO)) {
				this.setActivartotal_abonoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION)) {
				this.setActivarporcentaje_comisionComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO)) {
				this.setActivartotal_comision_cobroComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasComisionVentaCobro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionVentaCobro(esInicial);
		this.setResaltarid_empresaComisionVentaCobro(esInicial);
		this.setResaltarid_ejercicioComisionVentaCobro(esInicial);
		this.setResaltarid_periodoComisionVentaCobro(esInicial);
		this.setResaltarid_vendedorComisionVentaCobro(esInicial);
		this.setResaltarid_facturaComisionVentaCobro(esInicial);
		this.setResaltarnumero_facturaComisionVentaCobro(esInicial);
		this.setResaltarfecha_pagoComisionVentaCobro(esInicial);
		this.setResaltarnombre_clienteComisionVentaCobro(esInicial);
		this.setResaltarnumero_comprobanteComisionVentaCobro(esInicial);
		this.setResaltarestadoComisionVentaCobro(esInicial);
		this.setResaltartotal_facturaComisionVentaCobro(esInicial);
		this.setResaltartotal_abonoComisionVentaCobro(esInicial);
		this.setResaltarporcentaje_comisionComisionVentaCobro(esInicial);
		this.setResaltartotal_comision_cobroComisionVentaCobro(esInicial);
		this.setResaltarnumero_diasComisionVentaCobro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ID)) {
				this.setResaltaridComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.ESTADO)) {
				this.setResaltarestadoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALFACTURA)) {
				this.setResaltartotal_facturaComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALABONO)) {
				this.setResaltartotal_abonoComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION)) {
				this.setResaltarporcentaje_comisionComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO)) {
				this.setResaltartotal_comision_cobroComisionVentaCobro(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionVentaCobroConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasComisionVentaCobro(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaComisionVentaCobro=true;

	public Boolean getMostrarFK_IdEmpresaComisionVentaCobro() {
		return this.mostrarFK_IdEmpresaComisionVentaCobro;
	}

	public void setMostrarFK_IdEmpresaComisionVentaCobro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionVentaCobro= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaComisionVentaCobro=true;

	public Boolean getActivarFK_IdEmpresaComisionVentaCobro() {
		return this.activarFK_IdEmpresaComisionVentaCobro;
	}

	public void setActivarFK_IdEmpresaComisionVentaCobro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionVentaCobro= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaComisionVentaCobro=null;

	public Border getResaltarFK_IdEmpresaComisionVentaCobro() {
		return this.resaltarFK_IdEmpresaComisionVentaCobro;
	}

	public void setResaltarFK_IdEmpresaComisionVentaCobro(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionVentaCobro= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionVentaCobro(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionVentaCobroBeanSwingJInternalFrame comisionventacobroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionVentaCobro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}