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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.CentroCostoValorConstantesFunciones;
import com.bydan.erp.inventario.util.CentroCostoValorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CentroCostoValorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CentroCostoValorConstantesFunciones extends CentroCostoValorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CentroCostoValor";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CentroCostoValor"+CentroCostoValorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CentroCostoValorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CentroCostoValorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CentroCostoValorConstantesFunciones.SCHEMA+"_"+CentroCostoValorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoValorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CentroCostoValorConstantesFunciones.SCHEMA+"_"+CentroCostoValorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CentroCostoValorConstantesFunciones.SCHEMA+"_"+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoValorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CentroCostoValorConstantesFunciones.SCHEMA+"_"+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoValorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoValorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoValorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CentroCostoValorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CentroCostoValorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CentroCostoValorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CentroCostoValorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Centro Costo Valores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Centro Costo Valor";
	public static final String SCLASSWEBTITULO_LOWER="Centro Costo Valor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CentroCostoValor";
	public static final String OBJECTNAME="centrocostovalor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="centro_costo_valor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select centrocostovalor from "+CentroCostoValorConstantesFunciones.SPERSISTENCENAME+" centrocostovalor";
	public static String QUERYSELECTNATIVE="select "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".version_row,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_ejercicio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".nombre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".enero,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".febrero,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".marzo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".abril,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".mayo,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".junio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".julio,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".agosto,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".septiembre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".octubre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".noviembre,"+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME+".diciembre from "+CentroCostoValorConstantesFunciones.SCHEMA+"."+CentroCostoValorConstantesFunciones.TABLENAME;//+" as "+CentroCostoValorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CentroCostoValorConstantesFuncionesAdditional centrocostovalorConstantesFuncionesAdditional=null;
	
	public CentroCostoValorConstantesFuncionesAdditional getCentroCostoValorConstantesFuncionesAdditional() {
		return this.centrocostovalorConstantesFuncionesAdditional;
	}
	
	public void setCentroCostoValorConstantesFuncionesAdditional(CentroCostoValorConstantesFuncionesAdditional centrocostovalorConstantesFuncionesAdditional) {
		try {
			this.centrocostovalorConstantesFuncionesAdditional=centrocostovalorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String NOMBRE= "nombre";
    public static final String ENERO= "enero";
    public static final String FEBRERO= "febrero";
    public static final String MARZO= "marzo";
    public static final String ABRIL= "abril";
    public static final String MAYO= "mayo";
    public static final String JUNIO= "junio";
    public static final String JULIO= "julio";
    public static final String AGOSTO= "agosto";
    public static final String SEPTIEMBRE= "septiembre";
    public static final String OCTUBRE= "octubre";
    public static final String NOVIEMBRE= "noviembre";
    public static final String DICIEMBRE= "diciembre";
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
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ENERO= "Enero";
		public static final String LABEL_ENERO_LOWER= "Enero";
    	public static final String LABEL_FEBRERO= "Febrero";
		public static final String LABEL_FEBRERO_LOWER= "Febrero";
    	public static final String LABEL_MARZO= "Marzo";
		public static final String LABEL_MARZO_LOWER= "Marzo";
    	public static final String LABEL_ABRIL= "Abril";
		public static final String LABEL_ABRIL_LOWER= "Abril";
    	public static final String LABEL_MAYO= "Mayo";
		public static final String LABEL_MAYO_LOWER= "Mayo";
    	public static final String LABEL_JUNIO= "Junio";
		public static final String LABEL_JUNIO_LOWER= "Junio";
    	public static final String LABEL_JULIO= "Julio";
		public static final String LABEL_JULIO_LOWER= "Julio";
    	public static final String LABEL_AGOSTO= "Agosto";
		public static final String LABEL_AGOSTO_LOWER= "Agosto";
    	public static final String LABEL_SEPTIEMBRE= "Septiembre";
		public static final String LABEL_SEPTIEMBRE_LOWER= "Septiembre";
    	public static final String LABEL_OCTUBRE= "Octubre";
		public static final String LABEL_OCTUBRE_LOWER= "Octubre";
    	public static final String LABEL_NOVIEMBRE= "Noviembre";
		public static final String LABEL_NOVIEMBRE_LOWER= "Noviembre";
    	public static final String LABEL_DICIEMBRE= "Diciembre";
		public static final String LABEL_DICIEMBRE_LOWER= "Diciembre";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCentroCostoValorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.IDEMPRESA)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.NOMBRE)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.ENERO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_ENERO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.FEBRERO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_FEBRERO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.MARZO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_MARZO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.ABRIL)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_ABRIL;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.MAYO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_MAYO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.JUNIO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_JUNIO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.JULIO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_JULIO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.AGOSTO)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_AGOSTO;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.SEPTIEMBRE)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.OCTUBRE)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_OCTUBRE;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.NOVIEMBRE)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE;}
		if(sNombreColumna.equals(CentroCostoValorConstantesFunciones.DICIEMBRE)) {sLabelColumna=CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCentroCostoValorDescripcion(CentroCostoValor centrocostovalor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(centrocostovalor !=null/* && centrocostovalor.getId()!=0*/) {
			sDescripcion=centrocostovalor.getnombre();//centrocostovalorcentrocostovalor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCentroCostoValorDescripcionDetallado(CentroCostoValor centrocostovalor) {
		String sDescripcion="";
			
		sDescripcion+=CentroCostoValorConstantesFunciones.ID+"=";
		sDescripcion+=centrocostovalor.getId().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=centrocostovalor.getVersionRow().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=centrocostovalor.getid_empresa().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=centrocostovalor.getid_sucursal().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=centrocostovalor.getid_ejercicio().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=centrocostovalor.getid_centro_costo().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=centrocostovalor.getnombre()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.ENERO+"=";
		sDescripcion+=centrocostovalor.getenero().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.FEBRERO+"=";
		sDescripcion+=centrocostovalor.getfebrero().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.MARZO+"=";
		sDescripcion+=centrocostovalor.getmarzo().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.ABRIL+"=";
		sDescripcion+=centrocostovalor.getabril().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.MAYO+"=";
		sDescripcion+=centrocostovalor.getmayo().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.JUNIO+"=";
		sDescripcion+=centrocostovalor.getjunio().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.JULIO+"=";
		sDescripcion+=centrocostovalor.getjulio().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.AGOSTO+"=";
		sDescripcion+=centrocostovalor.getagosto().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.SEPTIEMBRE+"=";
		sDescripcion+=centrocostovalor.getseptiembre().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.OCTUBRE+"=";
		sDescripcion+=centrocostovalor.getoctubre().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.NOVIEMBRE+"=";
		sDescripcion+=centrocostovalor.getnoviembre().toString()+",";
		sDescripcion+=CentroCostoValorConstantesFunciones.DICIEMBRE+"=";
		sDescripcion+=centrocostovalor.getdiciembre().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCentroCostoValorDescripcion(CentroCostoValor centrocostovalor,String sValor) throws Exception {			
		if(centrocostovalor !=null) {
			centrocostovalor.setnombre(sValor);//centrocostovalorcentrocostovalor.getId().toString();
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCentroCostoValor(CentroCostoValor centrocostovalor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		centrocostovalor.setnombre(centrocostovalor.getnombre().trim());
	}
	
	public static void quitarEspaciosCentroCostoValors(List<CentroCostoValor> centrocostovalors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroCostoValor centrocostovalor: centrocostovalors) {
			centrocostovalor.setnombre(centrocostovalor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoValor(CentroCostoValor centrocostovalor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && centrocostovalor.getConCambioAuxiliar()) {
			centrocostovalor.setIsDeleted(centrocostovalor.getIsDeletedAuxiliar());	
			centrocostovalor.setIsNew(centrocostovalor.getIsNewAuxiliar());	
			centrocostovalor.setIsChanged(centrocostovalor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			centrocostovalor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			centrocostovalor.setIsDeletedAuxiliar(false);	
			centrocostovalor.setIsNewAuxiliar(false);	
			centrocostovalor.setIsChangedAuxiliar(false);
			
			centrocostovalor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoValors(List<CentroCostoValor> centrocostovalors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CentroCostoValor centrocostovalor : centrocostovalors) {
			if(conAsignarBase && centrocostovalor.getConCambioAuxiliar()) {
				centrocostovalor.setIsDeleted(centrocostovalor.getIsDeletedAuxiliar());	
				centrocostovalor.setIsNew(centrocostovalor.getIsNewAuxiliar());	
				centrocostovalor.setIsChanged(centrocostovalor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				centrocostovalor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				centrocostovalor.setIsDeletedAuxiliar(false);	
				centrocostovalor.setIsNewAuxiliar(false);	
				centrocostovalor.setIsChangedAuxiliar(false);
				
				centrocostovalor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCentroCostoValor(CentroCostoValor centrocostovalor,Boolean conEnteros) throws Exception  {
		centrocostovalor.setenero(0.0);
		centrocostovalor.setfebrero(0.0);
		centrocostovalor.setmarzo(0.0);
		centrocostovalor.setabril(0.0);
		centrocostovalor.setmayo(0.0);
		centrocostovalor.setjunio(0.0);
		centrocostovalor.setjulio(0.0);
		centrocostovalor.setagosto(0.0);
		centrocostovalor.setseptiembre(0.0);
		centrocostovalor.setoctubre(0.0);
		centrocostovalor.setnoviembre(0.0);
		centrocostovalor.setdiciembre(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCentroCostoValors(List<CentroCostoValor> centrocostovalors,Boolean conEnteros) throws Exception  {
		
		for(CentroCostoValor centrocostovalor: centrocostovalors) {
			centrocostovalor.setenero(0.0);
			centrocostovalor.setfebrero(0.0);
			centrocostovalor.setmarzo(0.0);
			centrocostovalor.setabril(0.0);
			centrocostovalor.setmayo(0.0);
			centrocostovalor.setjunio(0.0);
			centrocostovalor.setjulio(0.0);
			centrocostovalor.setagosto(0.0);
			centrocostovalor.setseptiembre(0.0);
			centrocostovalor.setoctubre(0.0);
			centrocostovalor.setnoviembre(0.0);
			centrocostovalor.setdiciembre(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCentroCostoValor(List<CentroCostoValor> centrocostovalors,CentroCostoValor centrocostovalorAux) throws Exception  {
		CentroCostoValorConstantesFunciones.InicializarValoresCentroCostoValor(centrocostovalorAux,true);
		
		for(CentroCostoValor centrocostovalor: centrocostovalors) {
			if(centrocostovalor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			centrocostovalorAux.setenero(centrocostovalorAux.getenero()+centrocostovalor.getenero());			
			centrocostovalorAux.setfebrero(centrocostovalorAux.getfebrero()+centrocostovalor.getfebrero());			
			centrocostovalorAux.setmarzo(centrocostovalorAux.getmarzo()+centrocostovalor.getmarzo());			
			centrocostovalorAux.setabril(centrocostovalorAux.getabril()+centrocostovalor.getabril());			
			centrocostovalorAux.setmayo(centrocostovalorAux.getmayo()+centrocostovalor.getmayo());			
			centrocostovalorAux.setjunio(centrocostovalorAux.getjunio()+centrocostovalor.getjunio());			
			centrocostovalorAux.setjulio(centrocostovalorAux.getjulio()+centrocostovalor.getjulio());			
			centrocostovalorAux.setagosto(centrocostovalorAux.getagosto()+centrocostovalor.getagosto());			
			centrocostovalorAux.setseptiembre(centrocostovalorAux.getseptiembre()+centrocostovalor.getseptiembre());			
			centrocostovalorAux.setoctubre(centrocostovalorAux.getoctubre()+centrocostovalor.getoctubre());			
			centrocostovalorAux.setnoviembre(centrocostovalorAux.getnoviembre()+centrocostovalor.getnoviembre());			
			centrocostovalorAux.setdiciembre(centrocostovalorAux.getdiciembre()+centrocostovalor.getdiciembre());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoValor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CentroCostoValorConstantesFunciones.getArrayColumnasGlobalesCentroCostoValor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoValor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoValorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoValorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoValorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoValorConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoValorConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoValorConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCentroCostoValor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroCostoValor> centrocostovalors,CentroCostoValor centrocostovalor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroCostoValor centrocostovalorAux: centrocostovalors) {
			if(centrocostovalorAux!=null && centrocostovalor!=null) {
				if((centrocostovalorAux.getId()==null && centrocostovalor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(centrocostovalorAux.getId()!=null && centrocostovalor.getId()!=null){
					if(centrocostovalorAux.getId().equals(centrocostovalor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroCostoValor(List<CentroCostoValor> centrocostovalors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double eneroTotal=0.0;
		Double febreroTotal=0.0;
		Double marzoTotal=0.0;
		Double abrilTotal=0.0;
		Double mayoTotal=0.0;
		Double junioTotal=0.0;
		Double julioTotal=0.0;
		Double agostoTotal=0.0;
		Double septiembreTotal=0.0;
		Double octubreTotal=0.0;
		Double noviembreTotal=0.0;
		Double diciembreTotal=0.0;
	
		for(CentroCostoValor centrocostovalor: centrocostovalors) {			
			if(centrocostovalor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			eneroTotal+=centrocostovalor.getenero();
			febreroTotal+=centrocostovalor.getfebrero();
			marzoTotal+=centrocostovalor.getmarzo();
			abrilTotal+=centrocostovalor.getabril();
			mayoTotal+=centrocostovalor.getmayo();
			junioTotal+=centrocostovalor.getjunio();
			julioTotal+=centrocostovalor.getjulio();
			agostoTotal+=centrocostovalor.getagosto();
			septiembreTotal+=centrocostovalor.getseptiembre();
			octubreTotal+=centrocostovalor.getoctubre();
			noviembreTotal+=centrocostovalor.getnoviembre();
			diciembreTotal+=centrocostovalor.getdiciembre();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.ENERO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_ENERO);
		datoGeneral.setdValorDouble(eneroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.FEBRERO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_FEBRERO);
		datoGeneral.setdValorDouble(febreroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.MARZO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_MARZO);
		datoGeneral.setdValorDouble(marzoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.ABRIL);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_ABRIL);
		datoGeneral.setdValorDouble(abrilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.MAYO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_MAYO);
		datoGeneral.setdValorDouble(mayoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.JUNIO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_JUNIO);
		datoGeneral.setdValorDouble(junioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.JULIO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_JULIO);
		datoGeneral.setdValorDouble(julioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.AGOSTO);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_AGOSTO);
		datoGeneral.setdValorDouble(agostoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.SEPTIEMBRE);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE);
		datoGeneral.setdValorDouble(septiembreTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.OCTUBRE);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_OCTUBRE);
		datoGeneral.setdValorDouble(octubreTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.NOVIEMBRE);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE);
		datoGeneral.setdValorDouble(noviembreTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CentroCostoValorConstantesFunciones.DICIEMBRE);
		datoGeneral.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE);
		datoGeneral.setdValorDouble(diciembreTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCentroCostoValor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_ID, CentroCostoValorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_VERSIONROW, CentroCostoValorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_IDEMPRESA, CentroCostoValorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_IDSUCURSAL, CentroCostoValorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_IDEJERCICIO, CentroCostoValorConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_IDCENTROCOSTO, CentroCostoValorConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_NOMBRE, CentroCostoValorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_ENERO, CentroCostoValorConstantesFunciones.ENERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_FEBRERO, CentroCostoValorConstantesFunciones.FEBRERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_MARZO, CentroCostoValorConstantesFunciones.MARZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_ABRIL, CentroCostoValorConstantesFunciones.ABRIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_MAYO, CentroCostoValorConstantesFunciones.MAYO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_JUNIO, CentroCostoValorConstantesFunciones.JUNIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_JULIO, CentroCostoValorConstantesFunciones.JULIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_AGOSTO, CentroCostoValorConstantesFunciones.AGOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE, CentroCostoValorConstantesFunciones.SEPTIEMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_OCTUBRE, CentroCostoValorConstantesFunciones.OCTUBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE, CentroCostoValorConstantesFunciones.NOVIEMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE, CentroCostoValorConstantesFunciones.DICIEMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCentroCostoValor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.ENERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.FEBRERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.MARZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.ABRIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.MAYO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.JUNIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.JULIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.AGOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.SEPTIEMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.OCTUBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.NOVIEMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoValorConstantesFunciones.DICIEMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoValor() throws Exception  {
		return CentroCostoValorConstantesFunciones.getTiposSeleccionarCentroCostoValor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoValor(Boolean conFk) throws Exception  {
		return CentroCostoValorConstantesFunciones.getTiposSeleccionarCentroCostoValor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoValor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_ENERO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_ENERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_FEBRERO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_FEBRERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_MARZO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_MARZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_ABRIL);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_ABRIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_MAYO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_MAYO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_JUNIO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_JUNIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_JULIO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_JULIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_AGOSTO);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_AGOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_OCTUBRE);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_OCTUBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE);
			reporte.setsDescripcion(CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCentroCostoValor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoValor(CentroCostoValor centrocostovalorAux) throws Exception {
		
			centrocostovalorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostovalorAux.getEmpresa()));
			centrocostovalorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostovalorAux.getSucursal()));
			centrocostovalorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(centrocostovalorAux.getEjercicio()));
			centrocostovalorAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostovalorAux.getCentroCosto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoValor(List<CentroCostoValor> centrocostovalorsTemp) throws Exception {
		for(CentroCostoValor centrocostovalorAux:centrocostovalorsTemp) {
			
			centrocostovalorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostovalorAux.getEmpresa()));
			centrocostovalorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostovalorAux.getSucursal()));
			centrocostovalorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(centrocostovalorAux.getEjercicio()));
			centrocostovalorAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostovalorAux.getCentroCosto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCostoValor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(CentroCosto.class));
				
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCentroCostoValor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoValor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoValorConstantesFunciones.getClassesRelationshipsOfCentroCostoValor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoValor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoValor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoValorConstantesFunciones.getClassesRelationshipsFromStringsOfCentroCostoValor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoValor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CentroCostoValor centrocostovalor,List<CentroCostoValor> centrocostovalors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CentroCostoValor centrocostovalorEncontrado=null;
			
			for(CentroCostoValor centrocostovalorLocal:centrocostovalors) {
				if(centrocostovalorLocal.getId().equals(centrocostovalor.getId())) {
					centrocostovalorEncontrado=centrocostovalorLocal;
					
					centrocostovalorLocal.setIsChanged(centrocostovalor.getIsChanged());
					centrocostovalorLocal.setIsNew(centrocostovalor.getIsNew());
					centrocostovalorLocal.setIsDeleted(centrocostovalor.getIsDeleted());
					
					centrocostovalorLocal.setGeneralEntityOriginal(centrocostovalor.getGeneralEntityOriginal());
					
					centrocostovalorLocal.setId(centrocostovalor.getId());	
					centrocostovalorLocal.setVersionRow(centrocostovalor.getVersionRow());	
					centrocostovalorLocal.setid_empresa(centrocostovalor.getid_empresa());	
					centrocostovalorLocal.setid_sucursal(centrocostovalor.getid_sucursal());	
					centrocostovalorLocal.setid_ejercicio(centrocostovalor.getid_ejercicio());	
					centrocostovalorLocal.setid_centro_costo(centrocostovalor.getid_centro_costo());	
					centrocostovalorLocal.setnombre(centrocostovalor.getnombre());	
					centrocostovalorLocal.setenero(centrocostovalor.getenero());	
					centrocostovalorLocal.setfebrero(centrocostovalor.getfebrero());	
					centrocostovalorLocal.setmarzo(centrocostovalor.getmarzo());	
					centrocostovalorLocal.setabril(centrocostovalor.getabril());	
					centrocostovalorLocal.setmayo(centrocostovalor.getmayo());	
					centrocostovalorLocal.setjunio(centrocostovalor.getjunio());	
					centrocostovalorLocal.setjulio(centrocostovalor.getjulio());	
					centrocostovalorLocal.setagosto(centrocostovalor.getagosto());	
					centrocostovalorLocal.setseptiembre(centrocostovalor.getseptiembre());	
					centrocostovalorLocal.setoctubre(centrocostovalor.getoctubre());	
					centrocostovalorLocal.setnoviembre(centrocostovalor.getnoviembre());	
					centrocostovalorLocal.setdiciembre(centrocostovalor.getdiciembre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!centrocostovalor.getIsDeleted()) {
				if(!existe) {
					centrocostovalors.add(centrocostovalor);
				}
			} else {
				if(centrocostovalorEncontrado!=null && permiteQuitar)  {
					centrocostovalors.remove(centrocostovalorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CentroCostoValor centrocostovalor,List<CentroCostoValor> centrocostovalors) throws Exception {
		try	{			
			for(CentroCostoValor centrocostovalorLocal:centrocostovalors) {
				if(centrocostovalorLocal.getId().equals(centrocostovalor.getId())) {
					centrocostovalorLocal.setIsSelected(centrocostovalor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCentroCostoValor(List<CentroCostoValor> centrocostovalorsAux) throws Exception {
		//this.centrocostovalorsAux=centrocostovalorsAux;
		
		for(CentroCostoValor centrocostovalorAux:centrocostovalorsAux) {
			if(centrocostovalorAux.getIsChanged()) {
				centrocostovalorAux.setIsChanged(false);
			}		
			
			if(centrocostovalorAux.getIsNew()) {
				centrocostovalorAux.setIsNew(false);
			}	
			
			if(centrocostovalorAux.getIsDeleted()) {
				centrocostovalorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCentroCostoValor(CentroCostoValor centrocostovalorAux) throws Exception {
		//this.centrocostovalorAux=centrocostovalorAux;
		
			if(centrocostovalorAux.getIsChanged()) {
				centrocostovalorAux.setIsChanged(false);
			}		
			
			if(centrocostovalorAux.getIsNew()) {
				centrocostovalorAux.setIsNew(false);
			}	
			
			if(centrocostovalorAux.getIsDeleted()) {
				centrocostovalorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CentroCostoValor centrocostovalorAsignar,CentroCostoValor centrocostovalor) throws Exception {
		centrocostovalorAsignar.setId(centrocostovalor.getId());	
		centrocostovalorAsignar.setVersionRow(centrocostovalor.getVersionRow());	
		centrocostovalorAsignar.setid_empresa(centrocostovalor.getid_empresa());
		centrocostovalorAsignar.setempresa_descripcion(centrocostovalor.getempresa_descripcion());	
		centrocostovalorAsignar.setid_sucursal(centrocostovalor.getid_sucursal());
		centrocostovalorAsignar.setsucursal_descripcion(centrocostovalor.getsucursal_descripcion());	
		centrocostovalorAsignar.setid_ejercicio(centrocostovalor.getid_ejercicio());
		centrocostovalorAsignar.setejercicio_descripcion(centrocostovalor.getejercicio_descripcion());	
		centrocostovalorAsignar.setid_centro_costo(centrocostovalor.getid_centro_costo());
		centrocostovalorAsignar.setcentrocosto_descripcion(centrocostovalor.getcentrocosto_descripcion());	
		centrocostovalorAsignar.setnombre(centrocostovalor.getnombre());	
		centrocostovalorAsignar.setenero(centrocostovalor.getenero());	
		centrocostovalorAsignar.setfebrero(centrocostovalor.getfebrero());	
		centrocostovalorAsignar.setmarzo(centrocostovalor.getmarzo());	
		centrocostovalorAsignar.setabril(centrocostovalor.getabril());	
		centrocostovalorAsignar.setmayo(centrocostovalor.getmayo());	
		centrocostovalorAsignar.setjunio(centrocostovalor.getjunio());	
		centrocostovalorAsignar.setjulio(centrocostovalor.getjulio());	
		centrocostovalorAsignar.setagosto(centrocostovalor.getagosto());	
		centrocostovalorAsignar.setseptiembre(centrocostovalor.getseptiembre());	
		centrocostovalorAsignar.setoctubre(centrocostovalor.getoctubre());	
		centrocostovalorAsignar.setnoviembre(centrocostovalor.getnoviembre());	
		centrocostovalorAsignar.setdiciembre(centrocostovalor.getdiciembre());	
	}
	
	public static void inicializarCentroCostoValor(CentroCostoValor centrocostovalor) throws Exception {
		try {
				centrocostovalor.setId(0L);	
					
				centrocostovalor.setid_empresa(-1L);	
				centrocostovalor.setid_sucursal(-1L);	
				centrocostovalor.setid_ejercicio(-1L);	
				centrocostovalor.setid_centro_costo(null);	
				centrocostovalor.setnombre("");	
				centrocostovalor.setenero(0.0);	
				centrocostovalor.setfebrero(0.0);	
				centrocostovalor.setmarzo(0.0);	
				centrocostovalor.setabril(0.0);	
				centrocostovalor.setmayo(0.0);	
				centrocostovalor.setjunio(0.0);	
				centrocostovalor.setjulio(0.0);	
				centrocostovalor.setagosto(0.0);	
				centrocostovalor.setseptiembre(0.0);	
				centrocostovalor.setoctubre(0.0);	
				centrocostovalor.setnoviembre(0.0);	
				centrocostovalor.setdiciembre(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCentroCostoValor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_ENERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_FEBRERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_MARZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_ABRIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_MAYO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_JUNIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_JULIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_AGOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_SEPTIEMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_OCTUBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_NOVIEMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoValorConstantesFunciones.LABEL_DICIEMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCentroCostoValor(String sTipo,Row row,Workbook workbook,CentroCostoValor centrocostovalor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getenero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getfebrero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getmarzo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getabril());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getmayo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getjunio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getjulio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getagosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getseptiembre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getoctubre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getnoviembre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostovalor.getdiciembre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCentroCostoValor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCentroCostoValor() {
		return this.sFinalQueryCentroCostoValor;
	}
	
	public void setsFinalQueryCentroCostoValor(String sFinalQueryCentroCostoValor) {
		this.sFinalQueryCentroCostoValor= sFinalQueryCentroCostoValor;
	}
	
	public Border resaltarSeleccionarCentroCostoValor=null;
	
	public Border setResaltarSeleccionarCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCentroCostoValor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCentroCostoValor() {
		return this.resaltarSeleccionarCentroCostoValor;
	}
	
	public void setResaltarSeleccionarCentroCostoValor(Border borderResaltarSeleccionarCentroCostoValor) {
		this.resaltarSeleccionarCentroCostoValor= borderResaltarSeleccionarCentroCostoValor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCentroCostoValor=null;
	public Boolean mostraridCentroCostoValor=true;
	public Boolean activaridCentroCostoValor=true;

	public Border resaltarid_empresaCentroCostoValor=null;
	public Boolean mostrarid_empresaCentroCostoValor=true;
	public Boolean activarid_empresaCentroCostoValor=true;
	public Boolean cargarid_empresaCentroCostoValor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCentroCostoValor=false;//ConEventDepend=true

	public Border resaltarid_sucursalCentroCostoValor=null;
	public Boolean mostrarid_sucursalCentroCostoValor=true;
	public Boolean activarid_sucursalCentroCostoValor=true;
	public Boolean cargarid_sucursalCentroCostoValor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCentroCostoValor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCentroCostoValor=null;
	public Boolean mostrarid_ejercicioCentroCostoValor=true;
	public Boolean activarid_ejercicioCentroCostoValor=true;
	public Boolean cargarid_ejercicioCentroCostoValor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCentroCostoValor=false;//ConEventDepend=true

	public Border resaltarid_centro_costoCentroCostoValor=null;
	public Boolean mostrarid_centro_costoCentroCostoValor=true;
	public Boolean activarid_centro_costoCentroCostoValor=true;
	public Boolean cargarid_centro_costoCentroCostoValor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCentroCostoValor=false;//ConEventDepend=true

	public Border resaltarnombreCentroCostoValor=null;
	public Boolean mostrarnombreCentroCostoValor=true;
	public Boolean activarnombreCentroCostoValor=true;

	public Border resaltareneroCentroCostoValor=null;
	public Boolean mostrareneroCentroCostoValor=true;
	public Boolean activareneroCentroCostoValor=true;

	public Border resaltarfebreroCentroCostoValor=null;
	public Boolean mostrarfebreroCentroCostoValor=true;
	public Boolean activarfebreroCentroCostoValor=true;

	public Border resaltarmarzoCentroCostoValor=null;
	public Boolean mostrarmarzoCentroCostoValor=true;
	public Boolean activarmarzoCentroCostoValor=true;

	public Border resaltarabrilCentroCostoValor=null;
	public Boolean mostrarabrilCentroCostoValor=true;
	public Boolean activarabrilCentroCostoValor=true;

	public Border resaltarmayoCentroCostoValor=null;
	public Boolean mostrarmayoCentroCostoValor=true;
	public Boolean activarmayoCentroCostoValor=true;

	public Border resaltarjunioCentroCostoValor=null;
	public Boolean mostrarjunioCentroCostoValor=true;
	public Boolean activarjunioCentroCostoValor=true;

	public Border resaltarjulioCentroCostoValor=null;
	public Boolean mostrarjulioCentroCostoValor=true;
	public Boolean activarjulioCentroCostoValor=true;

	public Border resaltaragostoCentroCostoValor=null;
	public Boolean mostraragostoCentroCostoValor=true;
	public Boolean activaragostoCentroCostoValor=true;

	public Border resaltarseptiembreCentroCostoValor=null;
	public Boolean mostrarseptiembreCentroCostoValor=true;
	public Boolean activarseptiembreCentroCostoValor=true;

	public Border resaltaroctubreCentroCostoValor=null;
	public Boolean mostraroctubreCentroCostoValor=true;
	public Boolean activaroctubreCentroCostoValor=true;

	public Border resaltarnoviembreCentroCostoValor=null;
	public Boolean mostrarnoviembreCentroCostoValor=true;
	public Boolean activarnoviembreCentroCostoValor=true;

	public Border resaltardiciembreCentroCostoValor=null;
	public Boolean mostrardiciembreCentroCostoValor=true;
	public Boolean activardiciembreCentroCostoValor=true;

	
	

	public Border setResaltaridCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltaridCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCentroCostoValor() {
		return this.resaltaridCentroCostoValor;
	}

	public void setResaltaridCentroCostoValor(Border borderResaltar) {
		this.resaltaridCentroCostoValor= borderResaltar;
	}

	public Boolean getMostraridCentroCostoValor() {
		return this.mostraridCentroCostoValor;
	}

	public void setMostraridCentroCostoValor(Boolean mostraridCentroCostoValor) {
		this.mostraridCentroCostoValor= mostraridCentroCostoValor;
	}

	public Boolean getActivaridCentroCostoValor() {
		return this.activaridCentroCostoValor;
	}

	public void setActivaridCentroCostoValor(Boolean activaridCentroCostoValor) {
		this.activaridCentroCostoValor= activaridCentroCostoValor;
	}

	public Border setResaltarid_empresaCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarid_empresaCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCentroCostoValor() {
		return this.resaltarid_empresaCentroCostoValor;
	}

	public void setResaltarid_empresaCentroCostoValor(Border borderResaltar) {
		this.resaltarid_empresaCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarid_empresaCentroCostoValor() {
		return this.mostrarid_empresaCentroCostoValor;
	}

	public void setMostrarid_empresaCentroCostoValor(Boolean mostrarid_empresaCentroCostoValor) {
		this.mostrarid_empresaCentroCostoValor= mostrarid_empresaCentroCostoValor;
	}

	public Boolean getActivarid_empresaCentroCostoValor() {
		return this.activarid_empresaCentroCostoValor;
	}

	public void setActivarid_empresaCentroCostoValor(Boolean activarid_empresaCentroCostoValor) {
		this.activarid_empresaCentroCostoValor= activarid_empresaCentroCostoValor;
	}

	public Boolean getCargarid_empresaCentroCostoValor() {
		return this.cargarid_empresaCentroCostoValor;
	}

	public void setCargarid_empresaCentroCostoValor(Boolean cargarid_empresaCentroCostoValor) {
		this.cargarid_empresaCentroCostoValor= cargarid_empresaCentroCostoValor;
	}

	public Border setResaltarid_sucursalCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCentroCostoValor() {
		return this.resaltarid_sucursalCentroCostoValor;
	}

	public void setResaltarid_sucursalCentroCostoValor(Border borderResaltar) {
		this.resaltarid_sucursalCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCentroCostoValor() {
		return this.mostrarid_sucursalCentroCostoValor;
	}

	public void setMostrarid_sucursalCentroCostoValor(Boolean mostrarid_sucursalCentroCostoValor) {
		this.mostrarid_sucursalCentroCostoValor= mostrarid_sucursalCentroCostoValor;
	}

	public Boolean getActivarid_sucursalCentroCostoValor() {
		return this.activarid_sucursalCentroCostoValor;
	}

	public void setActivarid_sucursalCentroCostoValor(Boolean activarid_sucursalCentroCostoValor) {
		this.activarid_sucursalCentroCostoValor= activarid_sucursalCentroCostoValor;
	}

	public Boolean getCargarid_sucursalCentroCostoValor() {
		return this.cargarid_sucursalCentroCostoValor;
	}

	public void setCargarid_sucursalCentroCostoValor(Boolean cargarid_sucursalCentroCostoValor) {
		this.cargarid_sucursalCentroCostoValor= cargarid_sucursalCentroCostoValor;
	}

	public Border setResaltarid_ejercicioCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCentroCostoValor() {
		return this.resaltarid_ejercicioCentroCostoValor;
	}

	public void setResaltarid_ejercicioCentroCostoValor(Border borderResaltar) {
		this.resaltarid_ejercicioCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCentroCostoValor() {
		return this.mostrarid_ejercicioCentroCostoValor;
	}

	public void setMostrarid_ejercicioCentroCostoValor(Boolean mostrarid_ejercicioCentroCostoValor) {
		this.mostrarid_ejercicioCentroCostoValor= mostrarid_ejercicioCentroCostoValor;
	}

	public Boolean getActivarid_ejercicioCentroCostoValor() {
		return this.activarid_ejercicioCentroCostoValor;
	}

	public void setActivarid_ejercicioCentroCostoValor(Boolean activarid_ejercicioCentroCostoValor) {
		this.activarid_ejercicioCentroCostoValor= activarid_ejercicioCentroCostoValor;
	}

	public Boolean getCargarid_ejercicioCentroCostoValor() {
		return this.cargarid_ejercicioCentroCostoValor;
	}

	public void setCargarid_ejercicioCentroCostoValor(Boolean cargarid_ejercicioCentroCostoValor) {
		this.cargarid_ejercicioCentroCostoValor= cargarid_ejercicioCentroCostoValor;
	}

	public Border setResaltarid_centro_costoCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCentroCostoValor() {
		return this.resaltarid_centro_costoCentroCostoValor;
	}

	public void setResaltarid_centro_costoCentroCostoValor(Border borderResaltar) {
		this.resaltarid_centro_costoCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCentroCostoValor() {
		return this.mostrarid_centro_costoCentroCostoValor;
	}

	public void setMostrarid_centro_costoCentroCostoValor(Boolean mostrarid_centro_costoCentroCostoValor) {
		this.mostrarid_centro_costoCentroCostoValor= mostrarid_centro_costoCentroCostoValor;
	}

	public Boolean getActivarid_centro_costoCentroCostoValor() {
		return this.activarid_centro_costoCentroCostoValor;
	}

	public void setActivarid_centro_costoCentroCostoValor(Boolean activarid_centro_costoCentroCostoValor) {
		this.activarid_centro_costoCentroCostoValor= activarid_centro_costoCentroCostoValor;
	}

	public Boolean getCargarid_centro_costoCentroCostoValor() {
		return this.cargarid_centro_costoCentroCostoValor;
	}

	public void setCargarid_centro_costoCentroCostoValor(Boolean cargarid_centro_costoCentroCostoValor) {
		this.cargarid_centro_costoCentroCostoValor= cargarid_centro_costoCentroCostoValor;
	}

	public Border setResaltarnombreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarnombreCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCentroCostoValor() {
		return this.resaltarnombreCentroCostoValor;
	}

	public void setResaltarnombreCentroCostoValor(Border borderResaltar) {
		this.resaltarnombreCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarnombreCentroCostoValor() {
		return this.mostrarnombreCentroCostoValor;
	}

	public void setMostrarnombreCentroCostoValor(Boolean mostrarnombreCentroCostoValor) {
		this.mostrarnombreCentroCostoValor= mostrarnombreCentroCostoValor;
	}

	public Boolean getActivarnombreCentroCostoValor() {
		return this.activarnombreCentroCostoValor;
	}

	public void setActivarnombreCentroCostoValor(Boolean activarnombreCentroCostoValor) {
		this.activarnombreCentroCostoValor= activarnombreCentroCostoValor;
	}

	public Border setResaltareneroCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltareneroCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltareneroCentroCostoValor() {
		return this.resaltareneroCentroCostoValor;
	}

	public void setResaltareneroCentroCostoValor(Border borderResaltar) {
		this.resaltareneroCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrareneroCentroCostoValor() {
		return this.mostrareneroCentroCostoValor;
	}

	public void setMostrareneroCentroCostoValor(Boolean mostrareneroCentroCostoValor) {
		this.mostrareneroCentroCostoValor= mostrareneroCentroCostoValor;
	}

	public Boolean getActivareneroCentroCostoValor() {
		return this.activareneroCentroCostoValor;
	}

	public void setActivareneroCentroCostoValor(Boolean activareneroCentroCostoValor) {
		this.activareneroCentroCostoValor= activareneroCentroCostoValor;
	}

	public Border setResaltarfebreroCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarfebreroCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfebreroCentroCostoValor() {
		return this.resaltarfebreroCentroCostoValor;
	}

	public void setResaltarfebreroCentroCostoValor(Border borderResaltar) {
		this.resaltarfebreroCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarfebreroCentroCostoValor() {
		return this.mostrarfebreroCentroCostoValor;
	}

	public void setMostrarfebreroCentroCostoValor(Boolean mostrarfebreroCentroCostoValor) {
		this.mostrarfebreroCentroCostoValor= mostrarfebreroCentroCostoValor;
	}

	public Boolean getActivarfebreroCentroCostoValor() {
		return this.activarfebreroCentroCostoValor;
	}

	public void setActivarfebreroCentroCostoValor(Boolean activarfebreroCentroCostoValor) {
		this.activarfebreroCentroCostoValor= activarfebreroCentroCostoValor;
	}

	public Border setResaltarmarzoCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarmarzoCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarzoCentroCostoValor() {
		return this.resaltarmarzoCentroCostoValor;
	}

	public void setResaltarmarzoCentroCostoValor(Border borderResaltar) {
		this.resaltarmarzoCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarmarzoCentroCostoValor() {
		return this.mostrarmarzoCentroCostoValor;
	}

	public void setMostrarmarzoCentroCostoValor(Boolean mostrarmarzoCentroCostoValor) {
		this.mostrarmarzoCentroCostoValor= mostrarmarzoCentroCostoValor;
	}

	public Boolean getActivarmarzoCentroCostoValor() {
		return this.activarmarzoCentroCostoValor;
	}

	public void setActivarmarzoCentroCostoValor(Boolean activarmarzoCentroCostoValor) {
		this.activarmarzoCentroCostoValor= activarmarzoCentroCostoValor;
	}

	public Border setResaltarabrilCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarabrilCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarabrilCentroCostoValor() {
		return this.resaltarabrilCentroCostoValor;
	}

	public void setResaltarabrilCentroCostoValor(Border borderResaltar) {
		this.resaltarabrilCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarabrilCentroCostoValor() {
		return this.mostrarabrilCentroCostoValor;
	}

	public void setMostrarabrilCentroCostoValor(Boolean mostrarabrilCentroCostoValor) {
		this.mostrarabrilCentroCostoValor= mostrarabrilCentroCostoValor;
	}

	public Boolean getActivarabrilCentroCostoValor() {
		return this.activarabrilCentroCostoValor;
	}

	public void setActivarabrilCentroCostoValor(Boolean activarabrilCentroCostoValor) {
		this.activarabrilCentroCostoValor= activarabrilCentroCostoValor;
	}

	public Border setResaltarmayoCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarmayoCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmayoCentroCostoValor() {
		return this.resaltarmayoCentroCostoValor;
	}

	public void setResaltarmayoCentroCostoValor(Border borderResaltar) {
		this.resaltarmayoCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarmayoCentroCostoValor() {
		return this.mostrarmayoCentroCostoValor;
	}

	public void setMostrarmayoCentroCostoValor(Boolean mostrarmayoCentroCostoValor) {
		this.mostrarmayoCentroCostoValor= mostrarmayoCentroCostoValor;
	}

	public Boolean getActivarmayoCentroCostoValor() {
		return this.activarmayoCentroCostoValor;
	}

	public void setActivarmayoCentroCostoValor(Boolean activarmayoCentroCostoValor) {
		this.activarmayoCentroCostoValor= activarmayoCentroCostoValor;
	}

	public Border setResaltarjunioCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarjunioCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarjunioCentroCostoValor() {
		return this.resaltarjunioCentroCostoValor;
	}

	public void setResaltarjunioCentroCostoValor(Border borderResaltar) {
		this.resaltarjunioCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarjunioCentroCostoValor() {
		return this.mostrarjunioCentroCostoValor;
	}

	public void setMostrarjunioCentroCostoValor(Boolean mostrarjunioCentroCostoValor) {
		this.mostrarjunioCentroCostoValor= mostrarjunioCentroCostoValor;
	}

	public Boolean getActivarjunioCentroCostoValor() {
		return this.activarjunioCentroCostoValor;
	}

	public void setActivarjunioCentroCostoValor(Boolean activarjunioCentroCostoValor) {
		this.activarjunioCentroCostoValor= activarjunioCentroCostoValor;
	}

	public Border setResaltarjulioCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarjulioCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarjulioCentroCostoValor() {
		return this.resaltarjulioCentroCostoValor;
	}

	public void setResaltarjulioCentroCostoValor(Border borderResaltar) {
		this.resaltarjulioCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarjulioCentroCostoValor() {
		return this.mostrarjulioCentroCostoValor;
	}

	public void setMostrarjulioCentroCostoValor(Boolean mostrarjulioCentroCostoValor) {
		this.mostrarjulioCentroCostoValor= mostrarjulioCentroCostoValor;
	}

	public Boolean getActivarjulioCentroCostoValor() {
		return this.activarjulioCentroCostoValor;
	}

	public void setActivarjulioCentroCostoValor(Boolean activarjulioCentroCostoValor) {
		this.activarjulioCentroCostoValor= activarjulioCentroCostoValor;
	}

	public Border setResaltaragostoCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltaragostoCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaragostoCentroCostoValor() {
		return this.resaltaragostoCentroCostoValor;
	}

	public void setResaltaragostoCentroCostoValor(Border borderResaltar) {
		this.resaltaragostoCentroCostoValor= borderResaltar;
	}

	public Boolean getMostraragostoCentroCostoValor() {
		return this.mostraragostoCentroCostoValor;
	}

	public void setMostraragostoCentroCostoValor(Boolean mostraragostoCentroCostoValor) {
		this.mostraragostoCentroCostoValor= mostraragostoCentroCostoValor;
	}

	public Boolean getActivaragostoCentroCostoValor() {
		return this.activaragostoCentroCostoValor;
	}

	public void setActivaragostoCentroCostoValor(Boolean activaragostoCentroCostoValor) {
		this.activaragostoCentroCostoValor= activaragostoCentroCostoValor;
	}

	public Border setResaltarseptiembreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarseptiembreCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarseptiembreCentroCostoValor() {
		return this.resaltarseptiembreCentroCostoValor;
	}

	public void setResaltarseptiembreCentroCostoValor(Border borderResaltar) {
		this.resaltarseptiembreCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarseptiembreCentroCostoValor() {
		return this.mostrarseptiembreCentroCostoValor;
	}

	public void setMostrarseptiembreCentroCostoValor(Boolean mostrarseptiembreCentroCostoValor) {
		this.mostrarseptiembreCentroCostoValor= mostrarseptiembreCentroCostoValor;
	}

	public Boolean getActivarseptiembreCentroCostoValor() {
		return this.activarseptiembreCentroCostoValor;
	}

	public void setActivarseptiembreCentroCostoValor(Boolean activarseptiembreCentroCostoValor) {
		this.activarseptiembreCentroCostoValor= activarseptiembreCentroCostoValor;
	}

	public Border setResaltaroctubreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltaroctubreCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaroctubreCentroCostoValor() {
		return this.resaltaroctubreCentroCostoValor;
	}

	public void setResaltaroctubreCentroCostoValor(Border borderResaltar) {
		this.resaltaroctubreCentroCostoValor= borderResaltar;
	}

	public Boolean getMostraroctubreCentroCostoValor() {
		return this.mostraroctubreCentroCostoValor;
	}

	public void setMostraroctubreCentroCostoValor(Boolean mostraroctubreCentroCostoValor) {
		this.mostraroctubreCentroCostoValor= mostraroctubreCentroCostoValor;
	}

	public Boolean getActivaroctubreCentroCostoValor() {
		return this.activaroctubreCentroCostoValor;
	}

	public void setActivaroctubreCentroCostoValor(Boolean activaroctubreCentroCostoValor) {
		this.activaroctubreCentroCostoValor= activaroctubreCentroCostoValor;
	}

	public Border setResaltarnoviembreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltarnoviembreCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnoviembreCentroCostoValor() {
		return this.resaltarnoviembreCentroCostoValor;
	}

	public void setResaltarnoviembreCentroCostoValor(Border borderResaltar) {
		this.resaltarnoviembreCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrarnoviembreCentroCostoValor() {
		return this.mostrarnoviembreCentroCostoValor;
	}

	public void setMostrarnoviembreCentroCostoValor(Boolean mostrarnoviembreCentroCostoValor) {
		this.mostrarnoviembreCentroCostoValor= mostrarnoviembreCentroCostoValor;
	}

	public Boolean getActivarnoviembreCentroCostoValor() {
		return this.activarnoviembreCentroCostoValor;
	}

	public void setActivarnoviembreCentroCostoValor(Boolean activarnoviembreCentroCostoValor) {
		this.activarnoviembreCentroCostoValor= activarnoviembreCentroCostoValor;
	}

	public Border setResaltardiciembreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostovalorBeanSwingJInternalFrame.jTtoolBarCentroCostoValor.setBorder(borderResaltar);
		
		this.resaltardiciembreCentroCostoValor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiciembreCentroCostoValor() {
		return this.resaltardiciembreCentroCostoValor;
	}

	public void setResaltardiciembreCentroCostoValor(Border borderResaltar) {
		this.resaltardiciembreCentroCostoValor= borderResaltar;
	}

	public Boolean getMostrardiciembreCentroCostoValor() {
		return this.mostrardiciembreCentroCostoValor;
	}

	public void setMostrardiciembreCentroCostoValor(Boolean mostrardiciembreCentroCostoValor) {
		this.mostrardiciembreCentroCostoValor= mostrardiciembreCentroCostoValor;
	}

	public Boolean getActivardiciembreCentroCostoValor() {
		return this.activardiciembreCentroCostoValor;
	}

	public void setActivardiciembreCentroCostoValor(Boolean activardiciembreCentroCostoValor) {
		this.activardiciembreCentroCostoValor= activardiciembreCentroCostoValor;
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
		
		
		this.setMostraridCentroCostoValor(esInicial);
		this.setMostrarid_empresaCentroCostoValor(esInicial);
		this.setMostrarid_sucursalCentroCostoValor(esInicial);
		this.setMostrarid_ejercicioCentroCostoValor(esInicial);
		this.setMostrarid_centro_costoCentroCostoValor(esInicial);
		this.setMostrarnombreCentroCostoValor(esInicial);
		this.setMostrareneroCentroCostoValor(esInicial);
		this.setMostrarfebreroCentroCostoValor(esInicial);
		this.setMostrarmarzoCentroCostoValor(esInicial);
		this.setMostrarabrilCentroCostoValor(esInicial);
		this.setMostrarmayoCentroCostoValor(esInicial);
		this.setMostrarjunioCentroCostoValor(esInicial);
		this.setMostrarjulioCentroCostoValor(esInicial);
		this.setMostraragostoCentroCostoValor(esInicial);
		this.setMostrarseptiembreCentroCostoValor(esInicial);
		this.setMostraroctubreCentroCostoValor(esInicial);
		this.setMostrarnoviembreCentroCostoValor(esInicial);
		this.setMostrardiciembreCentroCostoValor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ID)) {
				this.setMostraridCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ENERO)) {
				this.setMostrareneroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.FEBRERO)) {
				this.setMostrarfebreroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MARZO)) {
				this.setMostrarmarzoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ABRIL)) {
				this.setMostrarabrilCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MAYO)) {
				this.setMostrarmayoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JUNIO)) {
				this.setMostrarjunioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JULIO)) {
				this.setMostrarjulioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.AGOSTO)) {
				this.setMostraragostoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.SEPTIEMBRE)) {
				this.setMostrarseptiembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.OCTUBRE)) {
				this.setMostraroctubreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOVIEMBRE)) {
				this.setMostrarnoviembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.DICIEMBRE)) {
				this.setMostrardiciembreCentroCostoValor(esAsigna);
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
		
		
		this.setActivaridCentroCostoValor(esInicial);
		this.setActivarid_empresaCentroCostoValor(esInicial);
		this.setActivarid_sucursalCentroCostoValor(esInicial);
		this.setActivarid_ejercicioCentroCostoValor(esInicial);
		this.setActivarid_centro_costoCentroCostoValor(esInicial);
		this.setActivarnombreCentroCostoValor(esInicial);
		this.setActivareneroCentroCostoValor(esInicial);
		this.setActivarfebreroCentroCostoValor(esInicial);
		this.setActivarmarzoCentroCostoValor(esInicial);
		this.setActivarabrilCentroCostoValor(esInicial);
		this.setActivarmayoCentroCostoValor(esInicial);
		this.setActivarjunioCentroCostoValor(esInicial);
		this.setActivarjulioCentroCostoValor(esInicial);
		this.setActivaragostoCentroCostoValor(esInicial);
		this.setActivarseptiembreCentroCostoValor(esInicial);
		this.setActivaroctubreCentroCostoValor(esInicial);
		this.setActivarnoviembreCentroCostoValor(esInicial);
		this.setActivardiciembreCentroCostoValor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ID)) {
				this.setActivaridCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ENERO)) {
				this.setActivareneroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.FEBRERO)) {
				this.setActivarfebreroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MARZO)) {
				this.setActivarmarzoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ABRIL)) {
				this.setActivarabrilCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MAYO)) {
				this.setActivarmayoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JUNIO)) {
				this.setActivarjunioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JULIO)) {
				this.setActivarjulioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.AGOSTO)) {
				this.setActivaragostoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.SEPTIEMBRE)) {
				this.setActivarseptiembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.OCTUBRE)) {
				this.setActivaroctubreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOVIEMBRE)) {
				this.setActivarnoviembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.DICIEMBRE)) {
				this.setActivardiciembreCentroCostoValor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCentroCostoValor(esInicial);
		this.setResaltarid_empresaCentroCostoValor(esInicial);
		this.setResaltarid_sucursalCentroCostoValor(esInicial);
		this.setResaltarid_ejercicioCentroCostoValor(esInicial);
		this.setResaltarid_centro_costoCentroCostoValor(esInicial);
		this.setResaltarnombreCentroCostoValor(esInicial);
		this.setResaltareneroCentroCostoValor(esInicial);
		this.setResaltarfebreroCentroCostoValor(esInicial);
		this.setResaltarmarzoCentroCostoValor(esInicial);
		this.setResaltarabrilCentroCostoValor(esInicial);
		this.setResaltarmayoCentroCostoValor(esInicial);
		this.setResaltarjunioCentroCostoValor(esInicial);
		this.setResaltarjulioCentroCostoValor(esInicial);
		this.setResaltaragostoCentroCostoValor(esInicial);
		this.setResaltarseptiembreCentroCostoValor(esInicial);
		this.setResaltaroctubreCentroCostoValor(esInicial);
		this.setResaltarnoviembreCentroCostoValor(esInicial);
		this.setResaltardiciembreCentroCostoValor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ID)) {
				this.setResaltaridCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ENERO)) {
				this.setResaltareneroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.FEBRERO)) {
				this.setResaltarfebreroCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MARZO)) {
				this.setResaltarmarzoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.ABRIL)) {
				this.setResaltarabrilCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.MAYO)) {
				this.setResaltarmayoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JUNIO)) {
				this.setResaltarjunioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.JULIO)) {
				this.setResaltarjulioCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.AGOSTO)) {
				this.setResaltaragostoCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.SEPTIEMBRE)) {
				this.setResaltarseptiembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.OCTUBRE)) {
				this.setResaltaroctubreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.NOVIEMBRE)) {
				this.setResaltarnoviembreCentroCostoValor(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoValorConstantesFunciones.DICIEMBRE)) {
				this.setResaltardiciembreCentroCostoValor(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreCentroCostoValor=true;

	public Boolean getMostrarBusquedaPorNombreCentroCostoValor() {
		return this.mostrarBusquedaPorNombreCentroCostoValor;
	}

	public void setMostrarBusquedaPorNombreCentroCostoValor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCentroCostoValor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoCentroCostoValor=true;

	public Boolean getMostrarFK_IdCentroCostoCentroCostoValor() {
		return this.mostrarFK_IdCentroCostoCentroCostoValor;
	}

	public void setMostrarFK_IdCentroCostoCentroCostoValor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCentroCostoValor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioCentroCostoValor=true;

	public Boolean getMostrarFK_IdEjercicioCentroCostoValor() {
		return this.mostrarFK_IdEjercicioCentroCostoValor;
	}

	public void setMostrarFK_IdEjercicioCentroCostoValor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCentroCostoValor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCentroCostoValor=true;

	public Boolean getMostrarFK_IdEmpresaCentroCostoValor() {
		return this.mostrarFK_IdEmpresaCentroCostoValor;
	}

	public void setMostrarFK_IdEmpresaCentroCostoValor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCentroCostoValor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCentroCostoValor=true;

	public Boolean getMostrarFK_IdSucursalCentroCostoValor() {
		return this.mostrarFK_IdSucursalCentroCostoValor;
	}

	public void setMostrarFK_IdSucursalCentroCostoValor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCentroCostoValor= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreCentroCostoValor=true;

	public Boolean getActivarBusquedaPorNombreCentroCostoValor() {
		return this.activarBusquedaPorNombreCentroCostoValor;
	}

	public void setActivarBusquedaPorNombreCentroCostoValor(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCentroCostoValor= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoCentroCostoValor=true;

	public Boolean getActivarFK_IdCentroCostoCentroCostoValor() {
		return this.activarFK_IdCentroCostoCentroCostoValor;
	}

	public void setActivarFK_IdCentroCostoCentroCostoValor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCentroCostoValor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioCentroCostoValor=true;

	public Boolean getActivarFK_IdEjercicioCentroCostoValor() {
		return this.activarFK_IdEjercicioCentroCostoValor;
	}

	public void setActivarFK_IdEjercicioCentroCostoValor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCentroCostoValor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCentroCostoValor=true;

	public Boolean getActivarFK_IdEmpresaCentroCostoValor() {
		return this.activarFK_IdEmpresaCentroCostoValor;
	}

	public void setActivarFK_IdEmpresaCentroCostoValor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCentroCostoValor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCentroCostoValor=true;

	public Boolean getActivarFK_IdSucursalCentroCostoValor() {
		return this.activarFK_IdSucursalCentroCostoValor;
	}

	public void setActivarFK_IdSucursalCentroCostoValor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCentroCostoValor= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreCentroCostoValor=null;

	public Border getResaltarBusquedaPorNombreCentroCostoValor() {
		return this.resaltarBusquedaPorNombreCentroCostoValor;
	}

	public void setResaltarBusquedaPorNombreCentroCostoValor(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCentroCostoValor= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCentroCostoValor= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoCentroCostoValor=null;

	public Border getResaltarFK_IdCentroCostoCentroCostoValor() {
		return this.resaltarFK_IdCentroCostoCentroCostoValor;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoValor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCentroCostoValor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCentroCostoValor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioCentroCostoValor=null;

	public Border getResaltarFK_IdEjercicioCentroCostoValor() {
		return this.resaltarFK_IdEjercicioCentroCostoValor;
	}

	public void setResaltarFK_IdEjercicioCentroCostoValor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCentroCostoValor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCentroCostoValor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCentroCostoValor=null;

	public Border getResaltarFK_IdEmpresaCentroCostoValor() {
		return this.resaltarFK_IdEmpresaCentroCostoValor;
	}

	public void setResaltarFK_IdEmpresaCentroCostoValor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCentroCostoValor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCentroCostoValor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCentroCostoValor=null;

	public Border getResaltarFK_IdSucursalCentroCostoValor() {
		return this.resaltarFK_IdSucursalCentroCostoValor;
	}

	public void setResaltarFK_IdSucursalCentroCostoValor(Border borderResaltar) {
		this.resaltarFK_IdSucursalCentroCostoValor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCentroCostoValor(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoValorBeanSwingJInternalFrame centrocostovalorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCentroCostoValor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}