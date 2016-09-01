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


import com.bydan.erp.facturacion.util.TablaAmortiConstantesFunciones;
import com.bydan.erp.facturacion.util.TablaAmortiParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TablaAmortiParameterGeneral;

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
final public class TablaAmortiConstantesFunciones extends TablaAmortiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TablaAmorti";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TablaAmorti"+TablaAmortiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TablaAmortiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TablaAmortiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TablaAmortiConstantesFunciones.SCHEMA+"_"+TablaAmortiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TablaAmortiConstantesFunciones.SCHEMA+"_"+TablaAmortiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TablaAmortiConstantesFunciones.SCHEMA+"_"+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TablaAmortiConstantesFunciones.SCHEMA+"_"+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TablaAmortiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TablaAmortiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TablaAmortiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TablaAmortiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tabla Amortis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tabla Amorti";
	public static final String SCLASSWEBTITULO_LOWER="Tabla Amorti";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TablaAmorti";
	public static final String OBJECTNAME="tablaamorti";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tabla_amorti";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tablaamorti from "+TablaAmortiConstantesFunciones.SPERSISTENCENAME+" tablaamorti";
	public static String QUERYSELECTNATIVE="select "+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".version_row,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_empresa,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_sucursal,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_ejercicio,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_periodo,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_tasa,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_factura,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".fecha_emision,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".fecha_vencimiento,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".valor_prestamo,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".numero_cuotas,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_anio,"+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME+".id_mes from "+TablaAmortiConstantesFunciones.SCHEMA+"."+TablaAmortiConstantesFunciones.TABLENAME;//+" as "+TablaAmortiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TablaAmortiConstantesFuncionesAdditional tablaamortiConstantesFuncionesAdditional=null;
	
	public TablaAmortiConstantesFuncionesAdditional getTablaAmortiConstantesFuncionesAdditional() {
		return this.tablaamortiConstantesFuncionesAdditional;
	}
	
	public void setTablaAmortiConstantesFuncionesAdditional(TablaAmortiConstantesFuncionesAdditional tablaamortiConstantesFuncionesAdditional) {
		try {
			this.tablaamortiConstantesFuncionesAdditional=tablaamortiConstantesFuncionesAdditional;
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
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String VALORPRESTAMO= "valor_prestamo";
    public static final String NUMEROCUOTAS= "numero_cuotas";
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
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_VALORPRESTAMO= "Valor Prestamo";
		public static final String LABEL_VALORPRESTAMO_LOWER= "Valor Prestamo";
    	public static final String LABEL_NUMEROCUOTAS= "Numero Cuotas";
		public static final String LABEL_NUMEROCUOTAS_LOWER= "Numero Cuotas";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getTablaAmortiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDEMPRESA)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDEJERCICIO)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDPERIODO)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDTASA)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDTASA;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDFACTURA)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.FECHAEMISION)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.VALORPRESTAMO)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.NUMEROCUOTAS)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_NUMEROCUOTAS;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDANIO)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(TablaAmortiConstantesFunciones.IDMES)) {sLabelColumna=TablaAmortiConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTablaAmortiDescripcion(TablaAmorti tablaamorti) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tablaamorti !=null/* && tablaamorti.getId()!=0*/) {
			if(tablaamorti.getId()!=null) {
				sDescripcion=tablaamorti.getId().toString();
			}//tablaamortitablaamorti.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTablaAmortiDescripcionDetallado(TablaAmorti tablaamorti) {
		String sDescripcion="";
			
		sDescripcion+=TablaAmortiConstantesFunciones.ID+"=";
		sDescripcion+=tablaamorti.getId().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tablaamorti.getVersionRow().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tablaamorti.getid_empresa().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tablaamorti.getid_sucursal().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=tablaamorti.getid_ejercicio().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=tablaamorti.getid_periodo().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDTASA+"=";
		sDescripcion+=tablaamorti.getid_tasa().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=tablaamorti.getid_factura().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=tablaamorti.getfecha_emision().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=tablaamorti.getfecha_vencimiento().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.VALORPRESTAMO+"=";
		sDescripcion+=tablaamorti.getvalor_prestamo().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.NUMEROCUOTAS+"=";
		sDescripcion+=tablaamorti.getnumero_cuotas().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDANIO+"=";
		sDescripcion+=tablaamorti.getid_anio().toString()+",";
		sDescripcion+=TablaAmortiConstantesFunciones.IDMES+"=";
		sDescripcion+=tablaamorti.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTablaAmortiDescripcion(TablaAmorti tablaamorti,String sValor) throws Exception {			
		if(tablaamorti !=null) {
			//tablaamortitablaamorti.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTablaAmorti(TablaAmorti tablaamorti,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTablaAmortis(List<TablaAmorti> tablaamortis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TablaAmorti tablaamorti: tablaamortis) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaAmorti(TablaAmorti tablaamorti,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tablaamorti.getConCambioAuxiliar()) {
			tablaamorti.setIsDeleted(tablaamorti.getIsDeletedAuxiliar());	
			tablaamorti.setIsNew(tablaamorti.getIsNewAuxiliar());	
			tablaamorti.setIsChanged(tablaamorti.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tablaamorti.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tablaamorti.setIsDeletedAuxiliar(false);	
			tablaamorti.setIsNewAuxiliar(false);	
			tablaamorti.setIsChangedAuxiliar(false);
			
			tablaamorti.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTablaAmortis(List<TablaAmorti> tablaamortis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TablaAmorti tablaamorti : tablaamortis) {
			if(conAsignarBase && tablaamorti.getConCambioAuxiliar()) {
				tablaamorti.setIsDeleted(tablaamorti.getIsDeletedAuxiliar());	
				tablaamorti.setIsNew(tablaamorti.getIsNewAuxiliar());	
				tablaamorti.setIsChanged(tablaamorti.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tablaamorti.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tablaamorti.setIsDeletedAuxiliar(false);	
				tablaamorti.setIsNewAuxiliar(false);	
				tablaamorti.setIsChangedAuxiliar(false);
				
				tablaamorti.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTablaAmorti(TablaAmorti tablaamorti,Boolean conEnteros) throws Exception  {
		tablaamorti.setvalor_prestamo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			tablaamorti.setnumero_cuotas(0);
		}
	}		
	
	public static void InicializarValoresTablaAmortis(List<TablaAmorti> tablaamortis,Boolean conEnteros) throws Exception  {
		
		for(TablaAmorti tablaamorti: tablaamortis) {
			tablaamorti.setvalor_prestamo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				tablaamorti.setnumero_cuotas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTablaAmorti(List<TablaAmorti> tablaamortis,TablaAmorti tablaamortiAux) throws Exception  {
		TablaAmortiConstantesFunciones.InicializarValoresTablaAmorti(tablaamortiAux,true);
		
		for(TablaAmorti tablaamorti: tablaamortis) {
			if(tablaamorti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tablaamortiAux.setvalor_prestamo(tablaamortiAux.getvalor_prestamo()+tablaamorti.getvalor_prestamo());			
			tablaamortiAux.setnumero_cuotas(tablaamortiAux.getnumero_cuotas()+tablaamorti.getnumero_cuotas());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TablaAmortiConstantesFunciones.getArrayColumnasGlobalesTablaAmorti(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TablaAmortiConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TablaAmortiConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TablaAmorti> tablaamortis,TablaAmorti tablaamorti,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TablaAmorti tablaamortiAux: tablaamortis) {
			if(tablaamortiAux!=null && tablaamorti!=null) {
				if((tablaamortiAux.getId()==null && tablaamorti.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tablaamortiAux.getId()!=null && tablaamorti.getId()!=null){
					if(tablaamortiAux.getId().equals(tablaamorti.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTablaAmorti(List<TablaAmorti> tablaamortis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_prestamoTotal=0.0;
	
		for(TablaAmorti tablaamorti: tablaamortis) {			
			if(tablaamorti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_prestamoTotal+=tablaamorti.getvalor_prestamo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TablaAmortiConstantesFunciones.VALORPRESTAMO);
		datoGeneral.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO);
		datoGeneral.setdValorDouble(valor_prestamoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTablaAmorti() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_ID, TablaAmortiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_VERSIONROW, TablaAmortiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDEMPRESA, TablaAmortiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDSUCURSAL, TablaAmortiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDEJERCICIO, TablaAmortiConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDPERIODO, TablaAmortiConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDTASA, TablaAmortiConstantesFunciones.IDTASA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDFACTURA, TablaAmortiConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_FECHAEMISION, TablaAmortiConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_FECHAVENCIMIENTO, TablaAmortiConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO, TablaAmortiConstantesFunciones.VALORPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_NUMEROCUOTAS, TablaAmortiConstantesFunciones.NUMEROCUOTAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDANIO, TablaAmortiConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TablaAmortiConstantesFunciones.LABEL_IDMES, TablaAmortiConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTablaAmorti() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDTASA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.VALORPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.NUMEROCUOTAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TablaAmortiConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmorti() throws Exception  {
		return TablaAmortiConstantesFunciones.getTiposSeleccionarTablaAmorti(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmorti(Boolean conFk) throws Exception  {
		return TablaAmortiConstantesFunciones.getTiposSeleccionarTablaAmorti(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTablaAmorti(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDTASA);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDTASA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_NUMEROCUOTAS);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_NUMEROCUOTAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TablaAmortiConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(TablaAmortiConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTablaAmorti(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTablaAmorti(TablaAmorti tablaamortiAux) throws Exception {
		
			tablaamortiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaamortiAux.getEmpresa()));
			tablaamortiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tablaamortiAux.getSucursal()));
			tablaamortiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(tablaamortiAux.getEjercicio()));
			tablaamortiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(tablaamortiAux.getPeriodo()));
			tablaamortiAux.settasa_descripcion(TasaConstantesFunciones.getTasaDescripcion(tablaamortiAux.getTasa()));
			tablaamortiAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tablaamortiAux.getFactura()));
			tablaamortiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(tablaamortiAux.getAnio()));
			tablaamortiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(tablaamortiAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTablaAmorti(List<TablaAmorti> tablaamortisTemp) throws Exception {
		for(TablaAmorti tablaamortiAux:tablaamortisTemp) {
			
			tablaamortiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tablaamortiAux.getEmpresa()));
			tablaamortiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tablaamortiAux.getSucursal()));
			tablaamortiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(tablaamortiAux.getEjercicio()));
			tablaamortiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(tablaamortiAux.getPeriodo()));
			tablaamortiAux.settasa_descripcion(TasaConstantesFunciones.getTasaDescripcion(tablaamortiAux.getTasa()));
			tablaamortiAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tablaamortiAux.getFactura()));
			tablaamortiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(tablaamortiAux.getAnio()));
			tablaamortiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(tablaamortiAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Tasa.class));
				classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaAmortiConstantesFunciones.getClassesRelationshipsOfTablaAmorti(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleTablaAmorti.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleTablaAmorti.class)) {
						classes.add(new Classe(DetalleTablaAmorti.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TablaAmortiConstantesFunciones.getClassesRelationshipsFromStringsOfTablaAmorti(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTablaAmorti.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTablaAmorti.class)); continue;
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
	public static void actualizarLista(TablaAmorti tablaamorti,List<TablaAmorti> tablaamortis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TablaAmorti tablaamortiEncontrado=null;
			
			for(TablaAmorti tablaamortiLocal:tablaamortis) {
				if(tablaamortiLocal.getId().equals(tablaamorti.getId())) {
					tablaamortiEncontrado=tablaamortiLocal;
					
					tablaamortiLocal.setIsChanged(tablaamorti.getIsChanged());
					tablaamortiLocal.setIsNew(tablaamorti.getIsNew());
					tablaamortiLocal.setIsDeleted(tablaamorti.getIsDeleted());
					
					tablaamortiLocal.setGeneralEntityOriginal(tablaamorti.getGeneralEntityOriginal());
					
					tablaamortiLocal.setId(tablaamorti.getId());	
					tablaamortiLocal.setVersionRow(tablaamorti.getVersionRow());	
					tablaamortiLocal.setid_empresa(tablaamorti.getid_empresa());	
					tablaamortiLocal.setid_sucursal(tablaamorti.getid_sucursal());	
					tablaamortiLocal.setid_ejercicio(tablaamorti.getid_ejercicio());	
					tablaamortiLocal.setid_periodo(tablaamorti.getid_periodo());	
					tablaamortiLocal.setid_tasa(tablaamorti.getid_tasa());	
					tablaamortiLocal.setid_factura(tablaamorti.getid_factura());	
					tablaamortiLocal.setfecha_emision(tablaamorti.getfecha_emision());	
					tablaamortiLocal.setfecha_vencimiento(tablaamorti.getfecha_vencimiento());	
					tablaamortiLocal.setvalor_prestamo(tablaamorti.getvalor_prestamo());	
					tablaamortiLocal.setnumero_cuotas(tablaamorti.getnumero_cuotas());	
					tablaamortiLocal.setid_anio(tablaamorti.getid_anio());	
					tablaamortiLocal.setid_mes(tablaamorti.getid_mes());	
					
					
					tablaamortiLocal.setDetalleTablaAmortis(tablaamorti.getDetalleTablaAmortis());
					
					existe=true;
					break;
				}
			}
			
			if(!tablaamorti.getIsDeleted()) {
				if(!existe) {
					tablaamortis.add(tablaamorti);
				}
			} else {
				if(tablaamortiEncontrado!=null && permiteQuitar)  {
					tablaamortis.remove(tablaamortiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TablaAmorti tablaamorti,List<TablaAmorti> tablaamortis) throws Exception {
		try	{			
			for(TablaAmorti tablaamortiLocal:tablaamortis) {
				if(tablaamortiLocal.getId().equals(tablaamorti.getId())) {
					tablaamortiLocal.setIsSelected(tablaamorti.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTablaAmorti(List<TablaAmorti> tablaamortisAux) throws Exception {
		//this.tablaamortisAux=tablaamortisAux;
		
		for(TablaAmorti tablaamortiAux:tablaamortisAux) {
			if(tablaamortiAux.getIsChanged()) {
				tablaamortiAux.setIsChanged(false);
			}		
			
			if(tablaamortiAux.getIsNew()) {
				tablaamortiAux.setIsNew(false);
			}	
			
			if(tablaamortiAux.getIsDeleted()) {
				tablaamortiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTablaAmorti(TablaAmorti tablaamortiAux) throws Exception {
		//this.tablaamortiAux=tablaamortiAux;
		
			if(tablaamortiAux.getIsChanged()) {
				tablaamortiAux.setIsChanged(false);
			}		
			
			if(tablaamortiAux.getIsNew()) {
				tablaamortiAux.setIsNew(false);
			}	
			
			if(tablaamortiAux.getIsDeleted()) {
				tablaamortiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TablaAmorti tablaamortiAsignar,TablaAmorti tablaamorti) throws Exception {
		tablaamortiAsignar.setId(tablaamorti.getId());	
		tablaamortiAsignar.setVersionRow(tablaamorti.getVersionRow());	
		tablaamortiAsignar.setid_empresa(tablaamorti.getid_empresa());
		tablaamortiAsignar.setempresa_descripcion(tablaamorti.getempresa_descripcion());	
		tablaamortiAsignar.setid_sucursal(tablaamorti.getid_sucursal());
		tablaamortiAsignar.setsucursal_descripcion(tablaamorti.getsucursal_descripcion());	
		tablaamortiAsignar.setid_ejercicio(tablaamorti.getid_ejercicio());
		tablaamortiAsignar.setejercicio_descripcion(tablaamorti.getejercicio_descripcion());	
		tablaamortiAsignar.setid_periodo(tablaamorti.getid_periodo());
		tablaamortiAsignar.setperiodo_descripcion(tablaamorti.getperiodo_descripcion());	
		tablaamortiAsignar.setid_tasa(tablaamorti.getid_tasa());
		tablaamortiAsignar.settasa_descripcion(tablaamorti.gettasa_descripcion());	
		tablaamortiAsignar.setid_factura(tablaamorti.getid_factura());
		tablaamortiAsignar.setfactura_descripcion(tablaamorti.getfactura_descripcion());	
		tablaamortiAsignar.setfecha_emision(tablaamorti.getfecha_emision());	
		tablaamortiAsignar.setfecha_vencimiento(tablaamorti.getfecha_vencimiento());	
		tablaamortiAsignar.setvalor_prestamo(tablaamorti.getvalor_prestamo());	
		tablaamortiAsignar.setnumero_cuotas(tablaamorti.getnumero_cuotas());	
		tablaamortiAsignar.setid_anio(tablaamorti.getid_anio());
		tablaamortiAsignar.setanio_descripcion(tablaamorti.getanio_descripcion());	
		tablaamortiAsignar.setid_mes(tablaamorti.getid_mes());
		tablaamortiAsignar.setmes_descripcion(tablaamorti.getmes_descripcion());	
	}
	
	public static void inicializarTablaAmorti(TablaAmorti tablaamorti) throws Exception {
		try {
				tablaamorti.setId(0L);	
					
				tablaamorti.setid_empresa(-1L);	
				tablaamorti.setid_sucursal(-1L);	
				tablaamorti.setid_ejercicio(-1L);	
				tablaamorti.setid_periodo(-1L);	
				tablaamorti.setid_tasa(-1L);	
				tablaamorti.setid_factura(-1L);	
				tablaamorti.setfecha_emision(new Date());	
				tablaamorti.setfecha_vencimiento(new Date());	
				tablaamorti.setvalor_prestamo(0.0);	
				tablaamorti.setnumero_cuotas(0);	
				tablaamorti.setid_anio(null);	
				tablaamorti.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTablaAmorti(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDTASA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_VALORPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_NUMEROCUOTAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TablaAmortiConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTablaAmorti(String sTipo,Row row,Workbook workbook,TablaAmorti tablaamorti,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.gettasa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getvalor_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getnumero_cuotas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tablaamorti.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTablaAmorti=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTablaAmorti() {
		return this.sFinalQueryTablaAmorti;
	}
	
	public void setsFinalQueryTablaAmorti(String sFinalQueryTablaAmorti) {
		this.sFinalQueryTablaAmorti= sFinalQueryTablaAmorti;
	}
	
	public Border resaltarSeleccionarTablaAmorti=null;
	
	public Border setResaltarSeleccionarTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTablaAmorti= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTablaAmorti() {
		return this.resaltarSeleccionarTablaAmorti;
	}
	
	public void setResaltarSeleccionarTablaAmorti(Border borderResaltarSeleccionarTablaAmorti) {
		this.resaltarSeleccionarTablaAmorti= borderResaltarSeleccionarTablaAmorti;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTablaAmorti=null;
	public Boolean mostraridTablaAmorti=true;
	public Boolean activaridTablaAmorti=true;

	public Border resaltarid_empresaTablaAmorti=null;
	public Boolean mostrarid_empresaTablaAmorti=true;
	public Boolean activarid_empresaTablaAmorti=true;
	public Boolean cargarid_empresaTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_sucursalTablaAmorti=null;
	public Boolean mostrarid_sucursalTablaAmorti=true;
	public Boolean activarid_sucursalTablaAmorti=true;
	public Boolean cargarid_sucursalTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_ejercicioTablaAmorti=null;
	public Boolean mostrarid_ejercicioTablaAmorti=true;
	public Boolean activarid_ejercicioTablaAmorti=true;
	public Boolean cargarid_ejercicioTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_periodoTablaAmorti=null;
	public Boolean mostrarid_periodoTablaAmorti=true;
	public Boolean activarid_periodoTablaAmorti=true;
	public Boolean cargarid_periodoTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_tasaTablaAmorti=null;
	public Boolean mostrarid_tasaTablaAmorti=true;
	public Boolean activarid_tasaTablaAmorti=true;
	public Boolean cargarid_tasaTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tasaTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_facturaTablaAmorti=null;
	public Boolean mostrarid_facturaTablaAmorti=true;
	public Boolean activarid_facturaTablaAmorti=true;
	public Boolean cargarid_facturaTablaAmorti=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaTablaAmorti=false;//ConEventDepend=true

	public Border resaltarfecha_emisionTablaAmorti=null;
	public Boolean mostrarfecha_emisionTablaAmorti=true;
	public Boolean activarfecha_emisionTablaAmorti=false;

	public Border resaltarfecha_vencimientoTablaAmorti=null;
	public Boolean mostrarfecha_vencimientoTablaAmorti=true;
	public Boolean activarfecha_vencimientoTablaAmorti=false;

	public Border resaltarvalor_prestamoTablaAmorti=null;
	public Boolean mostrarvalor_prestamoTablaAmorti=true;
	public Boolean activarvalor_prestamoTablaAmorti=true;

	public Border resaltarnumero_cuotasTablaAmorti=null;
	public Boolean mostrarnumero_cuotasTablaAmorti=true;
	public Boolean activarnumero_cuotasTablaAmorti=true;

	public Border resaltarid_anioTablaAmorti=null;
	public Boolean mostrarid_anioTablaAmorti=true;
	public Boolean activarid_anioTablaAmorti=false;
	public Boolean cargarid_anioTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_mesTablaAmorti=null;
	public Boolean mostrarid_mesTablaAmorti=true;
	public Boolean activarid_mesTablaAmorti=false;
	public Boolean cargarid_mesTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesTablaAmorti=false;//ConEventDepend=true

	
	

	public Border setResaltaridTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltaridTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTablaAmorti() {
		return this.resaltaridTablaAmorti;
	}

	public void setResaltaridTablaAmorti(Border borderResaltar) {
		this.resaltaridTablaAmorti= borderResaltar;
	}

	public Boolean getMostraridTablaAmorti() {
		return this.mostraridTablaAmorti;
	}

	public void setMostraridTablaAmorti(Boolean mostraridTablaAmorti) {
		this.mostraridTablaAmorti= mostraridTablaAmorti;
	}

	public Boolean getActivaridTablaAmorti() {
		return this.activaridTablaAmorti;
	}

	public void setActivaridTablaAmorti(Boolean activaridTablaAmorti) {
		this.activaridTablaAmorti= activaridTablaAmorti;
	}

	public Border setResaltarid_empresaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_empresaTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTablaAmorti() {
		return this.resaltarid_empresaTablaAmorti;
	}

	public void setResaltarid_empresaTablaAmorti(Border borderResaltar) {
		this.resaltarid_empresaTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_empresaTablaAmorti() {
		return this.mostrarid_empresaTablaAmorti;
	}

	public void setMostrarid_empresaTablaAmorti(Boolean mostrarid_empresaTablaAmorti) {
		this.mostrarid_empresaTablaAmorti= mostrarid_empresaTablaAmorti;
	}

	public Boolean getActivarid_empresaTablaAmorti() {
		return this.activarid_empresaTablaAmorti;
	}

	public void setActivarid_empresaTablaAmorti(Boolean activarid_empresaTablaAmorti) {
		this.activarid_empresaTablaAmorti= activarid_empresaTablaAmorti;
	}

	public Boolean getCargarid_empresaTablaAmorti() {
		return this.cargarid_empresaTablaAmorti;
	}

	public void setCargarid_empresaTablaAmorti(Boolean cargarid_empresaTablaAmorti) {
		this.cargarid_empresaTablaAmorti= cargarid_empresaTablaAmorti;
	}

	public Border setResaltarid_sucursalTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTablaAmorti() {
		return this.resaltarid_sucursalTablaAmorti;
	}

	public void setResaltarid_sucursalTablaAmorti(Border borderResaltar) {
		this.resaltarid_sucursalTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTablaAmorti() {
		return this.mostrarid_sucursalTablaAmorti;
	}

	public void setMostrarid_sucursalTablaAmorti(Boolean mostrarid_sucursalTablaAmorti) {
		this.mostrarid_sucursalTablaAmorti= mostrarid_sucursalTablaAmorti;
	}

	public Boolean getActivarid_sucursalTablaAmorti() {
		return this.activarid_sucursalTablaAmorti;
	}

	public void setActivarid_sucursalTablaAmorti(Boolean activarid_sucursalTablaAmorti) {
		this.activarid_sucursalTablaAmorti= activarid_sucursalTablaAmorti;
	}

	public Boolean getCargarid_sucursalTablaAmorti() {
		return this.cargarid_sucursalTablaAmorti;
	}

	public void setCargarid_sucursalTablaAmorti(Boolean cargarid_sucursalTablaAmorti) {
		this.cargarid_sucursalTablaAmorti= cargarid_sucursalTablaAmorti;
	}

	public Border setResaltarid_ejercicioTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioTablaAmorti() {
		return this.resaltarid_ejercicioTablaAmorti;
	}

	public void setResaltarid_ejercicioTablaAmorti(Border borderResaltar) {
		this.resaltarid_ejercicioTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioTablaAmorti() {
		return this.mostrarid_ejercicioTablaAmorti;
	}

	public void setMostrarid_ejercicioTablaAmorti(Boolean mostrarid_ejercicioTablaAmorti) {
		this.mostrarid_ejercicioTablaAmorti= mostrarid_ejercicioTablaAmorti;
	}

	public Boolean getActivarid_ejercicioTablaAmorti() {
		return this.activarid_ejercicioTablaAmorti;
	}

	public void setActivarid_ejercicioTablaAmorti(Boolean activarid_ejercicioTablaAmorti) {
		this.activarid_ejercicioTablaAmorti= activarid_ejercicioTablaAmorti;
	}

	public Boolean getCargarid_ejercicioTablaAmorti() {
		return this.cargarid_ejercicioTablaAmorti;
	}

	public void setCargarid_ejercicioTablaAmorti(Boolean cargarid_ejercicioTablaAmorti) {
		this.cargarid_ejercicioTablaAmorti= cargarid_ejercicioTablaAmorti;
	}

	public Border setResaltarid_periodoTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_periodoTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoTablaAmorti() {
		return this.resaltarid_periodoTablaAmorti;
	}

	public void setResaltarid_periodoTablaAmorti(Border borderResaltar) {
		this.resaltarid_periodoTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_periodoTablaAmorti() {
		return this.mostrarid_periodoTablaAmorti;
	}

	public void setMostrarid_periodoTablaAmorti(Boolean mostrarid_periodoTablaAmorti) {
		this.mostrarid_periodoTablaAmorti= mostrarid_periodoTablaAmorti;
	}

	public Boolean getActivarid_periodoTablaAmorti() {
		return this.activarid_periodoTablaAmorti;
	}

	public void setActivarid_periodoTablaAmorti(Boolean activarid_periodoTablaAmorti) {
		this.activarid_periodoTablaAmorti= activarid_periodoTablaAmorti;
	}

	public Boolean getCargarid_periodoTablaAmorti() {
		return this.cargarid_periodoTablaAmorti;
	}

	public void setCargarid_periodoTablaAmorti(Boolean cargarid_periodoTablaAmorti) {
		this.cargarid_periodoTablaAmorti= cargarid_periodoTablaAmorti;
	}

	public Border setResaltarid_tasaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_tasaTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tasaTablaAmorti() {
		return this.resaltarid_tasaTablaAmorti;
	}

	public void setResaltarid_tasaTablaAmorti(Border borderResaltar) {
		this.resaltarid_tasaTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_tasaTablaAmorti() {
		return this.mostrarid_tasaTablaAmorti;
	}

	public void setMostrarid_tasaTablaAmorti(Boolean mostrarid_tasaTablaAmorti) {
		this.mostrarid_tasaTablaAmorti= mostrarid_tasaTablaAmorti;
	}

	public Boolean getActivarid_tasaTablaAmorti() {
		return this.activarid_tasaTablaAmorti;
	}

	public void setActivarid_tasaTablaAmorti(Boolean activarid_tasaTablaAmorti) {
		this.activarid_tasaTablaAmorti= activarid_tasaTablaAmorti;
	}

	public Boolean getCargarid_tasaTablaAmorti() {
		return this.cargarid_tasaTablaAmorti;
	}

	public void setCargarid_tasaTablaAmorti(Boolean cargarid_tasaTablaAmorti) {
		this.cargarid_tasaTablaAmorti= cargarid_tasaTablaAmorti;
	}

	public Border setResaltarid_facturaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_facturaTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaTablaAmorti() {
		return this.resaltarid_facturaTablaAmorti;
	}

	public void setResaltarid_facturaTablaAmorti(Border borderResaltar) {
		this.resaltarid_facturaTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_facturaTablaAmorti() {
		return this.mostrarid_facturaTablaAmorti;
	}

	public void setMostrarid_facturaTablaAmorti(Boolean mostrarid_facturaTablaAmorti) {
		this.mostrarid_facturaTablaAmorti= mostrarid_facturaTablaAmorti;
	}

	public Boolean getActivarid_facturaTablaAmorti() {
		return this.activarid_facturaTablaAmorti;
	}

	public void setActivarid_facturaTablaAmorti(Boolean activarid_facturaTablaAmorti) {
		this.activarid_facturaTablaAmorti= activarid_facturaTablaAmorti;
	}

	public Boolean getCargarid_facturaTablaAmorti() {
		return this.cargarid_facturaTablaAmorti;
	}

	public void setCargarid_facturaTablaAmorti(Boolean cargarid_facturaTablaAmorti) {
		this.cargarid_facturaTablaAmorti= cargarid_facturaTablaAmorti;
	}

	public Border setResaltarfecha_emisionTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionTablaAmorti() {
		return this.resaltarfecha_emisionTablaAmorti;
	}

	public void setResaltarfecha_emisionTablaAmorti(Border borderResaltar) {
		this.resaltarfecha_emisionTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionTablaAmorti() {
		return this.mostrarfecha_emisionTablaAmorti;
	}

	public void setMostrarfecha_emisionTablaAmorti(Boolean mostrarfecha_emisionTablaAmorti) {
		this.mostrarfecha_emisionTablaAmorti= mostrarfecha_emisionTablaAmorti;
	}

	public Boolean getActivarfecha_emisionTablaAmorti() {
		return this.activarfecha_emisionTablaAmorti;
	}

	public void setActivarfecha_emisionTablaAmorti(Boolean activarfecha_emisionTablaAmorti) {
		this.activarfecha_emisionTablaAmorti= activarfecha_emisionTablaAmorti;
	}

	public Border setResaltarfecha_vencimientoTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoTablaAmorti() {
		return this.resaltarfecha_vencimientoTablaAmorti;
	}

	public void setResaltarfecha_vencimientoTablaAmorti(Border borderResaltar) {
		this.resaltarfecha_vencimientoTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoTablaAmorti() {
		return this.mostrarfecha_vencimientoTablaAmorti;
	}

	public void setMostrarfecha_vencimientoTablaAmorti(Boolean mostrarfecha_vencimientoTablaAmorti) {
		this.mostrarfecha_vencimientoTablaAmorti= mostrarfecha_vencimientoTablaAmorti;
	}

	public Boolean getActivarfecha_vencimientoTablaAmorti() {
		return this.activarfecha_vencimientoTablaAmorti;
	}

	public void setActivarfecha_vencimientoTablaAmorti(Boolean activarfecha_vencimientoTablaAmorti) {
		this.activarfecha_vencimientoTablaAmorti= activarfecha_vencimientoTablaAmorti;
	}

	public Border setResaltarvalor_prestamoTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarvalor_prestamoTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_prestamoTablaAmorti() {
		return this.resaltarvalor_prestamoTablaAmorti;
	}

	public void setResaltarvalor_prestamoTablaAmorti(Border borderResaltar) {
		this.resaltarvalor_prestamoTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarvalor_prestamoTablaAmorti() {
		return this.mostrarvalor_prestamoTablaAmorti;
	}

	public void setMostrarvalor_prestamoTablaAmorti(Boolean mostrarvalor_prestamoTablaAmorti) {
		this.mostrarvalor_prestamoTablaAmorti= mostrarvalor_prestamoTablaAmorti;
	}

	public Boolean getActivarvalor_prestamoTablaAmorti() {
		return this.activarvalor_prestamoTablaAmorti;
	}

	public void setActivarvalor_prestamoTablaAmorti(Boolean activarvalor_prestamoTablaAmorti) {
		this.activarvalor_prestamoTablaAmorti= activarvalor_prestamoTablaAmorti;
	}

	public Border setResaltarnumero_cuotasTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotasTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotasTablaAmorti() {
		return this.resaltarnumero_cuotasTablaAmorti;
	}

	public void setResaltarnumero_cuotasTablaAmorti(Border borderResaltar) {
		this.resaltarnumero_cuotasTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotasTablaAmorti() {
		return this.mostrarnumero_cuotasTablaAmorti;
	}

	public void setMostrarnumero_cuotasTablaAmorti(Boolean mostrarnumero_cuotasTablaAmorti) {
		this.mostrarnumero_cuotasTablaAmorti= mostrarnumero_cuotasTablaAmorti;
	}

	public Boolean getActivarnumero_cuotasTablaAmorti() {
		return this.activarnumero_cuotasTablaAmorti;
	}

	public void setActivarnumero_cuotasTablaAmorti(Boolean activarnumero_cuotasTablaAmorti) {
		this.activarnumero_cuotasTablaAmorti= activarnumero_cuotasTablaAmorti;
	}

	public Border setResaltarid_anioTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_anioTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioTablaAmorti() {
		return this.resaltarid_anioTablaAmorti;
	}

	public void setResaltarid_anioTablaAmorti(Border borderResaltar) {
		this.resaltarid_anioTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_anioTablaAmorti() {
		return this.mostrarid_anioTablaAmorti;
	}

	public void setMostrarid_anioTablaAmorti(Boolean mostrarid_anioTablaAmorti) {
		this.mostrarid_anioTablaAmorti= mostrarid_anioTablaAmorti;
	}

	public Boolean getActivarid_anioTablaAmorti() {
		return this.activarid_anioTablaAmorti;
	}

	public void setActivarid_anioTablaAmorti(Boolean activarid_anioTablaAmorti) {
		this.activarid_anioTablaAmorti= activarid_anioTablaAmorti;
	}

	public Boolean getCargarid_anioTablaAmorti() {
		return this.cargarid_anioTablaAmorti;
	}

	public void setCargarid_anioTablaAmorti(Boolean cargarid_anioTablaAmorti) {
		this.cargarid_anioTablaAmorti= cargarid_anioTablaAmorti;
	}

	public Border setResaltarid_mesTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_mesTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesTablaAmorti() {
		return this.resaltarid_mesTablaAmorti;
	}

	public void setResaltarid_mesTablaAmorti(Border borderResaltar) {
		this.resaltarid_mesTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_mesTablaAmorti() {
		return this.mostrarid_mesTablaAmorti;
	}

	public void setMostrarid_mesTablaAmorti(Boolean mostrarid_mesTablaAmorti) {
		this.mostrarid_mesTablaAmorti= mostrarid_mesTablaAmorti;
	}

	public Boolean getActivarid_mesTablaAmorti() {
		return this.activarid_mesTablaAmorti;
	}

	public void setActivarid_mesTablaAmorti(Boolean activarid_mesTablaAmorti) {
		this.activarid_mesTablaAmorti= activarid_mesTablaAmorti;
	}

	public Boolean getCargarid_mesTablaAmorti() {
		return this.cargarid_mesTablaAmorti;
	}

	public void setCargarid_mesTablaAmorti(Boolean cargarid_mesTablaAmorti) {
		this.cargarid_mesTablaAmorti= cargarid_mesTablaAmorti;
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
		
		
		this.setMostraridTablaAmorti(esInicial);
		this.setMostrarid_empresaTablaAmorti(esInicial);
		this.setMostrarid_sucursalTablaAmorti(esInicial);
		this.setMostrarid_ejercicioTablaAmorti(esInicial);
		this.setMostrarid_periodoTablaAmorti(esInicial);
		this.setMostrarid_tasaTablaAmorti(esInicial);
		this.setMostrarid_facturaTablaAmorti(esInicial);
		this.setMostrarfecha_emisionTablaAmorti(esInicial);
		this.setMostrarfecha_vencimientoTablaAmorti(esInicial);
		this.setMostrarvalor_prestamoTablaAmorti(esInicial);
		this.setMostrarnumero_cuotasTablaAmorti(esInicial);
		this.setMostrarid_anioTablaAmorti(esInicial);
		this.setMostrarid_mesTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiConstantesFunciones.ID)) {
				this.setMostraridTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDTASA)) {
				this.setMostrarid_tasaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.VALORPRESTAMO)) {
				this.setMostrarvalor_prestamoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.NUMEROCUOTAS)) {
				this.setMostrarnumero_cuotasTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDMES)) {
				this.setMostrarid_mesTablaAmorti(esAsigna);
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
		
		
		this.setActivaridTablaAmorti(esInicial);
		this.setActivarid_empresaTablaAmorti(esInicial);
		this.setActivarid_sucursalTablaAmorti(esInicial);
		this.setActivarid_ejercicioTablaAmorti(esInicial);
		this.setActivarid_periodoTablaAmorti(esInicial);
		this.setActivarid_tasaTablaAmorti(esInicial);
		this.setActivarid_facturaTablaAmorti(esInicial);
		this.setActivarfecha_emisionTablaAmorti(esInicial);
		this.setActivarfecha_vencimientoTablaAmorti(esInicial);
		this.setActivarvalor_prestamoTablaAmorti(esInicial);
		this.setActivarnumero_cuotasTablaAmorti(esInicial);
		this.setActivarid_anioTablaAmorti(esInicial);
		this.setActivarid_mesTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiConstantesFunciones.ID)) {
				this.setActivaridTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDTASA)) {
				this.setActivarid_tasaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.VALORPRESTAMO)) {
				this.setActivarvalor_prestamoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.NUMEROCUOTAS)) {
				this.setActivarnumero_cuotasTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDANIO)) {
				this.setActivarid_anioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDMES)) {
				this.setActivarid_mesTablaAmorti(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTablaAmorti(esInicial);
		this.setResaltarid_empresaTablaAmorti(esInicial);
		this.setResaltarid_sucursalTablaAmorti(esInicial);
		this.setResaltarid_ejercicioTablaAmorti(esInicial);
		this.setResaltarid_periodoTablaAmorti(esInicial);
		this.setResaltarid_tasaTablaAmorti(esInicial);
		this.setResaltarid_facturaTablaAmorti(esInicial);
		this.setResaltarfecha_emisionTablaAmorti(esInicial);
		this.setResaltarfecha_vencimientoTablaAmorti(esInicial);
		this.setResaltarvalor_prestamoTablaAmorti(esInicial);
		this.setResaltarnumero_cuotasTablaAmorti(esInicial);
		this.setResaltarid_anioTablaAmorti(esInicial);
		this.setResaltarid_mesTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TablaAmortiConstantesFunciones.ID)) {
				this.setResaltaridTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDTASA)) {
				this.setResaltarid_tasaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.VALORPRESTAMO)) {
				this.setResaltarvalor_prestamoTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.NUMEROCUOTAS)) {
				this.setResaltarnumero_cuotasTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(TablaAmortiConstantesFunciones.IDMES)) {
				this.setResaltarid_mesTablaAmorti(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleTablaAmortiTablaAmorti=null;

	public Border getResaltarDetalleTablaAmortiTablaAmorti() {
		return this.resaltarDetalleTablaAmortiTablaAmorti;
	}

	public void setResaltarDetalleTablaAmortiTablaAmorti(Border borderResaltarDetalleTablaAmorti) {
		if(borderResaltarDetalleTablaAmorti!=null) {
			this.resaltarDetalleTablaAmortiTablaAmorti= borderResaltarDetalleTablaAmorti;
		}
	}

	public Border setResaltarDetalleTablaAmortiTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleTablaAmorti=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tablaamortiBeanSwingJInternalFrame.jTtoolBarTablaAmorti.setBorder(borderResaltarDetalleTablaAmorti);
			
		this.resaltarDetalleTablaAmortiTablaAmorti= borderResaltarDetalleTablaAmorti;

		 return borderResaltarDetalleTablaAmorti;
	}



	public Boolean mostrarDetalleTablaAmortiTablaAmorti=true;

	public Boolean getMostrarDetalleTablaAmortiTablaAmorti() {
		return this.mostrarDetalleTablaAmortiTablaAmorti;
	}

	public void setMostrarDetalleTablaAmortiTablaAmorti(Boolean visibilidadResaltarDetalleTablaAmorti) {
		this.mostrarDetalleTablaAmortiTablaAmorti= visibilidadResaltarDetalleTablaAmorti;
	}



	public Boolean activarDetalleTablaAmortiTablaAmorti=true;

	public Boolean gethabilitarResaltarDetalleTablaAmortiTablaAmorti() {
		return this.activarDetalleTablaAmortiTablaAmorti;
	}

	public void setActivarDetalleTablaAmortiTablaAmorti(Boolean habilitarResaltarDetalleTablaAmorti) {
		this.activarDetalleTablaAmortiTablaAmorti= habilitarResaltarDetalleTablaAmorti;
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

		this.setMostrarDetalleTablaAmortiTablaAmorti(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTablaAmorti.class)) {
				this.setMostrarDetalleTablaAmortiTablaAmorti(esAsigna);
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

		this.setActivarDetalleTablaAmortiTablaAmorti(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTablaAmorti.class)) {
				this.setActivarDetalleTablaAmortiTablaAmorti(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleTablaAmortiTablaAmorti(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTablaAmorti.class)) {
				this.setResaltarDetalleTablaAmortiTablaAmorti(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioTablaAmorti=true;

	public Boolean getMostrarFK_IdEjercicioTablaAmorti() {
		return this.mostrarFK_IdEjercicioTablaAmorti;
	}

	public void setMostrarFK_IdEjercicioTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTablaAmorti=true;

	public Boolean getMostrarFK_IdEmpresaTablaAmorti() {
		return this.mostrarFK_IdEmpresaTablaAmorti;
	}

	public void setMostrarFK_IdEmpresaTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaTablaAmorti=true;

	public Boolean getMostrarFK_IdFacturaTablaAmorti() {
		return this.mostrarFK_IdFacturaTablaAmorti;
	}

	public void setMostrarFK_IdFacturaTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoTablaAmorti=true;

	public Boolean getMostrarFK_IdPeriodoTablaAmorti() {
		return this.mostrarFK_IdPeriodoTablaAmorti;
	}

	public void setMostrarFK_IdPeriodoTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTablaAmorti=true;

	public Boolean getMostrarFK_IdSucursalTablaAmorti() {
		return this.mostrarFK_IdSucursalTablaAmorti;
	}

	public void setMostrarFK_IdSucursalTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTasaTablaAmorti=true;

	public Boolean getMostrarFK_IdTasaTablaAmorti() {
		return this.mostrarFK_IdTasaTablaAmorti;
	}

	public void setMostrarFK_IdTasaTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTasaTablaAmorti= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioTablaAmorti=true;

	public Boolean getActivarFK_IdEjercicioTablaAmorti() {
		return this.activarFK_IdEjercicioTablaAmorti;
	}

	public void setActivarFK_IdEjercicioTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTablaAmorti=true;

	public Boolean getActivarFK_IdEmpresaTablaAmorti() {
		return this.activarFK_IdEmpresaTablaAmorti;
	}

	public void setActivarFK_IdEmpresaTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaTablaAmorti=true;

	public Boolean getActivarFK_IdFacturaTablaAmorti() {
		return this.activarFK_IdFacturaTablaAmorti;
	}

	public void setActivarFK_IdFacturaTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoTablaAmorti=true;

	public Boolean getActivarFK_IdPeriodoTablaAmorti() {
		return this.activarFK_IdPeriodoTablaAmorti;
	}

	public void setActivarFK_IdPeriodoTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTablaAmorti=true;

	public Boolean getActivarFK_IdSucursalTablaAmorti() {
		return this.activarFK_IdSucursalTablaAmorti;
	}

	public void setActivarFK_IdSucursalTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdTasaTablaAmorti=true;

	public Boolean getActivarFK_IdTasaTablaAmorti() {
		return this.activarFK_IdTasaTablaAmorti;
	}

	public void setActivarFK_IdTasaTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdTasaTablaAmorti= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioTablaAmorti=null;

	public Border getResaltarFK_IdEjercicioTablaAmorti() {
		return this.resaltarFK_IdEjercicioTablaAmorti;
	}

	public void setResaltarFK_IdEjercicioTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdEjercicioTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTablaAmorti=null;

	public Border getResaltarFK_IdEmpresaTablaAmorti() {
		return this.resaltarFK_IdEmpresaTablaAmorti;
	}

	public void setResaltarFK_IdEmpresaTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdFacturaTablaAmorti=null;

	public Border getResaltarFK_IdFacturaTablaAmorti() {
		return this.resaltarFK_IdFacturaTablaAmorti;
	}

	public void setResaltarFK_IdFacturaTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdFacturaTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdFacturaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoTablaAmorti=null;

	public Border getResaltarFK_IdPeriodoTablaAmorti() {
		return this.resaltarFK_IdPeriodoTablaAmorti;
	}

	public void setResaltarFK_IdPeriodoTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdPeriodoTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTablaAmorti=null;

	public Border getResaltarFK_IdSucursalTablaAmorti() {
		return this.resaltarFK_IdSucursalTablaAmorti;
	}

	public void setResaltarFK_IdSucursalTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdSucursalTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdTasaTablaAmorti=null;

	public Border getResaltarFK_IdTasaTablaAmorti() {
		return this.resaltarFK_IdTasaTablaAmorti;
	}

	public void setResaltarFK_IdTasaTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdTasaTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdTasaTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*TablaAmortiBeanSwingJInternalFrame tablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTasaTablaAmorti= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}