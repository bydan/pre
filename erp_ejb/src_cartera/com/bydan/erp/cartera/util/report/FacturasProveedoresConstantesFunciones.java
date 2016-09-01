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


import com.bydan.erp.cartera.util.report.FacturasProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.report.FacturasProveedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.FacturasProveedoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturasProveedoresConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturasProveedores";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturasProveedores"+FacturasProveedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturasProveedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturasProveedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturasProveedoresConstantesFunciones.SCHEMA+"_"+FacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturasProveedoresConstantesFunciones.SCHEMA+"_"+FacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturasProveedoresConstantesFunciones.SCHEMA+"_"+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturasProveedoresConstantesFunciones.SCHEMA+"_"+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturasProveedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturasProveedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturas Proveedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Facturas Proveedores";
	public static final String SCLASSWEBTITULO_LOWER="Facturas Proveedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturasProveedores";
	public static final String OBJECTNAME="facturasproveedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="facturas_proveedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturasproveedores from "+FacturasProveedoresConstantesFunciones.SPERSISTENCENAME+" facturasproveedores";
	public static String QUERYSELECTNATIVE="select "+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".id,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".version_row,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".id_empresa,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".id_cliente,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision_inicio,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision_fin,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".codigo_cliente,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".nombre_cliente,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".numero_factura,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".fecha_emision,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".total,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME+".fecha from "+FacturasProveedoresConstantesFunciones.SCHEMA+"."+FacturasProveedoresConstantesFunciones.TABLENAME;//+" as "+FacturasProveedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHAEMISIONINICIO= "fecha_emision_inicio";
    public static final String FECHAEMISIONFIN= "fecha_emision_fin";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String TOTAL= "total";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHAEMISIONINICIO= "Fecha Emision Inicio";
		public static final String LABEL_FECHAEMISIONINICIO_LOWER= "Fecha Emision Inicio";
    	public static final String LABEL_FECHAEMISIONFIN= "Fecha Emision Fin";
		public static final String LABEL_FECHAEMISIONFIN_LOWER= "Fecha Emision Fin";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getFacturasProveedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONINICIO)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONINICIO;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONFIN)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONFIN;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.TOTAL)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(FacturasProveedoresConstantesFunciones.FECHA)) {sLabelColumna=FacturasProveedoresConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturasProveedoresDescripcion(FacturasProveedores facturasproveedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturasproveedores !=null/* && facturasproveedores.getId()!=0*/) {
			sDescripcion=facturasproveedores.getfecha_emision_inicio().toString();//facturasproveedoresfacturasproveedores.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturasProveedoresDescripcionDetallado(FacturasProveedores facturasproveedores) {
		String sDescripcion="";
			
		sDescripcion+=FacturasProveedoresConstantesFunciones.ID+"=";
		sDescripcion+=facturasproveedores.getId().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturasproveedores.getVersionRow().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturasproveedores.getid_empresa().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturasproveedores.getid_cliente().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.FECHAEMISIONINICIO+"=";
		sDescripcion+=facturasproveedores.getfecha_emision_inicio().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.FECHAEMISIONFIN+"=";
		sDescripcion+=facturasproveedores.getfecha_emision_fin().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=facturasproveedores.getcodigo_cliente()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=facturasproveedores.getnombre_cliente()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=facturasproveedores.getnumero_factura()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturasproveedores.getfecha_emision().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturasproveedores.gettotal().toString()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=facturasproveedores.getnumero_pre_impreso()+",";
		sDescripcion+=FacturasProveedoresConstantesFunciones.FECHA+"=";
		sDescripcion+=facturasproveedores.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturasProveedoresDescripcion(FacturasProveedores facturasproveedores,String sValor) throws Exception {			
		if(facturasproveedores !=null) {
			//facturasproveedoresfacturasproveedores.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaFacturasProveedores")) {
			sNombreIndice="Tipo=  Por Cliente Por Fecha Emision Inicio Por Fecha Emision Fin";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaFacturasProveedores(Long id_cliente,Date fecha_emision_inicio,Date fecha_emision_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(fecha_emision_inicio!=null) {sDetalleIndice+=" Fecha Emision Inicio="+fecha_emision_inicio.toString();}
		if(fecha_emision_fin!=null) {sDetalleIndice+=" Fecha Emision Fin="+fecha_emision_fin.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosFacturasProveedores(FacturasProveedores facturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturasproveedores.setcodigo_cliente(facturasproveedores.getcodigo_cliente().trim());
		facturasproveedores.setnombre_cliente(facturasproveedores.getnombre_cliente().trim());
		facturasproveedores.setnumero_factura(facturasproveedores.getnumero_factura().trim());
		facturasproveedores.setnumero_pre_impreso(facturasproveedores.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFacturasProveedoress(List<FacturasProveedores> facturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {
			facturasproveedores.setcodigo_cliente(facturasproveedores.getcodigo_cliente().trim());
			facturasproveedores.setnombre_cliente(facturasproveedores.getnombre_cliente().trim());
			facturasproveedores.setnumero_factura(facturasproveedores.getnumero_factura().trim());
			facturasproveedores.setnumero_pre_impreso(facturasproveedores.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasProveedores(FacturasProveedores facturasproveedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturasproveedores.getConCambioAuxiliar()) {
			facturasproveedores.setIsDeleted(facturasproveedores.getIsDeletedAuxiliar());	
			facturasproveedores.setIsNew(facturasproveedores.getIsNewAuxiliar());	
			facturasproveedores.setIsChanged(facturasproveedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturasproveedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturasproveedores.setIsDeletedAuxiliar(false);	
			facturasproveedores.setIsNewAuxiliar(false);	
			facturasproveedores.setIsChangedAuxiliar(false);
			
			facturasproveedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasProveedoress(List<FacturasProveedores> facturasproveedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturasProveedores facturasproveedores : facturasproveedoress) {
			if(conAsignarBase && facturasproveedores.getConCambioAuxiliar()) {
				facturasproveedores.setIsDeleted(facturasproveedores.getIsDeletedAuxiliar());	
				facturasproveedores.setIsNew(facturasproveedores.getIsNewAuxiliar());	
				facturasproveedores.setIsChanged(facturasproveedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturasproveedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturasproveedores.setIsDeletedAuxiliar(false);	
				facturasproveedores.setIsNewAuxiliar(false);	
				facturasproveedores.setIsChangedAuxiliar(false);
				
				facturasproveedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturasProveedores(FacturasProveedores facturasproveedores,Boolean conEnteros) throws Exception  {
		facturasproveedores.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturasProveedoress(List<FacturasProveedores> facturasproveedoress,Boolean conEnteros) throws Exception  {
		
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {
			facturasproveedores.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturasProveedores(List<FacturasProveedores> facturasproveedoress,FacturasProveedores facturasproveedoresAux) throws Exception  {
		FacturasProveedoresConstantesFunciones.InicializarValoresFacturasProveedores(facturasproveedoresAux,true);
		
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {
			if(facturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturasproveedoresAux.settotal(facturasproveedoresAux.gettotal()+facturasproveedores.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturasProveedoresConstantesFunciones.getArrayColumnasGlobalesFacturasProveedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasProveedoresConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasProveedores> facturasproveedoress,FacturasProveedores facturasproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasProveedores facturasproveedoresAux: facturasproveedoress) {
			if(facturasproveedoresAux!=null && facturasproveedores!=null) {
				if((facturasproveedoresAux.getId()==null && facturasproveedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturasproveedoresAux.getId()!=null && facturasproveedores.getId()!=null){
					if(facturasproveedoresAux.getId().equals(facturasproveedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasProveedores(List<FacturasProveedores> facturasproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {			
			if(facturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=facturasproveedores.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasProveedoresConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturasProveedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_ID, FacturasProveedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_VERSIONROW, FacturasProveedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_CODIGOCLIENTE, FacturasProveedoresConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE, FacturasProveedoresConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA, FacturasProveedoresConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION, FacturasProveedoresConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_TOTAL, FacturasProveedoresConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_NUMEROPREIMPRESO, FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasProveedoresConstantesFunciones.LABEL_FECHA, FacturasProveedoresConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturasProveedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasProveedoresConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasProveedores() throws Exception  {
		return FacturasProveedoresConstantesFunciones.getTiposSeleccionarFacturasProveedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasProveedores(Boolean conFk) throws Exception  {
		return FacturasProveedoresConstantesFunciones.getTiposSeleccionarFacturasProveedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasProveedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONINICIO);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONFIN);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasProveedoresConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturasProveedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasProveedores(FacturasProveedores facturasproveedoresAux) throws Exception {
		
			facturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasproveedoresAux.getEmpresa()));
			facturasproveedoresAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturasproveedoresAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasProveedores(List<FacturasProveedores> facturasproveedoressTemp) throws Exception {
		for(FacturasProveedores facturasproveedoresAux:facturasproveedoressTemp) {
			
			facturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasproveedoresAux.getEmpresa()));
			facturasproveedoresAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturasproveedoresAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasProveedoresConstantesFunciones.getClassesRelationshipsOfFacturasProveedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasProveedoresConstantesFunciones.getClassesRelationshipsFromStringsOfFacturasProveedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturasProveedores facturasproveedores,List<FacturasProveedores> facturasproveedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturasProveedores facturasproveedores,List<FacturasProveedores> facturasproveedoress) throws Exception {
		try	{			
			for(FacturasProveedores facturasproveedoresLocal:facturasproveedoress) {
				if(facturasproveedoresLocal.getId().equals(facturasproveedores.getId())) {
					facturasproveedoresLocal.setIsSelected(facturasproveedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturasProveedores(List<FacturasProveedores> facturasproveedoressAux) throws Exception {
		//this.facturasproveedoressAux=facturasproveedoressAux;
		
		for(FacturasProveedores facturasproveedoresAux:facturasproveedoressAux) {
			if(facturasproveedoresAux.getIsChanged()) {
				facturasproveedoresAux.setIsChanged(false);
			}		
			
			if(facturasproveedoresAux.getIsNew()) {
				facturasproveedoresAux.setIsNew(false);
			}	
			
			if(facturasproveedoresAux.getIsDeleted()) {
				facturasproveedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturasProveedores(FacturasProveedores facturasproveedoresAux) throws Exception {
		//this.facturasproveedoresAux=facturasproveedoresAux;
		
			if(facturasproveedoresAux.getIsChanged()) {
				facturasproveedoresAux.setIsChanged(false);
			}		
			
			if(facturasproveedoresAux.getIsNew()) {
				facturasproveedoresAux.setIsNew(false);
			}	
			
			if(facturasproveedoresAux.getIsDeleted()) {
				facturasproveedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturasProveedores facturasproveedoresAsignar,FacturasProveedores facturasproveedores) throws Exception {
		facturasproveedoresAsignar.setId(facturasproveedores.getId());	
		facturasproveedoresAsignar.setVersionRow(facturasproveedores.getVersionRow());	
		facturasproveedoresAsignar.setcodigo_cliente(facturasproveedores.getcodigo_cliente());	
		facturasproveedoresAsignar.setnombre_cliente(facturasproveedores.getnombre_cliente());	
		facturasproveedoresAsignar.setnumero_factura(facturasproveedores.getnumero_factura());	
		facturasproveedoresAsignar.setfecha_emision(facturasproveedores.getfecha_emision());	
		facturasproveedoresAsignar.settotal(facturasproveedores.gettotal());	
		facturasproveedoresAsignar.setnumero_pre_impreso(facturasproveedores.getnumero_pre_impreso());	
		facturasproveedoresAsignar.setfecha(facturasproveedores.getfecha());	
	}
	
	public static void inicializarFacturasProveedores(FacturasProveedores facturasproveedores) throws Exception {
		try {
				facturasproveedores.setId(0L);	
					
				facturasproveedores.setcodigo_cliente("");	
				facturasproveedores.setnombre_cliente("");	
				facturasproveedores.setnumero_factura("");	
				facturasproveedores.setfecha_emision(new Date());	
				facturasproveedores.settotal(0.0);	
				facturasproveedores.setnumero_pre_impreso("");	
				facturasproveedores.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturasProveedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISIONFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasProveedoresConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturasProveedores(String sTipo,Row row,Workbook workbook,FacturasProveedores facturasproveedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getfecha_emision_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getfecha_emision_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasproveedores.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturasProveedores="";
	
	public String getsFinalQueryFacturasProveedores() {
		return this.sFinalQueryFacturasProveedores;
	}
	
	public void setsFinalQueryFacturasProveedores(String sFinalQueryFacturasProveedores) {
		this.sFinalQueryFacturasProveedores= sFinalQueryFacturasProveedores;
	}
	
	public Border resaltarSeleccionarFacturasProveedores=null;
	
	public Border setResaltarSeleccionarFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturasProveedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturasProveedores() {
		return this.resaltarSeleccionarFacturasProveedores;
	}
	
	public void setResaltarSeleccionarFacturasProveedores(Border borderResaltarSeleccionarFacturasProveedores) {
		this.resaltarSeleccionarFacturasProveedores= borderResaltarSeleccionarFacturasProveedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturasProveedores=null;
	public Boolean mostraridFacturasProveedores=true;
	public Boolean activaridFacturasProveedores=true;

	public Border resaltarid_empresaFacturasProveedores=null;
	public Boolean mostrarid_empresaFacturasProveedores=true;
	public Boolean activarid_empresaFacturasProveedores=true;
	public Boolean cargarid_empresaFacturasProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturasProveedores=false;//ConEventDepend=true

	public Border resaltarid_clienteFacturasProveedores=null;
	public Boolean mostrarid_clienteFacturasProveedores=true;
	public Boolean activarid_clienteFacturasProveedores=true;
	public Boolean cargarid_clienteFacturasProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturasProveedores=false;//ConEventDepend=true

	public Border resaltarfecha_emision_inicioFacturasProveedores=null;
	public Boolean mostrarfecha_emision_inicioFacturasProveedores=true;
	public Boolean activarfecha_emision_inicioFacturasProveedores=true;

	public Border resaltarfecha_emision_finFacturasProveedores=null;
	public Boolean mostrarfecha_emision_finFacturasProveedores=true;
	public Boolean activarfecha_emision_finFacturasProveedores=true;

	public Border resaltarcodigo_clienteFacturasProveedores=null;
	public Boolean mostrarcodigo_clienteFacturasProveedores=true;
	public Boolean activarcodigo_clienteFacturasProveedores=true;

	public Border resaltarnombre_clienteFacturasProveedores=null;
	public Boolean mostrarnombre_clienteFacturasProveedores=true;
	public Boolean activarnombre_clienteFacturasProveedores=true;

	public Border resaltarnumero_facturaFacturasProveedores=null;
	public Boolean mostrarnumero_facturaFacturasProveedores=true;
	public Boolean activarnumero_facturaFacturasProveedores=true;

	public Border resaltarfecha_emisionFacturasProveedores=null;
	public Boolean mostrarfecha_emisionFacturasProveedores=true;
	public Boolean activarfecha_emisionFacturasProveedores=true;

	public Border resaltartotalFacturasProveedores=null;
	public Boolean mostrartotalFacturasProveedores=true;
	public Boolean activartotalFacturasProveedores=true;

	public Border resaltarnumero_pre_impresoFacturasProveedores=null;
	public Boolean mostrarnumero_pre_impresoFacturasProveedores=true;
	public Boolean activarnumero_pre_impresoFacturasProveedores=true;

	public Border resaltarfechaFacturasProveedores=null;
	public Boolean mostrarfechaFacturasProveedores=true;
	public Boolean activarfechaFacturasProveedores=true;

	
	

	public Border setResaltaridFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltaridFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturasProveedores() {
		return this.resaltaridFacturasProveedores;
	}

	public void setResaltaridFacturasProveedores(Border borderResaltar) {
		this.resaltaridFacturasProveedores= borderResaltar;
	}

	public Boolean getMostraridFacturasProveedores() {
		return this.mostraridFacturasProveedores;
	}

	public void setMostraridFacturasProveedores(Boolean mostraridFacturasProveedores) {
		this.mostraridFacturasProveedores= mostraridFacturasProveedores;
	}

	public Boolean getActivaridFacturasProveedores() {
		return this.activaridFacturasProveedores;
	}

	public void setActivaridFacturasProveedores(Boolean activaridFacturasProveedores) {
		this.activaridFacturasProveedores= activaridFacturasProveedores;
	}

	public Border setResaltarid_empresaFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturasProveedores() {
		return this.resaltarid_empresaFacturasProveedores;
	}

	public void setResaltarid_empresaFacturasProveedores(Border borderResaltar) {
		this.resaltarid_empresaFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturasProveedores() {
		return this.mostrarid_empresaFacturasProveedores;
	}

	public void setMostrarid_empresaFacturasProveedores(Boolean mostrarid_empresaFacturasProveedores) {
		this.mostrarid_empresaFacturasProveedores= mostrarid_empresaFacturasProveedores;
	}

	public Boolean getActivarid_empresaFacturasProveedores() {
		return this.activarid_empresaFacturasProveedores;
	}

	public void setActivarid_empresaFacturasProveedores(Boolean activarid_empresaFacturasProveedores) {
		this.activarid_empresaFacturasProveedores= activarid_empresaFacturasProveedores;
	}

	public Boolean getCargarid_empresaFacturasProveedores() {
		return this.cargarid_empresaFacturasProveedores;
	}

	public void setCargarid_empresaFacturasProveedores(Boolean cargarid_empresaFacturasProveedores) {
		this.cargarid_empresaFacturasProveedores= cargarid_empresaFacturasProveedores;
	}

	public Border setResaltarid_clienteFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturasProveedores() {
		return this.resaltarid_clienteFacturasProveedores;
	}

	public void setResaltarid_clienteFacturasProveedores(Border borderResaltar) {
		this.resaltarid_clienteFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturasProveedores() {
		return this.mostrarid_clienteFacturasProveedores;
	}

	public void setMostrarid_clienteFacturasProveedores(Boolean mostrarid_clienteFacturasProveedores) {
		this.mostrarid_clienteFacturasProveedores= mostrarid_clienteFacturasProveedores;
	}

	public Boolean getActivarid_clienteFacturasProveedores() {
		return this.activarid_clienteFacturasProveedores;
	}

	public void setActivarid_clienteFacturasProveedores(Boolean activarid_clienteFacturasProveedores) {
		this.activarid_clienteFacturasProveedores= activarid_clienteFacturasProveedores;
	}

	public Boolean getCargarid_clienteFacturasProveedores() {
		return this.cargarid_clienteFacturasProveedores;
	}

	public void setCargarid_clienteFacturasProveedores(Boolean cargarid_clienteFacturasProveedores) {
		this.cargarid_clienteFacturasProveedores= cargarid_clienteFacturasProveedores;
	}

	public Border setResaltarfecha_emision_inicioFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_inicioFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_inicioFacturasProveedores() {
		return this.resaltarfecha_emision_inicioFacturasProveedores;
	}

	public void setResaltarfecha_emision_inicioFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emision_inicioFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_inicioFacturasProveedores() {
		return this.mostrarfecha_emision_inicioFacturasProveedores;
	}

	public void setMostrarfecha_emision_inicioFacturasProveedores(Boolean mostrarfecha_emision_inicioFacturasProveedores) {
		this.mostrarfecha_emision_inicioFacturasProveedores= mostrarfecha_emision_inicioFacturasProveedores;
	}

	public Boolean getActivarfecha_emision_inicioFacturasProveedores() {
		return this.activarfecha_emision_inicioFacturasProveedores;
	}

	public void setActivarfecha_emision_inicioFacturasProveedores(Boolean activarfecha_emision_inicioFacturasProveedores) {
		this.activarfecha_emision_inicioFacturasProveedores= activarfecha_emision_inicioFacturasProveedores;
	}

	public Border setResaltarfecha_emision_finFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_finFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_finFacturasProveedores() {
		return this.resaltarfecha_emision_finFacturasProveedores;
	}

	public void setResaltarfecha_emision_finFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emision_finFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_finFacturasProveedores() {
		return this.mostrarfecha_emision_finFacturasProveedores;
	}

	public void setMostrarfecha_emision_finFacturasProveedores(Boolean mostrarfecha_emision_finFacturasProveedores) {
		this.mostrarfecha_emision_finFacturasProveedores= mostrarfecha_emision_finFacturasProveedores;
	}

	public Boolean getActivarfecha_emision_finFacturasProveedores() {
		return this.activarfecha_emision_finFacturasProveedores;
	}

	public void setActivarfecha_emision_finFacturasProveedores(Boolean activarfecha_emision_finFacturasProveedores) {
		this.activarfecha_emision_finFacturasProveedores= activarfecha_emision_finFacturasProveedores;
	}

	public Border setResaltarcodigo_clienteFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteFacturasProveedores() {
		return this.resaltarcodigo_clienteFacturasProveedores;
	}

	public void setResaltarcodigo_clienteFacturasProveedores(Border borderResaltar) {
		this.resaltarcodigo_clienteFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteFacturasProveedores() {
		return this.mostrarcodigo_clienteFacturasProveedores;
	}

	public void setMostrarcodigo_clienteFacturasProveedores(Boolean mostrarcodigo_clienteFacturasProveedores) {
		this.mostrarcodigo_clienteFacturasProveedores= mostrarcodigo_clienteFacturasProveedores;
	}

	public Boolean getActivarcodigo_clienteFacturasProveedores() {
		return this.activarcodigo_clienteFacturasProveedores;
	}

	public void setActivarcodigo_clienteFacturasProveedores(Boolean activarcodigo_clienteFacturasProveedores) {
		this.activarcodigo_clienteFacturasProveedores= activarcodigo_clienteFacturasProveedores;
	}

	public Border setResaltarnombre_clienteFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteFacturasProveedores() {
		return this.resaltarnombre_clienteFacturasProveedores;
	}

	public void setResaltarnombre_clienteFacturasProveedores(Border borderResaltar) {
		this.resaltarnombre_clienteFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteFacturasProveedores() {
		return this.mostrarnombre_clienteFacturasProveedores;
	}

	public void setMostrarnombre_clienteFacturasProveedores(Boolean mostrarnombre_clienteFacturasProveedores) {
		this.mostrarnombre_clienteFacturasProveedores= mostrarnombre_clienteFacturasProveedores;
	}

	public Boolean getActivarnombre_clienteFacturasProveedores() {
		return this.activarnombre_clienteFacturasProveedores;
	}

	public void setActivarnombre_clienteFacturasProveedores(Boolean activarnombre_clienteFacturasProveedores) {
		this.activarnombre_clienteFacturasProveedores= activarnombre_clienteFacturasProveedores;
	}

	public Border setResaltarnumero_facturaFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaFacturasProveedores() {
		return this.resaltarnumero_facturaFacturasProveedores;
	}

	public void setResaltarnumero_facturaFacturasProveedores(Border borderResaltar) {
		this.resaltarnumero_facturaFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaFacturasProveedores() {
		return this.mostrarnumero_facturaFacturasProveedores;
	}

	public void setMostrarnumero_facturaFacturasProveedores(Boolean mostrarnumero_facturaFacturasProveedores) {
		this.mostrarnumero_facturaFacturasProveedores= mostrarnumero_facturaFacturasProveedores;
	}

	public Boolean getActivarnumero_facturaFacturasProveedores() {
		return this.activarnumero_facturaFacturasProveedores;
	}

	public void setActivarnumero_facturaFacturasProveedores(Boolean activarnumero_facturaFacturasProveedores) {
		this.activarnumero_facturaFacturasProveedores= activarnumero_facturaFacturasProveedores;
	}

	public Border setResaltarfecha_emisionFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturasProveedores() {
		return this.resaltarfecha_emisionFacturasProveedores;
	}

	public void setResaltarfecha_emisionFacturasProveedores(Border borderResaltar) {
		this.resaltarfecha_emisionFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturasProveedores() {
		return this.mostrarfecha_emisionFacturasProveedores;
	}

	public void setMostrarfecha_emisionFacturasProveedores(Boolean mostrarfecha_emisionFacturasProveedores) {
		this.mostrarfecha_emisionFacturasProveedores= mostrarfecha_emisionFacturasProveedores;
	}

	public Boolean getActivarfecha_emisionFacturasProveedores() {
		return this.activarfecha_emisionFacturasProveedores;
	}

	public void setActivarfecha_emisionFacturasProveedores(Boolean activarfecha_emisionFacturasProveedores) {
		this.activarfecha_emisionFacturasProveedores= activarfecha_emisionFacturasProveedores;
	}

	public Border setResaltartotalFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltartotalFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturasProveedores() {
		return this.resaltartotalFacturasProveedores;
	}

	public void setResaltartotalFacturasProveedores(Border borderResaltar) {
		this.resaltartotalFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrartotalFacturasProveedores() {
		return this.mostrartotalFacturasProveedores;
	}

	public void setMostrartotalFacturasProveedores(Boolean mostrartotalFacturasProveedores) {
		this.mostrartotalFacturasProveedores= mostrartotalFacturasProveedores;
	}

	public Boolean getActivartotalFacturasProveedores() {
		return this.activartotalFacturasProveedores;
	}

	public void setActivartotalFacturasProveedores(Boolean activartotalFacturasProveedores) {
		this.activartotalFacturasProveedores= activartotalFacturasProveedores;
	}

	public Border setResaltarnumero_pre_impresoFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoFacturasProveedores() {
		return this.resaltarnumero_pre_impresoFacturasProveedores;
	}

	public void setResaltarnumero_pre_impresoFacturasProveedores(Border borderResaltar) {
		this.resaltarnumero_pre_impresoFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoFacturasProveedores() {
		return this.mostrarnumero_pre_impresoFacturasProveedores;
	}

	public void setMostrarnumero_pre_impresoFacturasProveedores(Boolean mostrarnumero_pre_impresoFacturasProveedores) {
		this.mostrarnumero_pre_impresoFacturasProveedores= mostrarnumero_pre_impresoFacturasProveedores;
	}

	public Boolean getActivarnumero_pre_impresoFacturasProveedores() {
		return this.activarnumero_pre_impresoFacturasProveedores;
	}

	public void setActivarnumero_pre_impresoFacturasProveedores(Boolean activarnumero_pre_impresoFacturasProveedores) {
		this.activarnumero_pre_impresoFacturasProveedores= activarnumero_pre_impresoFacturasProveedores;
	}

	public Border setResaltarfechaFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasproveedoresBeanSwingJInternalFrame.jTtoolBarFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarfechaFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFacturasProveedores() {
		return this.resaltarfechaFacturasProveedores;
	}

	public void setResaltarfechaFacturasProveedores(Border borderResaltar) {
		this.resaltarfechaFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarfechaFacturasProveedores() {
		return this.mostrarfechaFacturasProveedores;
	}

	public void setMostrarfechaFacturasProveedores(Boolean mostrarfechaFacturasProveedores) {
		this.mostrarfechaFacturasProveedores= mostrarfechaFacturasProveedores;
	}

	public Boolean getActivarfechaFacturasProveedores() {
		return this.activarfechaFacturasProveedores;
	}

	public void setActivarfechaFacturasProveedores(Boolean activarfechaFacturasProveedores) {
		this.activarfechaFacturasProveedores= activarfechaFacturasProveedores;
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
		
		
		this.setMostraridFacturasProveedores(esInicial);
		this.setMostrarid_empresaFacturasProveedores(esInicial);
		this.setMostrarid_clienteFacturasProveedores(esInicial);
		this.setMostrarfecha_emision_inicioFacturasProveedores(esInicial);
		this.setMostrarfecha_emision_finFacturasProveedores(esInicial);
		this.setMostrarcodigo_clienteFacturasProveedores(esInicial);
		this.setMostrarnombre_clienteFacturasProveedores(esInicial);
		this.setMostrarnumero_facturaFacturasProveedores(esInicial);
		this.setMostrarfecha_emisionFacturasProveedores(esInicial);
		this.setMostrartotalFacturasProveedores(esInicial);
		this.setMostrarnumero_pre_impresoFacturasProveedores(esInicial);
		this.setMostrarfechaFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.ID)) {
				this.setMostraridFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONINICIO)) {
				this.setMostrarfecha_emision_inicioFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONFIN)) {
				this.setMostrarfecha_emision_finFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHA)) {
				this.setMostrarfechaFacturasProveedores(esAsigna);
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
		
		
		this.setActivaridFacturasProveedores(esInicial);
		this.setActivarid_empresaFacturasProveedores(esInicial);
		this.setActivarid_clienteFacturasProveedores(esInicial);
		this.setActivarfecha_emision_inicioFacturasProveedores(esInicial);
		this.setActivarfecha_emision_finFacturasProveedores(esInicial);
		this.setActivarcodigo_clienteFacturasProveedores(esInicial);
		this.setActivarnombre_clienteFacturasProveedores(esInicial);
		this.setActivarnumero_facturaFacturasProveedores(esInicial);
		this.setActivarfecha_emisionFacturasProveedores(esInicial);
		this.setActivartotalFacturasProveedores(esInicial);
		this.setActivarnumero_pre_impresoFacturasProveedores(esInicial);
		this.setActivarfechaFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.ID)) {
				this.setActivaridFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONINICIO)) {
				this.setActivarfecha_emision_inicioFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONFIN)) {
				this.setActivarfecha_emision_finFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHA)) {
				this.setActivarfechaFacturasProveedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturasProveedores(esInicial);
		this.setResaltarid_empresaFacturasProveedores(esInicial);
		this.setResaltarid_clienteFacturasProveedores(esInicial);
		this.setResaltarfecha_emision_inicioFacturasProveedores(esInicial);
		this.setResaltarfecha_emision_finFacturasProveedores(esInicial);
		this.setResaltarcodigo_clienteFacturasProveedores(esInicial);
		this.setResaltarnombre_clienteFacturasProveedores(esInicial);
		this.setResaltarnumero_facturaFacturasProveedores(esInicial);
		this.setResaltarfecha_emisionFacturasProveedores(esInicial);
		this.setResaltartotalFacturasProveedores(esInicial);
		this.setResaltarnumero_pre_impresoFacturasProveedores(esInicial);
		this.setResaltarfechaFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.ID)) {
				this.setResaltaridFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONINICIO)) {
				this.setResaltarfecha_emision_inicioFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISIONFIN)) {
				this.setResaltarfecha_emision_finFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasProveedoresConstantesFunciones.FECHA)) {
				this.setResaltarfechaFacturasProveedores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturasProveedoresFacturasProveedores=true;

	public Boolean getMostrarBusquedaFacturasProveedoresFacturasProveedores() {
		return this.mostrarBusquedaFacturasProveedoresFacturasProveedores;
	}

	public void setMostrarBusquedaFacturasProveedoresFacturasProveedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturasProveedoresFacturasProveedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturasProveedoresFacturasProveedores=true;

	public Boolean getActivarBusquedaFacturasProveedoresFacturasProveedores() {
		return this.activarBusquedaFacturasProveedoresFacturasProveedores;
	}

	public void setActivarBusquedaFacturasProveedoresFacturasProveedores(Boolean habilitarResaltar) {
		this.activarBusquedaFacturasProveedoresFacturasProveedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturasProveedoresFacturasProveedores=null;

	public Border getResaltarBusquedaFacturasProveedoresFacturasProveedores() {
		return this.resaltarBusquedaFacturasProveedoresFacturasProveedores;
	}

	public void setResaltarBusquedaFacturasProveedoresFacturasProveedores(Border borderResaltar) {
		this.resaltarBusquedaFacturasProveedoresFacturasProveedores= borderResaltar;
	}

	public void setResaltarBusquedaFacturasProveedoresFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasProveedoresBeanSwingJInternalFrame facturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturasProveedoresFacturasProveedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}