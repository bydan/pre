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


import com.bydan.erp.facturacion.util.DetalleTablaAmortiConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleTablaAmortiParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleTablaAmortiParameterGeneral;

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
final public class DetalleTablaAmortiConstantesFunciones extends DetalleTablaAmortiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleTablaAmorti";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleTablaAmorti"+DetalleTablaAmortiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleTablaAmortiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleTablaAmortiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleTablaAmortiConstantesFunciones.SCHEMA+"_"+DetalleTablaAmortiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleTablaAmortiConstantesFunciones.SCHEMA+"_"+DetalleTablaAmortiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleTablaAmortiConstantesFunciones.SCHEMA+"_"+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleTablaAmortiConstantesFunciones.SCHEMA+"_"+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTablaAmortiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTablaAmortiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleTablaAmortiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleTablaAmortiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleTablaAmortiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleTablaAmortiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Tabla Amortis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Tabla Amorti";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Tabla Amorti";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleTablaAmorti";
	public static final String OBJECTNAME="detalletablaamorti";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_tabla_amorti";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalletablaamorti from "+DetalleTablaAmortiConstantesFunciones.SPERSISTENCENAME+" detalletablaamorti";
	public static String QUERYSELECTNATIVE="select "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".version_row,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_periodo,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_tabla_amorti,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".valor,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".interes,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".capital,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".fecha_inicio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".fecha_fin,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".descripcion,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_anio,"+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME+".id_mes from "+DetalleTablaAmortiConstantesFunciones.SCHEMA+"."+DetalleTablaAmortiConstantesFunciones.TABLENAME;//+" as "+DetalleTablaAmortiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleTablaAmortiConstantesFuncionesAdditional detalletablaamortiConstantesFuncionesAdditional=null;
	
	public DetalleTablaAmortiConstantesFuncionesAdditional getDetalleTablaAmortiConstantesFuncionesAdditional() {
		return this.detalletablaamortiConstantesFuncionesAdditional;
	}
	
	public void setDetalleTablaAmortiConstantesFuncionesAdditional(DetalleTablaAmortiConstantesFuncionesAdditional detalletablaamortiConstantesFuncionesAdditional) {
		try {
			this.detalletablaamortiConstantesFuncionesAdditional=detalletablaamortiConstantesFuncionesAdditional;
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
    public static final String IDTABLAAMORTI= "id_tabla_amorti";
    public static final String VALOR= "valor";
    public static final String INTERES= "interes";
    public static final String CAPITAL= "capital";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDTABLAAMORTI= "Tabla Amorti";
		public static final String LABEL_IDTABLAAMORTI_LOWER= "Tabla Amorti";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_INTERES= "Interes";
		public static final String LABEL_INTERES_LOWER= "Interes";
    	public static final String LABEL_CAPITAL= "Capital";
		public static final String LABEL_CAPITAL_LOWER= "Capital";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetalleTablaAmortiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDTABLAAMORTI;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.VALOR)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.INTERES)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_INTERES;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.CAPITAL)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.FECHAINICIO)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.FECHAFIN)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDANIO)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleTablaAmortiConstantesFunciones.IDMES)) {sLabelColumna=DetalleTablaAmortiConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleTablaAmortiDescripcion(DetalleTablaAmorti detalletablaamorti) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalletablaamorti !=null/* && detalletablaamorti.getId()!=0*/) {
			if(detalletablaamorti.getId()!=null) {
				sDescripcion=detalletablaamorti.getId().toString();
			}//detalletablaamortidetalletablaamorti.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleTablaAmortiDescripcionDetallado(DetalleTablaAmorti detalletablaamorti) {
		String sDescripcion="";
			
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.ID+"=";
		sDescripcion+=detalletablaamorti.getId().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalletablaamorti.getVersionRow().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalletablaamorti.getid_empresa().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalletablaamorti.getid_sucursal().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalletablaamorti.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalletablaamorti.getid_periodo().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI+"=";
		sDescripcion+=detalletablaamorti.getid_tabla_amorti().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.VALOR+"=";
		sDescripcion+=detalletablaamorti.getvalor().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.INTERES+"=";
		sDescripcion+=detalletablaamorti.getinteres().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.CAPITAL+"=";
		sDescripcion+=detalletablaamorti.getcapital().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=detalletablaamorti.getfecha_inicio().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=detalletablaamorti.getfecha_fin().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalletablaamorti.getdescripcion()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalletablaamorti.getid_anio().toString()+",";
		sDescripcion+=DetalleTablaAmortiConstantesFunciones.IDMES+"=";
		sDescripcion+=detalletablaamorti.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleTablaAmortiDescripcion(DetalleTablaAmorti detalletablaamorti,String sValor) throws Exception {			
		if(detalletablaamorti !=null) {
			//detalletablaamortidetalletablaamorti.getId().toString();
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

	public static String getTablaAmortiDescripcion(TablaAmorti tablaamorti) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tablaamorti!=null/*&&tablaamorti.getId()>0*/) {
			sDescripcion=TablaAmortiConstantesFunciones.getTablaAmortiDescripcion(tablaamorti);
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
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTablaAmorti")) {
			sNombreIndice="Tipo=  Por Tabla Amorti";
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

	public static String getDetalleIndiceFK_IdTablaAmorti(Long id_tabla_amorti) {
		String sDetalleIndice=" Parametros->";
		if(id_tabla_amorti!=null) {sDetalleIndice+=" Codigo Unico De Tabla Amorti="+id_tabla_amorti.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalletablaamorti.setdescripcion(detalletablaamorti.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleTablaAmortis(List<DetalleTablaAmorti> detalletablaamortis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleTablaAmorti detalletablaamorti: detalletablaamortis) {
			detalletablaamorti.setdescripcion(detalletablaamorti.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalletablaamorti.getConCambioAuxiliar()) {
			detalletablaamorti.setIsDeleted(detalletablaamorti.getIsDeletedAuxiliar());	
			detalletablaamorti.setIsNew(detalletablaamorti.getIsNewAuxiliar());	
			detalletablaamorti.setIsChanged(detalletablaamorti.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalletablaamorti.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalletablaamorti.setIsDeletedAuxiliar(false);	
			detalletablaamorti.setIsNewAuxiliar(false);	
			detalletablaamorti.setIsChangedAuxiliar(false);
			
			detalletablaamorti.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTablaAmortis(List<DetalleTablaAmorti> detalletablaamortis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleTablaAmorti detalletablaamorti : detalletablaamortis) {
			if(conAsignarBase && detalletablaamorti.getConCambioAuxiliar()) {
				detalletablaamorti.setIsDeleted(detalletablaamorti.getIsDeletedAuxiliar());	
				detalletablaamorti.setIsNew(detalletablaamorti.getIsNewAuxiliar());	
				detalletablaamorti.setIsChanged(detalletablaamorti.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalletablaamorti.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalletablaamorti.setIsDeletedAuxiliar(false);	
				detalletablaamorti.setIsNewAuxiliar(false);	
				detalletablaamorti.setIsChangedAuxiliar(false);
				
				detalletablaamorti.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti,Boolean conEnteros) throws Exception  {
		detalletablaamorti.setvalor(0.0);
		detalletablaamorti.setinteres(0.0);
		detalletablaamorti.setcapital(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleTablaAmortis(List<DetalleTablaAmorti> detalletablaamortis,Boolean conEnteros) throws Exception  {
		
		for(DetalleTablaAmorti detalletablaamorti: detalletablaamortis) {
			detalletablaamorti.setvalor(0.0);
			detalletablaamorti.setinteres(0.0);
			detalletablaamorti.setcapital(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleTablaAmorti(List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmorti detalletablaamortiAux) throws Exception  {
		DetalleTablaAmortiConstantesFunciones.InicializarValoresDetalleTablaAmorti(detalletablaamortiAux,true);
		
		for(DetalleTablaAmorti detalletablaamorti: detalletablaamortis) {
			if(detalletablaamorti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalletablaamortiAux.setvalor(detalletablaamortiAux.getvalor()+detalletablaamorti.getvalor());			
			detalletablaamortiAux.setinteres(detalletablaamortiAux.getinteres()+detalletablaamorti.getinteres());			
			detalletablaamortiAux.setcapital(detalletablaamortiAux.getcapital()+detalletablaamorti.getcapital());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleTablaAmortiConstantesFunciones.getArrayColumnasGlobalesDetalleTablaAmorti(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTablaAmortiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTablaAmortiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTablaAmortiConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTablaAmortiConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleTablaAmorti(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleTablaAmorti> detalletablaamortis,DetalleTablaAmorti detalletablaamorti,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleTablaAmorti detalletablaamortiAux: detalletablaamortis) {
			if(detalletablaamortiAux!=null && detalletablaamorti!=null) {
				if((detalletablaamortiAux.getId()==null && detalletablaamorti.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalletablaamortiAux.getId()!=null && detalletablaamorti.getId()!=null){
					if(detalletablaamortiAux.getId().equals(detalletablaamorti.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleTablaAmorti(List<DetalleTablaAmorti> detalletablaamortis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double interesTotal=0.0;
		Double capitalTotal=0.0;
	
		for(DetalleTablaAmorti detalletablaamorti: detalletablaamortis) {			
			if(detalletablaamorti.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detalletablaamorti.getvalor();
			interesTotal+=detalletablaamorti.getinteres();
			capitalTotal+=detalletablaamorti.getcapital();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTablaAmortiConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTablaAmortiConstantesFunciones.INTERES);
		datoGeneral.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_INTERES);
		datoGeneral.setdValorDouble(interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleTablaAmortiConstantesFunciones.CAPITAL);
		datoGeneral.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL);
		datoGeneral.setdValorDouble(capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleTablaAmorti() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_ID, DetalleTablaAmortiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_VERSIONROW, DetalleTablaAmortiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDEMPRESA, DetalleTablaAmortiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDSUCURSAL, DetalleTablaAmortiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDEJERCICIO, DetalleTablaAmortiConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDPERIODO, DetalleTablaAmortiConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDTABLAAMORTI, DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_VALOR, DetalleTablaAmortiConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_INTERES, DetalleTablaAmortiConstantesFunciones.INTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL, DetalleTablaAmortiConstantesFunciones.CAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_FECHAINICIO, DetalleTablaAmortiConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_FECHAFIN, DetalleTablaAmortiConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_DESCRIPCION, DetalleTablaAmortiConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDANIO, DetalleTablaAmortiConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTablaAmortiConstantesFunciones.LABEL_IDMES, DetalleTablaAmortiConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleTablaAmorti() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.INTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.CAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTablaAmortiConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTablaAmorti() throws Exception  {
		return DetalleTablaAmortiConstantesFunciones.getTiposSeleccionarDetalleTablaAmorti(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTablaAmorti(Boolean conFk) throws Exception  {
		return DetalleTablaAmortiConstantesFunciones.getTiposSeleccionarDetalleTablaAmorti(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTablaAmorti(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDTABLAAMORTI);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDTABLAAMORTI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_INTERES);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_INTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTablaAmortiConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleTablaAmortiConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleTablaAmorti(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTablaAmorti(DetalleTablaAmorti detalletablaamortiAux) throws Exception {
		
			detalletablaamortiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalletablaamortiAux.getEmpresa()));
			detalletablaamortiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalletablaamortiAux.getSucursal()));
			detalletablaamortiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalletablaamortiAux.getEjercicio()));
			detalletablaamortiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalletablaamortiAux.getPeriodo()));
			detalletablaamortiAux.settablaamorti_descripcion(TablaAmortiConstantesFunciones.getTablaAmortiDescripcion(detalletablaamortiAux.getTablaAmorti()));
			detalletablaamortiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalletablaamortiAux.getAnio()));
			detalletablaamortiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalletablaamortiAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTablaAmorti(List<DetalleTablaAmorti> detalletablaamortisTemp) throws Exception {
		for(DetalleTablaAmorti detalletablaamortiAux:detalletablaamortisTemp) {
			
			detalletablaamortiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalletablaamortiAux.getEmpresa()));
			detalletablaamortiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalletablaamortiAux.getSucursal()));
			detalletablaamortiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalletablaamortiAux.getEjercicio()));
			detalletablaamortiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalletablaamortiAux.getPeriodo()));
			detalletablaamortiAux.settablaamorti_descripcion(TablaAmortiConstantesFunciones.getTablaAmortiDescripcion(detalletablaamortiAux.getTablaAmorti()));
			detalletablaamortiAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalletablaamortiAux.getAnio()));
			detalletablaamortiAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalletablaamortiAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(TablaAmorti.class));
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
					if(clas.clas.equals(TablaAmorti.class)) {
						classes.add(new Classe(TablaAmorti.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmorti.class)); continue;
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

					if(TablaAmorti.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TablaAmorti.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTablaAmortiConstantesFunciones.getClassesRelationshipsOfDetalleTablaAmorti(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTablaAmorti(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTablaAmortiConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleTablaAmorti(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTablaAmorti(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleTablaAmorti detalletablaamorti,List<DetalleTablaAmorti> detalletablaamortis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleTablaAmorti detalletablaamortiEncontrado=null;
			
			for(DetalleTablaAmorti detalletablaamortiLocal:detalletablaamortis) {
				if(detalletablaamortiLocal.getId().equals(detalletablaamorti.getId())) {
					detalletablaamortiEncontrado=detalletablaamortiLocal;
					
					detalletablaamortiLocal.setIsChanged(detalletablaamorti.getIsChanged());
					detalletablaamortiLocal.setIsNew(detalletablaamorti.getIsNew());
					detalletablaamortiLocal.setIsDeleted(detalletablaamorti.getIsDeleted());
					
					detalletablaamortiLocal.setGeneralEntityOriginal(detalletablaamorti.getGeneralEntityOriginal());
					
					detalletablaamortiLocal.setId(detalletablaamorti.getId());	
					detalletablaamortiLocal.setVersionRow(detalletablaamorti.getVersionRow());	
					detalletablaamortiLocal.setid_empresa(detalletablaamorti.getid_empresa());	
					detalletablaamortiLocal.setid_sucursal(detalletablaamorti.getid_sucursal());	
					detalletablaamortiLocal.setid_ejercicio(detalletablaamorti.getid_ejercicio());	
					detalletablaamortiLocal.setid_periodo(detalletablaamorti.getid_periodo());	
					detalletablaamortiLocal.setid_tabla_amorti(detalletablaamorti.getid_tabla_amorti());	
					detalletablaamortiLocal.setvalor(detalletablaamorti.getvalor());	
					detalletablaamortiLocal.setinteres(detalletablaamorti.getinteres());	
					detalletablaamortiLocal.setcapital(detalletablaamorti.getcapital());	
					detalletablaamortiLocal.setfecha_inicio(detalletablaamorti.getfecha_inicio());	
					detalletablaamortiLocal.setfecha_fin(detalletablaamorti.getfecha_fin());	
					detalletablaamortiLocal.setdescripcion(detalletablaamorti.getdescripcion());	
					detalletablaamortiLocal.setid_anio(detalletablaamorti.getid_anio());	
					detalletablaamortiLocal.setid_mes(detalletablaamorti.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalletablaamorti.getIsDeleted()) {
				if(!existe) {
					detalletablaamortis.add(detalletablaamorti);
				}
			} else {
				if(detalletablaamortiEncontrado!=null && permiteQuitar)  {
					detalletablaamortis.remove(detalletablaamortiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleTablaAmorti detalletablaamorti,List<DetalleTablaAmorti> detalletablaamortis) throws Exception {
		try	{			
			for(DetalleTablaAmorti detalletablaamortiLocal:detalletablaamortis) {
				if(detalletablaamortiLocal.getId().equals(detalletablaamorti.getId())) {
					detalletablaamortiLocal.setIsSelected(detalletablaamorti.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleTablaAmorti(List<DetalleTablaAmorti> detalletablaamortisAux) throws Exception {
		//this.detalletablaamortisAux=detalletablaamortisAux;
		
		for(DetalleTablaAmorti detalletablaamortiAux:detalletablaamortisAux) {
			if(detalletablaamortiAux.getIsChanged()) {
				detalletablaamortiAux.setIsChanged(false);
			}		
			
			if(detalletablaamortiAux.getIsNew()) {
				detalletablaamortiAux.setIsNew(false);
			}	
			
			if(detalletablaamortiAux.getIsDeleted()) {
				detalletablaamortiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleTablaAmorti(DetalleTablaAmorti detalletablaamortiAux) throws Exception {
		//this.detalletablaamortiAux=detalletablaamortiAux;
		
			if(detalletablaamortiAux.getIsChanged()) {
				detalletablaamortiAux.setIsChanged(false);
			}		
			
			if(detalletablaamortiAux.getIsNew()) {
				detalletablaamortiAux.setIsNew(false);
			}	
			
			if(detalletablaamortiAux.getIsDeleted()) {
				detalletablaamortiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleTablaAmorti detalletablaamortiAsignar,DetalleTablaAmorti detalletablaamorti) throws Exception {
		detalletablaamortiAsignar.setId(detalletablaamorti.getId());	
		detalletablaamortiAsignar.setVersionRow(detalletablaamorti.getVersionRow());	
		detalletablaamortiAsignar.setid_empresa(detalletablaamorti.getid_empresa());
		detalletablaamortiAsignar.setempresa_descripcion(detalletablaamorti.getempresa_descripcion());	
		detalletablaamortiAsignar.setid_sucursal(detalletablaamorti.getid_sucursal());
		detalletablaamortiAsignar.setsucursal_descripcion(detalletablaamorti.getsucursal_descripcion());	
		detalletablaamortiAsignar.setid_ejercicio(detalletablaamorti.getid_ejercicio());
		detalletablaamortiAsignar.setejercicio_descripcion(detalletablaamorti.getejercicio_descripcion());	
		detalletablaamortiAsignar.setid_periodo(detalletablaamorti.getid_periodo());
		detalletablaamortiAsignar.setperiodo_descripcion(detalletablaamorti.getperiodo_descripcion());	
		detalletablaamortiAsignar.setid_tabla_amorti(detalletablaamorti.getid_tabla_amorti());
		detalletablaamortiAsignar.settablaamorti_descripcion(detalletablaamorti.gettablaamorti_descripcion());	
		detalletablaamortiAsignar.setvalor(detalletablaamorti.getvalor());	
		detalletablaamortiAsignar.setinteres(detalletablaamorti.getinteres());	
		detalletablaamortiAsignar.setcapital(detalletablaamorti.getcapital());	
		detalletablaamortiAsignar.setfecha_inicio(detalletablaamorti.getfecha_inicio());	
		detalletablaamortiAsignar.setfecha_fin(detalletablaamorti.getfecha_fin());	
		detalletablaamortiAsignar.setdescripcion(detalletablaamorti.getdescripcion());	
		detalletablaamortiAsignar.setid_anio(detalletablaamorti.getid_anio());
		detalletablaamortiAsignar.setanio_descripcion(detalletablaamorti.getanio_descripcion());	
		detalletablaamortiAsignar.setid_mes(detalletablaamorti.getid_mes());
		detalletablaamortiAsignar.setmes_descripcion(detalletablaamorti.getmes_descripcion());	
	}
	
	public static void inicializarDetalleTablaAmorti(DetalleTablaAmorti detalletablaamorti) throws Exception {
		try {
				detalletablaamorti.setId(0L);	
					
				detalletablaamorti.setid_empresa(-1L);	
				detalletablaamorti.setid_sucursal(-1L);	
				detalletablaamorti.setid_ejercicio(-1L);	
				detalletablaamorti.setid_periodo(-1L);	
				detalletablaamorti.setid_tabla_amorti(-1L);	
				detalletablaamorti.setvalor(0.0);	
				detalletablaamorti.setinteres(0.0);	
				detalletablaamorti.setcapital(0.0);	
				detalletablaamorti.setfecha_inicio(new Date());	
				detalletablaamorti.setfecha_fin(new Date());	
				detalletablaamorti.setdescripcion("");	
				detalletablaamorti.setid_anio(null);	
				detalletablaamorti.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleTablaAmorti(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDTABLAAMORTI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_INTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_CAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTablaAmortiConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleTablaAmorti(String sTipo,Row row,Workbook workbook,DetalleTablaAmorti detalletablaamorti,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.gettablaamorti_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getinteres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getcapital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalletablaamorti.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleTablaAmorti=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleTablaAmorti() {
		return this.sFinalQueryDetalleTablaAmorti;
	}
	
	public void setsFinalQueryDetalleTablaAmorti(String sFinalQueryDetalleTablaAmorti) {
		this.sFinalQueryDetalleTablaAmorti= sFinalQueryDetalleTablaAmorti;
	}
	
	public Border resaltarSeleccionarDetalleTablaAmorti=null;
	
	public Border setResaltarSeleccionarDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleTablaAmorti= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleTablaAmorti() {
		return this.resaltarSeleccionarDetalleTablaAmorti;
	}
	
	public void setResaltarSeleccionarDetalleTablaAmorti(Border borderResaltarSeleccionarDetalleTablaAmorti) {
		this.resaltarSeleccionarDetalleTablaAmorti= borderResaltarSeleccionarDetalleTablaAmorti;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleTablaAmorti=null;
	public Boolean mostraridDetalleTablaAmorti=true;
	public Boolean activaridDetalleTablaAmorti=true;

	public Border resaltarid_empresaDetalleTablaAmorti=null;
	public Boolean mostrarid_empresaDetalleTablaAmorti=true;
	public Boolean activarid_empresaDetalleTablaAmorti=true;
	public Boolean cargarid_empresaDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleTablaAmorti=null;
	public Boolean mostrarid_sucursalDetalleTablaAmorti=true;
	public Boolean activarid_sucursalDetalleTablaAmorti=true;
	public Boolean cargarid_sucursalDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleTablaAmorti=null;
	public Boolean mostrarid_ejercicioDetalleTablaAmorti=true;
	public Boolean activarid_ejercicioDetalleTablaAmorti=true;
	public Boolean cargarid_ejercicioDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleTablaAmorti=null;
	public Boolean mostrarid_periodoDetalleTablaAmorti=true;
	public Boolean activarid_periodoDetalleTablaAmorti=true;
	public Boolean cargarid_periodoDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_tabla_amortiDetalleTablaAmorti=null;
	public Boolean mostrarid_tabla_amortiDetalleTablaAmorti=true;
	public Boolean activarid_tabla_amortiDetalleTablaAmorti=true;
	public Boolean cargarid_tabla_amortiDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tabla_amortiDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarvalorDetalleTablaAmorti=null;
	public Boolean mostrarvalorDetalleTablaAmorti=true;
	public Boolean activarvalorDetalleTablaAmorti=true;

	public Border resaltarinteresDetalleTablaAmorti=null;
	public Boolean mostrarinteresDetalleTablaAmorti=true;
	public Boolean activarinteresDetalleTablaAmorti=true;

	public Border resaltarcapitalDetalleTablaAmorti=null;
	public Boolean mostrarcapitalDetalleTablaAmorti=true;
	public Boolean activarcapitalDetalleTablaAmorti=true;

	public Border resaltarfecha_inicioDetalleTablaAmorti=null;
	public Boolean mostrarfecha_inicioDetalleTablaAmorti=true;
	public Boolean activarfecha_inicioDetalleTablaAmorti=false;

	public Border resaltarfecha_finDetalleTablaAmorti=null;
	public Boolean mostrarfecha_finDetalleTablaAmorti=true;
	public Boolean activarfecha_finDetalleTablaAmorti=false;

	public Border resaltardescripcionDetalleTablaAmorti=null;
	public Boolean mostrardescripcionDetalleTablaAmorti=true;
	public Boolean activardescripcionDetalleTablaAmorti=true;

	public Border resaltarid_anioDetalleTablaAmorti=null;
	public Boolean mostrarid_anioDetalleTablaAmorti=true;
	public Boolean activarid_anioDetalleTablaAmorti=false;
	public Boolean cargarid_anioDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleTablaAmorti=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleTablaAmorti=null;
	public Boolean mostrarid_mesDetalleTablaAmorti=true;
	public Boolean activarid_mesDetalleTablaAmorti=false;
	public Boolean cargarid_mesDetalleTablaAmorti=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleTablaAmorti=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltaridDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleTablaAmorti() {
		return this.resaltaridDetalleTablaAmorti;
	}

	public void setResaltaridDetalleTablaAmorti(Border borderResaltar) {
		this.resaltaridDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostraridDetalleTablaAmorti() {
		return this.mostraridDetalleTablaAmorti;
	}

	public void setMostraridDetalleTablaAmorti(Boolean mostraridDetalleTablaAmorti) {
		this.mostraridDetalleTablaAmorti= mostraridDetalleTablaAmorti;
	}

	public Boolean getActivaridDetalleTablaAmorti() {
		return this.activaridDetalleTablaAmorti;
	}

	public void setActivaridDetalleTablaAmorti(Boolean activaridDetalleTablaAmorti) {
		this.activaridDetalleTablaAmorti= activaridDetalleTablaAmorti;
	}

	public Border setResaltarid_empresaDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleTablaAmorti() {
		return this.resaltarid_empresaDetalleTablaAmorti;
	}

	public void setResaltarid_empresaDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_empresaDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleTablaAmorti() {
		return this.mostrarid_empresaDetalleTablaAmorti;
	}

	public void setMostrarid_empresaDetalleTablaAmorti(Boolean mostrarid_empresaDetalleTablaAmorti) {
		this.mostrarid_empresaDetalleTablaAmorti= mostrarid_empresaDetalleTablaAmorti;
	}

	public Boolean getActivarid_empresaDetalleTablaAmorti() {
		return this.activarid_empresaDetalleTablaAmorti;
	}

	public void setActivarid_empresaDetalleTablaAmorti(Boolean activarid_empresaDetalleTablaAmorti) {
		this.activarid_empresaDetalleTablaAmorti= activarid_empresaDetalleTablaAmorti;
	}

	public Boolean getCargarid_empresaDetalleTablaAmorti() {
		return this.cargarid_empresaDetalleTablaAmorti;
	}

	public void setCargarid_empresaDetalleTablaAmorti(Boolean cargarid_empresaDetalleTablaAmorti) {
		this.cargarid_empresaDetalleTablaAmorti= cargarid_empresaDetalleTablaAmorti;
	}

	public Border setResaltarid_sucursalDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleTablaAmorti() {
		return this.resaltarid_sucursalDetalleTablaAmorti;
	}

	public void setResaltarid_sucursalDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_sucursalDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleTablaAmorti() {
		return this.mostrarid_sucursalDetalleTablaAmorti;
	}

	public void setMostrarid_sucursalDetalleTablaAmorti(Boolean mostrarid_sucursalDetalleTablaAmorti) {
		this.mostrarid_sucursalDetalleTablaAmorti= mostrarid_sucursalDetalleTablaAmorti;
	}

	public Boolean getActivarid_sucursalDetalleTablaAmorti() {
		return this.activarid_sucursalDetalleTablaAmorti;
	}

	public void setActivarid_sucursalDetalleTablaAmorti(Boolean activarid_sucursalDetalleTablaAmorti) {
		this.activarid_sucursalDetalleTablaAmorti= activarid_sucursalDetalleTablaAmorti;
	}

	public Boolean getCargarid_sucursalDetalleTablaAmorti() {
		return this.cargarid_sucursalDetalleTablaAmorti;
	}

	public void setCargarid_sucursalDetalleTablaAmorti(Boolean cargarid_sucursalDetalleTablaAmorti) {
		this.cargarid_sucursalDetalleTablaAmorti= cargarid_sucursalDetalleTablaAmorti;
	}

	public Border setResaltarid_ejercicioDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleTablaAmorti() {
		return this.resaltarid_ejercicioDetalleTablaAmorti;
	}

	public void setResaltarid_ejercicioDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleTablaAmorti() {
		return this.mostrarid_ejercicioDetalleTablaAmorti;
	}

	public void setMostrarid_ejercicioDetalleTablaAmorti(Boolean mostrarid_ejercicioDetalleTablaAmorti) {
		this.mostrarid_ejercicioDetalleTablaAmorti= mostrarid_ejercicioDetalleTablaAmorti;
	}

	public Boolean getActivarid_ejercicioDetalleTablaAmorti() {
		return this.activarid_ejercicioDetalleTablaAmorti;
	}

	public void setActivarid_ejercicioDetalleTablaAmorti(Boolean activarid_ejercicioDetalleTablaAmorti) {
		this.activarid_ejercicioDetalleTablaAmorti= activarid_ejercicioDetalleTablaAmorti;
	}

	public Boolean getCargarid_ejercicioDetalleTablaAmorti() {
		return this.cargarid_ejercicioDetalleTablaAmorti;
	}

	public void setCargarid_ejercicioDetalleTablaAmorti(Boolean cargarid_ejercicioDetalleTablaAmorti) {
		this.cargarid_ejercicioDetalleTablaAmorti= cargarid_ejercicioDetalleTablaAmorti;
	}

	public Border setResaltarid_periodoDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleTablaAmorti() {
		return this.resaltarid_periodoDetalleTablaAmorti;
	}

	public void setResaltarid_periodoDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_periodoDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleTablaAmorti() {
		return this.mostrarid_periodoDetalleTablaAmorti;
	}

	public void setMostrarid_periodoDetalleTablaAmorti(Boolean mostrarid_periodoDetalleTablaAmorti) {
		this.mostrarid_periodoDetalleTablaAmorti= mostrarid_periodoDetalleTablaAmorti;
	}

	public Boolean getActivarid_periodoDetalleTablaAmorti() {
		return this.activarid_periodoDetalleTablaAmorti;
	}

	public void setActivarid_periodoDetalleTablaAmorti(Boolean activarid_periodoDetalleTablaAmorti) {
		this.activarid_periodoDetalleTablaAmorti= activarid_periodoDetalleTablaAmorti;
	}

	public Boolean getCargarid_periodoDetalleTablaAmorti() {
		return this.cargarid_periodoDetalleTablaAmorti;
	}

	public void setCargarid_periodoDetalleTablaAmorti(Boolean cargarid_periodoDetalleTablaAmorti) {
		this.cargarid_periodoDetalleTablaAmorti= cargarid_periodoDetalleTablaAmorti;
	}

	public Border setResaltarid_tabla_amortiDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_tabla_amortiDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tabla_amortiDetalleTablaAmorti() {
		return this.resaltarid_tabla_amortiDetalleTablaAmorti;
	}

	public void setResaltarid_tabla_amortiDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_tabla_amortiDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_tabla_amortiDetalleTablaAmorti() {
		return this.mostrarid_tabla_amortiDetalleTablaAmorti;
	}

	public void setMostrarid_tabla_amortiDetalleTablaAmorti(Boolean mostrarid_tabla_amortiDetalleTablaAmorti) {
		this.mostrarid_tabla_amortiDetalleTablaAmorti= mostrarid_tabla_amortiDetalleTablaAmorti;
	}

	public Boolean getActivarid_tabla_amortiDetalleTablaAmorti() {
		return this.activarid_tabla_amortiDetalleTablaAmorti;
	}

	public void setActivarid_tabla_amortiDetalleTablaAmorti(Boolean activarid_tabla_amortiDetalleTablaAmorti) {
		this.activarid_tabla_amortiDetalleTablaAmorti= activarid_tabla_amortiDetalleTablaAmorti;
	}

	public Boolean getCargarid_tabla_amortiDetalleTablaAmorti() {
		return this.cargarid_tabla_amortiDetalleTablaAmorti;
	}

	public void setCargarid_tabla_amortiDetalleTablaAmorti(Boolean cargarid_tabla_amortiDetalleTablaAmorti) {
		this.cargarid_tabla_amortiDetalleTablaAmorti= cargarid_tabla_amortiDetalleTablaAmorti;
	}

	public Border setResaltarvalorDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleTablaAmorti() {
		return this.resaltarvalorDetalleTablaAmorti;
	}

	public void setResaltarvalorDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarvalorDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleTablaAmorti() {
		return this.mostrarvalorDetalleTablaAmorti;
	}

	public void setMostrarvalorDetalleTablaAmorti(Boolean mostrarvalorDetalleTablaAmorti) {
		this.mostrarvalorDetalleTablaAmorti= mostrarvalorDetalleTablaAmorti;
	}

	public Boolean getActivarvalorDetalleTablaAmorti() {
		return this.activarvalorDetalleTablaAmorti;
	}

	public void setActivarvalorDetalleTablaAmorti(Boolean activarvalorDetalleTablaAmorti) {
		this.activarvalorDetalleTablaAmorti= activarvalorDetalleTablaAmorti;
	}

	public Border setResaltarinteresDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarinteresDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteresDetalleTablaAmorti() {
		return this.resaltarinteresDetalleTablaAmorti;
	}

	public void setResaltarinteresDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarinteresDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarinteresDetalleTablaAmorti() {
		return this.mostrarinteresDetalleTablaAmorti;
	}

	public void setMostrarinteresDetalleTablaAmorti(Boolean mostrarinteresDetalleTablaAmorti) {
		this.mostrarinteresDetalleTablaAmorti= mostrarinteresDetalleTablaAmorti;
	}

	public Boolean getActivarinteresDetalleTablaAmorti() {
		return this.activarinteresDetalleTablaAmorti;
	}

	public void setActivarinteresDetalleTablaAmorti(Boolean activarinteresDetalleTablaAmorti) {
		this.activarinteresDetalleTablaAmorti= activarinteresDetalleTablaAmorti;
	}

	public Border setResaltarcapitalDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarcapitalDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcapitalDetalleTablaAmorti() {
		return this.resaltarcapitalDetalleTablaAmorti;
	}

	public void setResaltarcapitalDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarcapitalDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarcapitalDetalleTablaAmorti() {
		return this.mostrarcapitalDetalleTablaAmorti;
	}

	public void setMostrarcapitalDetalleTablaAmorti(Boolean mostrarcapitalDetalleTablaAmorti) {
		this.mostrarcapitalDetalleTablaAmorti= mostrarcapitalDetalleTablaAmorti;
	}

	public Boolean getActivarcapitalDetalleTablaAmorti() {
		return this.activarcapitalDetalleTablaAmorti;
	}

	public void setActivarcapitalDetalleTablaAmorti(Boolean activarcapitalDetalleTablaAmorti) {
		this.activarcapitalDetalleTablaAmorti= activarcapitalDetalleTablaAmorti;
	}

	public Border setResaltarfecha_inicioDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioDetalleTablaAmorti() {
		return this.resaltarfecha_inicioDetalleTablaAmorti;
	}

	public void setResaltarfecha_inicioDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarfecha_inicioDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioDetalleTablaAmorti() {
		return this.mostrarfecha_inicioDetalleTablaAmorti;
	}

	public void setMostrarfecha_inicioDetalleTablaAmorti(Boolean mostrarfecha_inicioDetalleTablaAmorti) {
		this.mostrarfecha_inicioDetalleTablaAmorti= mostrarfecha_inicioDetalleTablaAmorti;
	}

	public Boolean getActivarfecha_inicioDetalleTablaAmorti() {
		return this.activarfecha_inicioDetalleTablaAmorti;
	}

	public void setActivarfecha_inicioDetalleTablaAmorti(Boolean activarfecha_inicioDetalleTablaAmorti) {
		this.activarfecha_inicioDetalleTablaAmorti= activarfecha_inicioDetalleTablaAmorti;
	}

	public Border setResaltarfecha_finDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarfecha_finDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finDetalleTablaAmorti() {
		return this.resaltarfecha_finDetalleTablaAmorti;
	}

	public void setResaltarfecha_finDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarfecha_finDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarfecha_finDetalleTablaAmorti() {
		return this.mostrarfecha_finDetalleTablaAmorti;
	}

	public void setMostrarfecha_finDetalleTablaAmorti(Boolean mostrarfecha_finDetalleTablaAmorti) {
		this.mostrarfecha_finDetalleTablaAmorti= mostrarfecha_finDetalleTablaAmorti;
	}

	public Boolean getActivarfecha_finDetalleTablaAmorti() {
		return this.activarfecha_finDetalleTablaAmorti;
	}

	public void setActivarfecha_finDetalleTablaAmorti(Boolean activarfecha_finDetalleTablaAmorti) {
		this.activarfecha_finDetalleTablaAmorti= activarfecha_finDetalleTablaAmorti;
	}

	public Border setResaltardescripcionDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleTablaAmorti() {
		return this.resaltardescripcionDetalleTablaAmorti;
	}

	public void setResaltardescripcionDetalleTablaAmorti(Border borderResaltar) {
		this.resaltardescripcionDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleTablaAmorti() {
		return this.mostrardescripcionDetalleTablaAmorti;
	}

	public void setMostrardescripcionDetalleTablaAmorti(Boolean mostrardescripcionDetalleTablaAmorti) {
		this.mostrardescripcionDetalleTablaAmorti= mostrardescripcionDetalleTablaAmorti;
	}

	public Boolean getActivardescripcionDetalleTablaAmorti() {
		return this.activardescripcionDetalleTablaAmorti;
	}

	public void setActivardescripcionDetalleTablaAmorti(Boolean activardescripcionDetalleTablaAmorti) {
		this.activardescripcionDetalleTablaAmorti= activardescripcionDetalleTablaAmorti;
	}

	public Border setResaltarid_anioDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleTablaAmorti() {
		return this.resaltarid_anioDetalleTablaAmorti;
	}

	public void setResaltarid_anioDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_anioDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleTablaAmorti() {
		return this.mostrarid_anioDetalleTablaAmorti;
	}

	public void setMostrarid_anioDetalleTablaAmorti(Boolean mostrarid_anioDetalleTablaAmorti) {
		this.mostrarid_anioDetalleTablaAmorti= mostrarid_anioDetalleTablaAmorti;
	}

	public Boolean getActivarid_anioDetalleTablaAmorti() {
		return this.activarid_anioDetalleTablaAmorti;
	}

	public void setActivarid_anioDetalleTablaAmorti(Boolean activarid_anioDetalleTablaAmorti) {
		this.activarid_anioDetalleTablaAmorti= activarid_anioDetalleTablaAmorti;
	}

	public Boolean getCargarid_anioDetalleTablaAmorti() {
		return this.cargarid_anioDetalleTablaAmorti;
	}

	public void setCargarid_anioDetalleTablaAmorti(Boolean cargarid_anioDetalleTablaAmorti) {
		this.cargarid_anioDetalleTablaAmorti= cargarid_anioDetalleTablaAmorti;
	}

	public Border setResaltarid_mesDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalletablaamortiBeanSwingJInternalFrame.jTtoolBarDetalleTablaAmorti.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleTablaAmorti= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleTablaAmorti() {
		return this.resaltarid_mesDetalleTablaAmorti;
	}

	public void setResaltarid_mesDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarid_mesDetalleTablaAmorti= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleTablaAmorti() {
		return this.mostrarid_mesDetalleTablaAmorti;
	}

	public void setMostrarid_mesDetalleTablaAmorti(Boolean mostrarid_mesDetalleTablaAmorti) {
		this.mostrarid_mesDetalleTablaAmorti= mostrarid_mesDetalleTablaAmorti;
	}

	public Boolean getActivarid_mesDetalleTablaAmorti() {
		return this.activarid_mesDetalleTablaAmorti;
	}

	public void setActivarid_mesDetalleTablaAmorti(Boolean activarid_mesDetalleTablaAmorti) {
		this.activarid_mesDetalleTablaAmorti= activarid_mesDetalleTablaAmorti;
	}

	public Boolean getCargarid_mesDetalleTablaAmorti() {
		return this.cargarid_mesDetalleTablaAmorti;
	}

	public void setCargarid_mesDetalleTablaAmorti(Boolean cargarid_mesDetalleTablaAmorti) {
		this.cargarid_mesDetalleTablaAmorti= cargarid_mesDetalleTablaAmorti;
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
		
		
		this.setMostraridDetalleTablaAmorti(esInicial);
		this.setMostrarid_empresaDetalleTablaAmorti(esInicial);
		this.setMostrarid_sucursalDetalleTablaAmorti(esInicial);
		this.setMostrarid_ejercicioDetalleTablaAmorti(esInicial);
		this.setMostrarid_periodoDetalleTablaAmorti(esInicial);
		this.setMostrarid_tabla_amortiDetalleTablaAmorti(esInicial);
		this.setMostrarvalorDetalleTablaAmorti(esInicial);
		this.setMostrarinteresDetalleTablaAmorti(esInicial);
		this.setMostrarcapitalDetalleTablaAmorti(esInicial);
		this.setMostrarfecha_inicioDetalleTablaAmorti(esInicial);
		this.setMostrarfecha_finDetalleTablaAmorti(esInicial);
		this.setMostrardescripcionDetalleTablaAmorti(esInicial);
		this.setMostrarid_anioDetalleTablaAmorti(esInicial);
		this.setMostrarid_mesDetalleTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.ID)) {
				this.setMostraridDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI)) {
				this.setMostrarid_tabla_amortiDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.INTERES)) {
				this.setMostrarinteresDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.CAPITAL)) {
				this.setMostrarcapitalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleTablaAmorti(esAsigna);
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
		
		
		this.setActivaridDetalleTablaAmorti(esInicial);
		this.setActivarid_empresaDetalleTablaAmorti(esInicial);
		this.setActivarid_sucursalDetalleTablaAmorti(esInicial);
		this.setActivarid_ejercicioDetalleTablaAmorti(esInicial);
		this.setActivarid_periodoDetalleTablaAmorti(esInicial);
		this.setActivarid_tabla_amortiDetalleTablaAmorti(esInicial);
		this.setActivarvalorDetalleTablaAmorti(esInicial);
		this.setActivarinteresDetalleTablaAmorti(esInicial);
		this.setActivarcapitalDetalleTablaAmorti(esInicial);
		this.setActivarfecha_inicioDetalleTablaAmorti(esInicial);
		this.setActivarfecha_finDetalleTablaAmorti(esInicial);
		this.setActivardescripcionDetalleTablaAmorti(esInicial);
		this.setActivarid_anioDetalleTablaAmorti(esInicial);
		this.setActivarid_mesDetalleTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.ID)) {
				this.setActivaridDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI)) {
				this.setActivarid_tabla_amortiDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.INTERES)) {
				this.setActivarinteresDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.CAPITAL)) {
				this.setActivarcapitalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleTablaAmorti(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleTablaAmorti(esInicial);
		this.setResaltarid_empresaDetalleTablaAmorti(esInicial);
		this.setResaltarid_sucursalDetalleTablaAmorti(esInicial);
		this.setResaltarid_ejercicioDetalleTablaAmorti(esInicial);
		this.setResaltarid_periodoDetalleTablaAmorti(esInicial);
		this.setResaltarid_tabla_amortiDetalleTablaAmorti(esInicial);
		this.setResaltarvalorDetalleTablaAmorti(esInicial);
		this.setResaltarinteresDetalleTablaAmorti(esInicial);
		this.setResaltarcapitalDetalleTablaAmorti(esInicial);
		this.setResaltarfecha_inicioDetalleTablaAmorti(esInicial);
		this.setResaltarfecha_finDetalleTablaAmorti(esInicial);
		this.setResaltardescripcionDetalleTablaAmorti(esInicial);
		this.setResaltarid_anioDetalleTablaAmorti(esInicial);
		this.setResaltarid_mesDetalleTablaAmorti(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.ID)) {
				this.setResaltaridDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDTABLAAMORTI)) {
				this.setResaltarid_tabla_amortiDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.INTERES)) {
				this.setResaltarinteresDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.CAPITAL)) {
				this.setResaltarcapitalDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleTablaAmorti(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTablaAmortiConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleTablaAmorti(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEjercicioDetalleTablaAmorti=true;

	public Boolean getMostrarFK_IdEjercicioDetalleTablaAmorti() {
		return this.mostrarFK_IdEjercicioDetalleTablaAmorti;
	}

	public void setMostrarFK_IdEjercicioDetalleTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleTablaAmorti=true;

	public Boolean getMostrarFK_IdEmpresaDetalleTablaAmorti() {
		return this.mostrarFK_IdEmpresaDetalleTablaAmorti;
	}

	public void setMostrarFK_IdEmpresaDetalleTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleTablaAmorti=true;

	public Boolean getMostrarFK_IdPeriodoDetalleTablaAmorti() {
		return this.mostrarFK_IdPeriodoDetalleTablaAmorti;
	}

	public void setMostrarFK_IdPeriodoDetalleTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleTablaAmorti=true;

	public Boolean getMostrarFK_IdSucursalDetalleTablaAmorti() {
		return this.mostrarFK_IdSucursalDetalleTablaAmorti;
	}

	public void setMostrarFK_IdSucursalDetalleTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleTablaAmorti= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTablaAmortiDetalleTablaAmorti=true;

	public Boolean getMostrarFK_IdTablaAmortiDetalleTablaAmorti() {
		return this.mostrarFK_IdTablaAmortiDetalleTablaAmorti;
	}

	public void setMostrarFK_IdTablaAmortiDetalleTablaAmorti(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTablaAmortiDetalleTablaAmorti= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioDetalleTablaAmorti=true;

	public Boolean getActivarFK_IdEjercicioDetalleTablaAmorti() {
		return this.activarFK_IdEjercicioDetalleTablaAmorti;
	}

	public void setActivarFK_IdEjercicioDetalleTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleTablaAmorti=true;

	public Boolean getActivarFK_IdEmpresaDetalleTablaAmorti() {
		return this.activarFK_IdEmpresaDetalleTablaAmorti;
	}

	public void setActivarFK_IdEmpresaDetalleTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleTablaAmorti=true;

	public Boolean getActivarFK_IdPeriodoDetalleTablaAmorti() {
		return this.activarFK_IdPeriodoDetalleTablaAmorti;
	}

	public void setActivarFK_IdPeriodoDetalleTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleTablaAmorti=true;

	public Boolean getActivarFK_IdSucursalDetalleTablaAmorti() {
		return this.activarFK_IdSucursalDetalleTablaAmorti;
	}

	public void setActivarFK_IdSucursalDetalleTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleTablaAmorti= habilitarResaltar;
	}

	public Boolean activarFK_IdTablaAmortiDetalleTablaAmorti=true;

	public Boolean getActivarFK_IdTablaAmortiDetalleTablaAmorti() {
		return this.activarFK_IdTablaAmortiDetalleTablaAmorti;
	}

	public void setActivarFK_IdTablaAmortiDetalleTablaAmorti(Boolean habilitarResaltar) {
		this.activarFK_IdTablaAmortiDetalleTablaAmorti= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioDetalleTablaAmorti=null;

	public Border getResaltarFK_IdEjercicioDetalleTablaAmorti() {
		return this.resaltarFK_IdEjercicioDetalleTablaAmorti;
	}

	public void setResaltarFK_IdEjercicioDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleTablaAmorti=null;

	public Border getResaltarFK_IdEmpresaDetalleTablaAmorti() {
		return this.resaltarFK_IdEmpresaDetalleTablaAmorti;
	}

	public void setResaltarFK_IdEmpresaDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleTablaAmorti=null;

	public Border getResaltarFK_IdPeriodoDetalleTablaAmorti() {
		return this.resaltarFK_IdPeriodoDetalleTablaAmorti;
	}

	public void setResaltarFK_IdPeriodoDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleTablaAmorti=null;

	public Border getResaltarFK_IdSucursalDetalleTablaAmorti() {
		return this.resaltarFK_IdSucursalDetalleTablaAmorti;
	}

	public void setResaltarFK_IdSucursalDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleTablaAmorti= borderResaltar;
	}

	public Border resaltarFK_IdTablaAmortiDetalleTablaAmorti=null;

	public Border getResaltarFK_IdTablaAmortiDetalleTablaAmorti() {
		return this.resaltarFK_IdTablaAmortiDetalleTablaAmorti;
	}

	public void setResaltarFK_IdTablaAmortiDetalleTablaAmorti(Border borderResaltar) {
		this.resaltarFK_IdTablaAmortiDetalleTablaAmorti= borderResaltar;
	}

	public void setResaltarFK_IdTablaAmortiDetalleTablaAmorti(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTablaAmortiBeanSwingJInternalFrame detalletablaamortiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTablaAmortiDetalleTablaAmorti= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}