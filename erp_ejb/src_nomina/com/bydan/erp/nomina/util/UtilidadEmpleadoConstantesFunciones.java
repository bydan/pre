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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.UtilidadEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.UtilidadEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.UtilidadEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UtilidadEmpleadoConstantesFunciones extends UtilidadEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UtilidadEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UtilidadEmpleado"+UtilidadEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UtilidadEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UtilidadEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UtilidadEmpleadoConstantesFunciones.SCHEMA+"_"+UtilidadEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UtilidadEmpleadoConstantesFunciones.SCHEMA+"_"+UtilidadEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UtilidadEmpleadoConstantesFunciones.SCHEMA+"_"+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UtilidadEmpleadoConstantesFunciones.SCHEMA+"_"+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UtilidadEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UtilidadEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UtilidadEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UtilidadEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Utilidad Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Utilidad Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Utilidad Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UtilidadEmpleado";
	public static final String OBJECTNAME="utilidadempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="utilidad_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select utilidadempleado from "+UtilidadEmpleadoConstantesFunciones.SPERSISTENCENAME+" utilidadempleado";
	public static String QUERYSELECTNATIVE="select "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".version_row,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".fecha_ingreso,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".fecha_salida,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_dias,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_cargas,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".utilidad_factor10,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".numero_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".valor_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".utilidad_factor5,"+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME+".total from "+UtilidadEmpleadoConstantesFunciones.SCHEMA+"."+UtilidadEmpleadoConstantesFunciones.TABLENAME;//+" as "+UtilidadEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UtilidadEmpleadoConstantesFuncionesAdditional utilidadempleadoConstantesFuncionesAdditional=null;
	
	public UtilidadEmpleadoConstantesFuncionesAdditional getUtilidadEmpleadoConstantesFuncionesAdditional() {
		return this.utilidadempleadoConstantesFuncionesAdditional;
	}
	
	public void setUtilidadEmpleadoConstantesFuncionesAdditional(UtilidadEmpleadoConstantesFuncionesAdditional utilidadempleadoConstantesFuncionesAdditional) {
		try {
			this.utilidadempleadoConstantesFuncionesAdditional=utilidadempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDANIO= "id_anio";
    public static final String FECHAINGRESO= "fecha_ingreso";
    public static final String FECHASALIDA= "fecha_salida";
    public static final String VALOR= "valor";
    public static final String NUMERODIAS= "numero_dias";
    public static final String NUMEROCARGAS= "numero_cargas";
    public static final String NUMEROFACTOR10= "numero_factor10";
    public static final String VALORFACTOR10= "valor_factor10";
    public static final String UTILIDADFACTOR10= "utilidad_factor10";
    public static final String NUMEROFACTOR5= "numero_factor5";
    public static final String VALORFACTOR5= "valor_factor5";
    public static final String UTILIDADFACTOR5= "utilidad_factor5";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_FECHAINGRESO= "Fecha Ingreso";
		public static final String LABEL_FECHAINGRESO_LOWER= "Fecha Ingreso";
    	public static final String LABEL_FECHASALIDA= "Fecha Salida";
		public static final String LABEL_FECHASALIDA_LOWER= "Fecha Salida";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_NUMEROCARGAS= "Numero Cargas";
		public static final String LABEL_NUMEROCARGAS_LOWER= "Numero Cargas";
    	public static final String LABEL_NUMEROFACTOR10= "Numero Factor10";
		public static final String LABEL_NUMEROFACTOR10_LOWER= "Numero Factor10";
    	public static final String LABEL_VALORFACTOR10= "Valor Factor10";
		public static final String LABEL_VALORFACTOR10_LOWER= "Valor Factor10";
    	public static final String LABEL_UTILIDADFACTOR10= "Utilidad Factor10";
		public static final String LABEL_UTILIDADFACTOR10_LOWER= "Utilidad Factor10";
    	public static final String LABEL_NUMEROFACTOR5= "Numero Factor5";
		public static final String LABEL_NUMEROFACTOR5_LOWER= "Numero Factor5";
    	public static final String LABEL_VALORFACTOR5= "Valor Factor5";
		public static final String LABEL_VALORFACTOR5_LOWER= "Valor Factor5";
    	public static final String LABEL_UTILIDADFACTOR5= "Utilidad Factor5";
		public static final String LABEL_UTILIDADFACTOR5_LOWER= "Utilidad Factor5";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getUtilidadEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.IDEMPRESA)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.IDANIO)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.FECHAINGRESO)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_FECHAINGRESO;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.FECHASALIDA)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_FECHASALIDA;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.VALOR)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.NUMERODIAS)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROCARGAS;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR10)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR5)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5;}
		if(sNombreColumna.equals(UtilidadEmpleadoConstantesFunciones.TOTAL)) {sLabelColumna=UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getUtilidadEmpleadoDescripcion(UtilidadEmpleado utilidadempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(utilidadempleado !=null/* && utilidadempleado.getId()!=0*/) {
			if(utilidadempleado.getId()!=null) {
				sDescripcion=utilidadempleado.getId().toString();
			}//utilidadempleadoutilidadempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUtilidadEmpleadoDescripcionDetallado(UtilidadEmpleado utilidadempleado) {
		String sDescripcion="";
			
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=utilidadempleado.getId().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=utilidadempleado.getVersionRow().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=utilidadempleado.getid_empresa().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=utilidadempleado.getid_empleado().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.IDANIO+"=";
		sDescripcion+=utilidadempleado.getid_anio().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.FECHAINGRESO+"=";
		sDescripcion+=utilidadempleado.getfecha_ingreso().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.FECHASALIDA+"=";
		sDescripcion+=utilidadempleado.getfecha_salida().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.VALOR+"=";
		sDescripcion+=utilidadempleado.getvalor().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=utilidadempleado.getnumero_dias().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS+"=";
		sDescripcion+=utilidadempleado.getnumero_cargas().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10+"=";
		sDescripcion+=utilidadempleado.getnumero_factor10().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.VALORFACTOR10+"=";
		sDescripcion+=utilidadempleado.getvalor_factor10().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10+"=";
		sDescripcion+=utilidadempleado.getutilidad_factor10().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5+"=";
		sDescripcion+=utilidadempleado.getnumero_factor5().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.VALORFACTOR5+"=";
		sDescripcion+=utilidadempleado.getvalor_factor5().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5+"=";
		sDescripcion+=utilidadempleado.getutilidad_factor5().toString()+",";
		sDescripcion+=UtilidadEmpleadoConstantesFunciones.TOTAL+"=";
		sDescripcion+=utilidadempleado.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUtilidadEmpleadoDescripcion(UtilidadEmpleado utilidadempleado,String sValor) throws Exception {			
		if(utilidadempleado !=null) {
			//utilidadempleadoutilidadempleado.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUtilidadEmpleado(UtilidadEmpleado utilidadempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosUtilidadEmpleados(List<UtilidadEmpleado> utilidadempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UtilidadEmpleado utilidadempleado: utilidadempleados) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadEmpleado(UtilidadEmpleado utilidadempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && utilidadempleado.getConCambioAuxiliar()) {
			utilidadempleado.setIsDeleted(utilidadempleado.getIsDeletedAuxiliar());	
			utilidadempleado.setIsNew(utilidadempleado.getIsNewAuxiliar());	
			utilidadempleado.setIsChanged(utilidadempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			utilidadempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			utilidadempleado.setIsDeletedAuxiliar(false);	
			utilidadempleado.setIsNewAuxiliar(false);	
			utilidadempleado.setIsChangedAuxiliar(false);
			
			utilidadempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadEmpleados(List<UtilidadEmpleado> utilidadempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UtilidadEmpleado utilidadempleado : utilidadempleados) {
			if(conAsignarBase && utilidadempleado.getConCambioAuxiliar()) {
				utilidadempleado.setIsDeleted(utilidadempleado.getIsDeletedAuxiliar());	
				utilidadempleado.setIsNew(utilidadempleado.getIsNewAuxiliar());	
				utilidadempleado.setIsChanged(utilidadempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				utilidadempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				utilidadempleado.setIsDeletedAuxiliar(false);	
				utilidadempleado.setIsNewAuxiliar(false);	
				utilidadempleado.setIsChangedAuxiliar(false);
				
				utilidadempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUtilidadEmpleado(UtilidadEmpleado utilidadempleado,Boolean conEnteros) throws Exception  {
		utilidadempleado.setvalor(0.0);
		utilidadempleado.setnumero_factor10(0.0);
		utilidadempleado.setvalor_factor10(0.0);
		utilidadempleado.setutilidad_factor10(0.0);
		utilidadempleado.setnumero_factor5(0.0);
		utilidadempleado.setvalor_factor5(0.0);
		utilidadempleado.setutilidad_factor5(0.0);
		utilidadempleado.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			utilidadempleado.setnumero_dias(0);
			utilidadempleado.setnumero_cargas(0);
		}
	}		
	
	public static void InicializarValoresUtilidadEmpleados(List<UtilidadEmpleado> utilidadempleados,Boolean conEnteros) throws Exception  {
		
		for(UtilidadEmpleado utilidadempleado: utilidadempleados) {
			utilidadempleado.setvalor(0.0);
			utilidadempleado.setnumero_factor10(0.0);
			utilidadempleado.setvalor_factor10(0.0);
			utilidadempleado.setutilidad_factor10(0.0);
			utilidadempleado.setnumero_factor5(0.0);
			utilidadempleado.setvalor_factor5(0.0);
			utilidadempleado.setutilidad_factor5(0.0);
			utilidadempleado.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				utilidadempleado.setnumero_dias(0);
				utilidadempleado.setnumero_cargas(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaUtilidadEmpleado(List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleado utilidadempleadoAux) throws Exception  {
		UtilidadEmpleadoConstantesFunciones.InicializarValoresUtilidadEmpleado(utilidadempleadoAux,true);
		
		for(UtilidadEmpleado utilidadempleado: utilidadempleados) {
			if(utilidadempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			utilidadempleadoAux.setvalor(utilidadempleadoAux.getvalor()+utilidadempleado.getvalor());			
			utilidadempleadoAux.setnumero_dias(utilidadempleadoAux.getnumero_dias()+utilidadempleado.getnumero_dias());			
			utilidadempleadoAux.setnumero_cargas(utilidadempleadoAux.getnumero_cargas()+utilidadempleado.getnumero_cargas());			
			utilidadempleadoAux.setnumero_factor10(utilidadempleadoAux.getnumero_factor10()+utilidadempleado.getnumero_factor10());			
			utilidadempleadoAux.setvalor_factor10(utilidadempleadoAux.getvalor_factor10()+utilidadempleado.getvalor_factor10());			
			utilidadempleadoAux.setutilidad_factor10(utilidadempleadoAux.getutilidad_factor10()+utilidadempleado.getutilidad_factor10());			
			utilidadempleadoAux.setnumero_factor5(utilidadempleadoAux.getnumero_factor5()+utilidadempleado.getnumero_factor5());			
			utilidadempleadoAux.setvalor_factor5(utilidadempleadoAux.getvalor_factor5()+utilidadempleado.getvalor_factor5());			
			utilidadempleadoAux.setutilidad_factor5(utilidadempleadoAux.getutilidad_factor5()+utilidadempleado.getutilidad_factor5());			
			utilidadempleadoAux.settotal(utilidadempleadoAux.gettotal()+utilidadempleado.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UtilidadEmpleadoConstantesFunciones.getArrayColumnasGlobalesUtilidadEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadEmpleadoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadEmpleadoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUtilidadEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleado utilidadempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UtilidadEmpleado utilidadempleadoAux: utilidadempleados) {
			if(utilidadempleadoAux!=null && utilidadempleado!=null) {
				if((utilidadempleadoAux.getId()==null && utilidadempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(utilidadempleadoAux.getId()!=null && utilidadempleado.getId()!=null){
					if(utilidadempleadoAux.getId().equals(utilidadempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUtilidadEmpleado(List<UtilidadEmpleado> utilidadempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double numero_factor10Total=0.0;
		Double valor_factor10Total=0.0;
		Double utilidad_factor10Total=0.0;
		Double numero_factor5Total=0.0;
		Double valor_factor5Total=0.0;
		Double utilidad_factor5Total=0.0;
		Double totalTotal=0.0;
	
		for(UtilidadEmpleado utilidadempleado: utilidadempleados) {			
			if(utilidadempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=utilidadempleado.getvalor();
			numero_factor10Total+=utilidadempleado.getnumero_factor10();
			valor_factor10Total+=utilidadempleado.getvalor_factor10();
			utilidad_factor10Total+=utilidadempleado.getutilidad_factor10();
			numero_factor5Total+=utilidadempleado.getnumero_factor5();
			valor_factor5Total+=utilidadempleado.getvalor_factor5();
			utilidad_factor5Total+=utilidadempleado.getutilidad_factor5();
			totalTotal+=utilidadempleado.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10);
		datoGeneral.setdValorDouble(numero_factor10Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.VALORFACTOR10);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10);
		datoGeneral.setdValorDouble(valor_factor10Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10);
		datoGeneral.setdValorDouble(utilidad_factor10Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5);
		datoGeneral.setdValorDouble(numero_factor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.VALORFACTOR5);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5);
		datoGeneral.setdValorDouble(valor_factor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5);
		datoGeneral.setdValorDouble(utilidad_factor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadEmpleadoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUtilidadEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_ID, UtilidadEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_VERSIONROW, UtilidadEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPRESA, UtilidadEmpleadoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPLEADO, UtilidadEmpleadoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_IDANIO, UtilidadEmpleadoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_FECHAINGRESO, UtilidadEmpleadoConstantesFunciones.FECHAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_FECHASALIDA, UtilidadEmpleadoConstantesFunciones.FECHASALIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_VALOR, UtilidadEmpleadoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_NUMERODIAS, UtilidadEmpleadoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROCARGAS, UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10, UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10, UtilidadEmpleadoConstantesFunciones.VALORFACTOR10,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10, UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5, UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5, UtilidadEmpleadoConstantesFunciones.VALORFACTOR5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5, UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL, UtilidadEmpleadoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUtilidadEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.FECHAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.FECHASALIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.VALORFACTOR10;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.VALORFACTOR5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadEmpleadoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadEmpleado() throws Exception  {
		return UtilidadEmpleadoConstantesFunciones.getTiposSeleccionarUtilidadEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadEmpleado(Boolean conFk) throws Exception  {
		return UtilidadEmpleadoConstantesFunciones.getTiposSeleccionarUtilidadEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_FECHAINGRESO);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_FECHAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_FECHASALIDA);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_FECHASALIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROCARGAS);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROCARGAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUtilidadEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadEmpleado(UtilidadEmpleado utilidadempleadoAux) throws Exception {
		
			utilidadempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadempleadoAux.getEmpresa()));
			utilidadempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(utilidadempleadoAux.getEmpleado()));
			utilidadempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(utilidadempleadoAux.getAnio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadEmpleado(List<UtilidadEmpleado> utilidadempleadosTemp) throws Exception {
		for(UtilidadEmpleado utilidadempleadoAux:utilidadempleadosTemp) {
			
			utilidadempleadoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadempleadoAux.getEmpresa()));
			utilidadempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(utilidadempleadoAux.getEmpleado()));
			utilidadempleadoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(utilidadempleadoAux.getAnio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Anio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUtilidadEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadEmpleadoConstantesFunciones.getClassesRelationshipsOfUtilidadEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfUtilidadEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UtilidadEmpleado utilidadempleado,List<UtilidadEmpleado> utilidadempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UtilidadEmpleado utilidadempleadoEncontrado=null;
			
			for(UtilidadEmpleado utilidadempleadoLocal:utilidadempleados) {
				if(utilidadempleadoLocal.getId().equals(utilidadempleado.getId())) {
					utilidadempleadoEncontrado=utilidadempleadoLocal;
					
					utilidadempleadoLocal.setIsChanged(utilidadempleado.getIsChanged());
					utilidadempleadoLocal.setIsNew(utilidadempleado.getIsNew());
					utilidadempleadoLocal.setIsDeleted(utilidadempleado.getIsDeleted());
					
					utilidadempleadoLocal.setGeneralEntityOriginal(utilidadempleado.getGeneralEntityOriginal());
					
					utilidadempleadoLocal.setId(utilidadempleado.getId());	
					utilidadempleadoLocal.setVersionRow(utilidadempleado.getVersionRow());	
					utilidadempleadoLocal.setid_empresa(utilidadempleado.getid_empresa());	
					utilidadempleadoLocal.setid_empleado(utilidadempleado.getid_empleado());	
					utilidadempleadoLocal.setid_anio(utilidadempleado.getid_anio());	
					utilidadempleadoLocal.setfecha_ingreso(utilidadempleado.getfecha_ingreso());	
					utilidadempleadoLocal.setfecha_salida(utilidadempleado.getfecha_salida());	
					utilidadempleadoLocal.setvalor(utilidadempleado.getvalor());	
					utilidadempleadoLocal.setnumero_dias(utilidadempleado.getnumero_dias());	
					utilidadempleadoLocal.setnumero_cargas(utilidadempleado.getnumero_cargas());	
					utilidadempleadoLocal.setnumero_factor10(utilidadempleado.getnumero_factor10());	
					utilidadempleadoLocal.setvalor_factor10(utilidadempleado.getvalor_factor10());	
					utilidadempleadoLocal.setutilidad_factor10(utilidadempleado.getutilidad_factor10());	
					utilidadempleadoLocal.setnumero_factor5(utilidadempleado.getnumero_factor5());	
					utilidadempleadoLocal.setvalor_factor5(utilidadempleado.getvalor_factor5());	
					utilidadempleadoLocal.setutilidad_factor5(utilidadempleado.getutilidad_factor5());	
					utilidadempleadoLocal.settotal(utilidadempleado.gettotal());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!utilidadempleado.getIsDeleted()) {
				if(!existe) {
					utilidadempleados.add(utilidadempleado);
				}
			} else {
				if(utilidadempleadoEncontrado!=null && permiteQuitar)  {
					utilidadempleados.remove(utilidadempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UtilidadEmpleado utilidadempleado,List<UtilidadEmpleado> utilidadempleados) throws Exception {
		try	{			
			for(UtilidadEmpleado utilidadempleadoLocal:utilidadempleados) {
				if(utilidadempleadoLocal.getId().equals(utilidadempleado.getId())) {
					utilidadempleadoLocal.setIsSelected(utilidadempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUtilidadEmpleado(List<UtilidadEmpleado> utilidadempleadosAux) throws Exception {
		//this.utilidadempleadosAux=utilidadempleadosAux;
		
		for(UtilidadEmpleado utilidadempleadoAux:utilidadempleadosAux) {
			if(utilidadempleadoAux.getIsChanged()) {
				utilidadempleadoAux.setIsChanged(false);
			}		
			
			if(utilidadempleadoAux.getIsNew()) {
				utilidadempleadoAux.setIsNew(false);
			}	
			
			if(utilidadempleadoAux.getIsDeleted()) {
				utilidadempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUtilidadEmpleado(UtilidadEmpleado utilidadempleadoAux) throws Exception {
		//this.utilidadempleadoAux=utilidadempleadoAux;
		
			if(utilidadempleadoAux.getIsChanged()) {
				utilidadempleadoAux.setIsChanged(false);
			}		
			
			if(utilidadempleadoAux.getIsNew()) {
				utilidadempleadoAux.setIsNew(false);
			}	
			
			if(utilidadempleadoAux.getIsDeleted()) {
				utilidadempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UtilidadEmpleado utilidadempleadoAsignar,UtilidadEmpleado utilidadempleado) throws Exception {
		utilidadempleadoAsignar.setId(utilidadempleado.getId());	
		utilidadempleadoAsignar.setVersionRow(utilidadempleado.getVersionRow());	
		utilidadempleadoAsignar.setid_empresa(utilidadempleado.getid_empresa());
		utilidadempleadoAsignar.setempresa_descripcion(utilidadempleado.getempresa_descripcion());	
		utilidadempleadoAsignar.setid_empleado(utilidadempleado.getid_empleado());
		utilidadempleadoAsignar.setempleado_descripcion(utilidadempleado.getempleado_descripcion());	
		utilidadempleadoAsignar.setid_anio(utilidadempleado.getid_anio());
		utilidadempleadoAsignar.setanio_descripcion(utilidadempleado.getanio_descripcion());	
		utilidadempleadoAsignar.setfecha_ingreso(utilidadempleado.getfecha_ingreso());	
		utilidadempleadoAsignar.setfecha_salida(utilidadempleado.getfecha_salida());	
		utilidadempleadoAsignar.setvalor(utilidadempleado.getvalor());	
		utilidadempleadoAsignar.setnumero_dias(utilidadempleado.getnumero_dias());	
		utilidadempleadoAsignar.setnumero_cargas(utilidadempleado.getnumero_cargas());	
		utilidadempleadoAsignar.setnumero_factor10(utilidadempleado.getnumero_factor10());	
		utilidadempleadoAsignar.setvalor_factor10(utilidadempleado.getvalor_factor10());	
		utilidadempleadoAsignar.setutilidad_factor10(utilidadempleado.getutilidad_factor10());	
		utilidadempleadoAsignar.setnumero_factor5(utilidadempleado.getnumero_factor5());	
		utilidadempleadoAsignar.setvalor_factor5(utilidadempleado.getvalor_factor5());	
		utilidadempleadoAsignar.setutilidad_factor5(utilidadempleado.getutilidad_factor5());	
		utilidadempleadoAsignar.settotal(utilidadempleado.gettotal());	
	}
	
	public static void inicializarUtilidadEmpleado(UtilidadEmpleado utilidadempleado) throws Exception {
		try {
				utilidadempleado.setId(0L);	
					
				utilidadempleado.setid_empresa(-1L);	
				utilidadempleado.setid_empleado(-1L);	
				utilidadempleado.setid_anio(null);	
				utilidadempleado.setfecha_ingreso(new Date());	
				utilidadempleado.setfecha_salida(new Date());	
				utilidadempleado.setvalor(0.0);	
				utilidadempleado.setnumero_dias(0);	
				utilidadempleado.setnumero_cargas(0);	
				utilidadempleado.setnumero_factor10(0.0);	
				utilidadempleado.setvalor_factor10(0.0);	
				utilidadempleado.setutilidad_factor10(0.0);	
				utilidadempleado.setnumero_factor5(0.0);	
				utilidadempleado.setvalor_factor5(0.0);	
				utilidadempleado.setutilidad_factor5(0.0);	
				utilidadempleado.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUtilidadEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_FECHAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_FECHASALIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROCARGAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR10);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR10);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR10);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_NUMEROFACTOR5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_VALORFACTOR5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_UTILIDADFACTOR5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadEmpleadoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUtilidadEmpleado(String sTipo,Row row,Workbook workbook,UtilidadEmpleado utilidadempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getfecha_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getfecha_salida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getnumero_cargas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getnumero_factor10());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getvalor_factor10());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getutilidad_factor10());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getnumero_factor5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getvalor_factor5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.getutilidad_factor5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadempleado.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUtilidadEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUtilidadEmpleado() {
		return this.sFinalQueryUtilidadEmpleado;
	}
	
	public void setsFinalQueryUtilidadEmpleado(String sFinalQueryUtilidadEmpleado) {
		this.sFinalQueryUtilidadEmpleado= sFinalQueryUtilidadEmpleado;
	}
	
	public Border resaltarSeleccionarUtilidadEmpleado=null;
	
	public Border setResaltarSeleccionarUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUtilidadEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUtilidadEmpleado() {
		return this.resaltarSeleccionarUtilidadEmpleado;
	}
	
	public void setResaltarSeleccionarUtilidadEmpleado(Border borderResaltarSeleccionarUtilidadEmpleado) {
		this.resaltarSeleccionarUtilidadEmpleado= borderResaltarSeleccionarUtilidadEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUtilidadEmpleado=null;
	public Boolean mostraridUtilidadEmpleado=true;
	public Boolean activaridUtilidadEmpleado=true;

	public Border resaltarid_empresaUtilidadEmpleado=null;
	public Boolean mostrarid_empresaUtilidadEmpleado=true;
	public Boolean activarid_empresaUtilidadEmpleado=true;
	public Boolean cargarid_empresaUtilidadEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUtilidadEmpleado=false;//ConEventDepend=true

	public Border resaltarid_empleadoUtilidadEmpleado=null;
	public Boolean mostrarid_empleadoUtilidadEmpleado=true;
	public Boolean activarid_empleadoUtilidadEmpleado=true;
	public Boolean cargarid_empleadoUtilidadEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoUtilidadEmpleado=false;//ConEventDepend=true

	public Border resaltarid_anioUtilidadEmpleado=null;
	public Boolean mostrarid_anioUtilidadEmpleado=true;
	public Boolean activarid_anioUtilidadEmpleado=true;
	public Boolean cargarid_anioUtilidadEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioUtilidadEmpleado=false;//ConEventDepend=true

	public Border resaltarfecha_ingresoUtilidadEmpleado=null;
	public Boolean mostrarfecha_ingresoUtilidadEmpleado=true;
	public Boolean activarfecha_ingresoUtilidadEmpleado=false;

	public Border resaltarfecha_salidaUtilidadEmpleado=null;
	public Boolean mostrarfecha_salidaUtilidadEmpleado=true;
	public Boolean activarfecha_salidaUtilidadEmpleado=false;

	public Border resaltarvalorUtilidadEmpleado=null;
	public Boolean mostrarvalorUtilidadEmpleado=true;
	public Boolean activarvalorUtilidadEmpleado=true;

	public Border resaltarnumero_diasUtilidadEmpleado=null;
	public Boolean mostrarnumero_diasUtilidadEmpleado=true;
	public Boolean activarnumero_diasUtilidadEmpleado=true;

	public Border resaltarnumero_cargasUtilidadEmpleado=null;
	public Boolean mostrarnumero_cargasUtilidadEmpleado=true;
	public Boolean activarnumero_cargasUtilidadEmpleado=true;

	public Border resaltarnumero_factor10UtilidadEmpleado=null;
	public Boolean mostrarnumero_factor10UtilidadEmpleado=true;
	public Boolean activarnumero_factor10UtilidadEmpleado=true;

	public Border resaltarvalor_factor10UtilidadEmpleado=null;
	public Boolean mostrarvalor_factor10UtilidadEmpleado=true;
	public Boolean activarvalor_factor10UtilidadEmpleado=true;

	public Border resaltarutilidad_factor10UtilidadEmpleado=null;
	public Boolean mostrarutilidad_factor10UtilidadEmpleado=true;
	public Boolean activarutilidad_factor10UtilidadEmpleado=true;

	public Border resaltarnumero_factor5UtilidadEmpleado=null;
	public Boolean mostrarnumero_factor5UtilidadEmpleado=true;
	public Boolean activarnumero_factor5UtilidadEmpleado=true;

	public Border resaltarvalor_factor5UtilidadEmpleado=null;
	public Boolean mostrarvalor_factor5UtilidadEmpleado=true;
	public Boolean activarvalor_factor5UtilidadEmpleado=true;

	public Border resaltarutilidad_factor5UtilidadEmpleado=null;
	public Boolean mostrarutilidad_factor5UtilidadEmpleado=true;
	public Boolean activarutilidad_factor5UtilidadEmpleado=true;

	public Border resaltartotalUtilidadEmpleado=null;
	public Boolean mostrartotalUtilidadEmpleado=true;
	public Boolean activartotalUtilidadEmpleado=true;

	
	

	public Border setResaltaridUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltaridUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUtilidadEmpleado() {
		return this.resaltaridUtilidadEmpleado;
	}

	public void setResaltaridUtilidadEmpleado(Border borderResaltar) {
		this.resaltaridUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostraridUtilidadEmpleado() {
		return this.mostraridUtilidadEmpleado;
	}

	public void setMostraridUtilidadEmpleado(Boolean mostraridUtilidadEmpleado) {
		this.mostraridUtilidadEmpleado= mostraridUtilidadEmpleado;
	}

	public Boolean getActivaridUtilidadEmpleado() {
		return this.activaridUtilidadEmpleado;
	}

	public void setActivaridUtilidadEmpleado(Boolean activaridUtilidadEmpleado) {
		this.activaridUtilidadEmpleado= activaridUtilidadEmpleado;
	}

	public Border setResaltarid_empresaUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empresaUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUtilidadEmpleado() {
		return this.resaltarid_empresaUtilidadEmpleado;
	}

	public void setResaltarid_empresaUtilidadEmpleado(Border borderResaltar) {
		this.resaltarid_empresaUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empresaUtilidadEmpleado() {
		return this.mostrarid_empresaUtilidadEmpleado;
	}

	public void setMostrarid_empresaUtilidadEmpleado(Boolean mostrarid_empresaUtilidadEmpleado) {
		this.mostrarid_empresaUtilidadEmpleado= mostrarid_empresaUtilidadEmpleado;
	}

	public Boolean getActivarid_empresaUtilidadEmpleado() {
		return this.activarid_empresaUtilidadEmpleado;
	}

	public void setActivarid_empresaUtilidadEmpleado(Boolean activarid_empresaUtilidadEmpleado) {
		this.activarid_empresaUtilidadEmpleado= activarid_empresaUtilidadEmpleado;
	}

	public Boolean getCargarid_empresaUtilidadEmpleado() {
		return this.cargarid_empresaUtilidadEmpleado;
	}

	public void setCargarid_empresaUtilidadEmpleado(Boolean cargarid_empresaUtilidadEmpleado) {
		this.cargarid_empresaUtilidadEmpleado= cargarid_empresaUtilidadEmpleado;
	}

	public Border setResaltarid_empleadoUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoUtilidadEmpleado() {
		return this.resaltarid_empleadoUtilidadEmpleado;
	}

	public void setResaltarid_empleadoUtilidadEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoUtilidadEmpleado() {
		return this.mostrarid_empleadoUtilidadEmpleado;
	}

	public void setMostrarid_empleadoUtilidadEmpleado(Boolean mostrarid_empleadoUtilidadEmpleado) {
		this.mostrarid_empleadoUtilidadEmpleado= mostrarid_empleadoUtilidadEmpleado;
	}

	public Boolean getActivarid_empleadoUtilidadEmpleado() {
		return this.activarid_empleadoUtilidadEmpleado;
	}

	public void setActivarid_empleadoUtilidadEmpleado(Boolean activarid_empleadoUtilidadEmpleado) {
		this.activarid_empleadoUtilidadEmpleado= activarid_empleadoUtilidadEmpleado;
	}

	public Boolean getCargarid_empleadoUtilidadEmpleado() {
		return this.cargarid_empleadoUtilidadEmpleado;
	}

	public void setCargarid_empleadoUtilidadEmpleado(Boolean cargarid_empleadoUtilidadEmpleado) {
		this.cargarid_empleadoUtilidadEmpleado= cargarid_empleadoUtilidadEmpleado;
	}

	public Border setResaltarid_anioUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_anioUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioUtilidadEmpleado() {
		return this.resaltarid_anioUtilidadEmpleado;
	}

	public void setResaltarid_anioUtilidadEmpleado(Border borderResaltar) {
		this.resaltarid_anioUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_anioUtilidadEmpleado() {
		return this.mostrarid_anioUtilidadEmpleado;
	}

	public void setMostrarid_anioUtilidadEmpleado(Boolean mostrarid_anioUtilidadEmpleado) {
		this.mostrarid_anioUtilidadEmpleado= mostrarid_anioUtilidadEmpleado;
	}

	public Boolean getActivarid_anioUtilidadEmpleado() {
		return this.activarid_anioUtilidadEmpleado;
	}

	public void setActivarid_anioUtilidadEmpleado(Boolean activarid_anioUtilidadEmpleado) {
		this.activarid_anioUtilidadEmpleado= activarid_anioUtilidadEmpleado;
	}

	public Boolean getCargarid_anioUtilidadEmpleado() {
		return this.cargarid_anioUtilidadEmpleado;
	}

	public void setCargarid_anioUtilidadEmpleado(Boolean cargarid_anioUtilidadEmpleado) {
		this.cargarid_anioUtilidadEmpleado= cargarid_anioUtilidadEmpleado;
	}

	public Border setResaltarfecha_ingresoUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_ingresoUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ingresoUtilidadEmpleado() {
		return this.resaltarfecha_ingresoUtilidadEmpleado;
	}

	public void setResaltarfecha_ingresoUtilidadEmpleado(Border borderResaltar) {
		this.resaltarfecha_ingresoUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_ingresoUtilidadEmpleado() {
		return this.mostrarfecha_ingresoUtilidadEmpleado;
	}

	public void setMostrarfecha_ingresoUtilidadEmpleado(Boolean mostrarfecha_ingresoUtilidadEmpleado) {
		this.mostrarfecha_ingresoUtilidadEmpleado= mostrarfecha_ingresoUtilidadEmpleado;
	}

	public Boolean getActivarfecha_ingresoUtilidadEmpleado() {
		return this.activarfecha_ingresoUtilidadEmpleado;
	}

	public void setActivarfecha_ingresoUtilidadEmpleado(Boolean activarfecha_ingresoUtilidadEmpleado) {
		this.activarfecha_ingresoUtilidadEmpleado= activarfecha_ingresoUtilidadEmpleado;
	}

	public Border setResaltarfecha_salidaUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_salidaUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_salidaUtilidadEmpleado() {
		return this.resaltarfecha_salidaUtilidadEmpleado;
	}

	public void setResaltarfecha_salidaUtilidadEmpleado(Border borderResaltar) {
		this.resaltarfecha_salidaUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_salidaUtilidadEmpleado() {
		return this.mostrarfecha_salidaUtilidadEmpleado;
	}

	public void setMostrarfecha_salidaUtilidadEmpleado(Boolean mostrarfecha_salidaUtilidadEmpleado) {
		this.mostrarfecha_salidaUtilidadEmpleado= mostrarfecha_salidaUtilidadEmpleado;
	}

	public Boolean getActivarfecha_salidaUtilidadEmpleado() {
		return this.activarfecha_salidaUtilidadEmpleado;
	}

	public void setActivarfecha_salidaUtilidadEmpleado(Boolean activarfecha_salidaUtilidadEmpleado) {
		this.activarfecha_salidaUtilidadEmpleado= activarfecha_salidaUtilidadEmpleado;
	}

	public Border setResaltarvalorUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalorUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorUtilidadEmpleado() {
		return this.resaltarvalorUtilidadEmpleado;
	}

	public void setResaltarvalorUtilidadEmpleado(Border borderResaltar) {
		this.resaltarvalorUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalorUtilidadEmpleado() {
		return this.mostrarvalorUtilidadEmpleado;
	}

	public void setMostrarvalorUtilidadEmpleado(Boolean mostrarvalorUtilidadEmpleado) {
		this.mostrarvalorUtilidadEmpleado= mostrarvalorUtilidadEmpleado;
	}

	public Boolean getActivarvalorUtilidadEmpleado() {
		return this.activarvalorUtilidadEmpleado;
	}

	public void setActivarvalorUtilidadEmpleado(Boolean activarvalorUtilidadEmpleado) {
		this.activarvalorUtilidadEmpleado= activarvalorUtilidadEmpleado;
	}

	public Border setResaltarnumero_diasUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_diasUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasUtilidadEmpleado() {
		return this.resaltarnumero_diasUtilidadEmpleado;
	}

	public void setResaltarnumero_diasUtilidadEmpleado(Border borderResaltar) {
		this.resaltarnumero_diasUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_diasUtilidadEmpleado() {
		return this.mostrarnumero_diasUtilidadEmpleado;
	}

	public void setMostrarnumero_diasUtilidadEmpleado(Boolean mostrarnumero_diasUtilidadEmpleado) {
		this.mostrarnumero_diasUtilidadEmpleado= mostrarnumero_diasUtilidadEmpleado;
	}

	public Boolean getActivarnumero_diasUtilidadEmpleado() {
		return this.activarnumero_diasUtilidadEmpleado;
	}

	public void setActivarnumero_diasUtilidadEmpleado(Boolean activarnumero_diasUtilidadEmpleado) {
		this.activarnumero_diasUtilidadEmpleado= activarnumero_diasUtilidadEmpleado;
	}

	public Border setResaltarnumero_cargasUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_cargasUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cargasUtilidadEmpleado() {
		return this.resaltarnumero_cargasUtilidadEmpleado;
	}

	public void setResaltarnumero_cargasUtilidadEmpleado(Border borderResaltar) {
		this.resaltarnumero_cargasUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_cargasUtilidadEmpleado() {
		return this.mostrarnumero_cargasUtilidadEmpleado;
	}

	public void setMostrarnumero_cargasUtilidadEmpleado(Boolean mostrarnumero_cargasUtilidadEmpleado) {
		this.mostrarnumero_cargasUtilidadEmpleado= mostrarnumero_cargasUtilidadEmpleado;
	}

	public Boolean getActivarnumero_cargasUtilidadEmpleado() {
		return this.activarnumero_cargasUtilidadEmpleado;
	}

	public void setActivarnumero_cargasUtilidadEmpleado(Boolean activarnumero_cargasUtilidadEmpleado) {
		this.activarnumero_cargasUtilidadEmpleado= activarnumero_cargasUtilidadEmpleado;
	}

	public Border setResaltarnumero_factor10UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_factor10UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_factor10UtilidadEmpleado() {
		return this.resaltarnumero_factor10UtilidadEmpleado;
	}

	public void setResaltarnumero_factor10UtilidadEmpleado(Border borderResaltar) {
		this.resaltarnumero_factor10UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_factor10UtilidadEmpleado() {
		return this.mostrarnumero_factor10UtilidadEmpleado;
	}

	public void setMostrarnumero_factor10UtilidadEmpleado(Boolean mostrarnumero_factor10UtilidadEmpleado) {
		this.mostrarnumero_factor10UtilidadEmpleado= mostrarnumero_factor10UtilidadEmpleado;
	}

	public Boolean getActivarnumero_factor10UtilidadEmpleado() {
		return this.activarnumero_factor10UtilidadEmpleado;
	}

	public void setActivarnumero_factor10UtilidadEmpleado(Boolean activarnumero_factor10UtilidadEmpleado) {
		this.activarnumero_factor10UtilidadEmpleado= activarnumero_factor10UtilidadEmpleado;
	}

	public Border setResaltarvalor_factor10UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_factor10UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_factor10UtilidadEmpleado() {
		return this.resaltarvalor_factor10UtilidadEmpleado;
	}

	public void setResaltarvalor_factor10UtilidadEmpleado(Border borderResaltar) {
		this.resaltarvalor_factor10UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_factor10UtilidadEmpleado() {
		return this.mostrarvalor_factor10UtilidadEmpleado;
	}

	public void setMostrarvalor_factor10UtilidadEmpleado(Boolean mostrarvalor_factor10UtilidadEmpleado) {
		this.mostrarvalor_factor10UtilidadEmpleado= mostrarvalor_factor10UtilidadEmpleado;
	}

	public Boolean getActivarvalor_factor10UtilidadEmpleado() {
		return this.activarvalor_factor10UtilidadEmpleado;
	}

	public void setActivarvalor_factor10UtilidadEmpleado(Boolean activarvalor_factor10UtilidadEmpleado) {
		this.activarvalor_factor10UtilidadEmpleado= activarvalor_factor10UtilidadEmpleado;
	}

	public Border setResaltarutilidad_factor10UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarutilidad_factor10UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidad_factor10UtilidadEmpleado() {
		return this.resaltarutilidad_factor10UtilidadEmpleado;
	}

	public void setResaltarutilidad_factor10UtilidadEmpleado(Border borderResaltar) {
		this.resaltarutilidad_factor10UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarutilidad_factor10UtilidadEmpleado() {
		return this.mostrarutilidad_factor10UtilidadEmpleado;
	}

	public void setMostrarutilidad_factor10UtilidadEmpleado(Boolean mostrarutilidad_factor10UtilidadEmpleado) {
		this.mostrarutilidad_factor10UtilidadEmpleado= mostrarutilidad_factor10UtilidadEmpleado;
	}

	public Boolean getActivarutilidad_factor10UtilidadEmpleado() {
		return this.activarutilidad_factor10UtilidadEmpleado;
	}

	public void setActivarutilidad_factor10UtilidadEmpleado(Boolean activarutilidad_factor10UtilidadEmpleado) {
		this.activarutilidad_factor10UtilidadEmpleado= activarutilidad_factor10UtilidadEmpleado;
	}

	public Border setResaltarnumero_factor5UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_factor5UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_factor5UtilidadEmpleado() {
		return this.resaltarnumero_factor5UtilidadEmpleado;
	}

	public void setResaltarnumero_factor5UtilidadEmpleado(Border borderResaltar) {
		this.resaltarnumero_factor5UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_factor5UtilidadEmpleado() {
		return this.mostrarnumero_factor5UtilidadEmpleado;
	}

	public void setMostrarnumero_factor5UtilidadEmpleado(Boolean mostrarnumero_factor5UtilidadEmpleado) {
		this.mostrarnumero_factor5UtilidadEmpleado= mostrarnumero_factor5UtilidadEmpleado;
	}

	public Boolean getActivarnumero_factor5UtilidadEmpleado() {
		return this.activarnumero_factor5UtilidadEmpleado;
	}

	public void setActivarnumero_factor5UtilidadEmpleado(Boolean activarnumero_factor5UtilidadEmpleado) {
		this.activarnumero_factor5UtilidadEmpleado= activarnumero_factor5UtilidadEmpleado;
	}

	public Border setResaltarvalor_factor5UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_factor5UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_factor5UtilidadEmpleado() {
		return this.resaltarvalor_factor5UtilidadEmpleado;
	}

	public void setResaltarvalor_factor5UtilidadEmpleado(Border borderResaltar) {
		this.resaltarvalor_factor5UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_factor5UtilidadEmpleado() {
		return this.mostrarvalor_factor5UtilidadEmpleado;
	}

	public void setMostrarvalor_factor5UtilidadEmpleado(Boolean mostrarvalor_factor5UtilidadEmpleado) {
		this.mostrarvalor_factor5UtilidadEmpleado= mostrarvalor_factor5UtilidadEmpleado;
	}

	public Boolean getActivarvalor_factor5UtilidadEmpleado() {
		return this.activarvalor_factor5UtilidadEmpleado;
	}

	public void setActivarvalor_factor5UtilidadEmpleado(Boolean activarvalor_factor5UtilidadEmpleado) {
		this.activarvalor_factor5UtilidadEmpleado= activarvalor_factor5UtilidadEmpleado;
	}

	public Border setResaltarutilidad_factor5UtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltarutilidad_factor5UtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidad_factor5UtilidadEmpleado() {
		return this.resaltarutilidad_factor5UtilidadEmpleado;
	}

	public void setResaltarutilidad_factor5UtilidadEmpleado(Border borderResaltar) {
		this.resaltarutilidad_factor5UtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrarutilidad_factor5UtilidadEmpleado() {
		return this.mostrarutilidad_factor5UtilidadEmpleado;
	}

	public void setMostrarutilidad_factor5UtilidadEmpleado(Boolean mostrarutilidad_factor5UtilidadEmpleado) {
		this.mostrarutilidad_factor5UtilidadEmpleado= mostrarutilidad_factor5UtilidadEmpleado;
	}

	public Boolean getActivarutilidad_factor5UtilidadEmpleado() {
		return this.activarutilidad_factor5UtilidadEmpleado;
	}

	public void setActivarutilidad_factor5UtilidadEmpleado(Boolean activarutilidad_factor5UtilidadEmpleado) {
		this.activarutilidad_factor5UtilidadEmpleado= activarutilidad_factor5UtilidadEmpleado;
	}

	public Border setResaltartotalUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadempleadoBeanSwingJInternalFrame.jTtoolBarUtilidadEmpleado.setBorder(borderResaltar);
		
		this.resaltartotalUtilidadEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalUtilidadEmpleado() {
		return this.resaltartotalUtilidadEmpleado;
	}

	public void setResaltartotalUtilidadEmpleado(Border borderResaltar) {
		this.resaltartotalUtilidadEmpleado= borderResaltar;
	}

	public Boolean getMostrartotalUtilidadEmpleado() {
		return this.mostrartotalUtilidadEmpleado;
	}

	public void setMostrartotalUtilidadEmpleado(Boolean mostrartotalUtilidadEmpleado) {
		this.mostrartotalUtilidadEmpleado= mostrartotalUtilidadEmpleado;
	}

	public Boolean getActivartotalUtilidadEmpleado() {
		return this.activartotalUtilidadEmpleado;
	}

	public void setActivartotalUtilidadEmpleado(Boolean activartotalUtilidadEmpleado) {
		this.activartotalUtilidadEmpleado= activartotalUtilidadEmpleado;
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
		
		
		this.setMostraridUtilidadEmpleado(esInicial);
		this.setMostrarid_empresaUtilidadEmpleado(esInicial);
		this.setMostrarid_empleadoUtilidadEmpleado(esInicial);
		this.setMostrarid_anioUtilidadEmpleado(esInicial);
		this.setMostrarfecha_ingresoUtilidadEmpleado(esInicial);
		this.setMostrarfecha_salidaUtilidadEmpleado(esInicial);
		this.setMostrarvalorUtilidadEmpleado(esInicial);
		this.setMostrarnumero_diasUtilidadEmpleado(esInicial);
		this.setMostrarnumero_cargasUtilidadEmpleado(esInicial);
		this.setMostrarnumero_factor10UtilidadEmpleado(esInicial);
		this.setMostrarvalor_factor10UtilidadEmpleado(esInicial);
		this.setMostrarutilidad_factor10UtilidadEmpleado(esInicial);
		this.setMostrarnumero_factor5UtilidadEmpleado(esInicial);
		this.setMostrarvalor_factor5UtilidadEmpleado(esInicial);
		this.setMostrarutilidad_factor5UtilidadEmpleado(esInicial);
		this.setMostrartotalUtilidadEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.ID)) {
				this.setMostraridUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHAINGRESO)) {
				this.setMostrarfecha_ingresoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHASALIDA)) {
				this.setMostrarfecha_salidaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALOR)) {
				this.setMostrarvalorUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS)) {
				this.setMostrarnumero_cargasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10)) {
				this.setMostrarnumero_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR10)) {
				this.setMostrarvalor_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10)) {
				this.setMostrarutilidad_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5)) {
				this.setMostrarnumero_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR5)) {
				this.setMostrarvalor_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5)) {
				this.setMostrarutilidad_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.TOTAL)) {
				this.setMostrartotalUtilidadEmpleado(esAsigna);
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
		
		
		this.setActivaridUtilidadEmpleado(esInicial);
		this.setActivarid_empresaUtilidadEmpleado(esInicial);
		this.setActivarid_empleadoUtilidadEmpleado(esInicial);
		this.setActivarid_anioUtilidadEmpleado(esInicial);
		this.setActivarfecha_ingresoUtilidadEmpleado(esInicial);
		this.setActivarfecha_salidaUtilidadEmpleado(esInicial);
		this.setActivarvalorUtilidadEmpleado(esInicial);
		this.setActivarnumero_diasUtilidadEmpleado(esInicial);
		this.setActivarnumero_cargasUtilidadEmpleado(esInicial);
		this.setActivarnumero_factor10UtilidadEmpleado(esInicial);
		this.setActivarvalor_factor10UtilidadEmpleado(esInicial);
		this.setActivarutilidad_factor10UtilidadEmpleado(esInicial);
		this.setActivarnumero_factor5UtilidadEmpleado(esInicial);
		this.setActivarvalor_factor5UtilidadEmpleado(esInicial);
		this.setActivarutilidad_factor5UtilidadEmpleado(esInicial);
		this.setActivartotalUtilidadEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.ID)) {
				this.setActivaridUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHAINGRESO)) {
				this.setActivarfecha_ingresoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHASALIDA)) {
				this.setActivarfecha_salidaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALOR)) {
				this.setActivarvalorUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS)) {
				this.setActivarnumero_cargasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10)) {
				this.setActivarnumero_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR10)) {
				this.setActivarvalor_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10)) {
				this.setActivarutilidad_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5)) {
				this.setActivarnumero_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR5)) {
				this.setActivarvalor_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5)) {
				this.setActivarutilidad_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.TOTAL)) {
				this.setActivartotalUtilidadEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUtilidadEmpleado(esInicial);
		this.setResaltarid_empresaUtilidadEmpleado(esInicial);
		this.setResaltarid_empleadoUtilidadEmpleado(esInicial);
		this.setResaltarid_anioUtilidadEmpleado(esInicial);
		this.setResaltarfecha_ingresoUtilidadEmpleado(esInicial);
		this.setResaltarfecha_salidaUtilidadEmpleado(esInicial);
		this.setResaltarvalorUtilidadEmpleado(esInicial);
		this.setResaltarnumero_diasUtilidadEmpleado(esInicial);
		this.setResaltarnumero_cargasUtilidadEmpleado(esInicial);
		this.setResaltarnumero_factor10UtilidadEmpleado(esInicial);
		this.setResaltarvalor_factor10UtilidadEmpleado(esInicial);
		this.setResaltarutilidad_factor10UtilidadEmpleado(esInicial);
		this.setResaltarnumero_factor5UtilidadEmpleado(esInicial);
		this.setResaltarvalor_factor5UtilidadEmpleado(esInicial);
		this.setResaltarutilidad_factor5UtilidadEmpleado(esInicial);
		this.setResaltartotalUtilidadEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.ID)) {
				this.setResaltaridUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHAINGRESO)) {
				this.setResaltarfecha_ingresoUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.FECHASALIDA)) {
				this.setResaltarfecha_salidaUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALOR)) {
				this.setResaltarvalorUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS)) {
				this.setResaltarnumero_cargasUtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10)) {
				this.setResaltarnumero_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR10)) {
				this.setResaltarvalor_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10)) {
				this.setResaltarutilidad_factor10UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5)) {
				this.setResaltarnumero_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.VALORFACTOR5)) {
				this.setResaltarvalor_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5)) {
				this.setResaltarutilidad_factor5UtilidadEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadEmpleadoConstantesFunciones.TOTAL)) {
				this.setResaltartotalUtilidadEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioUtilidadEmpleado=true;

	public Boolean getMostrarFK_IdAnioUtilidadEmpleado() {
		return this.mostrarFK_IdAnioUtilidadEmpleado;
	}

	public void setMostrarFK_IdAnioUtilidadEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioUtilidadEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoUtilidadEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoUtilidadEmpleado() {
		return this.mostrarFK_IdEmpleadoUtilidadEmpleado;
	}

	public void setMostrarFK_IdEmpleadoUtilidadEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoUtilidadEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUtilidadEmpleado=true;

	public Boolean getMostrarFK_IdEmpresaUtilidadEmpleado() {
		return this.mostrarFK_IdEmpresaUtilidadEmpleado;
	}

	public void setMostrarFK_IdEmpresaUtilidadEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUtilidadEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioUtilidadEmpleado=true;

	public Boolean getActivarFK_IdAnioUtilidadEmpleado() {
		return this.activarFK_IdAnioUtilidadEmpleado;
	}

	public void setActivarFK_IdAnioUtilidadEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdAnioUtilidadEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoUtilidadEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoUtilidadEmpleado() {
		return this.activarFK_IdEmpleadoUtilidadEmpleado;
	}

	public void setActivarFK_IdEmpleadoUtilidadEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoUtilidadEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUtilidadEmpleado=true;

	public Boolean getActivarFK_IdEmpresaUtilidadEmpleado() {
		return this.activarFK_IdEmpresaUtilidadEmpleado;
	}

	public void setActivarFK_IdEmpresaUtilidadEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUtilidadEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioUtilidadEmpleado=null;

	public Border getResaltarFK_IdAnioUtilidadEmpleado() {
		return this.resaltarFK_IdAnioUtilidadEmpleado;
	}

	public void setResaltarFK_IdAnioUtilidadEmpleado(Border borderResaltar) {
		this.resaltarFK_IdAnioUtilidadEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdAnioUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioUtilidadEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoUtilidadEmpleado=null;

	public Border getResaltarFK_IdEmpleadoUtilidadEmpleado() {
		return this.resaltarFK_IdEmpleadoUtilidadEmpleado;
	}

	public void setResaltarFK_IdEmpleadoUtilidadEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoUtilidadEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoUtilidadEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUtilidadEmpleado=null;

	public Border getResaltarFK_IdEmpresaUtilidadEmpleado() {
		return this.resaltarFK_IdEmpresaUtilidadEmpleado;
	}

	public void setResaltarFK_IdEmpresaUtilidadEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUtilidadEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUtilidadEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadEmpleadoBeanSwingJInternalFrame utilidadempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUtilidadEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}