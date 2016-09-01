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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SaldosVencidosProveedoresConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="SaldosVencidosProveedores";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SaldosVencidosProveedores"+SaldosVencidosProveedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SaldosVencidosProveedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SaldosVencidosProveedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"_"+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SaldosVencidosProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"_"+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"_"+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SaldosVencidosProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"_"+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosVencidosProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SaldosVencidosProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SaldosVencidosProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SaldosVencidosProveedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SaldosVencidosProveedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SaldosVencidosProveedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SaldosVencidosProveedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Saldos Vencidos Proveedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Saldos Vencidos Proveedores";
	public static final String SCLASSWEBTITULO_LOWER="Saldos Vencidos Proveedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SaldosVencidosProveedores";
	public static final String OBJECTNAME="saldosvencidosproveedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="saldos_vencidos_proveedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select saldosvencidosproveedores from "+SaldosVencidosProveedoresConstantesFunciones.SPERSISTENCENAME+" saldosvencidosproveedores";
	public static String QUERYSELECTNATIVE="select "+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".version_row,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id_empresa,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id_grupo_cliente,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id_factura,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id_moneda,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".id_cliente,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".numero_factura,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".fecha_emision,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".fecha_venta,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".nombre_moneda,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".saldo,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".saldo_extra,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".nombre_cliente,"+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME+".nombre_grupo_cliente from "+SaldosVencidosProveedoresConstantesFunciones.SCHEMA+"."+SaldosVencidosProveedoresConstantesFunciones.TABLENAME;//+" as "+SaldosVencidosProveedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String NOMBREMONEDA= "nombre_moneda";
    public static final String SALDO= "saldo";
    public static final String SALDOEXTRA= "saldo_extra";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NOMBREGRUPOCLIENTE= "nombre_grupo_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_NOMBREMONEDA= "Nombre Moneda";
		public static final String LABEL_NOMBREMONEDA_LOWER= "Nombre Moneda";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_SALDOEXTRA= "Saldo Extra";
		public static final String LABEL_SALDOEXTRA_LOWER= "Saldo Extra";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NOMBREGRUPOCLIENTE= "Nombre Grupo Cliente";
		public static final String LABEL_NOMBREGRUPOCLIENTE_LOWER= "Nombre Grupo Cliente";
	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_MONEDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MONEDA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSaldosVencidosProveedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.IDFACTURA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.IDMONEDA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREMONEDA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.SALDO)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {sLabelColumna=SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSaldosVencidosProveedoresDescripcion(SaldosVencidosProveedores saldosvencidosproveedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(saldosvencidosproveedores !=null/* && saldosvencidosproveedores.getId()!=0*/) {
			if(saldosvencidosproveedores.getId()!=null) {
				sDescripcion=saldosvencidosproveedores.getId().toString();
			}//saldosvencidosproveedoressaldosvencidosproveedores.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSaldosVencidosProveedoresDescripcionDetallado(SaldosVencidosProveedores saldosvencidosproveedores) {
		String sDescripcion="";
			
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.ID+"=";
		sDescripcion+=saldosvencidosproveedores.getId().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=saldosvencidosproveedores.getVersionRow().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=saldosvencidosproveedores.getid_empresa().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=saldosvencidosproveedores.getid_grupo_cliente().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=saldosvencidosproveedores.getid_factura().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=saldosvencidosproveedores.getid_moneda().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=saldosvencidosproveedores.getid_cliente().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=saldosvencidosproveedores.getnumero_factura()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=saldosvencidosproveedores.getfecha_emision().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=saldosvencidosproveedores.getfecha_venta().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA+"=";
		sDescripcion+=saldosvencidosproveedores.getnombre_moneda()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.SALDO+"=";
		sDescripcion+=saldosvencidosproveedores.getsaldo().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA+"=";
		sDescripcion+=saldosvencidosproveedores.getsaldo_extra().toString()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=saldosvencidosproveedores.getnombre_cliente()+",";
		sDescripcion+=SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE+"=";
		sDescripcion+=saldosvencidosproveedores.getnombre_grupo_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setSaldosVencidosProveedoresDescripcion(SaldosVencidosProveedores saldosvencidosproveedores,String sValor) throws Exception {			
		if(saldosvencidosproveedores !=null) {
			//saldosvencidosproveedoressaldosvencidosproveedores.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaSaldosVencidosProveedores")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaSaldosVencidosProveedores(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldosvencidosproveedores.setnumero_factura(saldosvencidosproveedores.getnumero_factura().trim());
		saldosvencidosproveedores.setnombre_moneda(saldosvencidosproveedores.getnombre_moneda().trim());
		saldosvencidosproveedores.setnombre_cliente(saldosvencidosproveedores.getnombre_cliente().trim());
		saldosvencidosproveedores.setnombre_grupo_cliente(saldosvencidosproveedores.getnombre_grupo_cliente().trim());
	}
	
	public static void quitarEspaciosSaldosVencidosProveedoress(List<SaldosVencidosProveedores> saldosvencidosproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {
			saldosvencidosproveedores.setnumero_factura(saldosvencidosproveedores.getnumero_factura().trim());
			saldosvencidosproveedores.setnombre_moneda(saldosvencidosproveedores.getnombre_moneda().trim());
			saldosvencidosproveedores.setnombre_cliente(saldosvencidosproveedores.getnombre_cliente().trim());
			saldosvencidosproveedores.setnombre_grupo_cliente(saldosvencidosproveedores.getnombre_grupo_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && saldosvencidosproveedores.getConCambioAuxiliar()) {
			saldosvencidosproveedores.setIsDeleted(saldosvencidosproveedores.getIsDeletedAuxiliar());	
			saldosvencidosproveedores.setIsNew(saldosvencidosproveedores.getIsNewAuxiliar());	
			saldosvencidosproveedores.setIsChanged(saldosvencidosproveedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			saldosvencidosproveedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			saldosvencidosproveedores.setIsDeletedAuxiliar(false);	
			saldosvencidosproveedores.setIsNewAuxiliar(false);	
			saldosvencidosproveedores.setIsChangedAuxiliar(false);
			
			saldosvencidosproveedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSaldosVencidosProveedoress(List<SaldosVencidosProveedores> saldosvencidosproveedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SaldosVencidosProveedores saldosvencidosproveedores : saldosvencidosproveedoress) {
			if(conAsignarBase && saldosvencidosproveedores.getConCambioAuxiliar()) {
				saldosvencidosproveedores.setIsDeleted(saldosvencidosproveedores.getIsDeletedAuxiliar());	
				saldosvencidosproveedores.setIsNew(saldosvencidosproveedores.getIsNewAuxiliar());	
				saldosvencidosproveedores.setIsChanged(saldosvencidosproveedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				saldosvencidosproveedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				saldosvencidosproveedores.setIsDeletedAuxiliar(false);	
				saldosvencidosproveedores.setIsNewAuxiliar(false);	
				saldosvencidosproveedores.setIsChangedAuxiliar(false);
				
				saldosvencidosproveedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedores,Boolean conEnteros) throws Exception  {
		saldosvencidosproveedores.setsaldo(0.0);
		saldosvencidosproveedores.setsaldo_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSaldosVencidosProveedoress(List<SaldosVencidosProveedores> saldosvencidosproveedoress,Boolean conEnteros) throws Exception  {
		
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {
			saldosvencidosproveedores.setsaldo(0.0);
			saldosvencidosproveedores.setsaldo_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSaldosVencidosProveedores(List<SaldosVencidosProveedores> saldosvencidosproveedoress,SaldosVencidosProveedores saldosvencidosproveedoresAux) throws Exception  {
		SaldosVencidosProveedoresConstantesFunciones.InicializarValoresSaldosVencidosProveedores(saldosvencidosproveedoresAux,true);
		
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {
			if(saldosvencidosproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldosvencidosproveedoresAux.setsaldo(saldosvencidosproveedoresAux.getsaldo()+saldosvencidosproveedores.getsaldo());			
			saldosvencidosproveedoresAux.setsaldo_extra(saldosvencidosproveedoresAux.getsaldo_extra()+saldosvencidosproveedores.getsaldo_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosVencidosProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SaldosVencidosProveedoresConstantesFunciones.getArrayColumnasGlobalesSaldosVencidosProveedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosVencidosProveedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSaldosVencidosProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosVencidosProveedores> saldosvencidosproveedoress,SaldosVencidosProveedores saldosvencidosproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosVencidosProveedores saldosvencidosproveedoresAux: saldosvencidosproveedoress) {
			if(saldosvencidosproveedoresAux!=null && saldosvencidosproveedores!=null) {
				if((saldosvencidosproveedoresAux.getId()==null && saldosvencidosproveedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(saldosvencidosproveedoresAux.getId()!=null && saldosvencidosproveedores.getId()!=null){
					if(saldosvencidosproveedoresAux.getId().equals(saldosvencidosproveedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosVencidosProveedores(List<SaldosVencidosProveedores> saldosvencidosproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
		Double saldo_extraTotal=0.0;
	
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {			
			if(saldosvencidosproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=saldosvencidosproveedores.getsaldo();
			saldo_extraTotal+=saldosvencidosproveedores.getsaldo_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA);
		datoGeneral.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA);
		datoGeneral.setdValorDouble(saldo_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSaldosVencidosProveedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_ID, SaldosVencidosProveedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_VERSIONROW, SaldosVencidosProveedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_IDFACTURA, SaldosVencidosProveedoresConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_IDMONEDA, SaldosVencidosProveedoresConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_IDCLIENTE, SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_NUMEROFACTURA, SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAEMISION, SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAVENTA, SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREMONEDA, SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO, SaldosVencidosProveedoresConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA, SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE, SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE, SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSaldosVencidosProveedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosVencidosProveedores() throws Exception  {
		return SaldosVencidosProveedoresConstantesFunciones.getTiposSeleccionarSaldosVencidosProveedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosVencidosProveedores(Boolean conFk) throws Exception  {
		return SaldosVencidosProveedoresConstantesFunciones.getTiposSeleccionarSaldosVencidosProveedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSaldosVencidosProveedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREMONEDA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
			reporte.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSaldosVencidosProveedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedoresAux) throws Exception {
		
			saldosvencidosproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldosvencidosproveedoresAux.getEmpresa()));
			saldosvencidosproveedoresAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(saldosvencidosproveedoresAux.getGrupoCliente()));
			saldosvencidosproveedoresAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(saldosvencidosproveedoresAux.getFactura()));
			saldosvencidosproveedoresAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(saldosvencidosproveedoresAux.getMoneda()));
			saldosvencidosproveedoresAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(saldosvencidosproveedoresAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSaldosVencidosProveedores(List<SaldosVencidosProveedores> saldosvencidosproveedoressTemp) throws Exception {
		for(SaldosVencidosProveedores saldosvencidosproveedoresAux:saldosvencidosproveedoressTemp) {
			
			saldosvencidosproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(saldosvencidosproveedoresAux.getEmpresa()));
			saldosvencidosproveedoresAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(saldosvencidosproveedoresAux.getGrupoCliente()));
			saldosvencidosproveedoresAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(saldosvencidosproveedoresAux.getFactura()));
			saldosvencidosproveedoresAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(saldosvencidosproveedoresAux.getMoneda()));
			saldosvencidosproveedoresAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(saldosvencidosproveedoresAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSaldosVencidosProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSaldosVencidosProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosVencidosProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosVencidosProveedoresConstantesFunciones.getClassesRelationshipsOfSaldosVencidosProveedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSaldosVencidosProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosVencidosProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SaldosVencidosProveedoresConstantesFunciones.getClassesRelationshipsFromStringsOfSaldosVencidosProveedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSaldosVencidosProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SaldosVencidosProveedores saldosvencidosproveedores,List<SaldosVencidosProveedores> saldosvencidosproveedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(SaldosVencidosProveedores saldosvencidosproveedores,List<SaldosVencidosProveedores> saldosvencidosproveedoress) throws Exception {
		try	{			
			for(SaldosVencidosProveedores saldosvencidosproveedoresLocal:saldosvencidosproveedoress) {
				if(saldosvencidosproveedoresLocal.getId().equals(saldosvencidosproveedores.getId())) {
					saldosvencidosproveedoresLocal.setIsSelected(saldosvencidosproveedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSaldosVencidosProveedores(List<SaldosVencidosProveedores> saldosvencidosproveedoressAux) throws Exception {
		//this.saldosvencidosproveedoressAux=saldosvencidosproveedoressAux;
		
		for(SaldosVencidosProveedores saldosvencidosproveedoresAux:saldosvencidosproveedoressAux) {
			if(saldosvencidosproveedoresAux.getIsChanged()) {
				saldosvencidosproveedoresAux.setIsChanged(false);
			}		
			
			if(saldosvencidosproveedoresAux.getIsNew()) {
				saldosvencidosproveedoresAux.setIsNew(false);
			}	
			
			if(saldosvencidosproveedoresAux.getIsDeleted()) {
				saldosvencidosproveedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedoresAux) throws Exception {
		//this.saldosvencidosproveedoresAux=saldosvencidosproveedoresAux;
		
			if(saldosvencidosproveedoresAux.getIsChanged()) {
				saldosvencidosproveedoresAux.setIsChanged(false);
			}		
			
			if(saldosvencidosproveedoresAux.getIsNew()) {
				saldosvencidosproveedoresAux.setIsNew(false);
			}	
			
			if(saldosvencidosproveedoresAux.getIsDeleted()) {
				saldosvencidosproveedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SaldosVencidosProveedores saldosvencidosproveedoresAsignar,SaldosVencidosProveedores saldosvencidosproveedores) throws Exception {
		saldosvencidosproveedoresAsignar.setId(saldosvencidosproveedores.getId());	
		saldosvencidosproveedoresAsignar.setVersionRow(saldosvencidosproveedores.getVersionRow());	
		saldosvencidosproveedoresAsignar.setid_factura(saldosvencidosproveedores.getid_factura());
		saldosvencidosproveedoresAsignar.setfactura_descripcion(saldosvencidosproveedores.getfactura_descripcion());	
		saldosvencidosproveedoresAsignar.setid_moneda(saldosvencidosproveedores.getid_moneda());
		saldosvencidosproveedoresAsignar.setmoneda_descripcion(saldosvencidosproveedores.getmoneda_descripcion());	
		saldosvencidosproveedoresAsignar.setid_cliente(saldosvencidosproveedores.getid_cliente());
		saldosvencidosproveedoresAsignar.setcliente_descripcion(saldosvencidosproveedores.getcliente_descripcion());	
		saldosvencidosproveedoresAsignar.setnumero_factura(saldosvencidosproveedores.getnumero_factura());	
		saldosvencidosproveedoresAsignar.setfecha_emision(saldosvencidosproveedores.getfecha_emision());	
		saldosvencidosproveedoresAsignar.setfecha_venta(saldosvencidosproveedores.getfecha_venta());	
		saldosvencidosproveedoresAsignar.setnombre_moneda(saldosvencidosproveedores.getnombre_moneda());	
		saldosvencidosproveedoresAsignar.setsaldo(saldosvencidosproveedores.getsaldo());	
		saldosvencidosproveedoresAsignar.setsaldo_extra(saldosvencidosproveedores.getsaldo_extra());	
		saldosvencidosproveedoresAsignar.setnombre_cliente(saldosvencidosproveedores.getnombre_cliente());	
		saldosvencidosproveedoresAsignar.setnombre_grupo_cliente(saldosvencidosproveedores.getnombre_grupo_cliente());	
	}
	
	public static void inicializarSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedores) throws Exception {
		try {
				saldosvencidosproveedores.setId(0L);	
					
				saldosvencidosproveedores.setid_factura(-1L);	
				saldosvencidosproveedores.setid_moneda(-1L);	
				saldosvencidosproveedores.setid_cliente(-1L);	
				saldosvencidosproveedores.setnumero_factura("");	
				saldosvencidosproveedores.setfecha_emision(new Date());	
				saldosvencidosproveedores.setfecha_venta(new Date());	
				saldosvencidosproveedores.setnombre_moneda("");	
				saldosvencidosproveedores.setsaldo(0.0);	
				saldosvencidosproveedores.setsaldo_extra(0.0);	
				saldosvencidosproveedores.setnombre_cliente("");	
				saldosvencidosproveedores.setnombre_grupo_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSaldosVencidosProveedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SaldosVencidosProveedoresConstantesFunciones.LABEL_NOMBREGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSaldosVencidosProveedores(String sTipo,Row row,Workbook workbook,SaldosVencidosProveedores saldosvencidosproveedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getnombre_moneda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getsaldo_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(saldosvencidosproveedores.getnombre_grupo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySaldosVencidosProveedores="";
	
	public String getsFinalQuerySaldosVencidosProveedores() {
		return this.sFinalQuerySaldosVencidosProveedores;
	}
	
	public void setsFinalQuerySaldosVencidosProveedores(String sFinalQuerySaldosVencidosProveedores) {
		this.sFinalQuerySaldosVencidosProveedores= sFinalQuerySaldosVencidosProveedores;
	}
	
	public Border resaltarSeleccionarSaldosVencidosProveedores=null;
	
	public Border setResaltarSeleccionarSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSaldosVencidosProveedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSaldosVencidosProveedores() {
		return this.resaltarSeleccionarSaldosVencidosProveedores;
	}
	
	public void setResaltarSeleccionarSaldosVencidosProveedores(Border borderResaltarSeleccionarSaldosVencidosProveedores) {
		this.resaltarSeleccionarSaldosVencidosProveedores= borderResaltarSeleccionarSaldosVencidosProveedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSaldosVencidosProveedores=null;
	public Boolean mostraridSaldosVencidosProveedores=true;
	public Boolean activaridSaldosVencidosProveedores=true;

	public Border resaltarid_empresaSaldosVencidosProveedores=null;
	public Boolean mostrarid_empresaSaldosVencidosProveedores=true;
	public Boolean activarid_empresaSaldosVencidosProveedores=true;
	public Boolean cargarid_empresaSaldosVencidosProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSaldosVencidosProveedores=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteSaldosVencidosProveedores=null;
	public Boolean mostrarid_grupo_clienteSaldosVencidosProveedores=true;
	public Boolean activarid_grupo_clienteSaldosVencidosProveedores=true;
	public Boolean cargarid_grupo_clienteSaldosVencidosProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteSaldosVencidosProveedores=false;//ConEventDepend=true

	public Border resaltarid_facturaSaldosVencidosProveedores=null;
	public Boolean mostrarid_facturaSaldosVencidosProveedores=true;
	public Boolean activarid_facturaSaldosVencidosProveedores=true;
	public Boolean cargarid_facturaSaldosVencidosProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaSaldosVencidosProveedores=false;//ConEventDepend=true

	public Border resaltarid_monedaSaldosVencidosProveedores=null;
	public Boolean mostrarid_monedaSaldosVencidosProveedores=true;
	public Boolean activarid_monedaSaldosVencidosProveedores=true;
	public Boolean cargarid_monedaSaldosVencidosProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaSaldosVencidosProveedores=false;//ConEventDepend=true

	public Border resaltarid_clienteSaldosVencidosProveedores=null;
	public Boolean mostrarid_clienteSaldosVencidosProveedores=true;
	public Boolean activarid_clienteSaldosVencidosProveedores=true;
	public Boolean cargarid_clienteSaldosVencidosProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteSaldosVencidosProveedores=false;//ConEventDepend=true

	public Border resaltarnumero_facturaSaldosVencidosProveedores=null;
	public Boolean mostrarnumero_facturaSaldosVencidosProveedores=true;
	public Boolean activarnumero_facturaSaldosVencidosProveedores=true;

	public Border resaltarfecha_emisionSaldosVencidosProveedores=null;
	public Boolean mostrarfecha_emisionSaldosVencidosProveedores=true;
	public Boolean activarfecha_emisionSaldosVencidosProveedores=true;

	public Border resaltarfecha_ventaSaldosVencidosProveedores=null;
	public Boolean mostrarfecha_ventaSaldosVencidosProveedores=true;
	public Boolean activarfecha_ventaSaldosVencidosProveedores=true;

	public Border resaltarnombre_monedaSaldosVencidosProveedores=null;
	public Boolean mostrarnombre_monedaSaldosVencidosProveedores=true;
	public Boolean activarnombre_monedaSaldosVencidosProveedores=true;

	public Border resaltarsaldoSaldosVencidosProveedores=null;
	public Boolean mostrarsaldoSaldosVencidosProveedores=true;
	public Boolean activarsaldoSaldosVencidosProveedores=true;

	public Border resaltarsaldo_extraSaldosVencidosProveedores=null;
	public Boolean mostrarsaldo_extraSaldosVencidosProveedores=true;
	public Boolean activarsaldo_extraSaldosVencidosProveedores=true;

	public Border resaltarnombre_clienteSaldosVencidosProveedores=null;
	public Boolean mostrarnombre_clienteSaldosVencidosProveedores=true;
	public Boolean activarnombre_clienteSaldosVencidosProveedores=true;

	public Border resaltarnombre_grupo_clienteSaldosVencidosProveedores=null;
	public Boolean mostrarnombre_grupo_clienteSaldosVencidosProveedores=true;
	public Boolean activarnombre_grupo_clienteSaldosVencidosProveedores=true;

	
	

	public Border setResaltaridSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltaridSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSaldosVencidosProveedores() {
		return this.resaltaridSaldosVencidosProveedores;
	}

	public void setResaltaridSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltaridSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostraridSaldosVencidosProveedores() {
		return this.mostraridSaldosVencidosProveedores;
	}

	public void setMostraridSaldosVencidosProveedores(Boolean mostraridSaldosVencidosProveedores) {
		this.mostraridSaldosVencidosProveedores= mostraridSaldosVencidosProveedores;
	}

	public Boolean getActivaridSaldosVencidosProveedores() {
		return this.activaridSaldosVencidosProveedores;
	}

	public void setActivaridSaldosVencidosProveedores(Boolean activaridSaldosVencidosProveedores) {
		this.activaridSaldosVencidosProveedores= activaridSaldosVencidosProveedores;
	}

	public Border setResaltarid_empresaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSaldosVencidosProveedores() {
		return this.resaltarid_empresaSaldosVencidosProveedores;
	}

	public void setResaltarid_empresaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarid_empresaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaSaldosVencidosProveedores() {
		return this.mostrarid_empresaSaldosVencidosProveedores;
	}

	public void setMostrarid_empresaSaldosVencidosProveedores(Boolean mostrarid_empresaSaldosVencidosProveedores) {
		this.mostrarid_empresaSaldosVencidosProveedores= mostrarid_empresaSaldosVencidosProveedores;
	}

	public Boolean getActivarid_empresaSaldosVencidosProveedores() {
		return this.activarid_empresaSaldosVencidosProveedores;
	}

	public void setActivarid_empresaSaldosVencidosProveedores(Boolean activarid_empresaSaldosVencidosProveedores) {
		this.activarid_empresaSaldosVencidosProveedores= activarid_empresaSaldosVencidosProveedores;
	}

	public Boolean getCargarid_empresaSaldosVencidosProveedores() {
		return this.cargarid_empresaSaldosVencidosProveedores;
	}

	public void setCargarid_empresaSaldosVencidosProveedores(Boolean cargarid_empresaSaldosVencidosProveedores) {
		this.cargarid_empresaSaldosVencidosProveedores= cargarid_empresaSaldosVencidosProveedores;
	}

	public Border setResaltarid_grupo_clienteSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteSaldosVencidosProveedores() {
		return this.resaltarid_grupo_clienteSaldosVencidosProveedores;
	}

	public void setResaltarid_grupo_clienteSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarid_grupo_clienteSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteSaldosVencidosProveedores() {
		return this.mostrarid_grupo_clienteSaldosVencidosProveedores;
	}

	public void setMostrarid_grupo_clienteSaldosVencidosProveedores(Boolean mostrarid_grupo_clienteSaldosVencidosProveedores) {
		this.mostrarid_grupo_clienteSaldosVencidosProveedores= mostrarid_grupo_clienteSaldosVencidosProveedores;
	}

	public Boolean getActivarid_grupo_clienteSaldosVencidosProveedores() {
		return this.activarid_grupo_clienteSaldosVencidosProveedores;
	}

	public void setActivarid_grupo_clienteSaldosVencidosProveedores(Boolean activarid_grupo_clienteSaldosVencidosProveedores) {
		this.activarid_grupo_clienteSaldosVencidosProveedores= activarid_grupo_clienteSaldosVencidosProveedores;
	}

	public Boolean getCargarid_grupo_clienteSaldosVencidosProveedores() {
		return this.cargarid_grupo_clienteSaldosVencidosProveedores;
	}

	public void setCargarid_grupo_clienteSaldosVencidosProveedores(Boolean cargarid_grupo_clienteSaldosVencidosProveedores) {
		this.cargarid_grupo_clienteSaldosVencidosProveedores= cargarid_grupo_clienteSaldosVencidosProveedores;
	}

	public Border setResaltarid_facturaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarid_facturaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaSaldosVencidosProveedores() {
		return this.resaltarid_facturaSaldosVencidosProveedores;
	}

	public void setResaltarid_facturaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarid_facturaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarid_facturaSaldosVencidosProveedores() {
		return this.mostrarid_facturaSaldosVencidosProveedores;
	}

	public void setMostrarid_facturaSaldosVencidosProveedores(Boolean mostrarid_facturaSaldosVencidosProveedores) {
		this.mostrarid_facturaSaldosVencidosProveedores= mostrarid_facturaSaldosVencidosProveedores;
	}

	public Boolean getActivarid_facturaSaldosVencidosProveedores() {
		return this.activarid_facturaSaldosVencidosProveedores;
	}

	public void setActivarid_facturaSaldosVencidosProveedores(Boolean activarid_facturaSaldosVencidosProveedores) {
		this.activarid_facturaSaldosVencidosProveedores= activarid_facturaSaldosVencidosProveedores;
	}

	public Boolean getCargarid_facturaSaldosVencidosProveedores() {
		return this.cargarid_facturaSaldosVencidosProveedores;
	}

	public void setCargarid_facturaSaldosVencidosProveedores(Boolean cargarid_facturaSaldosVencidosProveedores) {
		this.cargarid_facturaSaldosVencidosProveedores= cargarid_facturaSaldosVencidosProveedores;
	}

	public Border setResaltarid_monedaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarid_monedaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaSaldosVencidosProveedores() {
		return this.resaltarid_monedaSaldosVencidosProveedores;
	}

	public void setResaltarid_monedaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarid_monedaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarid_monedaSaldosVencidosProveedores() {
		return this.mostrarid_monedaSaldosVencidosProveedores;
	}

	public void setMostrarid_monedaSaldosVencidosProveedores(Boolean mostrarid_monedaSaldosVencidosProveedores) {
		this.mostrarid_monedaSaldosVencidosProveedores= mostrarid_monedaSaldosVencidosProveedores;
	}

	public Boolean getActivarid_monedaSaldosVencidosProveedores() {
		return this.activarid_monedaSaldosVencidosProveedores;
	}

	public void setActivarid_monedaSaldosVencidosProveedores(Boolean activarid_monedaSaldosVencidosProveedores) {
		this.activarid_monedaSaldosVencidosProveedores= activarid_monedaSaldosVencidosProveedores;
	}

	public Boolean getCargarid_monedaSaldosVencidosProveedores() {
		return this.cargarid_monedaSaldosVencidosProveedores;
	}

	public void setCargarid_monedaSaldosVencidosProveedores(Boolean cargarid_monedaSaldosVencidosProveedores) {
		this.cargarid_monedaSaldosVencidosProveedores= cargarid_monedaSaldosVencidosProveedores;
	}

	public Border setResaltarid_clienteSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarid_clienteSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteSaldosVencidosProveedores() {
		return this.resaltarid_clienteSaldosVencidosProveedores;
	}

	public void setResaltarid_clienteSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarid_clienteSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarid_clienteSaldosVencidosProveedores() {
		return this.mostrarid_clienteSaldosVencidosProveedores;
	}

	public void setMostrarid_clienteSaldosVencidosProveedores(Boolean mostrarid_clienteSaldosVencidosProveedores) {
		this.mostrarid_clienteSaldosVencidosProveedores= mostrarid_clienteSaldosVencidosProveedores;
	}

	public Boolean getActivarid_clienteSaldosVencidosProveedores() {
		return this.activarid_clienteSaldosVencidosProveedores;
	}

	public void setActivarid_clienteSaldosVencidosProveedores(Boolean activarid_clienteSaldosVencidosProveedores) {
		this.activarid_clienteSaldosVencidosProveedores= activarid_clienteSaldosVencidosProveedores;
	}

	public Boolean getCargarid_clienteSaldosVencidosProveedores() {
		return this.cargarid_clienteSaldosVencidosProveedores;
	}

	public void setCargarid_clienteSaldosVencidosProveedores(Boolean cargarid_clienteSaldosVencidosProveedores) {
		this.cargarid_clienteSaldosVencidosProveedores= cargarid_clienteSaldosVencidosProveedores;
	}

	public Border setResaltarnumero_facturaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaSaldosVencidosProveedores() {
		return this.resaltarnumero_facturaSaldosVencidosProveedores;
	}

	public void setResaltarnumero_facturaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarnumero_facturaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaSaldosVencidosProveedores() {
		return this.mostrarnumero_facturaSaldosVencidosProveedores;
	}

	public void setMostrarnumero_facturaSaldosVencidosProveedores(Boolean mostrarnumero_facturaSaldosVencidosProveedores) {
		this.mostrarnumero_facturaSaldosVencidosProveedores= mostrarnumero_facturaSaldosVencidosProveedores;
	}

	public Boolean getActivarnumero_facturaSaldosVencidosProveedores() {
		return this.activarnumero_facturaSaldosVencidosProveedores;
	}

	public void setActivarnumero_facturaSaldosVencidosProveedores(Boolean activarnumero_facturaSaldosVencidosProveedores) {
		this.activarnumero_facturaSaldosVencidosProveedores= activarnumero_facturaSaldosVencidosProveedores;
	}

	public Border setResaltarfecha_emisionSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSaldosVencidosProveedores() {
		return this.resaltarfecha_emisionSaldosVencidosProveedores;
	}

	public void setResaltarfecha_emisionSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarfecha_emisionSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSaldosVencidosProveedores() {
		return this.mostrarfecha_emisionSaldosVencidosProveedores;
	}

	public void setMostrarfecha_emisionSaldosVencidosProveedores(Boolean mostrarfecha_emisionSaldosVencidosProveedores) {
		this.mostrarfecha_emisionSaldosVencidosProveedores= mostrarfecha_emisionSaldosVencidosProveedores;
	}

	public Boolean getActivarfecha_emisionSaldosVencidosProveedores() {
		return this.activarfecha_emisionSaldosVencidosProveedores;
	}

	public void setActivarfecha_emisionSaldosVencidosProveedores(Boolean activarfecha_emisionSaldosVencidosProveedores) {
		this.activarfecha_emisionSaldosVencidosProveedores= activarfecha_emisionSaldosVencidosProveedores;
	}

	public Border setResaltarfecha_ventaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaSaldosVencidosProveedores() {
		return this.resaltarfecha_ventaSaldosVencidosProveedores;
	}

	public void setResaltarfecha_ventaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarfecha_ventaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaSaldosVencidosProveedores() {
		return this.mostrarfecha_ventaSaldosVencidosProveedores;
	}

	public void setMostrarfecha_ventaSaldosVencidosProveedores(Boolean mostrarfecha_ventaSaldosVencidosProveedores) {
		this.mostrarfecha_ventaSaldosVencidosProveedores= mostrarfecha_ventaSaldosVencidosProveedores;
	}

	public Boolean getActivarfecha_ventaSaldosVencidosProveedores() {
		return this.activarfecha_ventaSaldosVencidosProveedores;
	}

	public void setActivarfecha_ventaSaldosVencidosProveedores(Boolean activarfecha_ventaSaldosVencidosProveedores) {
		this.activarfecha_ventaSaldosVencidosProveedores= activarfecha_ventaSaldosVencidosProveedores;
	}

	public Border setResaltarnombre_monedaSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_monedaSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_monedaSaldosVencidosProveedores() {
		return this.resaltarnombre_monedaSaldosVencidosProveedores;
	}

	public void setResaltarnombre_monedaSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarnombre_monedaSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_monedaSaldosVencidosProveedores() {
		return this.mostrarnombre_monedaSaldosVencidosProveedores;
	}

	public void setMostrarnombre_monedaSaldosVencidosProveedores(Boolean mostrarnombre_monedaSaldosVencidosProveedores) {
		this.mostrarnombre_monedaSaldosVencidosProveedores= mostrarnombre_monedaSaldosVencidosProveedores;
	}

	public Boolean getActivarnombre_monedaSaldosVencidosProveedores() {
		return this.activarnombre_monedaSaldosVencidosProveedores;
	}

	public void setActivarnombre_monedaSaldosVencidosProveedores(Boolean activarnombre_monedaSaldosVencidosProveedores) {
		this.activarnombre_monedaSaldosVencidosProveedores= activarnombre_monedaSaldosVencidosProveedores;
	}

	public Border setResaltarsaldoSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarsaldoSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoSaldosVencidosProveedores() {
		return this.resaltarsaldoSaldosVencidosProveedores;
	}

	public void setResaltarsaldoSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarsaldoSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarsaldoSaldosVencidosProveedores() {
		return this.mostrarsaldoSaldosVencidosProveedores;
	}

	public void setMostrarsaldoSaldosVencidosProveedores(Boolean mostrarsaldoSaldosVencidosProveedores) {
		this.mostrarsaldoSaldosVencidosProveedores= mostrarsaldoSaldosVencidosProveedores;
	}

	public Boolean getActivarsaldoSaldosVencidosProveedores() {
		return this.activarsaldoSaldosVencidosProveedores;
	}

	public void setActivarsaldoSaldosVencidosProveedores(Boolean activarsaldoSaldosVencidosProveedores) {
		this.activarsaldoSaldosVencidosProveedores= activarsaldoSaldosVencidosProveedores;
	}

	public Border setResaltarsaldo_extraSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarsaldo_extraSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_extraSaldosVencidosProveedores() {
		return this.resaltarsaldo_extraSaldosVencidosProveedores;
	}

	public void setResaltarsaldo_extraSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarsaldo_extraSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarsaldo_extraSaldosVencidosProveedores() {
		return this.mostrarsaldo_extraSaldosVencidosProveedores;
	}

	public void setMostrarsaldo_extraSaldosVencidosProveedores(Boolean mostrarsaldo_extraSaldosVencidosProveedores) {
		this.mostrarsaldo_extraSaldosVencidosProveedores= mostrarsaldo_extraSaldosVencidosProveedores;
	}

	public Boolean getActivarsaldo_extraSaldosVencidosProveedores() {
		return this.activarsaldo_extraSaldosVencidosProveedores;
	}

	public void setActivarsaldo_extraSaldosVencidosProveedores(Boolean activarsaldo_extraSaldosVencidosProveedores) {
		this.activarsaldo_extraSaldosVencidosProveedores= activarsaldo_extraSaldosVencidosProveedores;
	}

	public Border setResaltarnombre_clienteSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteSaldosVencidosProveedores() {
		return this.resaltarnombre_clienteSaldosVencidosProveedores;
	}

	public void setResaltarnombre_clienteSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarnombre_clienteSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteSaldosVencidosProveedores() {
		return this.mostrarnombre_clienteSaldosVencidosProveedores;
	}

	public void setMostrarnombre_clienteSaldosVencidosProveedores(Boolean mostrarnombre_clienteSaldosVencidosProveedores) {
		this.mostrarnombre_clienteSaldosVencidosProveedores= mostrarnombre_clienteSaldosVencidosProveedores;
	}

	public Boolean getActivarnombre_clienteSaldosVencidosProveedores() {
		return this.activarnombre_clienteSaldosVencidosProveedores;
	}

	public void setActivarnombre_clienteSaldosVencidosProveedores(Boolean activarnombre_clienteSaldosVencidosProveedores) {
		this.activarnombre_clienteSaldosVencidosProveedores= activarnombre_clienteSaldosVencidosProveedores;
	}

	public Border setResaltarnombre_grupo_clienteSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//saldosvencidosproveedoresBeanSwingJInternalFrame.jTtoolBarSaldosVencidosProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_grupo_clienteSaldosVencidosProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupo_clienteSaldosVencidosProveedores() {
		return this.resaltarnombre_grupo_clienteSaldosVencidosProveedores;
	}

	public void setResaltarnombre_grupo_clienteSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarnombre_grupo_clienteSaldosVencidosProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_grupo_clienteSaldosVencidosProveedores() {
		return this.mostrarnombre_grupo_clienteSaldosVencidosProveedores;
	}

	public void setMostrarnombre_grupo_clienteSaldosVencidosProveedores(Boolean mostrarnombre_grupo_clienteSaldosVencidosProveedores) {
		this.mostrarnombre_grupo_clienteSaldosVencidosProveedores= mostrarnombre_grupo_clienteSaldosVencidosProveedores;
	}

	public Boolean getActivarnombre_grupo_clienteSaldosVencidosProveedores() {
		return this.activarnombre_grupo_clienteSaldosVencidosProveedores;
	}

	public void setActivarnombre_grupo_clienteSaldosVencidosProveedores(Boolean activarnombre_grupo_clienteSaldosVencidosProveedores) {
		this.activarnombre_grupo_clienteSaldosVencidosProveedores= activarnombre_grupo_clienteSaldosVencidosProveedores;
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
		
		
		this.setMostraridSaldosVencidosProveedores(esInicial);
		this.setMostrarid_empresaSaldosVencidosProveedores(esInicial);
		this.setMostrarid_grupo_clienteSaldosVencidosProveedores(esInicial);
		this.setMostrarid_facturaSaldosVencidosProveedores(esInicial);
		this.setMostrarid_monedaSaldosVencidosProveedores(esInicial);
		this.setMostrarid_clienteSaldosVencidosProveedores(esInicial);
		this.setMostrarnumero_facturaSaldosVencidosProveedores(esInicial);
		this.setMostrarfecha_emisionSaldosVencidosProveedores(esInicial);
		this.setMostrarfecha_ventaSaldosVencidosProveedores(esInicial);
		this.setMostrarnombre_monedaSaldosVencidosProveedores(esInicial);
		this.setMostrarsaldoSaldosVencidosProveedores(esInicial);
		this.setMostrarsaldo_extraSaldosVencidosProveedores(esInicial);
		this.setMostrarnombre_clienteSaldosVencidosProveedores(esInicial);
		this.setMostrarnombre_grupo_clienteSaldosVencidosProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.ID)) {
				this.setMostraridSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA)) {
				this.setMostrarnombre_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDO)) {
				this.setMostrarsaldoSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA)) {
				this.setMostrarsaldo_extraSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setMostrarnombre_grupo_clienteSaldosVencidosProveedores(esAsigna);
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
		
		
		this.setActivaridSaldosVencidosProveedores(esInicial);
		this.setActivarid_empresaSaldosVencidosProveedores(esInicial);
		this.setActivarid_grupo_clienteSaldosVencidosProveedores(esInicial);
		this.setActivarid_facturaSaldosVencidosProveedores(esInicial);
		this.setActivarid_monedaSaldosVencidosProveedores(esInicial);
		this.setActivarid_clienteSaldosVencidosProveedores(esInicial);
		this.setActivarnumero_facturaSaldosVencidosProveedores(esInicial);
		this.setActivarfecha_emisionSaldosVencidosProveedores(esInicial);
		this.setActivarfecha_ventaSaldosVencidosProveedores(esInicial);
		this.setActivarnombre_monedaSaldosVencidosProveedores(esInicial);
		this.setActivarsaldoSaldosVencidosProveedores(esInicial);
		this.setActivarsaldo_extraSaldosVencidosProveedores(esInicial);
		this.setActivarnombre_clienteSaldosVencidosProveedores(esInicial);
		this.setActivarnombre_grupo_clienteSaldosVencidosProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.ID)) {
				this.setActivaridSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA)) {
				this.setActivarnombre_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDO)) {
				this.setActivarsaldoSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA)) {
				this.setActivarsaldo_extraSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setActivarnombre_grupo_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSaldosVencidosProveedores(esInicial);
		this.setResaltarid_empresaSaldosVencidosProveedores(esInicial);
		this.setResaltarid_grupo_clienteSaldosVencidosProveedores(esInicial);
		this.setResaltarid_facturaSaldosVencidosProveedores(esInicial);
		this.setResaltarid_monedaSaldosVencidosProveedores(esInicial);
		this.setResaltarid_clienteSaldosVencidosProveedores(esInicial);
		this.setResaltarnumero_facturaSaldosVencidosProveedores(esInicial);
		this.setResaltarfecha_emisionSaldosVencidosProveedores(esInicial);
		this.setResaltarfecha_ventaSaldosVencidosProveedores(esInicial);
		this.setResaltarnombre_monedaSaldosVencidosProveedores(esInicial);
		this.setResaltarsaldoSaldosVencidosProveedores(esInicial);
		this.setResaltarsaldo_extraSaldosVencidosProveedores(esInicial);
		this.setResaltarnombre_clienteSaldosVencidosProveedores(esInicial);
		this.setResaltarnombre_grupo_clienteSaldosVencidosProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.ID)) {
				this.setResaltaridSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREMONEDA)) {
				this.setResaltarnombre_monedaSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDO)) {
				this.setResaltarsaldoSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA)) {
				this.setResaltarsaldo_extraSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteSaldosVencidosProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(SaldosVencidosProveedoresConstantesFunciones.NOMBREGRUPOCLIENTE)) {
				this.setResaltarnombre_grupo_clienteSaldosVencidosProveedores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores=true;

	public Boolean getMostrarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores() {
		return this.mostrarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores;
	}

	public void setMostrarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores=true;

	public Boolean getActivarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores() {
		return this.activarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores;
	}

	public void setActivarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores(Boolean habilitarResaltar) {
		this.activarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores=null;

	public Border getResaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores() {
		return this.resaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores;
	}

	public void setResaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores(Border borderResaltar) {
		this.resaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores= borderResaltar;
	}

	public void setResaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*SaldosVencidosProveedoresBeanSwingJInternalFrame saldosvencidosproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaSaldosVencidosProveedoresSaldosVencidosProveedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}