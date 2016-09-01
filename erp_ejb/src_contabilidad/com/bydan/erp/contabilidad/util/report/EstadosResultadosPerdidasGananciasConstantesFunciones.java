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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.EstadosResultadosPerdidasGananciasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadosResultadosPerdidasGananciasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="EstadosResultadosPerdidasGanancias";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadosResultadosPerdidasGanancias"+EstadosResultadosPerdidasGananciasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadosResultadosPerdidasGananciasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadosResultadosPerdidasGananciasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"_"+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadosResultadosPerdidasGananciasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"_"+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"_"+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadosResultadosPerdidasGananciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"_"+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadosResultadosPerdidasGananciasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadosResultadosPerdidasGananciasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadosResultadosPerdidasGananciasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadosResultadosPerdidasGananciasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadosResultadosPerdidasGananciasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadosResultadosPerdidasGananciasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadosResultadosPerdidasGananciasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estados Resultados Perdidas Gananciases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Estados Resultados Perdidas Ganancias";
	public static final String SCLASSWEBTITULO_LOWER="Estados Resultados Perdidas Ganancias";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadosResultadosPerdidasGanancias";
	public static final String OBJECTNAME="estadosresultadosperdidasganancias";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="estados_resultados_perdidas_ganancias";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadosresultadosperdidasganancias from "+EstadosResultadosPerdidasGananciasConstantesFunciones.SPERSISTENCENAME+" estadosresultadosperdidasganancias";
	public static String QUERYSELECTNATIVE="select "+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".id,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".version_row,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".id_empresa,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".id_nivel_cuenta,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".id_ejercicio,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".id_periodo,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".codigo,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".nombre,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".nombre_nivel_cuenta,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".debito_inicial,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".credito_inicial,"+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME+".saldo_inicial from "+EstadosResultadosPerdidasGananciasConstantesFunciones.SCHEMA+"."+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME;//+" as "+EstadosResultadosPerdidasGananciasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDNIVELCUENTA= "id_nivel_cuenta";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRENIVELCUENTA= "nombre_nivel_cuenta";
    public static final String DEBITOINICIAL= "debito_inicial";
    public static final String CREDITOINICIAL= "credito_inicial";
    public static final String SALDOINICIAL= "saldo_inicial";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDNIVELCUENTA= "Nivel Cuenta";
		public static final String LABEL_IDNIVELCUENTA_LOWER= "Nivel Cuenta";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRENIVELCUENTA= "Nombre Nivel Cuenta";
		public static final String LABEL_NOMBRENIVELCUENTA_LOWER= "Nombre Nivel Cuenta";
    	public static final String LABEL_DEBITOINICIAL= "Debito Inicial";
		public static final String LABEL_DEBITOINICIAL_LOWER= "Debito Inicial";
    	public static final String LABEL_CREDITOINICIAL= "Credito Inicial";
		public static final String LABEL_CREDITOINICIAL_LOWER= "Credito Inicial";
    	public static final String LABEL_SALDOINICIAL= "Saldo Inicial";
		public static final String LABEL_SALDOINICIAL_LOWER= "Saldo Inicial";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_NIVEL_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_NIVEL_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getEstadosResultadosPerdidasGananciasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDNIVELCUENTA)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDNIVELCUENTA;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRENIVELCUENTA;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL;}
		if(sNombreColumna.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL)) {sLabelColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEstadosResultadosPerdidasGananciasDescripcion(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadosresultadosperdidasganancias !=null/* && estadosresultadosperdidasganancias.getId()!=0*/) {
			sDescripcion=estadosresultadosperdidasganancias.getcodigo();//estadosresultadosperdidasgananciasestadosresultadosperdidasganancias.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadosResultadosPerdidasGananciasDescripcionDetallado(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias) {
		String sDescripcion="";
			
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.ID+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getId().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getVersionRow().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getid_empresa().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.IDNIVELCUENTA+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getid_nivel_cuenta().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getid_ejercicio().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getid_periodo().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getcodigo()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getnombre()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getnombre_nivel_cuenta()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getdebito_inicial().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getcredito_inicial().toString()+",";
		sDescripcion+=EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL+"=";
		sDescripcion+=estadosresultadosperdidasganancias.getsaldo_inicial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadosResultadosPerdidasGananciasDescripcion(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,String sValor) throws Exception {			
		if(estadosresultadosperdidasganancias !=null) {
			estadosresultadosperdidasganancias.setcodigo(sValor);;//estadosresultadosperdidasgananciasestadosresultadosperdidasganancias.getcodigo().trim();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaEstadosResultadosPerdidasGanancias")) {
			sNombreIndice="Tipo=  Por Nivel Cuenta Por Ejercicio Por Periodo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdNivelCuenta")) {
			sNombreIndice="Tipo=  Por Nivel Cuenta";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaEstadosResultadosPerdidasGanancias(Long id_nivel_cuenta,Long id_ejercicio,Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_nivel_cuenta!=null) {sDetalleIndice+=" Codigo Unico De Nivel Cuenta="+id_nivel_cuenta.toString();}
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

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

	public static String getDetalleIndiceFK_IdNivelCuenta(Long id_nivel_cuenta) {
		String sDetalleIndice=" Parametros->";
		if(id_nivel_cuenta!=null) {sDetalleIndice+=" Codigo Unico De Nivel Cuenta="+id_nivel_cuenta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadosresultadosperdidasganancias.setcodigo(estadosresultadosperdidasganancias.getcodigo().trim());
		estadosresultadosperdidasganancias.setnombre(estadosresultadosperdidasganancias.getnombre().trim());
		estadosresultadosperdidasganancias.setnombre_nivel_cuenta(estadosresultadosperdidasganancias.getnombre_nivel_cuenta().trim());
	}
	
	public static void quitarEspaciosEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {
			estadosresultadosperdidasganancias.setcodigo(estadosresultadosperdidasganancias.getcodigo().trim());
			estadosresultadosperdidasganancias.setnombre(estadosresultadosperdidasganancias.getnombre().trim());
			estadosresultadosperdidasganancias.setnombre_nivel_cuenta(estadosresultadosperdidasganancias.getnombre_nivel_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadosresultadosperdidasganancias.getConCambioAuxiliar()) {
			estadosresultadosperdidasganancias.setIsDeleted(estadosresultadosperdidasganancias.getIsDeletedAuxiliar());	
			estadosresultadosperdidasganancias.setIsNew(estadosresultadosperdidasganancias.getIsNewAuxiliar());	
			estadosresultadosperdidasganancias.setIsChanged(estadosresultadosperdidasganancias.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadosresultadosperdidasganancias.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadosresultadosperdidasganancias.setIsDeletedAuxiliar(false);	
			estadosresultadosperdidasganancias.setIsNewAuxiliar(false);	
			estadosresultadosperdidasganancias.setIsChangedAuxiliar(false);
			
			estadosresultadosperdidasganancias.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias : estadosresultadosperdidasgananciass) {
			if(conAsignarBase && estadosresultadosperdidasganancias.getConCambioAuxiliar()) {
				estadosresultadosperdidasganancias.setIsDeleted(estadosresultadosperdidasganancias.getIsDeletedAuxiliar());	
				estadosresultadosperdidasganancias.setIsNew(estadosresultadosperdidasganancias.getIsNewAuxiliar());	
				estadosresultadosperdidasganancias.setIsChanged(estadosresultadosperdidasganancias.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadosresultadosperdidasganancias.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadosresultadosperdidasganancias.setIsDeletedAuxiliar(false);	
				estadosresultadosperdidasganancias.setIsNewAuxiliar(false);	
				estadosresultadosperdidasganancias.setIsChangedAuxiliar(false);
				
				estadosresultadosperdidasganancias.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,Boolean conEnteros) throws Exception  {
		estadosresultadosperdidasganancias.setdebito_inicial(0.0);
		estadosresultadosperdidasganancias.setcredito_inicial(0.0);
		estadosresultadosperdidasganancias.setsaldo_inicial(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadosResultadosPerdidasGananciass(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,Boolean conEnteros) throws Exception  {
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {
			estadosresultadosperdidasganancias.setdebito_inicial(0.0);
			estadosresultadosperdidasganancias.setcredito_inicial(0.0);
			estadosresultadosperdidasganancias.setsaldo_inicial(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadosResultadosPerdidasGanancias(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux) throws Exception  {
		EstadosResultadosPerdidasGananciasConstantesFunciones.InicializarValoresEstadosResultadosPerdidasGanancias(estadosresultadosperdidasgananciasAux,true);
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {
			if(estadosresultadosperdidasganancias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			estadosresultadosperdidasgananciasAux.setdebito_inicial(estadosresultadosperdidasgananciasAux.getdebito_inicial()+estadosresultadosperdidasganancias.getdebito_inicial());			
			estadosresultadosperdidasgananciasAux.setcredito_inicial(estadosresultadosperdidasgananciasAux.getcredito_inicial()+estadosresultadosperdidasganancias.getcredito_inicial());			
			estadosresultadosperdidasgananciasAux.setsaldo_inicial(estadosresultadosperdidasgananciasAux.getsaldo_inicial()+estadosresultadosperdidasganancias.getsaldo_inicial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosResultadosPerdidasGanancias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadosResultadosPerdidasGananciasConstantesFunciones.getArrayColumnasGlobalesEstadosResultadosPerdidasGanancias(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosResultadosPerdidasGanancias(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadosResultadosPerdidasGanancias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux: estadosresultadosperdidasgananciass) {
			if(estadosresultadosperdidasgananciasAux!=null && estadosresultadosperdidasganancias!=null) {
				if((estadosresultadosperdidasgananciasAux.getId()==null && estadosresultadosperdidasganancias.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadosresultadosperdidasgananciasAux.getId()!=null && estadosresultadosperdidasganancias.getId()!=null){
					if(estadosresultadosperdidasgananciasAux.getId().equals(estadosresultadosperdidasganancias.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadosResultadosPerdidasGanancias(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_inicialTotal=0.0;
		Double credito_inicialTotal=0.0;
		Double saldo_inicialTotal=0.0;
	
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias: estadosresultadosperdidasgananciass) {			
			if(estadosresultadosperdidasganancias.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_inicialTotal+=estadosresultadosperdidasganancias.getdebito_inicial();
			credito_inicialTotal+=estadosresultadosperdidasganancias.getcredito_inicial();
			saldo_inicialTotal+=estadosresultadosperdidasganancias.getsaldo_inicial();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL);
		datoGeneral.setdValorDouble(debito_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL);
		datoGeneral.setdValorDouble(credito_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL);
		datoGeneral.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL);
		datoGeneral.setdValorDouble(saldo_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadosResultadosPerdidasGanancias() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_ID, EstadosResultadosPerdidasGananciasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_VERSIONROW, EstadosResultadosPerdidasGananciasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CODIGO, EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRE, EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRENIVELCUENTA, EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL, EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL, EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL, EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadosResultadosPerdidasGanancias() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosResultadosPerdidasGanancias() throws Exception  {
		return EstadosResultadosPerdidasGananciasConstantesFunciones.getTiposSeleccionarEstadosResultadosPerdidasGanancias(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosResultadosPerdidasGanancias(Boolean conFk) throws Exception  {
		return EstadosResultadosPerdidasGananciasConstantesFunciones.getTiposSeleccionarEstadosResultadosPerdidasGanancias(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadosResultadosPerdidasGanancias(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDNIVELCUENTA);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDNIVELCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL);
			reporte.setsDescripcion(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadosResultadosPerdidasGanancias(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux) throws Exception {
		
			estadosresultadosperdidasgananciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadosresultadosperdidasgananciasAux.getEmpresa()));
			estadosresultadosperdidasgananciasAux.setnivelcuenta_descripcion(NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(estadosresultadosperdidasgananciasAux.getNivelCuenta()));
			estadosresultadosperdidasgananciasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(estadosresultadosperdidasgananciasAux.getEjercicio()));
			estadosresultadosperdidasgananciasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(estadosresultadosperdidasgananciasAux.getPeriodo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadosResultadosPerdidasGanancias(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciassTemp) throws Exception {
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux:estadosresultadosperdidasgananciassTemp) {
			
			estadosresultadosperdidasgananciasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadosresultadosperdidasgananciasAux.getEmpresa()));
			estadosresultadosperdidasgananciasAux.setnivelcuenta_descripcion(NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(estadosresultadosperdidasgananciasAux.getNivelCuenta()));
			estadosresultadosperdidasgananciasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(estadosresultadosperdidasgananciasAux.getEjercicio()));
			estadosresultadosperdidasgananciasAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(estadosresultadosperdidasgananciasAux.getPeriodo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadosResultadosPerdidasGanancias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(NivelCuenta.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadosResultadosPerdidasGanancias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadosResultadosPerdidasGanancias(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadosResultadosPerdidasGananciasConstantesFunciones.getClassesRelationshipsOfEstadosResultadosPerdidasGanancias(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadosResultadosPerdidasGanancias(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadosResultadosPerdidasGanancias(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadosResultadosPerdidasGananciasConstantesFunciones.getClassesRelationshipsFromStringsOfEstadosResultadosPerdidasGanancias(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadosResultadosPerdidasGanancias(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciass) throws Exception {
		try	{			
			for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasLocal:estadosresultadosperdidasgananciass) {
				if(estadosresultadosperdidasgananciasLocal.getId().equals(estadosresultadosperdidasganancias.getId())) {
					estadosresultadosperdidasgananciasLocal.setIsSelected(estadosresultadosperdidasganancias.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadosResultadosPerdidasGanancias(List<EstadosResultadosPerdidasGanancias> estadosresultadosperdidasgananciassAux) throws Exception {
		//this.estadosresultadosperdidasgananciassAux=estadosresultadosperdidasgananciassAux;
		
		for(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux:estadosresultadosperdidasgananciassAux) {
			if(estadosresultadosperdidasgananciasAux.getIsChanged()) {
				estadosresultadosperdidasgananciasAux.setIsChanged(false);
			}		
			
			if(estadosresultadosperdidasgananciasAux.getIsNew()) {
				estadosresultadosperdidasgananciasAux.setIsNew(false);
			}	
			
			if(estadosresultadosperdidasgananciasAux.getIsDeleted()) {
				estadosresultadosperdidasgananciasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAux) throws Exception {
		//this.estadosresultadosperdidasgananciasAux=estadosresultadosperdidasgananciasAux;
		
			if(estadosresultadosperdidasgananciasAux.getIsChanged()) {
				estadosresultadosperdidasgananciasAux.setIsChanged(false);
			}		
			
			if(estadosresultadosperdidasgananciasAux.getIsNew()) {
				estadosresultadosperdidasgananciasAux.setIsNew(false);
			}	
			
			if(estadosresultadosperdidasgananciasAux.getIsDeleted()) {
				estadosresultadosperdidasgananciasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasAsignar,EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias) throws Exception {
		estadosresultadosperdidasgananciasAsignar.setId(estadosresultadosperdidasganancias.getId());	
		estadosresultadosperdidasgananciasAsignar.setVersionRow(estadosresultadosperdidasganancias.getVersionRow());	
		estadosresultadosperdidasgananciasAsignar.setcodigo(estadosresultadosperdidasganancias.getcodigo());	
		estadosresultadosperdidasgananciasAsignar.setnombre(estadosresultadosperdidasganancias.getnombre());	
		estadosresultadosperdidasgananciasAsignar.setnombre_nivel_cuenta(estadosresultadosperdidasganancias.getnombre_nivel_cuenta());	
		estadosresultadosperdidasgananciasAsignar.setdebito_inicial(estadosresultadosperdidasganancias.getdebito_inicial());	
		estadosresultadosperdidasgananciasAsignar.setcredito_inicial(estadosresultadosperdidasganancias.getcredito_inicial());	
		estadosresultadosperdidasgananciasAsignar.setsaldo_inicial(estadosresultadosperdidasganancias.getsaldo_inicial());	
	}
	
	public static void inicializarEstadosResultadosPerdidasGanancias(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias) throws Exception {
		try {
				estadosresultadosperdidasganancias.setId(0L);	
					
				estadosresultadosperdidasganancias.setcodigo("");	
				estadosresultadosperdidasganancias.setnombre("");	
				estadosresultadosperdidasganancias.setnombre_nivel_cuenta("");	
				estadosresultadosperdidasganancias.setdebito_inicial(0.0);	
				estadosresultadosperdidasganancias.setcredito_inicial(0.0);	
				estadosresultadosperdidasganancias.setsaldo_inicial(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadosResultadosPerdidasGanancias(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDNIVELCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_NOMBRENIVELCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_DEBITOINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_CREDITOINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadosResultadosPerdidasGananciasConstantesFunciones.LABEL_SALDOINICIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadosResultadosPerdidasGanancias(String sTipo,Row row,Workbook workbook,EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getnivelcuenta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getnombre_nivel_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getdebito_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getcredito_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadosresultadosperdidasganancias.getsaldo_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadosResultadosPerdidasGanancias="";
	
	public String getsFinalQueryEstadosResultadosPerdidasGanancias() {
		return this.sFinalQueryEstadosResultadosPerdidasGanancias;
	}
	
	public void setsFinalQueryEstadosResultadosPerdidasGanancias(String sFinalQueryEstadosResultadosPerdidasGanancias) {
		this.sFinalQueryEstadosResultadosPerdidasGanancias= sFinalQueryEstadosResultadosPerdidasGanancias;
	}
	
	public Border resaltarSeleccionarEstadosResultadosPerdidasGanancias=null;
	
	public Border setResaltarSeleccionarEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadosResultadosPerdidasGanancias= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadosResultadosPerdidasGanancias() {
		return this.resaltarSeleccionarEstadosResultadosPerdidasGanancias;
	}
	
	public void setResaltarSeleccionarEstadosResultadosPerdidasGanancias(Border borderResaltarSeleccionarEstadosResultadosPerdidasGanancias) {
		this.resaltarSeleccionarEstadosResultadosPerdidasGanancias= borderResaltarSeleccionarEstadosResultadosPerdidasGanancias;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadosResultadosPerdidasGanancias=null;
	public Boolean mostraridEstadosResultadosPerdidasGanancias=true;
	public Boolean activaridEstadosResultadosPerdidasGanancias=true;

	public Border resaltarid_empresaEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarid_empresaEstadosResultadosPerdidasGanancias=true;
	public Boolean activarid_empresaEstadosResultadosPerdidasGanancias=true;
	public Boolean cargarid_empresaEstadosResultadosPerdidasGanancias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadosResultadosPerdidasGanancias=false;//ConEventDepend=true

	public Border resaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias=true;
	public Boolean activarid_nivel_cuentaEstadosResultadosPerdidasGanancias=true;
	public Boolean cargarid_nivel_cuentaEstadosResultadosPerdidasGanancias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_nivel_cuentaEstadosResultadosPerdidasGanancias=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarid_ejercicioEstadosResultadosPerdidasGanancias=true;
	public Boolean activarid_ejercicioEstadosResultadosPerdidasGanancias=true;
	public Boolean cargarid_ejercicioEstadosResultadosPerdidasGanancias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEstadosResultadosPerdidasGanancias=false;//ConEventDepend=true

	public Border resaltarid_periodoEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarid_periodoEstadosResultadosPerdidasGanancias=true;
	public Boolean activarid_periodoEstadosResultadosPerdidasGanancias=true;
	public Boolean cargarid_periodoEstadosResultadosPerdidasGanancias=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoEstadosResultadosPerdidasGanancias=false;//ConEventDepend=true

	public Border resaltarcodigoEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarcodigoEstadosResultadosPerdidasGanancias=true;
	public Boolean activarcodigoEstadosResultadosPerdidasGanancias=true;

	public Border resaltarnombreEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarnombreEstadosResultadosPerdidasGanancias=true;
	public Boolean activarnombreEstadosResultadosPerdidasGanancias=true;

	public Border resaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias=true;
	public Boolean activarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias=true;

	public Border resaltardebito_inicialEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrardebito_inicialEstadosResultadosPerdidasGanancias=true;
	public Boolean activardebito_inicialEstadosResultadosPerdidasGanancias=true;

	public Border resaltarcredito_inicialEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarcredito_inicialEstadosResultadosPerdidasGanancias=true;
	public Boolean activarcredito_inicialEstadosResultadosPerdidasGanancias=true;

	public Border resaltarsaldo_inicialEstadosResultadosPerdidasGanancias=null;
	public Boolean mostrarsaldo_inicialEstadosResultadosPerdidasGanancias=true;
	public Boolean activarsaldo_inicialEstadosResultadosPerdidasGanancias=true;

	
	

	public Border setResaltaridEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltaridEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadosResultadosPerdidasGanancias() {
		return this.resaltaridEstadosResultadosPerdidasGanancias;
	}

	public void setResaltaridEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltaridEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostraridEstadosResultadosPerdidasGanancias() {
		return this.mostraridEstadosResultadosPerdidasGanancias;
	}

	public void setMostraridEstadosResultadosPerdidasGanancias(Boolean mostraridEstadosResultadosPerdidasGanancias) {
		this.mostraridEstadosResultadosPerdidasGanancias= mostraridEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivaridEstadosResultadosPerdidasGanancias() {
		return this.activaridEstadosResultadosPerdidasGanancias;
	}

	public void setActivaridEstadosResultadosPerdidasGanancias(Boolean activaridEstadosResultadosPerdidasGanancias) {
		this.activaridEstadosResultadosPerdidasGanancias= activaridEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarid_empresaEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadosResultadosPerdidasGanancias() {
		return this.resaltarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarid_empresaEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarid_empresaEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadosResultadosPerdidasGanancias() {
		return this.mostrarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarid_empresaEstadosResultadosPerdidasGanancias(Boolean mostrarid_empresaEstadosResultadosPerdidasGanancias) {
		this.mostrarid_empresaEstadosResultadosPerdidasGanancias= mostrarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarid_empresaEstadosResultadosPerdidasGanancias() {
		return this.activarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public void setActivarid_empresaEstadosResultadosPerdidasGanancias(Boolean activarid_empresaEstadosResultadosPerdidasGanancias) {
		this.activarid_empresaEstadosResultadosPerdidasGanancias= activarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public Boolean getCargarid_empresaEstadosResultadosPerdidasGanancias() {
		return this.cargarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public void setCargarid_empresaEstadosResultadosPerdidasGanancias(Boolean cargarid_empresaEstadosResultadosPerdidasGanancias) {
		this.cargarid_empresaEstadosResultadosPerdidasGanancias= cargarid_empresaEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.resaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.mostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias(Boolean mostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias) {
		this.mostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias= mostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarid_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.activarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setActivarid_nivel_cuentaEstadosResultadosPerdidasGanancias(Boolean activarid_nivel_cuentaEstadosResultadosPerdidasGanancias) {
		this.activarid_nivel_cuentaEstadosResultadosPerdidasGanancias= activarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public Boolean getCargarid_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.cargarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setCargarid_nivel_cuentaEstadosResultadosPerdidasGanancias(Boolean cargarid_nivel_cuentaEstadosResultadosPerdidasGanancias) {
		this.cargarid_nivel_cuentaEstadosResultadosPerdidasGanancias= cargarid_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarid_ejercicioEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEstadosResultadosPerdidasGanancias() {
		return this.resaltarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarid_ejercicioEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarid_ejercicioEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEstadosResultadosPerdidasGanancias() {
		return this.mostrarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarid_ejercicioEstadosResultadosPerdidasGanancias(Boolean mostrarid_ejercicioEstadosResultadosPerdidasGanancias) {
		this.mostrarid_ejercicioEstadosResultadosPerdidasGanancias= mostrarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarid_ejercicioEstadosResultadosPerdidasGanancias() {
		return this.activarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public void setActivarid_ejercicioEstadosResultadosPerdidasGanancias(Boolean activarid_ejercicioEstadosResultadosPerdidasGanancias) {
		this.activarid_ejercicioEstadosResultadosPerdidasGanancias= activarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public Boolean getCargarid_ejercicioEstadosResultadosPerdidasGanancias() {
		return this.cargarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public void setCargarid_ejercicioEstadosResultadosPerdidasGanancias(Boolean cargarid_ejercicioEstadosResultadosPerdidasGanancias) {
		this.cargarid_ejercicioEstadosResultadosPerdidasGanancias= cargarid_ejercicioEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarid_periodoEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarid_periodoEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoEstadosResultadosPerdidasGanancias() {
		return this.resaltarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarid_periodoEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarid_periodoEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarid_periodoEstadosResultadosPerdidasGanancias() {
		return this.mostrarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarid_periodoEstadosResultadosPerdidasGanancias(Boolean mostrarid_periodoEstadosResultadosPerdidasGanancias) {
		this.mostrarid_periodoEstadosResultadosPerdidasGanancias= mostrarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarid_periodoEstadosResultadosPerdidasGanancias() {
		return this.activarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public void setActivarid_periodoEstadosResultadosPerdidasGanancias(Boolean activarid_periodoEstadosResultadosPerdidasGanancias) {
		this.activarid_periodoEstadosResultadosPerdidasGanancias= activarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public Boolean getCargarid_periodoEstadosResultadosPerdidasGanancias() {
		return this.cargarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public void setCargarid_periodoEstadosResultadosPerdidasGanancias(Boolean cargarid_periodoEstadosResultadosPerdidasGanancias) {
		this.cargarid_periodoEstadosResultadosPerdidasGanancias= cargarid_periodoEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarcodigoEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadosResultadosPerdidasGanancias() {
		return this.resaltarcodigoEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarcodigoEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarcodigoEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadosResultadosPerdidasGanancias() {
		return this.mostrarcodigoEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarcodigoEstadosResultadosPerdidasGanancias(Boolean mostrarcodigoEstadosResultadosPerdidasGanancias) {
		this.mostrarcodigoEstadosResultadosPerdidasGanancias= mostrarcodigoEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarcodigoEstadosResultadosPerdidasGanancias() {
		return this.activarcodigoEstadosResultadosPerdidasGanancias;
	}

	public void setActivarcodigoEstadosResultadosPerdidasGanancias(Boolean activarcodigoEstadosResultadosPerdidasGanancias) {
		this.activarcodigoEstadosResultadosPerdidasGanancias= activarcodigoEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarnombreEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarnombreEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadosResultadosPerdidasGanancias() {
		return this.resaltarnombreEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarnombreEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarnombreEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarnombreEstadosResultadosPerdidasGanancias() {
		return this.mostrarnombreEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarnombreEstadosResultadosPerdidasGanancias(Boolean mostrarnombreEstadosResultadosPerdidasGanancias) {
		this.mostrarnombreEstadosResultadosPerdidasGanancias= mostrarnombreEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarnombreEstadosResultadosPerdidasGanancias() {
		return this.activarnombreEstadosResultadosPerdidasGanancias;
	}

	public void setActivarnombreEstadosResultadosPerdidasGanancias(Boolean activarnombreEstadosResultadosPerdidasGanancias) {
		this.activarnombreEstadosResultadosPerdidasGanancias= activarnombreEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.resaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.mostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(Boolean mostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias) {
		this.mostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias= mostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias() {
		return this.activarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public void setActivarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(Boolean activarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias) {
		this.activarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias= activarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltardebito_inicialEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltardebito_inicialEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_inicialEstadosResultadosPerdidasGanancias() {
		return this.resaltardebito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setResaltardebito_inicialEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltardebito_inicialEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrardebito_inicialEstadosResultadosPerdidasGanancias() {
		return this.mostrardebito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setMostrardebito_inicialEstadosResultadosPerdidasGanancias(Boolean mostrardebito_inicialEstadosResultadosPerdidasGanancias) {
		this.mostrardebito_inicialEstadosResultadosPerdidasGanancias= mostrardebito_inicialEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivardebito_inicialEstadosResultadosPerdidasGanancias() {
		return this.activardebito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setActivardebito_inicialEstadosResultadosPerdidasGanancias(Boolean activardebito_inicialEstadosResultadosPerdidasGanancias) {
		this.activardebito_inicialEstadosResultadosPerdidasGanancias= activardebito_inicialEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarcredito_inicialEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarcredito_inicialEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_inicialEstadosResultadosPerdidasGanancias() {
		return this.resaltarcredito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarcredito_inicialEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarcredito_inicialEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarcredito_inicialEstadosResultadosPerdidasGanancias() {
		return this.mostrarcredito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarcredito_inicialEstadosResultadosPerdidasGanancias(Boolean mostrarcredito_inicialEstadosResultadosPerdidasGanancias) {
		this.mostrarcredito_inicialEstadosResultadosPerdidasGanancias= mostrarcredito_inicialEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarcredito_inicialEstadosResultadosPerdidasGanancias() {
		return this.activarcredito_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setActivarcredito_inicialEstadosResultadosPerdidasGanancias(Boolean activarcredito_inicialEstadosResultadosPerdidasGanancias) {
		this.activarcredito_inicialEstadosResultadosPerdidasGanancias= activarcredito_inicialEstadosResultadosPerdidasGanancias;
	}

	public Border setResaltarsaldo_inicialEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadosresultadosperdidasgananciasBeanSwingJInternalFrame.jTtoolBarEstadosResultadosPerdidasGanancias.setBorder(borderResaltar);
		
		this.resaltarsaldo_inicialEstadosResultadosPerdidasGanancias= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_inicialEstadosResultadosPerdidasGanancias() {
		return this.resaltarsaldo_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarsaldo_inicialEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarsaldo_inicialEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public Boolean getMostrarsaldo_inicialEstadosResultadosPerdidasGanancias() {
		return this.mostrarsaldo_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarsaldo_inicialEstadosResultadosPerdidasGanancias(Boolean mostrarsaldo_inicialEstadosResultadosPerdidasGanancias) {
		this.mostrarsaldo_inicialEstadosResultadosPerdidasGanancias= mostrarsaldo_inicialEstadosResultadosPerdidasGanancias;
	}

	public Boolean getActivarsaldo_inicialEstadosResultadosPerdidasGanancias() {
		return this.activarsaldo_inicialEstadosResultadosPerdidasGanancias;
	}

	public void setActivarsaldo_inicialEstadosResultadosPerdidasGanancias(Boolean activarsaldo_inicialEstadosResultadosPerdidasGanancias) {
		this.activarsaldo_inicialEstadosResultadosPerdidasGanancias= activarsaldo_inicialEstadosResultadosPerdidasGanancias;
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
		
		
		this.setMostraridEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarid_empresaEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarid_ejercicioEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarid_periodoEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarcodigoEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarnombreEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrardebito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarcredito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setMostrarsaldo_inicialEstadosResultadosPerdidasGanancias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.ID)) {
				this.setMostraridEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDNIVELCUENTA)) {
				this.setMostrarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setMostrarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL)) {
				this.setMostrardebito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL)) {
				this.setMostrarcredito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL)) {
				this.setMostrarsaldo_inicialEstadosResultadosPerdidasGanancias(esAsigna);
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
		
		
		this.setActivaridEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarid_empresaEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarid_ejercicioEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarid_periodoEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarcodigoEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarnombreEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivardebito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarcredito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setActivarsaldo_inicialEstadosResultadosPerdidasGanancias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.ID)) {
				this.setActivaridEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDNIVELCUENTA)) {
				this.setActivarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setActivarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL)) {
				this.setActivardebito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL)) {
				this.setActivarcredito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL)) {
				this.setActivarsaldo_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarid_empresaEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarid_ejercicioEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarid_periodoEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarcodigoEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarnombreEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltardebito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarcredito_inicialEstadosResultadosPerdidasGanancias(esInicial);
		this.setResaltarsaldo_inicialEstadosResultadosPerdidasGanancias(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.ID)) {
				this.setResaltaridEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDNIVELCUENTA)) {
				this.setResaltarid_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.NOMBRENIVELCUENTA)) {
				this.setResaltarnombre_nivel_cuentaEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.DEBITOINICIAL)) {
				this.setResaltardebito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.CREDITOINICIAL)) {
				this.setResaltarcredito_inicialEstadosResultadosPerdidasGanancias(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadosResultadosPerdidasGananciasConstantesFunciones.SALDOINICIAL)) {
				this.setResaltarsaldo_inicialEstadosResultadosPerdidasGanancias(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias=true;

	public Boolean getMostrarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias() {
		return this.mostrarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias;
	}

	public void setMostrarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias(Boolean visibilidadResaltar) {
		this.mostrarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias=true;

	public Boolean getActivarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias() {
		return this.activarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias;
	}

	public void setActivarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias(Boolean habilitarResaltar) {
		this.activarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias=null;

	public Border getResaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias() {
		return this.resaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias;
	}

	public void setResaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias(Border borderResaltar) {
		this.resaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias= borderResaltar;
	}

	public void setResaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias(ParametroGeneralUsuario parametroGeneralUsuario/*EstadosResultadosPerdidasGananciasBeanSwingJInternalFrame estadosresultadosperdidasgananciasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaEstadosResultadosPerdidasGananciasEstadosResultadosPerdidasGanancias= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}