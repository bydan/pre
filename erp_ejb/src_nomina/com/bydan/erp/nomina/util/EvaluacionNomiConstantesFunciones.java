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


import com.bydan.erp.nomina.util.EvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.EvaluacionNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EvaluacionNomiParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EvaluacionNomiConstantesFunciones extends EvaluacionNomiConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionNomi";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionNomi"+EvaluacionNomiConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionNomiHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionNomiHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionNomiConstantesFunciones.SCHEMA+"_"+EvaluacionNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionNomiConstantesFunciones.SCHEMA+"_"+EvaluacionNomiConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionNomiConstantesFunciones.SCHEMA+"_"+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionNomiConstantesFunciones.SCHEMA+"_"+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionNomiHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionNomiConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionNomiConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionNomiConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionNomiConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionNomiConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluacion Nomis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Evaluacion Nomi";
	public static final String SCLASSWEBTITULO_LOWER="Evaluacion Nomi";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionNomi";
	public static final String OBJECTNAME="evaluacionnomi";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="evaluacion_nomi";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionnomi from "+EvaluacionNomiConstantesFunciones.SPERSISTENCENAME+" evaluacionnomi";
	public static String QUERYSELECTNATIVE="select "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".version_row,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empleado,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empleado_evaluador,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".fecha,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".instrucciones,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion2,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion3,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion4 from "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+EvaluacionNomiConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EvaluacionNomiConstantesFuncionesAdditional evaluacionnomiConstantesFuncionesAdditional=null;
	
	public EvaluacionNomiConstantesFuncionesAdditional getEvaluacionNomiConstantesFuncionesAdditional() {
		return this.evaluacionnomiConstantesFuncionesAdditional;
	}
	
	public void setEvaluacionNomiConstantesFuncionesAdditional(EvaluacionNomiConstantesFuncionesAdditional evaluacionnomiConstantesFuncionesAdditional) {
		try {
			this.evaluacionnomiConstantesFuncionesAdditional=evaluacionnomiConstantesFuncionesAdditional;
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
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMPLEADOEVALUADOR= "id_empleado_evaluador";
    public static final String IDFORMATONOMI= "id_formato_nomi";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String FECHA= "fecha";
    public static final String INSTRUCCIONES= "instrucciones";
    public static final String DESCRIPCION= "descripcion";
    public static final String DESCRIPCION2= "descripcion2";
    public static final String DESCRIPCION3= "descripcion3";
    public static final String DESCRIPCION4= "descripcion4";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMPLEADOEVALUADOR= "Empleado Evaluador";
		public static final String LABEL_IDEMPLEADOEVALUADOR_LOWER= "Empleado Evaluador";
    	public static final String LABEL_IDFORMATONOMI= "Formato Nomi";
		public static final String LABEL_IDFORMATONOMI_LOWER= "Formato Nomi";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_INSTRUCCIONES= "Instrucciones";
		public static final String LABEL_INSTRUCCIONES_LOWER= "Instrucciones";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESCRIPCION2= "Descripcion2";
		public static final String LABEL_DESCRIPCION2_LOWER= "Descripcion2";
    	public static final String LABEL_DESCRIPCION3= "Descripcion3";
		public static final String LABEL_DESCRIPCION3_LOWER= "Descripcion3";
    	public static final String LABEL_DESCRIPCION4= "Descripcion4";
		public static final String LABEL_DESCRIPCION4_LOWER= "Descripcion4";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXINSTRUCCIONES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXINSTRUCCIONES=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION3=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION3=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION4=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION4=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEvaluacionNomiLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDPERIODO)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADOEVALUADOR;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.FECHA)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.INSTRUCCIONES)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_INSTRUCCIONES;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION2)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION2;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION3)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION3;}
		if(sNombreColumna.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION4)) {sLabelColumna=EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION4;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionNomiDescripcion(EvaluacionNomi evaluacionnomi) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionnomi !=null/* && evaluacionnomi.getId()!=0*/) {
			if(evaluacionnomi.getId()!=null) {
				sDescripcion=evaluacionnomi.getId().toString();
			}//evaluacionnomievaluacionnomi.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionNomiDescripcionDetallado(EvaluacionNomi evaluacionnomi) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionNomiConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionnomi.getId().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionnomi.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionnomi.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionnomi.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=evaluacionnomi.getid_ejercicio().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=evaluacionnomi.getid_periodo().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=evaluacionnomi.getid_empleado().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR+"=";
		sDescripcion+=evaluacionnomi.getid_empleado_evaluador().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDFORMATONOMI+"=";
		sDescripcion+=evaluacionnomi.getid_formato_nomi().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=evaluacionnomi.getid_estructura().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.FECHA+"=";
		sDescripcion+=evaluacionnomi.getfecha().toString()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.INSTRUCCIONES+"=";
		sDescripcion+=evaluacionnomi.getinstrucciones()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=evaluacionnomi.getdescripcion()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.DESCRIPCION2+"=";
		sDescripcion+=evaluacionnomi.getdescripcion2()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.DESCRIPCION3+"=";
		sDescripcion+=evaluacionnomi.getdescripcion3()+",";
		sDescripcion+=EvaluacionNomiConstantesFunciones.DESCRIPCION4+"=";
		sDescripcion+=evaluacionnomi.getdescripcion4()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionNomiDescripcion(EvaluacionNomi evaluacionnomi,String sValor) throws Exception {			
		if(evaluacionnomi !=null) {
			//evaluacionnomievaluacionnomi.getId().toString();
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEmpleadoEvaluadorDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getFormatoNomiDescripcion(FormatoNomi formatonomi) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formatonomi!=null/*&&formatonomi.getId()>0*/) {
			sDescripcion=FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(formatonomi);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoEvaluador")) {
			sNombreIndice="Tipo=  Por Empleado Evaluador";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdFormatoNomi")) {
			sNombreIndice="Tipo=  Por Formato Nomi";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoEvaluador(Long id_empleado_evaluador) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_evaluador!=null) {sDetalleIndice+=" Codigo Unico De Empleado Evaluador="+id_empleado_evaluador.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoNomi(Long id_formato_nomi) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_nomi!=null) {sDetalleIndice+=" Codigo Unico De Formato Nomi="+id_formato_nomi.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionNomi(EvaluacionNomi evaluacionnomi,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionnomi.setinstrucciones(evaluacionnomi.getinstrucciones().trim());
		evaluacionnomi.setdescripcion(evaluacionnomi.getdescripcion().trim());
		evaluacionnomi.setdescripcion2(evaluacionnomi.getdescripcion2().trim());
		evaluacionnomi.setdescripcion3(evaluacionnomi.getdescripcion3().trim());
		evaluacionnomi.setdescripcion4(evaluacionnomi.getdescripcion4().trim());
	}
	
	public static void quitarEspaciosEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionNomi evaluacionnomi: evaluacionnomis) {
			evaluacionnomi.setinstrucciones(evaluacionnomi.getinstrucciones().trim());
			evaluacionnomi.setdescripcion(evaluacionnomi.getdescripcion().trim());
			evaluacionnomi.setdescripcion2(evaluacionnomi.getdescripcion2().trim());
			evaluacionnomi.setdescripcion3(evaluacionnomi.getdescripcion3().trim());
			evaluacionnomi.setdescripcion4(evaluacionnomi.getdescripcion4().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionNomi(EvaluacionNomi evaluacionnomi,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionnomi.getConCambioAuxiliar()) {
			evaluacionnomi.setIsDeleted(evaluacionnomi.getIsDeletedAuxiliar());	
			evaluacionnomi.setIsNew(evaluacionnomi.getIsNewAuxiliar());	
			evaluacionnomi.setIsChanged(evaluacionnomi.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionnomi.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionnomi.setIsDeletedAuxiliar(false);	
			evaluacionnomi.setIsNewAuxiliar(false);	
			evaluacionnomi.setIsChangedAuxiliar(false);
			
			evaluacionnomi.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionNomi evaluacionnomi : evaluacionnomis) {
			if(conAsignarBase && evaluacionnomi.getConCambioAuxiliar()) {
				evaluacionnomi.setIsDeleted(evaluacionnomi.getIsDeletedAuxiliar());	
				evaluacionnomi.setIsNew(evaluacionnomi.getIsNewAuxiliar());	
				evaluacionnomi.setIsChanged(evaluacionnomi.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionnomi.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionnomi.setIsDeletedAuxiliar(false);	
				evaluacionnomi.setIsNewAuxiliar(false);	
				evaluacionnomi.setIsChangedAuxiliar(false);
				
				evaluacionnomi.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionNomi(EvaluacionNomi evaluacionnomi,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionNomi evaluacionnomi: evaluacionnomis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionNomi(List<EvaluacionNomi> evaluacionnomis,EvaluacionNomi evaluacionnomiAux) throws Exception  {
		EvaluacionNomiConstantesFunciones.InicializarValoresEvaluacionNomi(evaluacionnomiAux,true);
		
		for(EvaluacionNomi evaluacionnomi: evaluacionnomis) {
			if(evaluacionnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionNomiConstantesFunciones.getArrayColumnasGlobalesEvaluacionNomi(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionNomiConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionNomiConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionNomiConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionNomiConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionNomiConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionNomiConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionNomiConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionNomi(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionNomi> evaluacionnomis,EvaluacionNomi evaluacionnomi,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionNomi evaluacionnomiAux: evaluacionnomis) {
			if(evaluacionnomiAux!=null && evaluacionnomi!=null) {
				if((evaluacionnomiAux.getId()==null && evaluacionnomi.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionnomiAux.getId()!=null && evaluacionnomi.getId()!=null){
					if(evaluacionnomiAux.getId().equals(evaluacionnomi.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionNomi(List<EvaluacionNomi> evaluacionnomis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EvaluacionNomi evaluacionnomi: evaluacionnomis) {			
			if(evaluacionnomi.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionNomi() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_ID, EvaluacionNomiConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_VERSIONROW, EvaluacionNomiConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA, EvaluacionNomiConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDSUCURSAL, EvaluacionNomiConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDEJERCICIO, EvaluacionNomiConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDPERIODO, EvaluacionNomiConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADO, EvaluacionNomiConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADOEVALUADOR, EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI, EvaluacionNomiConstantesFunciones.IDFORMATONOMI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_IDESTRUCTURA, EvaluacionNomiConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_FECHA, EvaluacionNomiConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_INSTRUCCIONES, EvaluacionNomiConstantesFunciones.INSTRUCCIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION, EvaluacionNomiConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION2, EvaluacionNomiConstantesFunciones.DESCRIPCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION3, EvaluacionNomiConstantesFunciones.DESCRIPCION3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION4, EvaluacionNomiConstantesFunciones.DESCRIPCION4,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionNomi() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDFORMATONOMI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.INSTRUCCIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.DESCRIPCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.DESCRIPCION3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionNomiConstantesFunciones.DESCRIPCION4;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionNomi() throws Exception  {
		return EvaluacionNomiConstantesFunciones.getTiposSeleccionarEvaluacionNomi(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionNomi(Boolean conFk) throws Exception  {
		return EvaluacionNomiConstantesFunciones.getTiposSeleccionarEvaluacionNomi(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionNomi(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADOEVALUADOR);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADOEVALUADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_INSTRUCCIONES);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_INSTRUCCIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION2);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION3);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION4);
			reporte.setsDescripcion(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionNomi(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionNomi(EvaluacionNomi evaluacionnomiAux) throws Exception {
		
			evaluacionnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionnomiAux.getEmpresa()));
			evaluacionnomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionnomiAux.getSucursal()));
			evaluacionnomiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionnomiAux.getEjercicio()));
			evaluacionnomiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionnomiAux.getPeriodo()));
			evaluacionnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionnomiAux.getEmpleado()));
			evaluacionnomiAux.setempleadoevaluador_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionnomiAux.getEmpleadoEvaluador()));
			evaluacionnomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(evaluacionnomiAux.getFormatoNomi()));
			evaluacionnomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionnomiAux.getEstructura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionNomi(List<EvaluacionNomi> evaluacionnomisTemp) throws Exception {
		for(EvaluacionNomi evaluacionnomiAux:evaluacionnomisTemp) {
			
			evaluacionnomiAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionnomiAux.getEmpresa()));
			evaluacionnomiAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionnomiAux.getSucursal()));
			evaluacionnomiAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionnomiAux.getEjercicio()));
			evaluacionnomiAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionnomiAux.getPeriodo()));
			evaluacionnomiAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionnomiAux.getEmpleado()));
			evaluacionnomiAux.setempleadoevaluador_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(evaluacionnomiAux.getEmpleadoEvaluador()));
			evaluacionnomiAux.setformatonomi_descripcion(FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(evaluacionnomiAux.getFormatoNomi()));
			evaluacionnomiAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(evaluacionnomiAux.getEstructura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(FormatoNomi.class));
				classes.add(new Classe(Estructura.class));
				
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
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormatoNomi.class)) {
						classes.add(new Classe(FormatoNomi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(FormatoNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormatoNomi.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionNomiConstantesFunciones.getClassesRelationshipsOfEvaluacionNomi(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleEvaluacionNomi.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionNomi.class)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionNomiConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionNomi(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionNomi(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionNomi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionNomi.class)); continue;
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
	public static void actualizarLista(EvaluacionNomi evaluacionnomi,List<EvaluacionNomi> evaluacionnomis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EvaluacionNomi evaluacionnomiEncontrado=null;
			
			for(EvaluacionNomi evaluacionnomiLocal:evaluacionnomis) {
				if(evaluacionnomiLocal.getId().equals(evaluacionnomi.getId())) {
					evaluacionnomiEncontrado=evaluacionnomiLocal;
					
					evaluacionnomiLocal.setIsChanged(evaluacionnomi.getIsChanged());
					evaluacionnomiLocal.setIsNew(evaluacionnomi.getIsNew());
					evaluacionnomiLocal.setIsDeleted(evaluacionnomi.getIsDeleted());
					
					evaluacionnomiLocal.setGeneralEntityOriginal(evaluacionnomi.getGeneralEntityOriginal());
					
					evaluacionnomiLocal.setId(evaluacionnomi.getId());	
					evaluacionnomiLocal.setVersionRow(evaluacionnomi.getVersionRow());	
					evaluacionnomiLocal.setid_empresa(evaluacionnomi.getid_empresa());	
					evaluacionnomiLocal.setid_sucursal(evaluacionnomi.getid_sucursal());	
					evaluacionnomiLocal.setid_ejercicio(evaluacionnomi.getid_ejercicio());	
					evaluacionnomiLocal.setid_periodo(evaluacionnomi.getid_periodo());	
					evaluacionnomiLocal.setid_empleado(evaluacionnomi.getid_empleado());	
					evaluacionnomiLocal.setid_empleado_evaluador(evaluacionnomi.getid_empleado_evaluador());	
					evaluacionnomiLocal.setid_formato_nomi(evaluacionnomi.getid_formato_nomi());	
					evaluacionnomiLocal.setid_estructura(evaluacionnomi.getid_estructura());	
					evaluacionnomiLocal.setfecha(evaluacionnomi.getfecha());	
					evaluacionnomiLocal.setinstrucciones(evaluacionnomi.getinstrucciones());	
					evaluacionnomiLocal.setdescripcion(evaluacionnomi.getdescripcion());	
					evaluacionnomiLocal.setdescripcion2(evaluacionnomi.getdescripcion2());	
					evaluacionnomiLocal.setdescripcion3(evaluacionnomi.getdescripcion3());	
					evaluacionnomiLocal.setdescripcion4(evaluacionnomi.getdescripcion4());	
					
					
					evaluacionnomiLocal.setDetalleEvaluacionNomis(evaluacionnomi.getDetalleEvaluacionNomis());
					
					existe=true;
					break;
				}
			}
			
			if(!evaluacionnomi.getIsDeleted()) {
				if(!existe) {
					evaluacionnomis.add(evaluacionnomi);
				}
			} else {
				if(evaluacionnomiEncontrado!=null && permiteQuitar)  {
					evaluacionnomis.remove(evaluacionnomiEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EvaluacionNomi evaluacionnomi,List<EvaluacionNomi> evaluacionnomis) throws Exception {
		try	{			
			for(EvaluacionNomi evaluacionnomiLocal:evaluacionnomis) {
				if(evaluacionnomiLocal.getId().equals(evaluacionnomi.getId())) {
					evaluacionnomiLocal.setIsSelected(evaluacionnomi.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionNomi(List<EvaluacionNomi> evaluacionnomisAux) throws Exception {
		//this.evaluacionnomisAux=evaluacionnomisAux;
		
		for(EvaluacionNomi evaluacionnomiAux:evaluacionnomisAux) {
			if(evaluacionnomiAux.getIsChanged()) {
				evaluacionnomiAux.setIsChanged(false);
			}		
			
			if(evaluacionnomiAux.getIsNew()) {
				evaluacionnomiAux.setIsNew(false);
			}	
			
			if(evaluacionnomiAux.getIsDeleted()) {
				evaluacionnomiAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionNomi(EvaluacionNomi evaluacionnomiAux) throws Exception {
		//this.evaluacionnomiAux=evaluacionnomiAux;
		
			if(evaluacionnomiAux.getIsChanged()) {
				evaluacionnomiAux.setIsChanged(false);
			}		
			
			if(evaluacionnomiAux.getIsNew()) {
				evaluacionnomiAux.setIsNew(false);
			}	
			
			if(evaluacionnomiAux.getIsDeleted()) {
				evaluacionnomiAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionNomi evaluacionnomiAsignar,EvaluacionNomi evaluacionnomi) throws Exception {
		evaluacionnomiAsignar.setId(evaluacionnomi.getId());	
		evaluacionnomiAsignar.setVersionRow(evaluacionnomi.getVersionRow());	
		evaluacionnomiAsignar.setid_empresa(evaluacionnomi.getid_empresa());
		evaluacionnomiAsignar.setempresa_descripcion(evaluacionnomi.getempresa_descripcion());	
		evaluacionnomiAsignar.setid_sucursal(evaluacionnomi.getid_sucursal());
		evaluacionnomiAsignar.setsucursal_descripcion(evaluacionnomi.getsucursal_descripcion());	
		evaluacionnomiAsignar.setid_ejercicio(evaluacionnomi.getid_ejercicio());
		evaluacionnomiAsignar.setejercicio_descripcion(evaluacionnomi.getejercicio_descripcion());	
		evaluacionnomiAsignar.setid_periodo(evaluacionnomi.getid_periodo());
		evaluacionnomiAsignar.setperiodo_descripcion(evaluacionnomi.getperiodo_descripcion());	
		evaluacionnomiAsignar.setid_empleado(evaluacionnomi.getid_empleado());
		evaluacionnomiAsignar.setempleado_descripcion(evaluacionnomi.getempleado_descripcion());	
		evaluacionnomiAsignar.setid_empleado_evaluador(evaluacionnomi.getid_empleado_evaluador());
		evaluacionnomiAsignar.setempleadoevaluador_descripcion(evaluacionnomi.getempleadoevaluador_descripcion());	
		evaluacionnomiAsignar.setid_formato_nomi(evaluacionnomi.getid_formato_nomi());
		evaluacionnomiAsignar.setformatonomi_descripcion(evaluacionnomi.getformatonomi_descripcion());	
		evaluacionnomiAsignar.setid_estructura(evaluacionnomi.getid_estructura());
		evaluacionnomiAsignar.setestructura_descripcion(evaluacionnomi.getestructura_descripcion());	
		evaluacionnomiAsignar.setfecha(evaluacionnomi.getfecha());	
		evaluacionnomiAsignar.setinstrucciones(evaluacionnomi.getinstrucciones());	
		evaluacionnomiAsignar.setdescripcion(evaluacionnomi.getdescripcion());	
		evaluacionnomiAsignar.setdescripcion2(evaluacionnomi.getdescripcion2());	
		evaluacionnomiAsignar.setdescripcion3(evaluacionnomi.getdescripcion3());	
		evaluacionnomiAsignar.setdescripcion4(evaluacionnomi.getdescripcion4());	
	}
	
	public static void inicializarEvaluacionNomi(EvaluacionNomi evaluacionnomi) throws Exception {
		try {
				evaluacionnomi.setId(0L);	
					
				evaluacionnomi.setid_empresa(-1L);	
				evaluacionnomi.setid_sucursal(-1L);	
				evaluacionnomi.setid_ejercicio(-1L);	
				evaluacionnomi.setid_periodo(-1L);	
				evaluacionnomi.setid_empleado(-1L);	
				evaluacionnomi.setid_empleado_evaluador(-1L);	
				evaluacionnomi.setid_formato_nomi(-1L);	
				evaluacionnomi.setid_estructura(-1L);	
				evaluacionnomi.setfecha(new Date());	
				evaluacionnomi.setinstrucciones("");	
				evaluacionnomi.setdescripcion("");	
				evaluacionnomi.setdescripcion2("");	
				evaluacionnomi.setdescripcion3("");	
				evaluacionnomi.setdescripcion4("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionNomi(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDEMPLEADOEVALUADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDFORMATONOMI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_INSTRUCCIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionNomiConstantesFunciones.LABEL_DESCRIPCION4);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionNomi(String sTipo,Row row,Workbook workbook,EvaluacionNomi evaluacionnomi,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getempleadoevaluador_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getformatonomi_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getinstrucciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getdescripcion2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getdescripcion3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionnomi.getdescripcion4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionNomi=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEvaluacionNomi() {
		return this.sFinalQueryEvaluacionNomi;
	}
	
	public void setsFinalQueryEvaluacionNomi(String sFinalQueryEvaluacionNomi) {
		this.sFinalQueryEvaluacionNomi= sFinalQueryEvaluacionNomi;
	}
	
	public Border resaltarSeleccionarEvaluacionNomi=null;
	
	public Border setResaltarSeleccionarEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionNomi= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionNomi() {
		return this.resaltarSeleccionarEvaluacionNomi;
	}
	
	public void setResaltarSeleccionarEvaluacionNomi(Border borderResaltarSeleccionarEvaluacionNomi) {
		this.resaltarSeleccionarEvaluacionNomi= borderResaltarSeleccionarEvaluacionNomi;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionNomi=null;
	public Boolean mostraridEvaluacionNomi=true;
	public Boolean activaridEvaluacionNomi=true;

	public Border resaltarid_empresaEvaluacionNomi=null;
	public Boolean mostrarid_empresaEvaluacionNomi=true;
	public Boolean activarid_empresaEvaluacionNomi=true;
	public Boolean cargarid_empresaEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionNomi=null;
	public Boolean mostrarid_sucursalEvaluacionNomi=true;
	public Boolean activarid_sucursalEvaluacionNomi=true;
	public Boolean cargarid_sucursalEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEvaluacionNomi=null;
	public Boolean mostrarid_ejercicioEvaluacionNomi=true;
	public Boolean activarid_ejercicioEvaluacionNomi=true;
	public Boolean cargarid_ejercicioEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_periodoEvaluacionNomi=null;
	public Boolean mostrarid_periodoEvaluacionNomi=true;
	public Boolean activarid_periodoEvaluacionNomi=true;
	public Boolean cargarid_periodoEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_empleadoEvaluacionNomi=null;
	public Boolean mostrarid_empleadoEvaluacionNomi=true;
	public Boolean activarid_empleadoEvaluacionNomi=true;
	public Boolean cargarid_empleadoEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_empleado_evaluadorEvaluacionNomi=null;
	public Boolean mostrarid_empleado_evaluadorEvaluacionNomi=true;
	public Boolean activarid_empleado_evaluadorEvaluacionNomi=true;
	public Boolean cargarid_empleado_evaluadorEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_evaluadorEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_formato_nomiEvaluacionNomi=null;
	public Boolean mostrarid_formato_nomiEvaluacionNomi=true;
	public Boolean activarid_formato_nomiEvaluacionNomi=true;
	public Boolean cargarid_formato_nomiEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_nomiEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarid_estructuraEvaluacionNomi=null;
	public Boolean mostrarid_estructuraEvaluacionNomi=true;
	public Boolean activarid_estructuraEvaluacionNomi=true;
	public Boolean cargarid_estructuraEvaluacionNomi=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEvaluacionNomi=false;//ConEventDepend=true

	public Border resaltarfechaEvaluacionNomi=null;
	public Boolean mostrarfechaEvaluacionNomi=true;
	public Boolean activarfechaEvaluacionNomi=false;

	public Border resaltarinstruccionesEvaluacionNomi=null;
	public Boolean mostrarinstruccionesEvaluacionNomi=true;
	public Boolean activarinstruccionesEvaluacionNomi=true;

	public Border resaltardescripcionEvaluacionNomi=null;
	public Boolean mostrardescripcionEvaluacionNomi=true;
	public Boolean activardescripcionEvaluacionNomi=true;

	public Border resaltardescripcion2EvaluacionNomi=null;
	public Boolean mostrardescripcion2EvaluacionNomi=true;
	public Boolean activardescripcion2EvaluacionNomi=true;

	public Border resaltardescripcion3EvaluacionNomi=null;
	public Boolean mostrardescripcion3EvaluacionNomi=true;
	public Boolean activardescripcion3EvaluacionNomi=true;

	public Border resaltardescripcion4EvaluacionNomi=null;
	public Boolean mostrardescripcion4EvaluacionNomi=true;
	public Boolean activardescripcion4EvaluacionNomi=true;

	
	

	public Border setResaltaridEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionNomi() {
		return this.resaltaridEvaluacionNomi;
	}

	public void setResaltaridEvaluacionNomi(Border borderResaltar) {
		this.resaltaridEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostraridEvaluacionNomi() {
		return this.mostraridEvaluacionNomi;
	}

	public void setMostraridEvaluacionNomi(Boolean mostraridEvaluacionNomi) {
		this.mostraridEvaluacionNomi= mostraridEvaluacionNomi;
	}

	public Boolean getActivaridEvaluacionNomi() {
		return this.activaridEvaluacionNomi;
	}

	public void setActivaridEvaluacionNomi(Boolean activaridEvaluacionNomi) {
		this.activaridEvaluacionNomi= activaridEvaluacionNomi;
	}

	public Border setResaltarid_empresaEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionNomi() {
		return this.resaltarid_empresaEvaluacionNomi;
	}

	public void setResaltarid_empresaEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionNomi() {
		return this.mostrarid_empresaEvaluacionNomi;
	}

	public void setMostrarid_empresaEvaluacionNomi(Boolean mostrarid_empresaEvaluacionNomi) {
		this.mostrarid_empresaEvaluacionNomi= mostrarid_empresaEvaluacionNomi;
	}

	public Boolean getActivarid_empresaEvaluacionNomi() {
		return this.activarid_empresaEvaluacionNomi;
	}

	public void setActivarid_empresaEvaluacionNomi(Boolean activarid_empresaEvaluacionNomi) {
		this.activarid_empresaEvaluacionNomi= activarid_empresaEvaluacionNomi;
	}

	public Boolean getCargarid_empresaEvaluacionNomi() {
		return this.cargarid_empresaEvaluacionNomi;
	}

	public void setCargarid_empresaEvaluacionNomi(Boolean cargarid_empresaEvaluacionNomi) {
		this.cargarid_empresaEvaluacionNomi= cargarid_empresaEvaluacionNomi;
	}

	public Border setResaltarid_sucursalEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionNomi() {
		return this.resaltarid_sucursalEvaluacionNomi;
	}

	public void setResaltarid_sucursalEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionNomi() {
		return this.mostrarid_sucursalEvaluacionNomi;
	}

	public void setMostrarid_sucursalEvaluacionNomi(Boolean mostrarid_sucursalEvaluacionNomi) {
		this.mostrarid_sucursalEvaluacionNomi= mostrarid_sucursalEvaluacionNomi;
	}

	public Boolean getActivarid_sucursalEvaluacionNomi() {
		return this.activarid_sucursalEvaluacionNomi;
	}

	public void setActivarid_sucursalEvaluacionNomi(Boolean activarid_sucursalEvaluacionNomi) {
		this.activarid_sucursalEvaluacionNomi= activarid_sucursalEvaluacionNomi;
	}

	public Boolean getCargarid_sucursalEvaluacionNomi() {
		return this.cargarid_sucursalEvaluacionNomi;
	}

	public void setCargarid_sucursalEvaluacionNomi(Boolean cargarid_sucursalEvaluacionNomi) {
		this.cargarid_sucursalEvaluacionNomi= cargarid_sucursalEvaluacionNomi;
	}

	public Border setResaltarid_ejercicioEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEvaluacionNomi() {
		return this.resaltarid_ejercicioEvaluacionNomi;
	}

	public void setResaltarid_ejercicioEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_ejercicioEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEvaluacionNomi() {
		return this.mostrarid_ejercicioEvaluacionNomi;
	}

	public void setMostrarid_ejercicioEvaluacionNomi(Boolean mostrarid_ejercicioEvaluacionNomi) {
		this.mostrarid_ejercicioEvaluacionNomi= mostrarid_ejercicioEvaluacionNomi;
	}

	public Boolean getActivarid_ejercicioEvaluacionNomi() {
		return this.activarid_ejercicioEvaluacionNomi;
	}

	public void setActivarid_ejercicioEvaluacionNomi(Boolean activarid_ejercicioEvaluacionNomi) {
		this.activarid_ejercicioEvaluacionNomi= activarid_ejercicioEvaluacionNomi;
	}

	public Boolean getCargarid_ejercicioEvaluacionNomi() {
		return this.cargarid_ejercicioEvaluacionNomi;
	}

	public void setCargarid_ejercicioEvaluacionNomi(Boolean cargarid_ejercicioEvaluacionNomi) {
		this.cargarid_ejercicioEvaluacionNomi= cargarid_ejercicioEvaluacionNomi;
	}

	public Border setResaltarid_periodoEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_periodoEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoEvaluacionNomi() {
		return this.resaltarid_periodoEvaluacionNomi;
	}

	public void setResaltarid_periodoEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_periodoEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_periodoEvaluacionNomi() {
		return this.mostrarid_periodoEvaluacionNomi;
	}

	public void setMostrarid_periodoEvaluacionNomi(Boolean mostrarid_periodoEvaluacionNomi) {
		this.mostrarid_periodoEvaluacionNomi= mostrarid_periodoEvaluacionNomi;
	}

	public Boolean getActivarid_periodoEvaluacionNomi() {
		return this.activarid_periodoEvaluacionNomi;
	}

	public void setActivarid_periodoEvaluacionNomi(Boolean activarid_periodoEvaluacionNomi) {
		this.activarid_periodoEvaluacionNomi= activarid_periodoEvaluacionNomi;
	}

	public Boolean getCargarid_periodoEvaluacionNomi() {
		return this.cargarid_periodoEvaluacionNomi;
	}

	public void setCargarid_periodoEvaluacionNomi(Boolean cargarid_periodoEvaluacionNomi) {
		this.cargarid_periodoEvaluacionNomi= cargarid_periodoEvaluacionNomi;
	}

	public Border setResaltarid_empleadoEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEvaluacionNomi() {
		return this.resaltarid_empleadoEvaluacionNomi;
	}

	public void setResaltarid_empleadoEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_empleadoEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEvaluacionNomi() {
		return this.mostrarid_empleadoEvaluacionNomi;
	}

	public void setMostrarid_empleadoEvaluacionNomi(Boolean mostrarid_empleadoEvaluacionNomi) {
		this.mostrarid_empleadoEvaluacionNomi= mostrarid_empleadoEvaluacionNomi;
	}

	public Boolean getActivarid_empleadoEvaluacionNomi() {
		return this.activarid_empleadoEvaluacionNomi;
	}

	public void setActivarid_empleadoEvaluacionNomi(Boolean activarid_empleadoEvaluacionNomi) {
		this.activarid_empleadoEvaluacionNomi= activarid_empleadoEvaluacionNomi;
	}

	public Boolean getCargarid_empleadoEvaluacionNomi() {
		return this.cargarid_empleadoEvaluacionNomi;
	}

	public void setCargarid_empleadoEvaluacionNomi(Boolean cargarid_empleadoEvaluacionNomi) {
		this.cargarid_empleadoEvaluacionNomi= cargarid_empleadoEvaluacionNomi;
	}

	public Border setResaltarid_empleado_evaluadorEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_empleado_evaluadorEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_evaluadorEvaluacionNomi() {
		return this.resaltarid_empleado_evaluadorEvaluacionNomi;
	}

	public void setResaltarid_empleado_evaluadorEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_empleado_evaluadorEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_empleado_evaluadorEvaluacionNomi() {
		return this.mostrarid_empleado_evaluadorEvaluacionNomi;
	}

	public void setMostrarid_empleado_evaluadorEvaluacionNomi(Boolean mostrarid_empleado_evaluadorEvaluacionNomi) {
		this.mostrarid_empleado_evaluadorEvaluacionNomi= mostrarid_empleado_evaluadorEvaluacionNomi;
	}

	public Boolean getActivarid_empleado_evaluadorEvaluacionNomi() {
		return this.activarid_empleado_evaluadorEvaluacionNomi;
	}

	public void setActivarid_empleado_evaluadorEvaluacionNomi(Boolean activarid_empleado_evaluadorEvaluacionNomi) {
		this.activarid_empleado_evaluadorEvaluacionNomi= activarid_empleado_evaluadorEvaluacionNomi;
	}

	public Boolean getCargarid_empleado_evaluadorEvaluacionNomi() {
		return this.cargarid_empleado_evaluadorEvaluacionNomi;
	}

	public void setCargarid_empleado_evaluadorEvaluacionNomi(Boolean cargarid_empleado_evaluadorEvaluacionNomi) {
		this.cargarid_empleado_evaluadorEvaluacionNomi= cargarid_empleado_evaluadorEvaluacionNomi;
	}

	public Border setResaltarid_formato_nomiEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_formato_nomiEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_nomiEvaluacionNomi() {
		return this.resaltarid_formato_nomiEvaluacionNomi;
	}

	public void setResaltarid_formato_nomiEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_formato_nomiEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_formato_nomiEvaluacionNomi() {
		return this.mostrarid_formato_nomiEvaluacionNomi;
	}

	public void setMostrarid_formato_nomiEvaluacionNomi(Boolean mostrarid_formato_nomiEvaluacionNomi) {
		this.mostrarid_formato_nomiEvaluacionNomi= mostrarid_formato_nomiEvaluacionNomi;
	}

	public Boolean getActivarid_formato_nomiEvaluacionNomi() {
		return this.activarid_formato_nomiEvaluacionNomi;
	}

	public void setActivarid_formato_nomiEvaluacionNomi(Boolean activarid_formato_nomiEvaluacionNomi) {
		this.activarid_formato_nomiEvaluacionNomi= activarid_formato_nomiEvaluacionNomi;
	}

	public Boolean getCargarid_formato_nomiEvaluacionNomi() {
		return this.cargarid_formato_nomiEvaluacionNomi;
	}

	public void setCargarid_formato_nomiEvaluacionNomi(Boolean cargarid_formato_nomiEvaluacionNomi) {
		this.cargarid_formato_nomiEvaluacionNomi= cargarid_formato_nomiEvaluacionNomi;
	}

	public Border setResaltarid_estructuraEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEvaluacionNomi() {
		return this.resaltarid_estructuraEvaluacionNomi;
	}

	public void setResaltarid_estructuraEvaluacionNomi(Border borderResaltar) {
		this.resaltarid_estructuraEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEvaluacionNomi() {
		return this.mostrarid_estructuraEvaluacionNomi;
	}

	public void setMostrarid_estructuraEvaluacionNomi(Boolean mostrarid_estructuraEvaluacionNomi) {
		this.mostrarid_estructuraEvaluacionNomi= mostrarid_estructuraEvaluacionNomi;
	}

	public Boolean getActivarid_estructuraEvaluacionNomi() {
		return this.activarid_estructuraEvaluacionNomi;
	}

	public void setActivarid_estructuraEvaluacionNomi(Boolean activarid_estructuraEvaluacionNomi) {
		this.activarid_estructuraEvaluacionNomi= activarid_estructuraEvaluacionNomi;
	}

	public Boolean getCargarid_estructuraEvaluacionNomi() {
		return this.cargarid_estructuraEvaluacionNomi;
	}

	public void setCargarid_estructuraEvaluacionNomi(Boolean cargarid_estructuraEvaluacionNomi) {
		this.cargarid_estructuraEvaluacionNomi= cargarid_estructuraEvaluacionNomi;
	}

	public Border setResaltarfechaEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarfechaEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaEvaluacionNomi() {
		return this.resaltarfechaEvaluacionNomi;
	}

	public void setResaltarfechaEvaluacionNomi(Border borderResaltar) {
		this.resaltarfechaEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarfechaEvaluacionNomi() {
		return this.mostrarfechaEvaluacionNomi;
	}

	public void setMostrarfechaEvaluacionNomi(Boolean mostrarfechaEvaluacionNomi) {
		this.mostrarfechaEvaluacionNomi= mostrarfechaEvaluacionNomi;
	}

	public Boolean getActivarfechaEvaluacionNomi() {
		return this.activarfechaEvaluacionNomi;
	}

	public void setActivarfechaEvaluacionNomi(Boolean activarfechaEvaluacionNomi) {
		this.activarfechaEvaluacionNomi= activarfechaEvaluacionNomi;
	}

	public Border setResaltarinstruccionesEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltarinstruccionesEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinstruccionesEvaluacionNomi() {
		return this.resaltarinstruccionesEvaluacionNomi;
	}

	public void setResaltarinstruccionesEvaluacionNomi(Border borderResaltar) {
		this.resaltarinstruccionesEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrarinstruccionesEvaluacionNomi() {
		return this.mostrarinstruccionesEvaluacionNomi;
	}

	public void setMostrarinstruccionesEvaluacionNomi(Boolean mostrarinstruccionesEvaluacionNomi) {
		this.mostrarinstruccionesEvaluacionNomi= mostrarinstruccionesEvaluacionNomi;
	}

	public Boolean getActivarinstruccionesEvaluacionNomi() {
		return this.activarinstruccionesEvaluacionNomi;
	}

	public void setActivarinstruccionesEvaluacionNomi(Boolean activarinstruccionesEvaluacionNomi) {
		this.activarinstruccionesEvaluacionNomi= activarinstruccionesEvaluacionNomi;
	}

	public Border setResaltardescripcionEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltardescripcionEvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEvaluacionNomi() {
		return this.resaltardescripcionEvaluacionNomi;
	}

	public void setResaltardescripcionEvaluacionNomi(Border borderResaltar) {
		this.resaltardescripcionEvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrardescripcionEvaluacionNomi() {
		return this.mostrardescripcionEvaluacionNomi;
	}

	public void setMostrardescripcionEvaluacionNomi(Boolean mostrardescripcionEvaluacionNomi) {
		this.mostrardescripcionEvaluacionNomi= mostrardescripcionEvaluacionNomi;
	}

	public Boolean getActivardescripcionEvaluacionNomi() {
		return this.activardescripcionEvaluacionNomi;
	}

	public void setActivardescripcionEvaluacionNomi(Boolean activardescripcionEvaluacionNomi) {
		this.activardescripcionEvaluacionNomi= activardescripcionEvaluacionNomi;
	}

	public Border setResaltardescripcion2EvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltardescripcion2EvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion2EvaluacionNomi() {
		return this.resaltardescripcion2EvaluacionNomi;
	}

	public void setResaltardescripcion2EvaluacionNomi(Border borderResaltar) {
		this.resaltardescripcion2EvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrardescripcion2EvaluacionNomi() {
		return this.mostrardescripcion2EvaluacionNomi;
	}

	public void setMostrardescripcion2EvaluacionNomi(Boolean mostrardescripcion2EvaluacionNomi) {
		this.mostrardescripcion2EvaluacionNomi= mostrardescripcion2EvaluacionNomi;
	}

	public Boolean getActivardescripcion2EvaluacionNomi() {
		return this.activardescripcion2EvaluacionNomi;
	}

	public void setActivardescripcion2EvaluacionNomi(Boolean activardescripcion2EvaluacionNomi) {
		this.activardescripcion2EvaluacionNomi= activardescripcion2EvaluacionNomi;
	}

	public Border setResaltardescripcion3EvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltardescripcion3EvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion3EvaluacionNomi() {
		return this.resaltardescripcion3EvaluacionNomi;
	}

	public void setResaltardescripcion3EvaluacionNomi(Border borderResaltar) {
		this.resaltardescripcion3EvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrardescripcion3EvaluacionNomi() {
		return this.mostrardescripcion3EvaluacionNomi;
	}

	public void setMostrardescripcion3EvaluacionNomi(Boolean mostrardescripcion3EvaluacionNomi) {
		this.mostrardescripcion3EvaluacionNomi= mostrardescripcion3EvaluacionNomi;
	}

	public Boolean getActivardescripcion3EvaluacionNomi() {
		return this.activardescripcion3EvaluacionNomi;
	}

	public void setActivardescripcion3EvaluacionNomi(Boolean activardescripcion3EvaluacionNomi) {
		this.activardescripcion3EvaluacionNomi= activardescripcion3EvaluacionNomi;
	}

	public Border setResaltardescripcion4EvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltar);
		
		this.resaltardescripcion4EvaluacionNomi= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion4EvaluacionNomi() {
		return this.resaltardescripcion4EvaluacionNomi;
	}

	public void setResaltardescripcion4EvaluacionNomi(Border borderResaltar) {
		this.resaltardescripcion4EvaluacionNomi= borderResaltar;
	}

	public Boolean getMostrardescripcion4EvaluacionNomi() {
		return this.mostrardescripcion4EvaluacionNomi;
	}

	public void setMostrardescripcion4EvaluacionNomi(Boolean mostrardescripcion4EvaluacionNomi) {
		this.mostrardescripcion4EvaluacionNomi= mostrardescripcion4EvaluacionNomi;
	}

	public Boolean getActivardescripcion4EvaluacionNomi() {
		return this.activardescripcion4EvaluacionNomi;
	}

	public void setActivardescripcion4EvaluacionNomi(Boolean activardescripcion4EvaluacionNomi) {
		this.activardescripcion4EvaluacionNomi= activardescripcion4EvaluacionNomi;
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
		
		
		this.setMostraridEvaluacionNomi(esInicial);
		this.setMostrarid_empresaEvaluacionNomi(esInicial);
		this.setMostrarid_sucursalEvaluacionNomi(esInicial);
		this.setMostrarid_ejercicioEvaluacionNomi(esInicial);
		this.setMostrarid_periodoEvaluacionNomi(esInicial);
		this.setMostrarid_empleadoEvaluacionNomi(esInicial);
		this.setMostrarid_empleado_evaluadorEvaluacionNomi(esInicial);
		this.setMostrarid_formato_nomiEvaluacionNomi(esInicial);
		this.setMostrarid_estructuraEvaluacionNomi(esInicial);
		this.setMostrarfechaEvaluacionNomi(esInicial);
		this.setMostrarinstruccionesEvaluacionNomi(esInicial);
		this.setMostrardescripcionEvaluacionNomi(esInicial);
		this.setMostrardescripcion2EvaluacionNomi(esInicial);
		this.setMostrardescripcion3EvaluacionNomi(esInicial);
		this.setMostrardescripcion4EvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.ID)) {
				this.setMostraridEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR)) {
				this.setMostrarid_empleado_evaluadorEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setMostrarid_formato_nomiEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.FECHA)) {
				this.setMostrarfechaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setMostrarinstruccionesEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION2)) {
				this.setMostrardescripcion2EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION3)) {
				this.setMostrardescripcion3EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION4)) {
				this.setMostrardescripcion4EvaluacionNomi(esAsigna);
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
		
		
		this.setActivaridEvaluacionNomi(esInicial);
		this.setActivarid_empresaEvaluacionNomi(esInicial);
		this.setActivarid_sucursalEvaluacionNomi(esInicial);
		this.setActivarid_ejercicioEvaluacionNomi(esInicial);
		this.setActivarid_periodoEvaluacionNomi(esInicial);
		this.setActivarid_empleadoEvaluacionNomi(esInicial);
		this.setActivarid_empleado_evaluadorEvaluacionNomi(esInicial);
		this.setActivarid_formato_nomiEvaluacionNomi(esInicial);
		this.setActivarid_estructuraEvaluacionNomi(esInicial);
		this.setActivarfechaEvaluacionNomi(esInicial);
		this.setActivarinstruccionesEvaluacionNomi(esInicial);
		this.setActivardescripcionEvaluacionNomi(esInicial);
		this.setActivardescripcion2EvaluacionNomi(esInicial);
		this.setActivardescripcion3EvaluacionNomi(esInicial);
		this.setActivardescripcion4EvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.ID)) {
				this.setActivaridEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR)) {
				this.setActivarid_empleado_evaluadorEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setActivarid_formato_nomiEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.FECHA)) {
				this.setActivarfechaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setActivarinstruccionesEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION2)) {
				this.setActivardescripcion2EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION3)) {
				this.setActivardescripcion3EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION4)) {
				this.setActivardescripcion4EvaluacionNomi(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionNomi(esInicial);
		this.setResaltarid_empresaEvaluacionNomi(esInicial);
		this.setResaltarid_sucursalEvaluacionNomi(esInicial);
		this.setResaltarid_ejercicioEvaluacionNomi(esInicial);
		this.setResaltarid_periodoEvaluacionNomi(esInicial);
		this.setResaltarid_empleadoEvaluacionNomi(esInicial);
		this.setResaltarid_empleado_evaluadorEvaluacionNomi(esInicial);
		this.setResaltarid_formato_nomiEvaluacionNomi(esInicial);
		this.setResaltarid_estructuraEvaluacionNomi(esInicial);
		this.setResaltarfechaEvaluacionNomi(esInicial);
		this.setResaltarinstruccionesEvaluacionNomi(esInicial);
		this.setResaltardescripcionEvaluacionNomi(esInicial);
		this.setResaltardescripcion2EvaluacionNomi(esInicial);
		this.setResaltardescripcion3EvaluacionNomi(esInicial);
		this.setResaltardescripcion4EvaluacionNomi(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR)) {
				this.setResaltarid_empleado_evaluadorEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDFORMATONOMI)) {
				this.setResaltarid_formato_nomiEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.FECHA)) {
				this.setResaltarfechaEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.INSTRUCCIONES)) {
				this.setResaltarinstruccionesEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION2)) {
				this.setResaltardescripcion2EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION3)) {
				this.setResaltardescripcion3EvaluacionNomi(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionNomiConstantesFunciones.DESCRIPCION4)) {
				this.setResaltardescripcion4EvaluacionNomi(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleEvaluacionNomiEvaluacionNomi=null;

	public Border getResaltarDetalleEvaluacionNomiEvaluacionNomi() {
		return this.resaltarDetalleEvaluacionNomiEvaluacionNomi;
	}

	public void setResaltarDetalleEvaluacionNomiEvaluacionNomi(Border borderResaltarDetalleEvaluacionNomi) {
		if(borderResaltarDetalleEvaluacionNomi!=null) {
			this.resaltarDetalleEvaluacionNomiEvaluacionNomi= borderResaltarDetalleEvaluacionNomi;
		}
	}

	public Border setResaltarDetalleEvaluacionNomiEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionNomi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//evaluacionnomiBeanSwingJInternalFrame.jTtoolBarEvaluacionNomi.setBorder(borderResaltarDetalleEvaluacionNomi);
			
		this.resaltarDetalleEvaluacionNomiEvaluacionNomi= borderResaltarDetalleEvaluacionNomi;

		 return borderResaltarDetalleEvaluacionNomi;
	}



	public Boolean mostrarDetalleEvaluacionNomiEvaluacionNomi=true;

	public Boolean getMostrarDetalleEvaluacionNomiEvaluacionNomi() {
		return this.mostrarDetalleEvaluacionNomiEvaluacionNomi;
	}

	public void setMostrarDetalleEvaluacionNomiEvaluacionNomi(Boolean visibilidadResaltarDetalleEvaluacionNomi) {
		this.mostrarDetalleEvaluacionNomiEvaluacionNomi= visibilidadResaltarDetalleEvaluacionNomi;
	}



	public Boolean activarDetalleEvaluacionNomiEvaluacionNomi=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionNomiEvaluacionNomi() {
		return this.activarDetalleEvaluacionNomiEvaluacionNomi;
	}

	public void setActivarDetalleEvaluacionNomiEvaluacionNomi(Boolean habilitarResaltarDetalleEvaluacionNomi) {
		this.activarDetalleEvaluacionNomiEvaluacionNomi= habilitarResaltarDetalleEvaluacionNomi;
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

		this.setMostrarDetalleEvaluacionNomiEvaluacionNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setMostrarDetalleEvaluacionNomiEvaluacionNomi(esAsigna);
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

		this.setActivarDetalleEvaluacionNomiEvaluacionNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setActivarDetalleEvaluacionNomiEvaluacionNomi(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleEvaluacionNomiEvaluacionNomi(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionNomi.class)) {
				this.setResaltarDetalleEvaluacionNomiEvaluacionNomi(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEjercicioEvaluacionNomi() {
		return this.mostrarFK_IdEjercicioEvaluacionNomi;
	}

	public void setMostrarFK_IdEjercicioEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEmpleadoEvaluacionNomi() {
		return this.mostrarFK_IdEmpleadoEvaluacionNomi;
	}

	public void setMostrarFK_IdEmpleadoEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEvaluadorEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEmpleadoEvaluadorEvaluacionNomi() {
		return this.mostrarFK_IdEmpleadoEvaluadorEvaluacionNomi;
	}

	public void setMostrarFK_IdEmpleadoEvaluadorEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEvaluadorEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEmpresaEvaluacionNomi() {
		return this.mostrarFK_IdEmpresaEvaluacionNomi;
	}

	public void setMostrarFK_IdEmpresaEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEvaluacionNomi=true;

	public Boolean getMostrarFK_IdEstructuraEvaluacionNomi() {
		return this.mostrarFK_IdEstructuraEvaluacionNomi;
	}

	public void setMostrarFK_IdEstructuraEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoNomiEvaluacionNomi=true;

	public Boolean getMostrarFK_IdFormatoNomiEvaluacionNomi() {
		return this.mostrarFK_IdFormatoNomiEvaluacionNomi;
	}

	public void setMostrarFK_IdFormatoNomiEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoNomiEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoEvaluacionNomi=true;

	public Boolean getMostrarFK_IdPeriodoEvaluacionNomi() {
		return this.mostrarFK_IdPeriodoEvaluacionNomi;
	}

	public void setMostrarFK_IdPeriodoEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoEvaluacionNomi= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEvaluacionNomi=true;

	public Boolean getMostrarFK_IdSucursalEvaluacionNomi() {
		return this.mostrarFK_IdSucursalEvaluacionNomi;
	}

	public void setMostrarFK_IdSucursalEvaluacionNomi(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEvaluacionNomi= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioEvaluacionNomi=true;

	public Boolean getActivarFK_IdEjercicioEvaluacionNomi() {
		return this.activarFK_IdEjercicioEvaluacionNomi;
	}

	public void setActivarFK_IdEjercicioEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEvaluacionNomi=true;

	public Boolean getActivarFK_IdEmpleadoEvaluacionNomi() {
		return this.activarFK_IdEmpleadoEvaluacionNomi;
	}

	public void setActivarFK_IdEmpleadoEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEvaluadorEvaluacionNomi=true;

	public Boolean getActivarFK_IdEmpleadoEvaluadorEvaluacionNomi() {
		return this.activarFK_IdEmpleadoEvaluadorEvaluacionNomi;
	}

	public void setActivarFK_IdEmpleadoEvaluadorEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEvaluadorEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEvaluacionNomi=true;

	public Boolean getActivarFK_IdEmpresaEvaluacionNomi() {
		return this.activarFK_IdEmpresaEvaluacionNomi;
	}

	public void setActivarFK_IdEmpresaEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEvaluacionNomi=true;

	public Boolean getActivarFK_IdEstructuraEvaluacionNomi() {
		return this.activarFK_IdEstructuraEvaluacionNomi;
	}

	public void setActivarFK_IdEstructuraEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoNomiEvaluacionNomi=true;

	public Boolean getActivarFK_IdFormatoNomiEvaluacionNomi() {
		return this.activarFK_IdFormatoNomiEvaluacionNomi;
	}

	public void setActivarFK_IdFormatoNomiEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoNomiEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoEvaluacionNomi=true;

	public Boolean getActivarFK_IdPeriodoEvaluacionNomi() {
		return this.activarFK_IdPeriodoEvaluacionNomi;
	}

	public void setActivarFK_IdPeriodoEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoEvaluacionNomi= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEvaluacionNomi=true;

	public Boolean getActivarFK_IdSucursalEvaluacionNomi() {
		return this.activarFK_IdSucursalEvaluacionNomi;
	}

	public void setActivarFK_IdSucursalEvaluacionNomi(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEvaluacionNomi= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioEvaluacionNomi=null;

	public Border getResaltarFK_IdEjercicioEvaluacionNomi() {
		return this.resaltarFK_IdEjercicioEvaluacionNomi;
	}

	public void setResaltarFK_IdEjercicioEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEjercicioEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEvaluacionNomi=null;

	public Border getResaltarFK_IdEmpleadoEvaluacionNomi() {
		return this.resaltarFK_IdEmpleadoEvaluacionNomi;
	}

	public void setResaltarFK_IdEmpleadoEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEvaluadorEvaluacionNomi=null;

	public Border getResaltarFK_IdEmpleadoEvaluadorEvaluacionNomi() {
		return this.resaltarFK_IdEmpleadoEvaluadorEvaluacionNomi;
	}

	public void setResaltarFK_IdEmpleadoEvaluadorEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEvaluadorEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEvaluadorEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEvaluadorEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEvaluacionNomi=null;

	public Border getResaltarFK_IdEmpresaEvaluacionNomi() {
		return this.resaltarFK_IdEmpresaEvaluacionNomi;
	}

	public void setResaltarFK_IdEmpresaEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEvaluacionNomi=null;

	public Border getResaltarFK_IdEstructuraEvaluacionNomi() {
		return this.resaltarFK_IdEstructuraEvaluacionNomi;
	}

	public void setResaltarFK_IdEstructuraEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdFormatoNomiEvaluacionNomi=null;

	public Border getResaltarFK_IdFormatoNomiEvaluacionNomi() {
		return this.resaltarFK_IdFormatoNomiEvaluacionNomi;
	}

	public void setResaltarFK_IdFormatoNomiEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdFormatoNomiEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdFormatoNomiEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoNomiEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoEvaluacionNomi=null;

	public Border getResaltarFK_IdPeriodoEvaluacionNomi() {
		return this.resaltarFK_IdPeriodoEvaluacionNomi;
	}

	public void setResaltarFK_IdPeriodoEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdPeriodoEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoEvaluacionNomi= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEvaluacionNomi=null;

	public Border getResaltarFK_IdSucursalEvaluacionNomi() {
		return this.resaltarFK_IdSucursalEvaluacionNomi;
	}

	public void setResaltarFK_IdSucursalEvaluacionNomi(Border borderResaltar) {
		this.resaltarFK_IdSucursalEvaluacionNomi= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEvaluacionNomi(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionNomiBeanSwingJInternalFrame evaluacionnomiBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEvaluacionNomi= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}